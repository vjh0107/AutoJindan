package scheduler

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.quartz.*
import org.quartz.impl.StdSchedulerFactory
import selenium.driver
import selenium.elements
import selenium.way.returnURL
import sqlite.connectDiscriminator
import java.sql.ResultSet
import java.sql.Statement

fun schedulerRegisterer() {
    val schedf: SchedulerFactory = StdSchedulerFactory()
    try {
        val sched = schedf.scheduler

        val execute = JobBuilder.newJob(JindanExecute::class.java)
            .withIdentity("jindanExecuter", Scheduler.DEFAULT_GROUP)
            .build()

        val trigger: Trigger = TriggerBuilder.newTrigger()
            .withIdentity("jindanStartAtAm7:20", Scheduler.DEFAULT_GROUP)
            //초 분 시 일 월 요일 (년)
            .withSchedule(CronScheduleBuilder.cronSchedule("35 * * * * ?"))
            .build()

        sched.scheduleJob(execute, trigger)
        sched.start()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

class JindanExecute : Job {
    override fun execute(arg0: JobExecutionContext?) {
        val statement: Statement = connectDiscriminator()!!.createStatement()
        val rs: ResultSet = statement.executeQuery("select * from jindanRepository")
        while (rs.next()) {
            //while문 안에서의 선언 한번 더 해줘야함 안그러면 작동 X
            var MainDiscordId: String = rs.getString("discordId")
            val statement: Statement = connectDiscriminator()!!.createStatement()

            val rs: ResultSet = statement.executeQuery("select * from jindanRepository")
            while (rs.next()) {
                if (rs.getString("discordId") == MainDiscordId) {
                    val returnedURL: String = returnURL(rs.getString("location"))
                    if (returnedURL != "invalid location") {
                        driver.get(returnedURL)
                    } else {
                        return
                    }
                    try {
                        driver.findElement(By.id("schulNm")).sendKeys(rs.getString("school"))
                        Thread.sleep(10)
                        val nameElement: WebElement = driver.findElementByXPath("//*[@id=\"pName\"]")
                        nameElement.click()
                        nameElement.clear()
                        nameElement.sendKeys(rs.getString("name"))
                        Thread.sleep(10)
                        driver.findElement(By.id("frnoRidno")).sendKeys(rs.getString("birth"))
                        Thread.sleep(10)
                        driver.findElement(By.id("btnConfirm")).click()
                        Thread.sleep(10)
                        try {
                            try {
                                for (value in elements) {
                                    driver.findElement(By.id("rspns$value")).click()
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                            Thread.sleep((100))
                            driver.findElement(By.id("btnConfirm")).click()
                            Thread.sleep(500)
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    } catch (e: java.lang.Exception) {
                        //만약 정보처리에 문제가 있다면, 해당 유저는 스킵함
                        driver.switchTo().alert().accept()
                        e.printStackTrace()
                    }
                    println(rs.getString("name"))
                    break
                }
            }
        }
    }
}
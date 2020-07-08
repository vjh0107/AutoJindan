package selenium.way

import com.jetbrains.rd.util.string.print
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import selenium.clickSections
import selenium.clickerById

import selenium.driver

//private val elements: Array<String> = arrayOf("011", "02", "070", "080", "090")
private var infoUrl: String = "https://eduro.pen.go.kr/stv_cvd_co00_002.do"
fun enterInfo(school: String, name: String, birth: String) {
    try {
        driver.get(infoUrl);

        driver.findElement(By.id("schulNm")).sendKeys(school)
        Thread.sleep(100)

        val nameElement: WebElement = driver.findElementByXPath("//*[@id=\"pName\"]")
        nameElement.click()
        nameElement.clear()
        nameElement.sendKeys(name)

        Thread.sleep(100)
        driver.findElement(By.id("frnoRidno")).sendKeys(birth)

        Thread.sleep(100)
        driver.findElement(By.id("btnConfirm")).click()

        Thread.sleep(100)
        clickSections()
    } catch (e: java.lang.Exception) {
        e.printStackTrace()}

}
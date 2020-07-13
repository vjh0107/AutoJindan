import discord.events.ProfileBot
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import scheduler.schedulerRegisterer
import sqlite.sqliteRegisterer
import java.util.ArrayList


val localPATH = "C:\\Users\\vjh01\\Desktop"

fun main(args: Array<String>) {
    //init
    val jda = JDABuilder(AccountType.BOT)

    //셀레니움 property
    System.setProperty("webdriver.chrome.driver", "$localPATH/chromedriver_win32/chromedriver.exe")

    //토큰설정
    jda.setToken("NzI5NTQxMjY3ODk3NDUwNDk2.XwObVQ.xfkTLGgVRBwBeD91w2UDUA69SKI")

    //이벤트등록
    jda.addEventListeners(ProfileBot())

    //봇 login
    jda.build()

    //7:20부터 시작하는 스케쥴러 등록
    schedulerRegisterer()

    //SQLite [db (생성/접속) 테이블 (생성/접속)]
    sqliteRegisterer()


}


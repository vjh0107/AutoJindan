import discord.testEmbed
import discord.events.ProfileBot
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.ini4j.Profile
import java.awt.Color
import javax.security.auth.login.LoginException

val WEB_DRIVER_ID = "webdriver.chrome.driver";
val localPATH = "C:\\Users\\vjh01\\Desktop"
val WEB_DRIVER_PATH = "$localPATH/chromedriver_win32/chromedriver.exe";

fun main(args: Array<String>) {
    //init
    val jda = JDABuilder(AccountType.BOT)

    //셀레니움 property
    System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH)

    //토큰설정
    jda.setToken("NzI5NTQxMjY3ODk3NDUwNDk2.XwObVQ.xfkTLGgVRBwBeD91w2UDUA69SKI")

    //이벤트등록
    jda.addEventListeners(ProfileBot())

    //봇 login
    jda.build()
}


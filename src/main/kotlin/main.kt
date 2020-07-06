import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import javax.security.auth.login.LoginException
//import com.google.firebase.

class ProfileBot : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        println(event.message.toString())
        try {

            val msg = event.message
            val mc = event.channel
            val str = msg.contentRaw
            //val order = str.substring(0, 7)
            val jda = event.jda
            if (event.author != event.member) {
                if (event.message.contentRaw.toString() == "뷰지"){
                    event.channel.sendMessage("late night sex, so wet, so tight").queue()
                }
            }
            if (event.message.toString().contains("Get")) {
                val tag = str.substring(8)
                val usr = jda.getUserByTag(tag)
                mc.sendMessage(usr!!.avatarUrl!!).queue()
                println("성공")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            println("finally,")
        }
    }

    companion object {
        @Throws(LoginException::class, InterruptedException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val jda = JDABuilder(AccountType.BOT)
            jda.setToken("NzI5NTQxMjY3ODk3NDUwNDk2.XwObVQ.xfkTLGgVRBwBeD91w2UDUA69SKI")
            jda.addEventListeners(ProfileBot())
            jda.build()
        }
    }
}
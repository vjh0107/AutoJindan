package discord.events

import com.sun.jna.StringArray
import discord.commands.searchCommands
import discord.testEmbed
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import selenium.way.enterInfo
import kotlin.system.exitProcess

class ProfileBot : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        //println(event.message.toString())
        try {

            val msg = event.message
            val mc = event.channel
            val content = msg.contentRaw
            val jda = event.jda
            testEmbed()
            if (event.channelType.isGuild.not()) {
                if (event.author != event.member) {
                    if (event.message.contentRaw.contains("자가진단")) {
                        event.channel.sendMessage(testEmbed()).queue()
                        var cospl = content.split(" ")
                        if (cospl.size <= 2) {
                            for(value in cospl) {
                                if (value != "자가진단") {
                                    searchCommands(value)
                                }
                            }
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            println("finally,")
        }
    }
}
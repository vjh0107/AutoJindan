package discord.commands

import discord.invalidCommandEmbed
import net.dv8tion.jda.api.entities.MessageChannel
import selenium.way.enterInfo

val registeredCommand: Array<String> = arrayOf("현황", "취소", "정보설정")

fun searchCommands(mc: MessageChannel, command: String) {
    if (registeredCommand.contains(command).not()) {
        //mc.sendMessage(invalidCommandEmbed()).queue()
    } else {
        if (command == "현황") {
            enterInfo("경기도1", "의정부광동고등학교", "이윤하", "040101")
        }
    }
}
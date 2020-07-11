package discord.commands

import discord.invalidCommandEmbed
import net.dv8tion.jda.api.entities.MessageChannel

val registeredCommand: Array<String> = arrayOf("현황", "취소", "정보설정")

fun searchCommands(mc: MessageChannel, command: String) {
    if (registeredCommand.contains(command).not()) {
        mc.sendMessage(invalidCommandEmbed()).queue()
    } else {
        if (command == "현황") {

        }
    }
}
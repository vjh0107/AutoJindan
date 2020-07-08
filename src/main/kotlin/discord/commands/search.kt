package discord.commands

val registeredCommand: Array<String> = arrayOf("현황", "취소", "정보설정")

fun searchCommands(command: String): Boolean {
    if (registeredCommand.contains(command).not()) {
        return false
    }
}
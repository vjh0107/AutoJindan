package discord

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color

fun testEmbed(): MessageEmbed {
    val eb = EmbedBuilder()
    eb.setTitle("클릭하여 자가진단합니다.", "http://vjh0107.com")
    eb.setColor(Color.GREEN)
    eb.setDescription("박준형");
    eb.addField("oo고등학교", " o학년 o반", false);
    //eb.addBlankField(false);
    eb.setAuthor("AutoJindan", null, "http://discordapp.com/assets/6debd47ed13483642cf09e832ed0bc1b.png");
    eb.setFooter("자가진단 전입니다.", "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");
    //eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
    eb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
    return eb.build()
}

fun invalidCommandEmbed(): MessageEmbed {
    val eb = EmbedBuilder()
    eb.setTitle("클릭하여 자가진단합니다.", "http://vjh0107.com")
    eb.setColor(Color.CYAN)
    eb.setDescription("박준형");
    eb.addField("oo고등학교", " o학년 o반", false);
    //eb.addBlankField(false);
    eb.setAuthor("AutoJindan", null, "http://discordapp.com/assets/6debd47ed13483642cf09e832ed0bc1b.png");
    eb.setFooter("자가진단 전입니다.", "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");
    //eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
    eb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
    return eb.build()
}

package discord

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.entities.User
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
val randomMessages: Array<String> = arrayOf("커피한잔의 여유는", "책 한구절 읽기는", "든든한 아침은", "꼼꼼한 자기관리는")
fun invalidCommandEmbed(eventUser: User): MessageEmbed {
    val eb = EmbedBuilder()
    val randomMessage = randomMessages.random()
    eb.setAuthor("자가진단봇 Auto", null, "http://discordapp.com/assets/6debd47ed13483642cf09e832ed0bc1b.png");
    //eb.setTitle("**자가진단봇 Auto**")
    eb.setColor((Color(0x7289da)))
    eb.setDescription("안녕하세요 저는 " + eventUser.name + "님의 바쁜 아침을 책임집니다.\n일어나자마자 휴대폰이 아닌, $randomMessage 어떤가요?\n\n명령어:\n```자가진단 정보입력 [지역] [학교] [생년월일] [이름]\nex)자가진단 정보입력 제주특별자치도 oo고등학교 030107 홍길동``` 매일마다 자가진단될 아이디를 설정합니다.\n\n```자가진단 넘기기``` 해당일의 자가진단을 넘깁니다.\n\n```자가진단 서비스취소``` 자동 자가진단 서비스를 종료합니다.");
    //eb.addField("oo고등학교", " o학년 o반", false);
    //eb.addBlankField(false);

    eb.setFooter("contact: vjh0107@naver.com", "https://cdn.discordapp.com/avatars/688553878517448728/b100fa4a85c962b9cef57ccfaa68d9ed.webp?size=256");
    //eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
    //eb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
    return eb.build()
}
fun checkAgain(location: String, school: String, birth: String, name: String): MessageEmbed {
    val eb = EmbedBuilder()
    eb.setTitle("**해당 정보로 자가진단이 등록되었습니다!**")
    eb.setDescription("해당 정보가 만약 맞지 않는다면, 다시 등록해주세요!\n\n```지역: $location```\n```학교: $school```\n```생일: $birth```\n```이름: $name```")
    eb.setColor((Color(0x7289da)))
    eb.setFooter("contact: vjh0107@naver.com", "https://cdn.discordapp.com/avatars/688553878517448728/b100fa4a85c962b9cef57ccfaa68d9ed.webp?size=256");
    return eb.build()
}

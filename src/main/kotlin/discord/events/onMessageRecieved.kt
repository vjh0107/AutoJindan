package discord.events

import discord.checkAgain
import discord.invalidCommandEmbed
import isInt
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import selenium.way.enterInfo
import selenium.way.returnURL
import sqlite.dataReader
import sqlite.insertData

class ProfileBot : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        //println(event.message.toString())
        try {

            val msg = event.message
            val mc = event.channel
            val content = msg.contentRaw

            if (event.channelType.isGuild) { return }
            if (event.author == event.member) { return }

            if (event.message.contentRaw.contains("자가진단").not()) {
                //없는 명령어입니다. 출력
                return
            }
            //event.channel.sendMessage(testEmbed()).queue()
            var coSpl = content.split(" ")
            //println(coSpl[0]) = 자가진단

            if (coSpl.size > 1 && coSpl[1] == "정보입력" && coSpl.size == 6) { //todo: 첫1회
                //자가진단 정보입력 [지역] [학교] [생년월일] [이름]
                //todo: 유효검사
                if (returnURL(coSpl[2]) == "invalid location"){
                    event.channel.sendMessage("없는 지역입니다. 지역명을 올바르게 기입해주세요.").queue()
                    event.channel.sendMessage(invalidCommandEmbed(event.author)).queue()
                    return
                }
                if (isInt(coSpl[4]).not()) {
                    event.channel.sendMessage("올바르지 않는 생년월일 값입니다.").queue()
                    event.channel.sendMessage(invalidCommandEmbed(event.author)).queue()
                    return
                }
                insertData(event.author.id, coSpl[2], coSpl[3], coSpl[4], coSpl[5])
                //enterInfo(coSpl[2], coSpl[3], coSpl[4], coSpl[5])
                event.channel.sendMessage(checkAgain(coSpl[2], coSpl[3], coSpl[4], coSpl[5])).queue()
                return

            }
            if (coSpl[1] == "넘기기") {
                //todo: 해당일의 자가진단을 넘깁니다.
                return
            }
            if (coSpl[1] == "서비스취소") {
                //todo: 정보입력의 정보 삭제
            }
            event.channel.sendMessage(invalidCommandEmbed(event.author)).queue()
            println(event.author.id)
            dataReader(event.author.id)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            println("finish: onMessageRecieved")
        }
    }
}
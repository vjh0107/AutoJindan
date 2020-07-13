package sqlite

import selenium.way.enterInfo
import java.sql.ResultSet
import java.sql.Statement


//디스코드Id를 이용한 그사람의 정보 찾기
fun dataReader(discordId: String) {
    val statement: Statement = connectDiscriminator()!!.createStatement()
    val rs: ResultSet = statement.executeQuery("select * from jindanRepository")
    while (rs.next()) {
        println(rs.getString("discordId") + discordId)
        if (rs.getString("discordId") == discordId) {
            enterInfo(rs.getString("location"), rs.getString("school"), rs.getString("birth"), rs.getString("name"))
            println(rs.getString("name"))
            break
        }
    }
}
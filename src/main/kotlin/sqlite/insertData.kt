package sqlite


import java.sql.PreparedStatement
import java.sql.SQLException

internal fun insertData(discordId: String, location: String, school: String, birth: String, name: String) {
    val sql = "INSERT INTO jindanRepository(discordId, location, school, birth, name) VALUES(?, ?, ?, ?, ?)"
    try {
        //값넣기
        var pstmt: PreparedStatement = connectDiscriminator()!!.prepareStatement(sql)
        pstmt.setString(1, discordId)
        pstmt.setString(2, location)
        pstmt.setString(3, school)
        pstmt.setString(4, birth)
        pstmt.setString(5, name)

        pstmt.executeUpdate()
    } catch (e: SQLException) { println(e.message)}
}
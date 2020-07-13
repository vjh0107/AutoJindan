package sqlite

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun connectDiscriminator(): Connection? {
    var connection: Connection? = null
    try {
        connection = DriverManager.getConnection("jdbc:sqlite:jindanRepository.db")
    } catch(e: SQLException) {
        e.stackTrace
    }
    return connection
}
package sqlite

import java.sql.*

fun main(){
    var connection: Connection? = null
    var statement: Statement? = null

    try {
        Class.forName("org.sqlite.JDBC")

    } catch(e: ClassNotFoundException) {
        println("org.sqlite.JDBC를 못찾음")
    }
    connection = DriverManager.getConnection("jdbc:sqlite:test.db")
    statement = connection.createStatement()

    var resultSet: ResultSet = statement.executeQuery("select * from Table1")
    while(resultSet.next()) {
        println(resultSet.getString("field1"))
    }
    resultSet.close()
    connection.close()
}
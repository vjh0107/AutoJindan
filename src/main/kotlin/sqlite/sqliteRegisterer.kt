package sqlite

import org.sqlite.SQLiteConfig
import java.sql.*


fun sqliteRegisterer(){
    var connection: Connection? = null
    var statement: Statement? = null

    //SQLite 인코딩 및 jindanRepository 생성/접속
    var config: SQLiteConfig = SQLiteConfig()
    config.setEncoding(SQLiteConfig.Encoding.UTF8)
    connection = DriverManager.getConnection("jdbc:sqlite:jindanRepository.db", config.toProperties())

    //테이블 생성/접속
    statement = connection.createStatement()
    val tableCreate = """CREATE TABLE IF NOT EXISTS jindanRepository (
	discordId integer PRIMARY KEY,
	location text NOT NULL,
    school text NOT NULL,
    birth text NOT NULL,
    name text NOT NULL
);"""
    statement.execute(tableCreate)

}
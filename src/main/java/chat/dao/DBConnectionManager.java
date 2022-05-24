package chat.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private Connection connection;

    public DBConnectionManager() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_schema", "root", "ma123");
    }


    public Connection getConnection(){
        return this.connection;
    }
}


package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mariadb {
    public Connection tryConnect() throws SQLException{
            String user = "root";
            String password = "";
            String url = "jdbc:mariadb://localhost:3306/jarigui";
            return DriverManager.getConnection(url, user, password);
    }

    public Connection connection(){
        try {
            return tryConnect();
        } catch (SQLException e) {
            System.err.println("Hiba! Nem sikerült csatlakozni az adatbázishoz!");
            System.err.println(e.getMessage());
            return null;
        }
    }
}

package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DataSource {
    public void tryAddCar(Car car) throws SQLException{
        Mariadb db = new Mariadb();
        Connection conn = db.connection();
        String sql = "INSERT INTO cars (plate, brand, cyear, fuel, price, klima, ccert) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, car.getPlate());
        stm.setString(2, car.getBrand());
        stm.setInt(3, car.getYear());
        stm.setString(4, car.getFuel());
        stm.setDouble(5, car.getPrice());
        stm.setBoolean(6, car.getClimate());
        stm.setString(7, car.getCert().toString());
        stm.execute();
    }

    public void addCar(Car car){
        try {
            tryAddCar(car);
        } catch (SQLException e) {
            System.err.println("Hiba! Nem sikerült hozzáadni az autót az adatbázishoz!");
            System.err.println(e.getMessage());
        }
    }
}

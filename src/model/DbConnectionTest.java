package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionTest {

    private static final String URL = "jdbc:mysql://localhost:3306/tourism_booking";
    private static final String USER = "root";
    private static final String PASSWORD = "David123"; // change this

    public static Connection getConnection() {

        Connection conn = null;

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("✅ Database Connected");

        } catch (Exception e) {
            System.out.println("❌ Database Connection Failed");
            e.printStackTrace();
        }

        return conn;
    }
}
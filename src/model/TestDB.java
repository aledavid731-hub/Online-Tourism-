package model;

import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {
        Connection conn = DbConnectionTest.getConnection();

        if (conn != null) {
            System.out.println("Connection successful! ✅");
            System.out.println(conn);
        } else {
            System.out.println("Connection failed! ❌");
        }
    }
}
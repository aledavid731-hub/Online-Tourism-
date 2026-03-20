package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.DbConnectionTest;

public class LoginControl {

    public boolean validateUser(String username, String password) {

        try {
            Connection conn = DbConnectionTest.getConnection();

            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next(); // true if login success

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
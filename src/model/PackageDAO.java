package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO {

    private Connection conn;

    public PackageDAO() {
        conn = DbConnectionTest.getConnection();
    }

    // ✅ GET ALL PACKAGES
    public List<Package> getAllPackages() {

        List<Package> list = new ArrayList<>();

        String sql = "SELECT * FROM packages";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                list.add(new Package(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("price")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ GET ONE PACKAGE
    public Package getPackageById(int id) {

        Package p = null;

        String sql = "SELECT * FROM packages WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                p = new Package(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }
}
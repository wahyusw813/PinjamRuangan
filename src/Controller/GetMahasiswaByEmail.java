/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import Model.Mahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class GetMahasiswaByEmail {
    private final Connection connection;
    private final ExecutorService executor;

    public GetMahasiswaByEmail(Connection connection, ExecutorService executor) {
        this.connection = connection;
        this.executor = executor;
    }

    public Future<Mahasiswa> getMahasiswaByEmail(String email) {
        return executor.submit(() -> {
            Mahasiswa mahasiswa = null;
            String query = "SELECT * FROM mahasiswa WHERE email = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    mahasiswa = new Mahasiswa(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getString("password")
                    );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return mahasiswa;
        });
    }
}

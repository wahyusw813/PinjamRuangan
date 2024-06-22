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
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class UpdateMahasiswa {
    private final Connection connection;
    private final ExecutorService executor;

    public UpdateMahasiswa(Connection connection, ExecutorService executor) {
        this.connection = connection;
        this.executor = executor;
    }

    public Future<Boolean> updateMahasiswa(Mahasiswa mahasiswa) {
        return executor.submit(() -> {
            String query = "UPDATE mahasiswa SET nim = ?, nama = ?, password = ? WHERE email = ?";
            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, mahasiswa.getNim());
                ps.setString(2, mahasiswa.getNama());
                ps.setString(3, mahasiswa.getPassword());
                ps.setString(4, mahasiswa.getEmail());
                int rowsUpdated = ps.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        });
    }
}

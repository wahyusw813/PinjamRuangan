/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */

import Model.KoneksiDB;
import Model.Mahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.*;

public class MahasiswaController {
    private final Connection connection;
    private final ExecutorService executor;

    public MahasiswaController() {
        this.connection = KoneksiDB.getConnection();
        this.executor = Executors.newCachedThreadPool();
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

    public void shutdownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                executor.shutdownNow();
                if (!executor.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS))
                    System.err.println("Executor did not terminate");
            }
        } catch (InterruptedException ie) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import Model.Session;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.sql.ResultSet;

public class HandleAjukanButton {
    private final Connection connection;
    private final ExecutorService executor;

    public HandleAjukanButton(Connection connection, ExecutorService executor) {
        this.connection = connection;
        this.executor = executor;
    }

    public void handleAjukanButton(String gedung, String lantai, String ruangan, Date tanggal, boolean sesi1, boolean sesi2, boolean sesi3, boolean sesi4, String keterangan) {
        Runnable task = () -> {
            try {
                String email = Session.getEmail();
                GetMahasiswaIdByEmail getter = new GetMahasiswaIdByEmail(connection);
                int mahasiswaId = getter.getMahasiswaIdByEmail(email);

                if (isSessionOverlapping(ruangan, tanggal, sesi1, sesi2, sesi3, sesi4, mahasiswaId)) {
                    SwingUtilities.invokeLater(() -> 
                        JOptionPane.showMessageDialog(null, "Anda sudah mengajukan ruangan ini untuk satu atau lebih sesi pada tanggal tersebut.")
                    );
                    return;
                }

                String query = "INSERT INTO ruangan (ruang, tanggal, sesi1, sesi2, sesi3, sesi4, keterangan, mahasiswa_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, ruangan);
                pst.setDate(2, new java.sql.Date(tanggal.getTime()));
                pst.setBoolean(3, sesi1);
                pst.setBoolean(4, sesi2);
                pst.setBoolean(5, sesi3);
                pst.setBoolean(6, sesi4);
                pst.setString(7, keterangan);
                pst.setInt(8, mahasiswaId);
                pst.executeUpdate();

                SwingUtilities.invokeLater(() -> 
                    JOptionPane.showMessageDialog(null, "Pengajuan ruangan berhasil.")
                );
            } catch (SQLException ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(() -> 
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage())
                );
            }
        };

        Future<?> future = executor.submit(task);
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isSessionOverlapping(String ruangan, Date tanggal, boolean sesi1, boolean sesi2, boolean sesi3, boolean sesi4, int mahasiswaId) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM ruangan WHERE ruang = ? AND tanggal = ? AND mahasiswa_id = ? " +
                       "AND ((sesi1 = ? AND sesi1 = true) OR (sesi2 = ? AND sesi2 = true) OR (sesi3 = ? AND sesi3 = true) OR (sesi4 = ? AND sesi4 = true))";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, ruangan);
        pst.setDate(2, new java.sql.Date(tanggal.getTime()));
        pst.setInt(3, mahasiswaId);
        pst.setBoolean(4, sesi1);
        pst.setBoolean(5, sesi2);
        pst.setBoolean(6, sesi3);
        pst.setBoolean(7, sesi4);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("count");
            return count > 0;
        }
        return false;
    }
}
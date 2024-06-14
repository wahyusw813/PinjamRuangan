/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetKeteranganFromDatabase {
    private final Connection connection;

    public GetKeteranganFromDatabase(Connection connection) {
        this.connection = connection;
    }

    public String getKeteranganFromDatabase(String ruang, String tanggal) {
        String keterangan = "";
        String query = "SELECT keterangan FROM ruangan WHERE ruang = ? AND tanggal = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, ruang);
            pst.setString(2, tanggal);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    keterangan = rs.getString("keterangan");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            SwingUtilities.invokeLater(() -> 
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
            );
        }
        return keterangan;
    }
}
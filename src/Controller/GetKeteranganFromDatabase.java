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

    public String getKeteranganFromDatabase(String id_ruang) {
        String keterangan = "";
        String query = "SELECT keterangan FROM ruangan WHERE id_ruang = ?";
        System.out.println("Executing query: " + query + " with parameters id_ruang=" + id_ruang);
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, id_ruang);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    keterangan = rs.getString("keterangan");
                } else {
                    // Handle case where no record is found
                    keterangan = "Keterangan tidak tersedia";
                    System.out.println("No keterangan found for id_ruang=" + id_ruang);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
            );
            System.out.println("SQL Exception in getKeteranganFromDatabase: " + e.getMessage());
        }
        return keterangan;
    }
}
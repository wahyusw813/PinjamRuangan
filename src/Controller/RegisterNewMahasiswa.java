/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import View.Login;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;

public class RegisterNewMahasiswa {
    private final Connection connection;
    private final ExecutorService executor;

    public RegisterNewMahasiswa(Connection connection, ExecutorService executor) {
        this.connection = connection;
        this.executor = executor;
    }

    public void registerNewMahasiswa(String email, String nim, String nama, String password, JScrollPane contentScrollPane) {
        executor.submit(() -> {
            try {
                String query = "INSERT INTO mahasiswa (email, nim, nama, password) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, email);
                pst.setString(2, nim);
                pst.setString(3, nama);
                pst.setString(4, password);
                pst.executeUpdate();

                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, "Pendaftaran berhasil. Silakan login.");
                    contentScrollPane.setViewportView(new Login(contentScrollPane));
                });
            } catch (SQLException ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()));
            }
        });
    }
}

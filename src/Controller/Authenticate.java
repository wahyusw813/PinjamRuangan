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
import View.PinjamRuangan;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;

public class Authenticate {
    private final Connection connection;
    private final ExecutorService executor;

    public Authenticate(Connection connection, ExecutorService executor) {
        this.connection = connection;
        this.executor = executor;
    }

    public void authenticate(String email, String password, JScrollPane contentScrollPane) {
        executor.submit(() -> {
            try {
                String query = "SELECT * FROM mahasiswa WHERE email = ? AND password = ?";
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    Session.setEmail(email); // Set email in session
                    SwingUtilities.invokeLater(() -> contentScrollPane.setViewportView(new PinjamRuangan(contentScrollPane)));
                } else {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Login gagal. Email atau password salah."));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage()));
            }
        });
    }
}

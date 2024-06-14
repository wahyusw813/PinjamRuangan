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
import Model.Session;
import View.Login;
import View.Signup;
import View.PinjamRuangan;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LoginController {
    private final Connection connection;
    private final ExecutorService executor;

    public LoginController() {
        this.connection = KoneksiDB.getConnection();
        this.executor = Executors.newFixedThreadPool(10);
    }

    // Metode untuk validasi input
    private boolean validateInputs(String email, String nim, String nama, String password) {
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(null, "Email harus mengandung '@'.");
            return false;
        }
        if (!nim.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(null, "NIM harus terdiri dari 9 angka.");
            return false;
        }
        if (!Character.isUpperCase(nama.charAt(0))) {
            JOptionPane.showMessageDialog(null, "Nama harus diawali dengan huruf kapital.");
            return false;
        }
        if (password.length() < 5) {
            JOptionPane.showMessageDialog(null, "Password minimal harus terdiri dari 5 karakter.");
            return false;
        }
        return true;
    }

    public void registerNewMahasiswa(String email, String nim, String nama, String password, JScrollPane contentScrollPane) {
        if (!validateInputs(email, nim, nama, password)) {
            return;
        }

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

    public void shutdown() {
        executor.shutdown();
    }
}

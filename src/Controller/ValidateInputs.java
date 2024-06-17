/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import javax.swing.JOptionPane;

public class ValidateInputs {
    public boolean validateInputs(String email, String nim, String nama, String password) {
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
}

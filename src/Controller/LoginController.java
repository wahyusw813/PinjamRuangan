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
import View.Login;
import View.PinjamRuangan;
import javax.swing.*;
import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginController {
    private final Connection connection;
    private final ExecutorService executor;

    public LoginController() {
        this.connection = KoneksiDB.getConnection();
        this.executor = Executors.newFixedThreadPool(10);
    }

    private boolean validateInputs(String email, String nim, String nama, String password) {
        ValidateInputs validator = new ValidateInputs();
        return validator.validateInputs(email, nim, nama, password);
    }

    public void registerNewMahasiswa(String email, String nim, String nama, String password, JScrollPane contentScrollPane) {
        if (!validateInputs(email, nim, nama, password)) {
            return;
        }

        RegisterNewMahasiswa register = new RegisterNewMahasiswa(connection, executor);
        register.registerNewMahasiswa(email, nim, nama, password, contentScrollPane);
    }

    public void authenticate(String email, String password, JScrollPane contentScrollPane) {
        Authenticate authenticate = new Authenticate(connection, executor);
        authenticate.authenticate(email, password, contentScrollPane);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
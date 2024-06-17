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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MahasiswaController {
    private final Connection connection;
    private final ExecutorService executor;

    public MahasiswaController() {
        this.connection = KoneksiDB.getConnection();
        this.executor = Executors.newCachedThreadPool();
    }

    public Future<Mahasiswa> getMahasiswaByEmail(String email) {
        GetMahasiswaByEmail getter = new GetMahasiswaByEmail(connection, executor);
        return getter.getMahasiswaByEmail(email);
    }

    public Future<Boolean> updateMahasiswa(Mahasiswa mahasiswa) {
        UpdateMahasiswa updater = new UpdateMahasiswa(connection, executor);
        return updater.updateMahasiswa(mahasiswa);
    }

    public void shutdownExecutor() {
        ShutdownExecutor shutdown = new ShutdownExecutor(executor);
        shutdown.shutdownExecutor();
    }
}

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
import Model.Ruangan;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.IOException;

public class RuanganController {
    private final Connection connection;
    private final ExecutorService executor;

    public RuanganController() {
        this.connection = KoneksiDB.getConnection();
        this.executor = Executors.newCachedThreadPool();
    }

    public List<Ruangan> getRuanganByMahasiswaId(int mahasiswaId) {
        GetRuanganByMahasiswaId getter = new GetRuanganByMahasiswaId(connection);
        return getter.getRuanganByMahasiswaId(mahasiswaId);
    }

    public List<Ruangan> getAllRuangan() {
        GetAllRuangan getter = new GetAllRuangan(connection);
        return getter.getAllRuangan();
    }


    // Methods for handling different functionalities
    public void handleAjukanButton(String gedung, String lantai, String ruangan, Date tanggal, boolean sesi1, boolean sesi2, boolean sesi3, boolean sesi4, String keterangan) {
        HandleAjukanButton handle = new HandleAjukanButton(connection, executor);
        handle.handleAjukanButton(gedung, lantai, ruangan, tanggal, sesi1, sesi2, sesi3, sesi4, keterangan);
    }

    public int getMahasiswaIdByEmail(String email) throws SQLException {
        GetMahasiswaIdByEmail getter = new GetMahasiswaIdByEmail(connection);
        return getter.getMahasiswaIdByEmail(email);
    }

    public String getKeteranganFromDatabase(String id_ruang) {
        GetKeteranganFromDatabase getter = new GetKeteranganFromDatabase(connection);
        return getter.getKeteranganFromDatabase(id_ruang);
    }

    public void exportToPdf(String id_ruang, String ruang, String tanggal, String sesi1, String sesi2, String sesi3, String sesi4) throws IOException {
        ExportToPdf exporter = new ExportToPdf(connection);
        exporter.exportToPdf(id_ruang, ruang, tanggal, sesi1, sesi2, sesi3, sesi4);
    }

    public boolean deleteRuangan(String ruang, java.sql.Date tanggal) {
        DeleteRuangan deleter = new DeleteRuangan(connection);
        return deleter.deleteRuangan(ruang, tanggal);
    }
}


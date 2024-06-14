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
import Model.RuanganModel;

import java.sql.Connection;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

public class RuanganController {
    private final Connection connection;
    private final RuanganModel ruanganModel;
    private final ExecutorService executor;

    public RuanganController() {
        this.connection = KoneksiDB.getConnection();
        this.ruanganModel = new RuanganModel();
        this.executor = Executors.newCachedThreadPool();
    }
    public List<Ruangan> getRuanganByMahasiswaId(int mahasiswaId) {
        return ruanganModel.getRuanganByMahasiswaId(mahasiswaId);
    }
    public List<Ruangan> getAllRuangan() {
        return ruanganModel.getAllRuangan();
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

    public String getKeteranganFromDatabase(String ruang, String tanggal) {
        GetKeteranganFromDatabase getter = new GetKeteranganFromDatabase(connection);
        return getter.getKeteranganFromDatabase(ruang, tanggal);
    }

    public void exportToPdf(String ruang, String tanggal, String sesi1, String sesi2, String sesi3, String sesi4) throws IOException {
        ExportToPdf exporter = new ExportToPdf(connection);
        exporter.exportToPdf(ruang, tanggal, sesi1, sesi2, sesi3, sesi4);
    }

    public boolean deleteRuangan(String ruang, java.sql.Date tanggal) {
        DeleteRuangan deleter = new DeleteRuangan(connection);
        return deleter.deleteRuangan(ruang, tanggal);
    }
}


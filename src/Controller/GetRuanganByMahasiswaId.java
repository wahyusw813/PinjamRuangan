/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import Model.Ruangan;
import Model.KoneksiDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetRuanganByMahasiswaId {
    private final Connection connection;

    public GetRuanganByMahasiswaId(Connection connection) {
        this.connection = connection;
    }

    public List<Ruangan> getRuanganByMahasiswaId(int mahasiswaId) {
        List<Ruangan> ruanganList = new ArrayList<>();
        String query = "SELECT id_ruang, ruang, tanggal, sesi1, sesi2, sesi3, sesi4 FROM ruangan WHERE mahasiswa_id = ?";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, mahasiswaId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Ruangan ruangan = new Ruangan(
                        rs.getInt("id_ruang"),
                        rs.getString("ruang"),
                        rs.getDate("tanggal"),
                        rs.getString("sesi1"),
                        rs.getString("sesi2"),
                        rs.getString("sesi3"),
                        rs.getString("sesi4"),
                        mahasiswaId
                    );
                    ruanganList.add(ruangan);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruanganList;
    }
}

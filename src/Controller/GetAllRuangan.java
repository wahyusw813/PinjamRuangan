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

public class GetAllRuangan {
    private final Connection connection;

    public GetAllRuangan(Connection connection) {
        this.connection = connection;
    }

    public List<Ruangan> getAllRuangan() {
        List<Ruangan> ruanganList = new ArrayList<>();
        String query = "SELECT ruang, tanggal, sesi1, sesi2, sesi3, sesi4 FROM ruangan";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ruangan ruangan = new Ruangan(
                    rs.getString("ruang"),
                    rs.getDate("tanggal"),
                    rs.getString("sesi1"),
                    rs.getString("sesi2"),
                    rs.getString("sesi3"),
                    rs.getString("sesi4")
                );
                ruanganList.add(ruangan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruanganList;
    }
}

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

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRuangan {
    private final Connection connection;

    public DeleteRuangan(Connection connection) {
        this.connection = connection;
    }

    public boolean deleteRuangan(String ruang, Date tanggal) {
        String query = "DELETE FROM ruangan WHERE ruang = ? AND tanggal = ? AND mahasiswa_id = ?";
        try {
            String email = Session.getEmail();
            GetMahasiswaIdByEmail getter = new GetMahasiswaIdByEmail(connection);
            int mahasiswaId = getter.getMahasiswaIdByEmail(email);
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, ruang);
            pst.setDate(2, tanggal);
            pst.setInt(3, mahasiswaId);
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}


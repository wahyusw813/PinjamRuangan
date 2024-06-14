/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetMahasiswaIdByEmail {
    private final Connection connection;

    public GetMahasiswaIdByEmail(Connection connection) {
        this.connection = connection;
    }

    public int getMahasiswaIdByEmail(String email) throws SQLException {
        String query = "SELECT id FROM mahasiswa WHERE email = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        throw new SQLException("Mahasiswa tidak ditemukan.");
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Wahyu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    private static final String URL = "jdbc:sqlite:C:\\Users\\Wahyu\\Downloads\\STIS\\Semester 4\\PBO\\JavaNetbeans\\PinjamRuangan\\pinjam_ruangan.db";
    private static final int MAX_RETRY = 3;

    // ThreadLocal to ensure each thread has its own connection instance
    private static final ThreadLocal<Connection> threadLocalConnection = ThreadLocal.withInitial(() -> {
        int retry = 0;
        while (retry < MAX_RETRY) {
            try {
                Class.forName("org.sqlite.JDBC");
                return DriverManager.getConnection(URL);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Driver SQLite tidak ditemukan", e);
            } catch (SQLException ex) {
                if (ex.getMessage().contains("SQLITE_BUSY")) {
                    // Database is busy, retry after a short delay
                    retry++;
                    System.out.println("Database is busy, retrying... Attempt " + retry);
                    try {
                        Thread.sleep(1000); // Delay 1 second
                    } catch (InterruptedException interruptEx) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    throw new RuntimeException("Koneksi ke database gagal", ex);
                }
            }
        }
        throw new RuntimeException("Gagal mendapatkan koneksi setelah " + MAX_RETRY + " percobaan");
    });

    public static Connection getConnection() {
        return threadLocalConnection.get();
    }

    public static void closeConnection() {
        Connection connection = threadLocalConnection.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                threadLocalConnection.remove();
            }
        }
    }
}


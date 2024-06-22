/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Wahyu
 */

public class Mahasiswa {
    private int id;
    private String email;
    private String nim;
    private String nama;
    private String password;

    public Mahasiswa(int id, String email, String nim, String nama, String password) {
        this.id = id;
        this.email = email;
        this.nim = nim;
        this.nama = nama;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and setters for all fields
    // These are omitted for brevity but should be included

    // Optionally, you can override toString() for debugging or logging purposes
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Wahyu
 */
public class Ruangan {
    private String ruang;
    private Date tanggal;
    private String sesi1;
    private String sesi2;
    private String sesi3;
    private String sesi4;
    private int mahasiswa_id;

    public Ruangan(String ruang, Date tanggal, String sesi1, String sesi2, String sesi3, String sesi4) {
        this.ruang = ruang;
        this.tanggal = tanggal;
        this.sesi1 = sesi1;
        this.sesi2 = sesi2;
        this.sesi3 = sesi3;
        this.sesi4 = sesi4;
        this.mahasiswa_id = mahasiswa_id;
    }

    public String getRuang() {
        return ruang;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getSesi1() {
        return sesi1;
    }

    public String getSesi2() {
        return sesi2;
    }

    public String getSesi3() {
        return sesi3;
    }

    public String getSesi4() {
        return sesi4;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public void setSesi1(String sesi1) {
        this.sesi1 = sesi1;
    }

    public void setSesi2(String sesi2) {
        this.sesi2 = sesi2;
    }

    public void setSesi3(String sesi3) {
        this.sesi3 = sesi3;
    }

    public void setSesi4(String sesi4) {
        this.sesi4 = sesi4;
    }

    public int getMahasiswa_id() {
        return mahasiswa_id;
    }

    public void setMahasiswa_id(int mahasiswa_id) {
        this.mahasiswa_id = mahasiswa_id;
    }
    
}

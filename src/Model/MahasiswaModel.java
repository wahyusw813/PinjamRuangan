/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.MahasiswaController;
import View.Akun;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author Wahyu
 */

public class MahasiswaModel {
    private final MahasiswaController mahasiswaController;
    private final Akun akunView;

    public MahasiswaModel(Akun akunView) {
        this.mahasiswaController = new MahasiswaController();
        this.akunView = akunView;
    }

    public Mahasiswa getCurrentMahasiswa() {
        String email = Session.getEmail();
        Future<Mahasiswa> futureMahasiswa = mahasiswaController.getMahasiswaByEmail(email);
        try {
            return futureMahasiswa.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateMahasiswa(Mahasiswa mahasiswa) {
        Future<Boolean> futureUpdate = mahasiswaController.updateMahasiswa(mahasiswa);
        try {
            return futureUpdate.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void shutdownControllerExecutor() {
        mahasiswaController.shutdownExecutor();
    }
}



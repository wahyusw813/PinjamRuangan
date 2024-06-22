/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.KoneksiDB;
import Model.Ruangan;
import Model.Session;
import Controller.RuanganController;

import java.sql.Connection;
import javax.swing.JScrollPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Wahyu
 */
public class RoomList extends javax.swing.JPanel {
    private JScrollPane contentScrollPane;
    private final Connection connection;
    private RuanganController ruanganController;

    /**
     * Creates new form list
     */
    public RoomList(JScrollPane contentScrollPane) {
        initComponents();
        this.contentScrollPane = contentScrollPane;
        this.connection = KoneksiDB.getConnection(); // Koneksi ke database
        this.ruanganController = new RuanganController();
        jLabelUser.setText("Logged in as: " + Session.getEmail());
        loadAllRuangan();
    }
    private void loadAllRuangan() {
        List<Ruangan> ruanganList = ruanganController.getAllRuangan();
        updateTableData(ruanganList);
    }

    private void updateTableData(List<Ruangan> ruanganList) {
        DefaultTableModel model = (DefaultTableModel) allTableRuangan.getModel();
        model.setRowCount(0);
        for (Ruangan ruangan : ruanganList) {
            model.addRow(new Object[]{
                ruangan.getRuang(),
                ruangan.getTanggal(),
                ruangan.getSesi1(),
                ruangan.getSesi2(),
                ruangan.getSesi3(),
                ruangan.getSesi4()
            });
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allTableRuangan = new javax.swing.JTable();
        jLabelUser = new javax.swing.JLabel();
        sortComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("List Ruangan");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        allTableRuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ruang", "Tanggal", "Sesi 1", "Sesi 2", "Sesi 3", "Sesi 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(allTableRuangan);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 96, 650, 340));

        jLabelUser.setForeground(new java.awt.Color(204, 255, 255));
        jLabelUser.setText("Akun");
        add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 270, -1));

        sortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ruangan", "Tanggal" }));
        sortComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBoxActionPerformed(evt);
            }
        });
        add(sortComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 101, -1));

        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Urut berdasarkan");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 20));

        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("1: booked");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("0: available");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, -1, -1));

        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Plain.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 680, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void sortComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) sortComboBox.getSelectedItem();
        List<Ruangan> ruanganList = ruanganController.getAllRuangan();
        if (selectedItem != null) {
            switch (selectedItem) {
                case "Ruangan":
                    Collections.sort(ruanganList, Comparator.comparing(Ruangan::getRuang));
                    break;
                case "Tanggal":
                    Collections.sort(ruanganList, Comparator.comparing(Ruangan::getTanggal));
                    break;
                default:
                    break;
            }
        }
        updateTableData(ruanganList);
    }//GEN-LAST:event_sortComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allTableRuangan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> sortComboBox;
    // End of variables declaration//GEN-END:variables
}
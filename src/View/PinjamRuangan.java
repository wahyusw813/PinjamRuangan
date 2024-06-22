/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.RuanganController;
import Model.Session;

import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Wahyu
 */
public class PinjamRuangan extends javax.swing.JPanel {
    private final JScrollPane contentScrollPane;
    private RuanganController controller;

    public PinjamRuangan(JScrollPane contentScrollPane) {
        this.contentScrollPane = contentScrollPane;
        this.controller = new RuanganController();
        initComponents();
        jLabelUser.setText("Logged in as: " + Session.getEmail());

    }

    private final String[] ruanganList = {
        "Auditorium", "251", "252", "253", "254", "255", "256", "257",
        "261", "262", "263", "264", "265", "266", "267",
        "321", "322", "323", "324", "325", "326", "327", "328",
        "331", "332", "333", "334", "335", "336", "337", "338",
        "341", "342", "343", "344", "345", "346", "347", "348"
    };
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxGedung = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboBoxLantai = new javax.swing.JComboBox<>();
        comboBoxRuangan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        buttonAjukan = new javax.swing.JButton();
        checkBoxSesi1 = new javax.swing.JCheckBox();
        checkBoxSesi2 = new javax.swing.JCheckBox();
        checkBoxSesi3 = new javax.swing.JCheckBox();
        checkBoxSesi4 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Pinjam Ruangan");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Gedung");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        comboBoxGedung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxGedung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auditorium", "Gedung 2", "Gedung 3" }));
        comboBoxGedung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGedungActionPerformed(evt);
            }
        });
        add(comboBoxGedung, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Lantai");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        comboBoxLantai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxLantai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auditorium", "Lantai 2", "Lantai 3", "Lantai 4", "Lantai 5", "Lantai 6" }));
        comboBoxLantai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxLantaiActionPerformed(evt);
            }
        });
        add(comboBoxLantai, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        comboBoxRuangan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxRuangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auditorium", "251", "252", "253", "254", "255", "256", "257", "261", "262", "263", "264", "265", "266", "267", "321", "322", "323", "324", "325", "326", "327", "328", "331", "332", "333", "334", "335", "336", "337", "338", "341", "342", "343", "344", "345", "346", "347", "348" }));
        comboBoxRuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRuanganActionPerformed(evt);
            }
        });
        add(comboBoxRuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Ruangan");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 116, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Sesi");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(textArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 285, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Kebutuhan/Kegiatan");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 285, -1));

        buttonAjukan.setBackground(new java.awt.Color(102, 153, 255));
        buttonAjukan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonAjukan.setForeground(new java.awt.Color(0, 51, 153));
        buttonAjukan.setText("Ajukan");
        buttonAjukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAjukanActionPerformed(evt);
            }
        });
        add(buttonAjukan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, -1, -1));

        checkBoxSesi1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxSesi1.setForeground(new java.awt.Color(204, 255, 255));
        checkBoxSesi1.setText("Sesi 1");
        checkBoxSesi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSesi1ActionPerformed(evt);
            }
        });
        add(checkBoxSesi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        checkBoxSesi2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxSesi2.setForeground(new java.awt.Color(204, 255, 255));
        checkBoxSesi2.setText("Sesi 2");
        checkBoxSesi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSesi2ActionPerformed(evt);
            }
        });
        add(checkBoxSesi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        checkBoxSesi3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxSesi3.setForeground(new java.awt.Color(204, 255, 255));
        checkBoxSesi3.setText("Sesi 3");
        checkBoxSesi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSesi3ActionPerformed(evt);
            }
        });
        add(checkBoxSesi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        checkBoxSesi4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkBoxSesi4.setForeground(new java.awt.Color(204, 255, 255));
        checkBoxSesi4.setText("Sesi 4");
        checkBoxSesi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxSesi4ActionPerformed(evt);
            }
        });
        add(checkBoxSesi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Keterangan:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Sesi 1: 7.20 - 9.50");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Sesi 2: 10.10 - 12.40");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setText("Sesi 3: 13.30 - 16.00");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        jLabel11.setForeground(new java.awt.Color(204, 255, 255));
        jLabel11.setText("Sesi 4: 16.10 - 18.40");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        jLabelUser.setForeground(new java.awt.Color(204, 255, 255));
        jLabelUser.setText("Akun");
        add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 255));
        jLabel12.setText("Tanggal");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, 30));
        add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 240, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Plain.png"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 700, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxGedungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGedungActionPerformed
        // TODO add your handling code here:
        String selectedGedung = (String) comboBoxGedung.getSelectedItem();
        comboBoxLantai.removeAllItems();
        comboBoxRuangan.removeAllItems();

        if (selectedGedung != null) {
            if (!selectedGedung.equals("Auditorium")) 
                if(selectedGedung.equals("Gedung 2")){
                comboBoxLantai.addItem("Lantai 5");
                comboBoxLantai.addItem("Lantai 6");
            } else {
                comboBoxLantai.addItem("Lantai 2");
                comboBoxLantai.addItem("Lantai 3");
                comboBoxLantai.addItem("Lantai 4");
            } else {
                comboBoxLantai.addItem("Auditorium");
                comboBoxRuangan.addItem("Auditorium");
            }
        }
    }//GEN-LAST:event_comboBoxGedungActionPerformed

    private void comboBoxLantaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLantaiActionPerformed
        // TODO add your handling code here:
        String selectedGedung = (String) comboBoxGedung.getSelectedItem();
        String selectedLantai = (String) comboBoxLantai.getSelectedItem();

        comboBoxRuangan.removeAllItems();

        if (selectedGedung != null && selectedLantai != null) {
            List<String> filteredRuangan = new ArrayList<>();
            for (String ruangan : ruanganList) {
                if (ruangan.equals("Auditorium") && selectedGedung.equals("Auditorium") && selectedLantai.equals("Auditorium")) {
                    filteredRuangan.add(ruangan);
                } else if (ruangan.matches("\\d{3}")) {
                    int gedung = Character.getNumericValue(ruangan.charAt(0));
                    int lantai = Character.getNumericValue(ruangan.charAt(1));

                    if ((selectedGedung.equals("Gedung 2") && gedung == 2) || (selectedGedung.equals("Gedung 3") && gedung == 3)) {
                        if (selectedLantai.equals("Lantai " + lantai)) {
                            filteredRuangan.add(ruangan);
                        }
                    }
                }
            }

            for (String ruangan : filteredRuangan) {
                comboBoxRuangan.addItem(ruangan);
            }
        }
    }//GEN-LAST:event_comboBoxLantaiActionPerformed

    private void comboBoxRuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRuanganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRuanganActionPerformed

    private void checkBoxSesi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSesi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSesi1ActionPerformed

    private void checkBoxSesi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSesi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSesi2ActionPerformed

    private void checkBoxSesi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSesi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSesi3ActionPerformed

    private void checkBoxSesi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxSesi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxSesi4ActionPerformed

    private void buttonAjukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAjukanActionPerformed
        // TODO add your handling code here:
        String gedung = (String) comboBoxGedung.getSelectedItem();
        String lantai = (String) comboBoxLantai.getSelectedItem();
        String ruangan = (String) comboBoxRuangan.getSelectedItem();
        boolean sesi1 = checkBoxSesi1.isSelected();
        boolean sesi2 = checkBoxSesi2.isSelected();
        boolean sesi3 = checkBoxSesi3.isSelected();
        boolean sesi4 = checkBoxSesi4.isSelected();
        String keterangan = textArea.getText();
        Date tanggal = dateChooser.getDate();

        if (!sesi1 && !sesi2 && !sesi3 && !sesi4) {
            JOptionPane.showMessageDialog(this, "Setidaknya satu sesi harus dipilih", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validasi bahwa keterangan harus diisi
        if (keterangan.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keterangan harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        controller.handleAjukanButton(gedung, lantai, ruangan, tanggal, sesi1, sesi2, sesi3, sesi4, keterangan);
    }//GEN-LAST:event_buttonAjukanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAjukan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkBoxSesi1;
    private javax.swing.JCheckBox checkBoxSesi2;
    private javax.swing.JCheckBox checkBoxSesi3;
    private javax.swing.JCheckBox checkBoxSesi4;
    private javax.swing.JComboBox<String> comboBoxGedung;
    private javax.swing.JComboBox<String> comboBoxLantai;
    private javax.swing.JComboBox<String> comboBoxRuangan;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
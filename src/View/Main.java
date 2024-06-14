/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Model.Session;
import javax.swing.JOptionPane;

/**
 *
 * @author Wahyu
 */

public class Main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public Main() {
        initComponents();
        contentScrollPane.setViewportView(new Welcome(contentScrollPane));
        setTitle("Aplikasi Peminjaman Ruangan");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentScrollPane = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        akunMenu = new javax.swing.JMenu();
        akunMenuItem = new javax.swing.JMenuItem();
        pinjamMenu = new javax.swing.JMenu();
        pinjamMenuItem = new javax.swing.JMenuItem();
        listMenu = new javax.swing.JMenu();
        listMenuItem = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenu();
        logoutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        akunMenu.setText("Akun");
        akunMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akunMenuActionPerformed(evt);
            }
        });

        akunMenuItem.setText("Akun");
        akunMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akunMenuItemActionPerformed(evt);
            }
        });
        akunMenu.add(akunMenuItem);

        jMenuBar1.add(akunMenu);

        pinjamMenu.setText("Pinjam Ruangan");
        pinjamMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamMenuActionPerformed(evt);
            }
        });

        pinjamMenuItem.setText("Pinjam Ruangan");
        pinjamMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamMenuItemActionPerformed(evt);
            }
        });
        pinjamMenu.add(pinjamMenuItem);

        jMenuBar1.add(pinjamMenu);

        listMenu.setText("List");

        listMenuItem.setText("List");
        listMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listMenuItemActionPerformed(evt);
            }
        });
        listMenu.add(listMenuItem);

        jMenuBar1.add(listMenu);

        logoutMenu.setText("Logout");

        logoutMenuItem.setText("Logout");
        logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuItemActionPerformed(evt);
            }
        });
        logoutMenu.add(logoutMenuItem);

        jMenuBar1.add(logoutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void akunMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akunMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_akunMenuActionPerformed

    private void pinjamMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pinjamMenuActionPerformed

    private void akunMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akunMenuItemActionPerformed
        // TODO add your handling code here:
        if (Session.getEmail() == null) {
            contentScrollPane.setViewportView(new Login(contentScrollPane));
            JOptionPane.showMessageDialog(this, "Anda harus login terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            contentScrollPane.setViewportView(new Akun(contentScrollPane));
        }
    }//GEN-LAST:event_akunMenuItemActionPerformed

    private void pinjamMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamMenuItemActionPerformed
        // TODO add your handling code here:
        if (Session.getEmail() == null) {
            contentScrollPane.setViewportView(new Login(contentScrollPane));
            JOptionPane.showMessageDialog(this, "Anda harus login terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            contentScrollPane.setViewportView(new PinjamRuangan(contentScrollPane));
        }
    }//GEN-LAST:event_pinjamMenuItemActionPerformed

    private void listMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listMenuItemActionPerformed
        // TODO add your handling code here:
        if (Session.getEmail() == null) {
            contentScrollPane.setViewportView(new Login(contentScrollPane));
            JOptionPane.showMessageDialog(this, "Anda harus login terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            contentScrollPane.setViewportView(new RoomList(contentScrollPane));
        }
    }//GEN-LAST:event_listMenuItemActionPerformed

    private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuItemActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            // Fungsi untuk logout
            Session.clear();  // Hapus sesi
            contentScrollPane.setViewportView(new Login(contentScrollPane));  // Tampilkan halaman login
        }
    }//GEN-LAST:event_logoutMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu akunMenu;
    private javax.swing.JMenuItem akunMenuItem;
    private javax.swing.JScrollPane contentScrollPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu listMenu;
    private javax.swing.JMenuItem listMenuItem;
    private javax.swing.JMenu logoutMenu;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenu pinjamMenu;
    private javax.swing.JMenuItem pinjamMenuItem;
    // End of variables declaration//GEN-END:variables
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Wahyu
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;

public class ExportToPdf {
    private final Connection connection;

    public ExportToPdf(Connection connection) {
        this.connection = connection;
    }

    public void exportToPdf(String id_ruang, String ruang, String tanggal, String sesi1, String sesi2, String sesi3, String sesi4) throws IOException {
        try {
            StringBuilder sesiBuilder = new StringBuilder();
            if ("1".equals(sesi1)) sesiBuilder.append("               Sesi 1: 7.20 - 9.50\n");
            if ("1".equals(sesi2)) sesiBuilder.append("               Sesi 2: 10.10 - 12.40\n");
            if ("1".equals(sesi3)) sesiBuilder.append("               Sesi 3: 13.30 - 16.00\n");
            if ("1".equals(sesi4)) sesiBuilder.append("               Sesi 4: 16.10 - 18.40\n");

            GetKeteranganFromDatabase getter = new GetKeteranganFromDatabase(connection);
            String keterangan = getter.getKeteranganFromDatabase(id_ruang);
            System.out.println("Keterangan retrieved: " + keterangan);

            Document document = new Document();
            document.setMargins(72, 72, 72, 72);
            PdfWriter.getInstance(document, new FileOutputStream("Peminjaman_Ruangan.pdf"));

            document.open();
            BaseFont bfArial = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
            Font titleFont = new Font(bfArial, 18, Font.BOLD);
            Font normalFont = new Font(bfArial, 12);

            Paragraph title = new Paragraph("Surat Peminjaman Ruangan\n\n", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10f);
            document.add(title);

            Paragraph para1 = new Paragraph("Yth. Kasubbag Tata Usaha dan Rumah Tangga", normalFont);
            para1.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para1);

            Paragraph para2 = new Paragraph("      Politeknik Statistika STIS", normalFont);
            para2.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para2);

            Paragraph para3 = new Paragraph("di", normalFont);
            para3.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para3);

            Paragraph para4 = new Paragraph("      tempat\n\n", normalFont);
            para4.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para4);

            Paragraph para5 = new Paragraph("      Sehubungan dengan akan diadakannya kegiatan " + keterangan + 
                                            ", kami bermaksud mengajukan peminjaman Ruang " + ruang + 
                                            " yang akan digunakan pada:\n", normalFont);
            para5.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para5);

            Paragraph para6 = new Paragraph("      tanggal: " + tanggal, normalFont);
            para6.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para6);

            Paragraph para7 = new Paragraph("      waktu: \n" + sesiBuilder.toString(), normalFont);
            para7.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para7);

            Paragraph para8 = new Paragraph("      tempat: " + ruang + "\n\n", normalFont);
            para8.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para8);

            Paragraph para9 = new Paragraph("      Demikian surat permohonan ini kami sampaikan, atas perhatian dan izin yang Bapak/Ibu berikan kami mengucapkan terima kasih.", normalFont);
            para9.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(para9);
            
            Paragraph para10 = new Paragraph("\n\n\n\nMengetahui,               ", normalFont);
            para10.setAlignment(Element.ALIGN_RIGHT);
            document.add(para10);
            
            Paragraph para11 = new Paragraph("Kepala Subbagian Administrasi", normalFont);
            para11.setAlignment(Element.ALIGN_RIGHT);
            document.add(para11);
            
            Paragraph para12 = new Paragraph("Kemahasiswaan,          ", normalFont);
            para12.setAlignment(Element.ALIGN_RIGHT);
            document.add(para12);
            
            Paragraph para13 = new Paragraph("\n\n\n\n\n(............................................)", normalFont);
            para13.setAlignment(Element.ALIGN_RIGHT);
            document.add(para13);

            document.close();

            JOptionPane.showMessageDialog(null, "PDF berhasil diekspor!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Document or File Not Found Exception: " + e.getMessage());
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author sabri
 */

////import Controller.ControllerMahasiswa;
//import Model.Mahasiswa.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuUtama extends JFrame{
    JLabel header = new JLabel("Selamat Datang!");
    JLabel greet = new JLabel("Pilih menu kelola data:");    
    JButton tombolKendaraan = new JButton("Data Kendaraan");
    JButton tombolSopir = new JButton("Data Sopir");
    JButton tombolLogOut = new JButton("Log Out");
    
    public MenuUtama() {
//        tableModel = new DefaultTableModel(namaKolom, 0);
//        table = new JTable(tableModel);
//        scrollPane = new JScrollPane(table);

        setTitle("Logistik App - MENU UTAMA");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 230);

        add(header);
        add(greet);
//        add(scrollPane);
        add(tombolKendaraan);
        add(tombolSopir);
        add(tombolLogOut);

        header.setBounds(20, 5, 440, 24);
        greet.setBounds(20,30,440,24);
//        scrollPane.setBounds(20, 36, 512, 320);
        tombolKendaraan.setBounds(20, 56, 512, 40);
        tombolSopir.setBounds(20, 100, 512, 40);
        tombolLogOut.setBounds(20, 144, 512, 40);
        
        tombolKendaraan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new DataKendaraan();
            }
        });
        
        tombolSopir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new DataSopir();
            }
        });
        
        tombolLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new LoginApp();
            }
        });
    }
}

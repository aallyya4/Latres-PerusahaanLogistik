/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author sabri
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Model.Session;

public class MenuUtama extends JFrame{
    JLabel header = new JLabel("Selamat Datang!");
    JLabel greet = new JLabel("Pilih menu kelola data:");    
    JButton tombolKendaraan = new JButton("Data Kendaraan");
    JButton tombolSopir = new JButton("Data Sopir");
    JButton tombolLogOut = new JButton("Log Out");
    
    public MenuUtama() {
        String userLogin = Session.getUsername();
        setTitle("Logistik App - MENU UTAMA");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 230);

        add(header);
        header.setText("Selamat datang " + Session.getUsername());
        add(greet);
        add(tombolKendaraan);
        add(tombolSopir);
        add(tombolLogOut);

        header.setBounds(20, 5, 440, 24);
        greet.setBounds(20,30,440,24);
        tombolKendaraan.setBounds(20, 56, 512, 40);
        tombolSopir.setBounds(20, 100, 512, 40);
        tombolLogOut.setBounds(20, 144, 512, 40);
        
        tombolKendaraan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DataKendaraan();
            }
        });
        
        tombolSopir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DataSopir();
            }
        });
        
        tombolLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginApp();
            }
        });
    }
}

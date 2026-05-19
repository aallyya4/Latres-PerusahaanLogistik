/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.ControllerKendaraan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sabri
 */
public class InputKendaraan extends JFrame{
    ControllerKendaraan controller;
    
    JLabel header = new JLabel("Input Kendaraan");
    JLabel labelInputPlat = new JLabel("Plat Nomor");
    JLabel labelInputJenis = new JLabel("Jenis");
    JLabel labelInputMerk = new JLabel("Merk");
    JTextField inputPlat = new JTextField();
    JTextField inputJenis = new JTextField();
    JTextField inputMerk = new JTextField();
    JButton tombolKembali = new JButton("Kembali");
    JButton tombolTambah = new JButton("Tambah");
    
    public InputKendaraan(){
        setTitle("Tambah Data Kendaraan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 370);

        add(header);
        add(labelInputPlat);
        add(labelInputJenis);
        add(labelInputMerk);
        add(inputPlat);
        add(inputJenis);
        add(inputMerk);
        add(tombolKembali);
        add(tombolTambah);
        
        header.setBounds(20, 5, 440, 30);
        labelInputPlat.setBounds(20, 35, 440, 20);
        inputPlat.setBounds(20, 60, 440, 36);
        labelInputJenis.setBounds(20, 100, 440, 20);
        inputJenis.setBounds(20, 125, 440, 36);
        labelInputMerk.setBounds(20, 165, 440, 20);
        inputMerk.setBounds(20, 190, 440, 36);
        tombolKembali.setBounds(20, 230, 440, 40);
        tombolTambah.setBounds(20, 275, 440, 40);

        setVisible(true);
        controller = new ControllerKendaraan(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new DataKendaraan();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                controller.insertKendaraan();
            }
        });        
    }
    
    public String getInputPlat() {
        return inputPlat.getText();
    }
    public String getInputJenis() {
        return inputJenis.getText();
    }
    public String getInputMerk() {
        return inputMerk.getText();
    }    
}

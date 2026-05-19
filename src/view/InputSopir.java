/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.ControllerSopir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sabri
 */
public class InputSopir extends JFrame{
    ControllerSopir controller;
    JLabel header = new JLabel("Input Sopir");
    JLabel labelInputNama = new JLabel("Nama Sopir");
    JLabel labelInputSIM = new JLabel("NO SIM");
    JLabel labelInputHP = new JLabel("NO HP");
    JTextField inputNama = new JTextField();
    JTextField inputSIM = new JTextField();
    JTextField inputHP = new JTextField();
    JButton tombolKembali = new JButton("Kembali");
    JButton tombolTambah = new JButton("Tambah");
    
    public InputSopir(){
        setTitle("Tambah Data Sopir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 370);

        add(header);
        add(labelInputNama);
        add(labelInputSIM);
        add(labelInputHP);
        add(inputNama);
        add(inputSIM);
        add(inputHP);
        add(tombolKembali);
        add(tombolTambah);
        
        header.setBounds(20, 5, 440, 30);
        labelInputNama.setBounds(20, 35, 440, 20);
        inputNama.setBounds(20, 60, 440, 36);
        labelInputSIM.setBounds(20, 100, 440, 20);
        inputSIM.setBounds(20, 125, 440, 36);
        labelInputHP.setBounds(20, 165, 440, 20);
        inputHP.setBounds(20, 190, 440, 36);
        tombolKembali.setBounds(20, 230, 440, 40);
        tombolTambah.setBounds(20, 275, 440, 40);

        setVisible(true);
        controller = new ControllerSopir(this);  
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new DataSopir();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                controller.insertSopir();
            }
        });        
    }
    public String getInputNama() {
        return inputNama.getText();
    }
    public String getInputNoSIM() {
        return inputSIM.getText();
    }
    public String getInputNoHP() {
        return inputHP.getText();
    }  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.ControllerKendaraan;
import Model.ModelKendaraan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sabri
 */
public class EditKendaraan extends JFrame{
    JLabel header = new JLabel("Edit Kendaraan");
    JLabel labelEditPlat = new JLabel("Plat Nomor");
    JLabel labelEditJenis = new JLabel("Jenis");
    JLabel labelEditMerk = new JLabel("Merk");
    JTextField EditPlat = new JTextField();
    JTextField EditJenis = new JTextField();
    JTextField EditMerk = new JTextField();
    JButton tombolKembali = new JButton("Kembali");
    JButton tombolEdit = new JButton("Edit");
    
    public EditKendaraan(ModelKendaraan kendaraan){
        ControllerKendaraan controller;
    
        setTitle("Edit Data Kendaraan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 370);

        add(header);;
        add(labelEditPlat);
        add(labelEditJenis);
        add(labelEditMerk);
        add(EditPlat);
        add(EditJenis);
        add(EditMerk);
        add(tombolKembali);
        add(tombolEdit);
        
        header.setBounds(20, 5, 440, 30);
        labelEditPlat.setBounds(20, 35, 440, 20);
        EditPlat.setBounds(20, 60, 440, 36);
        labelEditJenis.setBounds(20, 100, 440, 20);
        EditJenis.setBounds(20, 125, 440, 36);
        labelEditMerk.setBounds(20, 165, 440, 20);
        EditMerk.setBounds(20, 190, 440, 36);
        tombolKembali.setBounds(20, 230, 440, 40);
        tombolEdit.setBounds(20, 275, 440, 40);
        
        EditPlat.setText(kendaraan.getPlat());
        EditJenis.setText(kendaraan.getJenis());
        EditMerk.setText(kendaraan.getMerk());
        
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

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
            controller.editKendaraan(kendaraan.getId());
            }
        });        
    }

    public String getEditPlat() {
        return EditPlat.getText();
    }
    public String getEditJenis() {
        return EditJenis.getText();
    }
    public String getEditMerk() {
        return EditMerk.getText();
    }  
}

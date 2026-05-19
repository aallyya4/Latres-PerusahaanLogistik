/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Controller.ControllerKendaraan;
import Controller.ControllerSopir;
import Model.ModelSopir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sabri
 */
public class EditSopir extends JFrame{
    JLabel header = new JLabel("Edit Kendaraan");
    JLabel labelEditNama = new JLabel("Nama Sopir");
    JLabel labelEditSIM = new JLabel("NO SIM");
    JLabel labelEditHP = new JLabel("NO HP");
    JTextField EditNama = new JTextField();
    JTextField EditSIM = new JTextField();
    JTextField EditHP = new JTextField();
    JButton tombolKembali = new JButton("Kembali");
    JButton tombolEdit = new JButton("Edit");
    
    public EditSopir(ModelSopir sopir){
        ControllerSopir controller;
        setTitle("Edit Data Sopir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 370);

        add(header);
        add(labelEditNama);
        add(labelEditSIM);
        add(labelEditHP);
        add(EditNama);
        add(EditSIM);
        add(EditHP);
        add(tombolKembali);
        add(tombolEdit);
        
        header.setBounds(20, 5, 440, 30);
        labelEditNama.setBounds(20, 35, 440, 20);
        EditNama.setBounds(20, 60, 440, 36);
        labelEditSIM.setBounds(20, 100, 440, 20);
        EditSIM.setBounds(20, 125, 440, 36);
        labelEditHP.setBounds(20, 165, 440, 20);
        EditHP.setBounds(20, 190, 440, 36);
        tombolKembali.setBounds(20, 230, 440, 40);
        tombolEdit.setBounds(20, 275, 440, 40);

        EditNama.setText(sopir.getNama());
        EditSIM.setText(sopir.getNoSIM());
        EditHP.setText(sopir.getNoHP());        
        
        setVisible(true);
        controller = new ControllerSopir(this);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new MenuUtama();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                controller.editSopir(sopir.getId());
            }
        });        
    }
    
    public String getEditNama() {
        return EditNama.getText();
    }
    public String getEditNoSIM() {
        return EditSIM.getText();
    }
    public String getEditNoHP() {
        return EditHP.getText();
    }
}

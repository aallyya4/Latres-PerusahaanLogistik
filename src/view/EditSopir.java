/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

//import Controller.ControllerMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author sabri
 */
public class EditSopir extends JFrame{
    JLabel header = new JLabel("Edit Kendaraan");
    JLabel labelEditIDS = new JLabel("ID");
    JLabel labelEditNama = new JLabel("Nama Sopir");
    JLabel labelEditSIM = new JLabel("NO SIM");
    JLabel labelEditHP = new JLabel("NO HP");
    JTextField EditIDS = new JTextField();
    JTextField EditNama = new JTextField();
    JTextField EditSIM = new JTextField();
    JTextField EditHP = new JTextField();
    JButton tombolKembali = new JButton("Login");
    JButton tombolTambah = new JButton("Login");
    
    public EditSopir(){
        setTitle("Edit Data Sopir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 270);

        add(header);
        add(labelEditIDS);
        add(labelEditNama);
        add(labelEditSIM);
        add(labelEditHP);
        add(EditIDS);
        add(EditNama);
        add(EditSIM);
        add(EditHP);
        add(tombolKembali);
        add(tombolTambah);
        
        header.setBounds(20, 5, 440, 30);
        labelEditIDS.setBounds(20, 35, 440, 20);
        EditIDS.setBounds(20, 60, 440, 36);
        labelEditNama.setBounds(20, 100, 440, 20);
        EditNama.setBounds(20, 125, 440, 36);
        labelEditSIM.setBounds(20, 165, 440, 20);
        EditSIM.setBounds(20, 190, 440, 36);
        labelEditHP.setBounds(20, 230, 440, 20);
        EditHP.setBounds(20, 255, 440, 36);
        tombolKembali.setBounds(20, 295, 440, 40);
        tombolTambah.setBounds(20, 320, 440, 40);

        setVisible(true);
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new MenuUtama();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol login diklik, maka program akan berpindah ke halaman ViewData()
                dispose();
                new MenuUtama();
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

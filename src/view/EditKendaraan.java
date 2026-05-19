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
public class EditKendaraan extends JFrame{
    JLabel header = new JLabel("Edit Kendaraan");
    JLabel labelEditIDK = new JLabel("ID");
    JLabel labelEditPlat = new JLabel("Plat Nomor");
    JLabel labelEditJenis = new JLabel("Jenis");
    JLabel labelEditMerk = new JLabel("Merk");
    JTextField EditIDK = new JTextField();
    JTextField EditPlat = new JTextField();
    JTextField EditJenis = new JTextField();
    JTextField EditMerk = new JTextField();
    JButton tombolKembali = new JButton("Login");
    JButton tombolTambah = new JButton("Login");
    
    public EditKendaraan(){
        setTitle("Edit Data Kendaraan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 270);

        add(header);
        add(labelEditIDK);
        add(labelEditPlat);
        add(labelEditJenis);
        add(labelEditMerk);
        add(EditIDK);
        add(EditPlat);
        add(EditJenis);
        add(EditMerk);
        add(tombolKembali);
        add(tombolTambah);
        
        header.setBounds(20, 5, 440, 30);
        labelEditIDK.setBounds(20, 35, 440, 20);
        EditIDK.setBounds(20, 60, 440, 36);
        labelEditPlat.setBounds(20, 100, 440, 20);
        EditPlat.setBounds(20, 125, 440, 36);
        labelEditJenis.setBounds(20, 165, 440, 20);
        EditJenis.setBounds(20, 190, 440, 36);
        labelEditMerk.setBounds(20, 230, 440, 20);
        EditMerk.setBounds(20, 255, 440, 36);
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

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
public class InputSopir extends JFrame{
    JLabel header = new JLabel("Input Sopir");
    JLabel labelInputIDS = new JLabel("ID");
    JLabel labelInputNama = new JLabel("Nama Sopir");
    JLabel labelInputSIM = new JLabel("NO SIM");
    JLabel labelInputHP = new JLabel("NO HP");
    JTextField inputIDS = new JTextField();
    JTextField inputNama = new JTextField();
    JTextField inputSIM = new JTextField();
    JTextField inputHP = new JTextField();
    JButton tombolKembali = new JButton("Login");
    JButton tombolTambah = new JButton("Login");
    
    public InputSopir(){
        setTitle("Tambah Data Sopir");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 270);

        add(header);
        add(labelInputIDS);
        add(labelInputNama);
        add(labelInputSIM);
        add(labelInputHP);
        add(inputIDS);
        add(inputNama);
        add(inputSIM);
        add(inputHP);
        add(tombolKembali);
        add(tombolTambah);
        
        header.setBounds(20, 5, 440, 30);
        labelInputIDS.setBounds(20, 35, 440, 20);
        inputIDS.setBounds(20, 60, 440, 36);
        labelInputNama.setBounds(20, 100, 440, 20);
        inputNama.setBounds(20, 125, 440, 36);
        labelInputSIM.setBounds(20, 165, 440, 20);
        inputSIM.setBounds(20, 190, 440, 36);
        labelInputHP.setBounds(20, 230, 440, 20);
        inputHP.setBounds(20, 255, 440, 36);
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

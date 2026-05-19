/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
//
//import Controller.ControllerMahasiswa;
//import Model.Mahasiswa.ModelMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sabri
 */
public class DataSopir extends JFrame{
    JLabel header = new JLabel("Tabel Data Kendaraan");
    JButton tombolTambah = new JButton("Tambah");
    JButton tombolEdit = new JButton("Edit");
    JButton tombolHapus = new JButton("Hapus");
    JButton tombolKembali = new JButton ("Kembali ke Menu");
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    String namaKolom[] = {"ID", "Nama Sopir", "No SIM", "NO HP"};
    
    public DataSopir(){
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Kelola Data Sopir");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(552, 575);

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);
        add(tombolKembali);

        header.setBounds(20, 5, 440, 24);
        scrollPane.setBounds(20, 35, 512, 320);
        tombolTambah.setBounds(20, 360, 512, 40);
        tombolEdit.setBounds(20, 404, 512, 40);
        tombolHapus.setBounds(20, 448, 512, 40);
        tombolKembali.setBounds(20, 492, 512, 40);
    }

    public JTable getTableSopir() {
        return table;
    }
}

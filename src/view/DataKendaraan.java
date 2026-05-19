/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
//
import Controller.ControllerKendaraan;
import Model.ModelKendaraan;
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
public class DataKendaraan extends JFrame{
    Integer baris;
    ControllerKendaraan controller;
    JLabel header = new JLabel("Tabel Data Kendaraan");
    JButton tombolTambah = new JButton("Tambah");
    JButton tombolEdit = new JButton("Edit");
    JButton tombolHapus = new JButton("Hapus");
    JButton tombolKembali = new JButton ("Kembali ke Menu");
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    
    String namaKolom[] = {"ID", "Plat Nomor", "Jenis", "Merk"};
    
    public DataKendaraan(){
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Kelola Data Kendaraan");
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
/*
          Memanggil method showData() dari controller untuk
          mengisi tabel dengan data yang diambil dari DB
         */
        controller = new ControllerKendaraan(this);
        controller.showAllKendaraan();

        // Menambahkan event handling ketika salah satu baris di tabel dipilih
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Mengambil baris ke-n dari tabel
                baris = table.getSelectedRow();
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputKendaraan();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengecek apakah ada baris di dalam tabel yang dipilih atau tidak
                if (baris != null) {
                    
                    ModelKendaraan kendaraanTerpilih = new ModelKendaraan();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String plat = table.getValueAt(baris, 1).toString();
                    String jenis= table.getValueAt(baris, 2).toString();
                    String merk= table.getValueAt(baris, 3).toString();
                    
                    kendaraanTerpilih.setId(id);
                    kendaraanTerpilih.setPlat(plat);
                    kendaraanTerpilih.setJenis(jenis);
                    kendaraanTerpilih.setMerk(merk);
                    
                    dispose();
                    new EditKendaraan(kendaraanTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengecek apakah ada baris di dalam tabel yang dipilih atau tidak
                if (baris != null) {
                    controller.deleteKendaraan(baris);
                    
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
         tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuUtama();
            }
        });
    }



    public JTable getTableKendaraan() {
        return table;
    }
}

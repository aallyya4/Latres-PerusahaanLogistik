/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
//
import Controller.ControllerSopir;
import Model.ModelSopir;
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
    Integer baris;
    ControllerSopir controller;
    
    JLabel header = new JLabel("Tabel Data Kendaraan");
    JButton tombolTambah = new JButton("Tambah");
    JButton tombolEdit = new JButton("Edit");
    JButton tombolHapus = new JButton("Hapus");
    JButton tombolKembali = new JButton ("Kembali ke Menu");
    JLabel labelCari = new JLabel("Cari:");
    JTextField inputCari = new JTextField();
    JButton tombolCari = new JButton("Cari Data");
    
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
        add(labelCari);
        add(inputCari);
        add(tombolCari);

        header.setBounds(20, 5, 440, 24);
        tombolCari.setBounds(420, 5, 112, 24);
        inputCari.setBounds(270, 5, 140, 24);
        labelCari.setBounds(230, 5, 40, 24);
        scrollPane.setBounds(20, 35, 512, 320);
        tombolTambah.setBounds(20, 360, 512, 40);
        tombolEdit.setBounds(20, 404, 512, 40);
        tombolHapus.setBounds(20, 448, 512, 40);
        tombolKembali.setBounds(20, 492, 512, 40);
        
        /*
          Memanggil method showData() dari controller untuk
          mengisi tabel dengan data yang diambil dari DB
         */
        controller = new ControllerSopir(this);
        controller.showAllSopir();

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
                new InputSopir();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    ModelSopir sopirTerpilih = new ModelSopir();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String sim = table.getValueAt(baris, 2).toString();
                    String hp = table.getValueAt(baris, 3).toString();
                    
                    sopirTerpilih.setId(id);
                    sopirTerpilih.setNama(nama);
                    sopirTerpilih.setNoSIM(sim);
                    sopirTerpilih.setNoHP(hp);
                    
                    dispose();
                    new EditSopir(sopirTerpilih);
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
                    controller.deleteSopir(baris);
                    
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
        
        tombolCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = inputCari.getText().trim();

                if (keyword.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Tidak ada inputan!",
                            "Peringatan",
                            JOptionPane.WARNING_MESSAGE);
                    controller.showAllSopir();
                    return;
                } else {
                    controller.cariSopir(keyword);
                }
            }
        });

    }

    public JTable getTableSopir() {
        return table;
    }
}

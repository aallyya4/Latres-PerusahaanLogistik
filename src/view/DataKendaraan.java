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

        // Memberikan event handling ketika tombol "Tambah Mahasiswa" diklik
        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol tambah diklik, maka program akan berpindah ke halaman InputData()
                dispose();
                new InputKendaraan();
            }
        });

        // Memberikan event handling ketika tombol "Edit Mahasiswa" diklik
        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengecek apakah ada baris di dalam tabel yang dipilih atau tidak
                if (baris != null) {
                    /*
                      Membuat instance "mahasiswa" yang digunakan untuk menyimpan 
                      informasi mahasiswa yang diklik di table.
                    */
                    ModelKendaraan kendaraanTerpilih = new ModelKendaraan();
                    
                    // Mengambil id dan nama berdasarkan baris yang dipilih
                    Integer id = (int) table.getValueAt(baris, 0);
                    String plat = table.getValueAt(baris, 1).toString();
                    String jenis= table.getValueAt(baris, 2).toString();
                    String merk= table.getValueAt(baris, 3).toString();
                    
                    // Menyimpan informasi id, nama, dan nim ke objek "mahasiswaTerpilih".
                    kendaraanTerpilih.setId(id);
                    kendaraanTerpilih.setPlat(plat);
                    kendaraanTerpilih.setJenis(jenis);
                    kendaraanTerpilih.setMerk(merk);
                    
                    /* 
                      Ketika tombol edit diklik, maka program akan berpindah ke 
                      halaman EditData() dengan membawa id, nama, dan nim untuk
                      diberikan ke halaman EditData()
                     */
                    dispose();
                    new EditKendaraan();
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        // Memberikan event handling ketika tombol "Hapus Mahasiswa" diklik
        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengecek apakah ada baris di dalam tabel yang dipilih atau tidak
                if (baris != null) {
                    controller.deleteKendaraan(baris);
                    
                    /*
                      Mengembalikan nilai dari variabel baris ke null. Kenapa?
                      Karena halaman tidak dimuat ulang, hanya tabel yang direfresh.
                      Sehingga variabel baris harus dikembalikan ke value awalnya.
                      
                      Jika tidak, maka setelah user menghapus mahasiswa,
                      lalu langsung menekan tombol "Edit" atau "Hapus", maka akan 
                      terjadi error karena variabel baris masih menyimpan nilai lama,
                      sedangkan baris yang lama sudah terhapus.
                    */
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
    }



    public JTable getTableKendaraan() {
        return table;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rafli
 */
public class TabelSopir extends AbstractTableModel {

    // Berfungsi untuk menyimpan daftar mahasiswa
    List<ModelSopir> daftarSopir;

    /*
      Nama kolom tabelnya disimpan ke dalam variabel "namaKolom" yang memiliki 
      tipe data Array String.
     */
    String kolom[] = {"ID", "Nama", "No SIM", "No HP"};

    /*
      Karena daftarMahasiswa memiliki tipe data List, kita harus mengubahnya
      terlebih dahulu ke dalam tipe data Array Object supaya dapat 
      dimasukkan ke dalam table.
     */
    public TabelSopir(List<ModelSopir> daftarSopir) {
        this.daftarSopir = daftarSopir;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarSopir.size();
    }

    // Method untuk mengambil jumlah kolom dari tabel
    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarSopir.get(rowIndex).getId();
            case 1:
                return daftarSopir.get(rowIndex).getNama();
            case 2:
                return daftarSopir.get(rowIndex).getNoSIM();
            case 3:
                return daftarSopir.get(rowIndex).getNoHP();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}

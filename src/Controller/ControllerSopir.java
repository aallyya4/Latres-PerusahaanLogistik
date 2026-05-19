package Controller;

import Model.*;
import view.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerSopir {

    DataSopir halamanTable;
    InputSopir halamanInput;
    EditSopir halamanEdit;

    InterDAOsopir daoSopir;

    // Membuat variabel "daftarMahasiswa" untuk menyimpan data mahasiswa yg diambil dari DB.
    List<ModelSopir> daftarSopir;
    
    
    /*
      Kalo temen-temen liat di sini, ada 3 fungsi contructor yang masing-masing memiliki
      parameter yang berbeda. Nah, hal ini disebut dengan "function overloading",
      yaitu sebuah fungsi yang memiliki nama sama tetapi memiliki parameter yang berbeda.
      
      Mengapa kita butuh "function overloading"?
      Karena dalam hal ini, controller mahasiswa akan digunakan pada 3 halaman atau 3 view yang berbeda, 
      yaitu Halaman Table, Halaman Input, dan Halaman Edit.
    */
    public ControllerSopir(DataSopir halamanTable) {
        this.halamanTable = halamanTable;
        this.daoSopir = new DAOsopir();
    }
    
    public ControllerSopir(InputSopir halamanInput) {
        this.halamanInput = halamanInput;
        this.daoSopir = new DAOsopir();
    }
    
    public ControllerSopir(EditSopir halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoSopir = new DAOsopir();
    }

    public void showAllSopir() {
        /*
          Mengambil daftar mahasiswa dari database, 
          kemudian disimpan ke dalam variabel bernama list.
         */
        daftarSopir = daoSopir.getAll();

        /* 
          Supaya daftarMahasiswa dapat dimasukkan ke dalam tabel, kita perlu 
          mengubah daftarMahasiswa yang memiliki tipe data List menjadi 
          tipe data Array Object. Jika pada pertemuan kemarin kita melakukannya
          secara manual menggunakan looping, kali ini kita tidak perlu melakukan hal tersebut,
          karena class ModelTabel sudah otomatis mengubahnya menjadi tipe data yang sesuai.
          
          Caranya kita hanya perlu membuat sebuah instance dari class ModelTable,
          kemudian kita masukkan variabel daftarMahasiswa sebagai parameter constructor
          supaya dapat diubah menjadi sebuah isi table yang dapat dimasukkan ke dalam tabel.
         */
        TabelSopir table = new TabelSopir(daftarSopir);

        // Mengisi tabel yang berada pada halaman Table Mahasiswa
        halamanTable.getTableSopir().setModel(table);
    }

    public void insertSopir() {
        try {
            // Membuat "mahasiswa baru" yang isinya masih kosong
            ModelSopir sopirBaru = new ModelSopir();
            
            /*
              Mengambil input nama dan nim menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nim".
            */
            String nama = halamanInput.getInputNama();
            String sim = halamanInput.getInputNoSIM();
            String hp = halamanInput.getInputNoHP();
            
            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(nama) || "".equals(sim) || "".equals(hp)) {
                throw new Exception("Nama, Nomor SIM, dan atau Nomor HP tidak boleh kosong!");
            }
            
            // Mengisi nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            sopirBaru.setNama(nama);
            sopirBaru.setNoSIM(sim);
            sopirBaru.setNoHP(hp);
            
            // Memasukkan "mahasiswa baru" ke dalam database.
            daoSopir.insert(sopirBaru);
            
            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "sopir baru berhasil ditambahkan.");
            
            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanInput.dispose();
            new DataSopir();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editSopir(int id) {
        try {
            /*
              Membuat instance "mahasiswa yang mau diedit" buat 
              menyimpan informasi mahasiswa yang mau diedit.
            */
            ModelSopir sopirYangMauDiedit = new ModelSopir();
                        
            /*
              Mengambil input nama dan nim menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nim".
            */
            String nama = halamanEdit.getEditNama();
            String sim = halamanEdit.getEditNoSIM();
            String hp = halamanEdit.getEditNoHP();
            
            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(nama) || "".equals(sim) || "".equals(hp)) {
                throw new Exception("Nama, Nomor SIM, dan atau Nomor HP tidak boleh kosong!");
            }
            
            // Mengisi id, nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            sopirYangMauDiedit.setId(id);
            sopirYangMauDiedit.setNama(nama);
            sopirYangMauDiedit.setNoSIM(sim);
            sopirYangMauDiedit.setNoHP(hp);            
            
            // Memasukkan "mahasiswa baru" ke dalam database.
            daoSopir.update(sopirYangMauDiedit);

            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Data sopir berhasil diubah.");

            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanEdit.dispose();
            new DataSopir();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteSopir(Integer baris) {
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable.getTableSopir().getValueAt(baris, 0);
        String nama = halamanTable.getTableSopir().getValueAt(baris, 1).toString();
        String sim = halamanTable.getTableSopir().getValueAt(baris, 2).toString();
        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Kendaraan",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            /* 
              Memanggil method delete() untuk menghaous data dari DB
              berdasarkan id yang dipilih.
            */
            daoSopir.delete(id);
            
            // Menampilkan pop-up jika berhasil menghapus.
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            // Memanggil method "showAllMahasiswa()" untuk merefresh table.
            showAllSopir();
        }
    }
}

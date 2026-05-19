package Controller;

import Model.*;
import view.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerKendaraan {

    DataKendaraan halamanTable;
    InputKendaraan halamanInput;
    EditKendaraan halamanEdit;

    InterDAOkendaraan daoKendaraan;

    // Membuat variabel "daftarMahasiswa" untuk menyimpan data mahasiswa yg diambil dari DB.
    List<ModelKendaraan> daftarKendaraan;
    
    
    /*
      Kalo temen-temen liat di sini, ada 3 fungsi contructor yang masing-masing memiliki
      parameter yang berbeda. Nah, hal ini disebut dengan "function overloading",
      yaitu sebuah fungsi yang memiliki nama sama tetapi memiliki parameter yang berbeda.
      
      Mengapa kita butuh "function overloading"?
      Karena dalam hal ini, controller mahasiswa akan digunakan pada 3 halaman atau 3 view yang berbeda, 
      yaitu Halaman Table, Halaman Input, dan Halaman Edit.
    */
    public ControllerKendaraan(DataKendaraan halamanTable) {
        this.halamanTable = halamanTable;
        this.daoKendaraan = new DAOkendaraan();
    }
    
    public ControllerKendaraan(InputKendaraan halamanInput) {
        this.halamanInput = halamanInput;
        this.daoKendaraan = new DAOkendaraan();
    }
    
    public ControllerKendaraan(EditKendaraan halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoKendaraan = new DAOkendaraan();
    }

    public void showAllKendaraan() {
        /*
          Mengambil daftar mahasiswa dari database, 
          kemudian disimpan ke dalam variabel bernama list.
         */
        daftarKendaraan = daoKendaraan.getAll();

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
        TabelKendaraan table = new TabelKendaraan(daftarKendaraan);

        // Mengisi tabel yang berada pada halaman Table Mahasiswa
        halamanTable.getTableKendaraan().setModel(table);
    }

    public void insertKendaraan() {
        try {
            // Membuat "mahasiswa baru" yang isinya masih kosong
            ModelKendaraan kendaraanBaru = new ModelKendaraan();
            
            /*
              Mengambil input nama dan nim menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nim".
            */
            String plat = halamanInput.getInputPlat();
            String jenis = halamanInput.getInputJenis();
            String merk = halamanInput.getInputMerk();
            
            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(plat) || "".equals(jenis) || "".equals(merk)) {
                throw new Exception("Plat Nomor, Jenis, dan atau Merk tidak boleh kosong!");
            }
            
            // Mengisi nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            kendaraanBaru.setPlat(plat);
            kendaraanBaru.setJenis(jenis);
            kendaraanBaru.setMerk(merk);
            
            // Memasukkan "mahasiswa baru" ke dalam database.
            daoKendaraan.insert(kendaraanBaru);
            
            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "kendaraan baru berhasil ditambahkan.");
            
            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanInput.dispose();
            new DataKendaraan();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editKendaraan(int id) {
        try {
            /*
              Membuat instance "mahasiswa yang mau diedit" buat 
              menyimpan informasi mahasiswa yang mau diedit.
            */
            ModelKendaraan kendaraanYangMauDiedit = new ModelKendaraan();
                        
            /*
              Mengambil input nama dan nim menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nim".
            */
            String plat = halamanEdit.getEditPlat();
            String jenis = halamanEdit.getEditJenis();
            String merk = halamanEdit.getEditMerk();
            
            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(plat) || "".equals(jenis) || "".equals(merk)) {
                throw new Exception("Plat Nomor, Jenis, dan atau Merk tidak boleh kosong!");
            }
            
            // Mengisi id, nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            kendaraanYangMauDiedit.setId(id);
            kendaraanYangMauDiedit.setPlat(plat);
            kendaraanYangMauDiedit.setJenis(jenis);
            kendaraanYangMauDiedit.setMerk(merk);            
            
            // Memasukkan "mahasiswa baru" ke dalam database.
            daoKendaraan.update(kendaraanYangMauDiedit);

            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Data kendaraan berhasil diubah.");

            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanEdit.dispose();
            new DataKendaraan();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteKendaraan(Integer baris) {
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable.getTableKendaraan().getValueAt(baris, 0);
        String plat = halamanTable.getTableKendaraan().getValueAt(baris, 1).toString();
        String merk = halamanTable.getTableKendaraan().getValueAt(baris, 2).toString();
        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + plat + "?",
                "Hapus Kendaraan",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            /* 
              Memanggil method delete() untuk menghaous data dari DB
              berdasarkan id yang dipilih.
            */
            daoKendaraan.delete(id);
            
            // Menampilkan pop-up jika berhasil menghapus.
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            // Memanggil method "showAllMahasiswa()" untuk merefresh table.
            showAllKendaraan();
        }
    }
}

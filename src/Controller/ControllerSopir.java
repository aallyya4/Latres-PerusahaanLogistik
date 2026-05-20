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

    List<ModelSopir> daftarSopir;

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

        daftarSopir = daoSopir.getAll();

        TabelSopir table = new TabelSopir(daftarSopir);

        halamanTable.getTableSopir().setModel(table);
    }

    public void insertSopir() {
        try {
            ModelSopir sopirBaru = new ModelSopir();
            
            String nama = halamanInput.getInputNama();
            String sim = halamanInput.getInputNoSIM();
            String hp = halamanInput.getInputNoHP();
           
            if ("".equals(nama) || "".equals(sim) || "".equals(hp)) {
                throw new Exception("Nama, Nomor SIM, dan atau Nomor HP tidak boleh kosong!");
            }
            
            sopirBaru.setNama(nama);
            sopirBaru.setNoSIM(sim);
            sopirBaru.setNoHP(hp);
            
            daoSopir.insert(sopirBaru);

            JOptionPane.showMessageDialog(null, "sopir baru berhasil ditambahkan.");
            
            halamanInput.dispose();
            new DataSopir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editSopir(int id) {
        try {
            ModelSopir sopirYangMauDiedit = new ModelSopir();
            
            String nama = halamanEdit.getEditNama();
            String sim = halamanEdit.getEditNoSIM();
            String hp = halamanEdit.getEditNoHP();
           
            if ("".equals(nama) || "".equals(sim) || "".equals(hp)) {
                throw new Exception("Nama, Nomor SIM, dan atau Nomor HP tidak boleh kosong!");
            }
            
            sopirYangMauDiedit.setId(id);
            sopirYangMauDiedit.setNama(nama);
            sopirYangMauDiedit.setNoSIM(sim);
            sopirYangMauDiedit.setNoHP(hp);            
            
            daoSopir.update(sopirYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data sopir berhasil diubah.");

            halamanEdit.dispose();
            new DataSopir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteSopir(Integer baris) {
        Integer id = (int) halamanTable.getTableSopir().getValueAt(baris, 0);
        String nama = halamanTable.getTableSopir().getValueAt(baris, 1).toString();
        String sim = halamanTable.getTableSopir().getValueAt(baris, 2).toString();
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Kendaraan",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoSopir.delete(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllSopir();
        }
    }
    
    public void cariSopir(String keyword) {
        daftarSopir = daoSopir.search(keyword);
        
        if (daftarSopir.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sopir tidak ditemukan!");
            showAllSopir(); // tampilkan lagi semua data
        } else {
            TabelSopir table = new TabelSopir(daftarSopir);
            halamanTable.getTableSopir().setModel(table);

            JOptionPane.showMessageDialog(null, "Sopir berhasil ditemukan.");
        }
    }
}

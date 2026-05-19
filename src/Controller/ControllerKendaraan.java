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

    List<ModelKendaraan> daftarKendaraan;

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
        daftarKendaraan = daoKendaraan.getAll();

        TabelKendaraan table = new TabelKendaraan(daftarKendaraan);

        halamanTable.getTableKendaraan().setModel(table);
    }

    public void insertKendaraan() {
        try {
            ModelKendaraan kendaraanBaru = new ModelKendaraan();
            
            String plat = halamanInput.getInputPlat();
            String jenis = halamanInput.getInputJenis();
            String merk = halamanInput.getInputMerk();
            
            if ("".equals(plat) || "".equals(jenis) || "".equals(merk)) {
                throw new Exception("Plat Nomor, Jenis, dan atau Merk tidak boleh kosong!");
            }
            
            kendaraanBaru.setPlat(plat);
            kendaraanBaru.setJenis(jenis);
            kendaraanBaru.setMerk(merk);
            
            daoKendaraan.insert(kendaraanBaru);
            
            JOptionPane.showMessageDialog(null, "kendaraan baru berhasil ditambahkan.");
            
            halamanInput.dispose();
            new DataKendaraan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editKendaraan(int id) {
        try {
            ModelKendaraan kendaraanYangMauDiedit = new ModelKendaraan();

            String plat = halamanEdit.getEditPlat();
            String jenis = halamanEdit.getEditJenis();
            String merk = halamanEdit.getEditMerk();
            
            if ("".equals(plat) || "".equals(jenis) || "".equals(merk)) {
                throw new Exception("Plat Nomor, Jenis, dan atau Merk tidak boleh kosong!");
            }
            
            kendaraanYangMauDiedit.setId(id);
            kendaraanYangMauDiedit.setPlat(plat);
            kendaraanYangMauDiedit.setJenis(jenis);
            kendaraanYangMauDiedit.setMerk(merk);            
            
            daoKendaraan.update(kendaraanYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data kendaraan berhasil diubah.");

            halamanEdit.dispose();
            new DataKendaraan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteKendaraan(Integer baris) {
        Integer id = (int) halamanTable.getTableKendaraan().getValueAt(baris, 0);
        String plat = halamanTable.getTableKendaraan().getValueAt(baris, 1).toString();
        String merk = halamanTable.getTableKendaraan().getValueAt(baris, 2).toString();
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + plat + "?",
                "Hapus Kendaraan",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoKendaraan.delete(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllKendaraan();
        }
    }
}

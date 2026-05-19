package Model;

import java.util.List;

public interface InterDAOkendaraan {
    // Method untuk memasukkan suatu data mahasiswa
    public void insert(ModelKendaraan kendaraan);
    
    // Method untuk mengupdate (mengedit) suatu data mahasiswa
    public void update(ModelKendaraan kendaraan);
    
    // Method untuk menghapus suatu data mahasiswa
    public void delete(int id);
    
    // Method untuk mengambil data mahasiswa
    public List<ModelKendaraan> getAll();
}

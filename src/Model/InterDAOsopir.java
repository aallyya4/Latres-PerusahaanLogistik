package Model;

import java.util.List;

public interface InterDAOsopir {
    // Method untuk memasukkan suatu data mahasiswa
    public void insert(ModelSopir sopir);
    
    // Method untuk mengupdate (mengedit) suatu data mahasiswa
    public void update(ModelSopir sopir);
    
    // Method untuk menghapus suatu data mahasiswa
    public void delete(int id);
    
    // Method untuk mengambil data mahasiswa
    public List<ModelSopir> getAll();
}

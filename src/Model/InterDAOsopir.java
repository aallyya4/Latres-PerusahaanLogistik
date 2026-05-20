package Model;

import java.util.List;

public interface InterDAOsopir {
    // Method untuk memasukkan suatu data sopir
    public void insert(ModelSopir sopir);
    
    // Method untuk mengupdate (mengedit) suatu data sopir
    public void update(ModelSopir sopir);
    
    // Method untuk menghapus suatu data sopir
    public void delete(int id);
    
    // Method untuk mengambil data sopir
    public List<ModelSopir> getAll();
    
    // Method cari sopir
    public List<ModelSopir> search(String keyword);
}

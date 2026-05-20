package Model;

import java.util.List;

public interface InterDAOkendaraan {
    // Method untuk memasukkan suatu data kendaraan
    public void insert(ModelKendaraan kendaraan);
    
    // Method untuk mengupdate (mengedit) suatu data kendaraan
    public void update(ModelKendaraan kendaraan);
    
    // Method untuk menghapus suatu data kendaraan
    public void delete(int id);
    
    // Method untuk mengambil data kendaraan
    public List<ModelKendaraan> getAll();
    
    // Method cari kendaraan
    public List<ModelKendaraan> search(String keyword);
}

package Model;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOkendaraan implements InterDAOkendaraan {

    @Override
    public void insert(ModelKendaraan kendaraan) {
       try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "INSERT INTO kendaraan (plat_nomor, jenis, merk) VALUES (?, ?, ?);";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, kendaraan.getPlat());
            statement.setString(2, kendaraan.getJenis());
            statement.setString(3, kendaraan.getMerk());
            
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(ModelKendaraan kendaraan) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE kendaraan SET plat_nomor=?, jenis=?, merk=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, kendaraan.getPlat());
            statement.setString(2, kendaraan.getJenis());
            statement.setString(3, kendaraan.getMerk());
            statement.setInt(4, kendaraan.getId());
            
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "DELETE FROM kendaraan WHERE id=?;";
          
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal hapus data.
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelKendaraan> getAll() {
         List<ModelKendaraan> listKendaraan = null;

        try {
            listKendaraan = new ArrayList<>();
            
            // Membuat objek statement yang digunakan untuk melakukan query.
            Statement statement = Connector.Connect().createStatement();
            
            String query = "SELECT * FROM kendaraan;";
            
             // Mengeksekusi query dan menyimpannya ke dalam variabel "resultSet".
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelKendaraan knd = new ModelKendaraan();
                
                knd.setId(resultSet.getInt("id"));
                knd.setPlat(resultSet.getString("plat_nomor"));
                knd.setJenis(resultSet.getString("jenis"));
                knd.setMerk(resultSet.getString("merk"));
                
                listKendaraan.add(knd);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listKendaraan;
    }
}

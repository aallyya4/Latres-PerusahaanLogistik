package Model;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOsopir implements InterDAOsopir {

    @Override
    public void insert(ModelSopir sopir) {
       try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "INSERT INTO sopir (nama, no_sim, no_hp) VALUES (?, ?, ?);";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, sopir.getNama());
            statement.setString(2, sopir.getNoSIM());
            statement.setString(3, sopir.getNoHP());
            
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }

    @Override
    public void update(ModelSopir sopir) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE sopir SET nama=?, no_sim=?, no_hp=? WHERE id=?;";
           
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, sopir.getNama());
            statement.setString(2, sopir.getNoSIM());
            statement.setString(3, sopir.getNoHP());
            statement.setInt(4, sopir.getId());
            
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
            String query = "DELETE FROM sopir WHERE id=?;";
            
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
    public List<ModelSopir> getAll() {
         List<ModelSopir> listSopir = null;

        try {
            listSopir = new ArrayList<>();
            
            // Membuat objek statement yang digunakan untuk melakukan query.
            Statement statement = Connector.Connect().createStatement();
           
            String query = "SELECT * FROM sopir;";
            
             // Mengeksekusi query dan menyimpannya ke dalam variabel "resultSet".
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelSopir spr = new ModelSopir();
                
                spr.setId(resultSet.getInt("id"));
                spr.setNama(resultSet.getString("nama"));
                spr.setNoSIM(resultSet.getString("no_sim"));
                spr.setNoHP(resultSet.getString("no_hp"));
               
                listSopir.add(spr);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listSopir;
    }
    
    @Override
    public List<ModelSopir> search(String keyword) {
        List<ModelSopir> listSopir = new ArrayList<>();

        try {
            String query = "SELECT * FROM sopir WHERE nama LIKE ? OR no_sim LIKE ?";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                ModelSopir sopir = new ModelSopir();

                sopir.setId(rs.getInt("id"));
                sopir.setNama(rs.getString("nama"));
                sopir.setNoSIM(rs.getString("no_sim"));
                sopir.setNoHP(rs.getString("no_hp"));

                listSopir.add(sopir);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSopir;
    }
}

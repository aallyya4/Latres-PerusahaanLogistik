package Model;

public class ModelSopir {
    private Integer id;
    private String nama, no_sim, no_hp;
    
    /*
      Membuat getter dan setter untuk mengambil/mengatur informasi mahasiswa.
      Karena sekarang atribut id, nama, dan nim diubah menjadi private, 
      sehingga atribut2 tersebut tidak dapat diakses secara langsung (Prinsip Enkapsulasi)
    */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoSIM() {
        return no_sim;
    }

    public void setNoSIM(String no_sim) {
        this.no_sim = no_sim;
    }
    
    public String getNoHP() {
        return no_hp;
    }

    public void setNoHP(String no_hp) {
        this.no_hp = no_hp;
    }
}


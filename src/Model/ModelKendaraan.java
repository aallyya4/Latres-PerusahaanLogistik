package Model;

public class ModelKendaraan {
    private Integer id;
    private String plat_nomor, jenis, merk;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlat() {
        return plat_nomor;
    }

    public void setPlat(String plat_nomor) {
        this.plat_nomor = plat_nomor;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}


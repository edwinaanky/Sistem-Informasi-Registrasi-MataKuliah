/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk;

/**
 *
 * @author desmoncode
 */
public abstract class Orang {
    private String name;
    private String jenisKelamin;
    private String alamat;
    private String telepon;
    
    public Orang(String name, String jenisKelamin, String alamat, String telepon){
        this.name = name;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.telepon = telepon;
    };
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    
}

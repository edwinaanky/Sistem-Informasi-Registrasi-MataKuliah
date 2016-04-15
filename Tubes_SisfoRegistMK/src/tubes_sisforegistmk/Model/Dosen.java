/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Model;

import java.io.Serializable;

/**
 *
 * @author desmoncode
 */
public class Dosen extends Orang implements Serializable{
    private long nik;
    private String kk;
    private String status;

    public Dosen(long nik, String kk, String status, String name, String jenisKelamin, String alamat, String telepon) {
        super(name, jenisKelamin, alamat, telepon);
        this.nik = nik;
        this.kk = kk;
        this.status = status;
    }

    public Dosen() {
        super();
    }
    
    

    public long getNik() {
        return nik;
    }

    public void setNik(long nik) {
        this.nik = nik;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

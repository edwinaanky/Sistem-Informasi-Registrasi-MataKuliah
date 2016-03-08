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
public class Dosen extends Orang {

    private long nik;
    private String kk;

    public Dosen(long nik, String kk, String name, String jenisKelamin, String alamat, String telepon) {
        super(name, jenisKelamin, alamat, telepon);
        this.nik = nik;
        this.kk = kk;
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

}

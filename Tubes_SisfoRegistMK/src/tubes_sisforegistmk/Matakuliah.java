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
public class Matakuliah {

    private String kode;
    private String namaMatkul;
    private int sks;
    private int maxMhs;
    private int jmlMhs = 0;

    public Matakuliah(String kode, String namaMatkul, int sks, int maxMhs) {
        this.kode = kode;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
        this.maxMhs = maxMhs;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public int getMaxMhs() {
        return maxMhs;
    }

    public void setMaxMhs(int maxMhs) {
        this.maxMhs = maxMhs;
    }

    public int getJmlMhs() {
        return jmlMhs;
    }

    public void setJmlMhs(int jmlMhs) {
        this.jmlMhs = jmlMhs;
    }

}

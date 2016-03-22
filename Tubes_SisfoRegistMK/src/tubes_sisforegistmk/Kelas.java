/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk;

import java.io.Serializable;

/**
 *
 * @author desmoncode
 */
public class Kelas implements Serializable{

    private String namaKelas;
    private Matakuliah matakuliah;
    private Dosen dosen;
    private int maxMhs;
    private int jmlMhs = 0;

    public Kelas(String namaKelas, int maxMhs) {
        this.namaKelas = namaKelas;
        this.maxMhs = maxMhs;
    }

    public void setMatakuliah(Matakuliah m) {
        matakuliah = m;
    }

    public void setDosen(Dosen d) {
        dosen = d;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public Matakuliah getMatakuliah() {
        return matakuliah;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
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

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
public class Kelas {

    private String namaKelas;
    private Matakuliah[] matakuliah;
    private Dosen[] dosen;
    private int maxMhs;
    private int maxMatkul;
    private int jmlMatkul = 0;

    public Kelas(String namaKelas, int maxMhs, int maxMatkul) {
        this.namaKelas = namaKelas;
        this.maxMhs = maxMhs;
        this.maxMatkul = maxMatkul;
        matakuliah = new Matakuliah[maxMatkul];
        dosen = new Dosen[maxMatkul];
    }

    public void addMatakuliah(Matakuliah m, Dosen d) {
        if (jmlMatkul < maxMatkul) {
            matakuliah[jmlMatkul] = m;
            dosen[jmlMatkul] = d;
            jmlMatkul++;
        } else {
            System.out.println("Tidak Dapat Menambahkan Matakuliah");
        }
    }

    public Dosen getDosen(int i) {
        return dosen[i];
    }

    public Matakuliah getMatakuliah(int i) {
        return matakuliah[i];
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

    public int getMaxMatkul() {
        return maxMatkul;
    }

    public void setMaxMatkul(int maxMatkul) {
        this.maxMatkul = maxMatkul;
    }

}

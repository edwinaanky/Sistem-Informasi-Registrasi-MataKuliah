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
    private Matakuliah matakuliah;
    private Dosen dosen;

    public Kelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public void setMatakuliah(Matakuliah m) {
        if (m.getJmlMhs() < m.getMaxMhs()) {
            matakuliah = m;
            m.setJmlMhs(m.getJmlMhs() + 1);
        } else {
            System.out.println("Tidak dapat diambil karena penuh");
        }
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

}

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
public class Main {

    public static void main(String[] args) {
        Matakuliah m = new Matakuliah("PBO", "Pemrograman Berorientasi Objek", 3, 30);
        Matakuliah m1 = new Matakuliah("DAP", "Dasar Algoritma dan Pemrograman", 3, 30);
        Dosen d = new Dosen(1, "ICM", "Kurniawan Nur Ramadhani, ST., MT.", "Pria", "abc", "+6282222");
        Kelas k = new Kelas("IF-38-04");
        Kelas k1 = new Kelas("IF-38-04");
        k.setMatakuliah(m);
        k1.setMatakuliah(m1);
        Mahasiswa mhs = new Mahasiswa(1301141264, 24, "Graham Desmon S", "Pria", "PBB C146", "+6282358997212");
        mhs.addKelas(k);
        mhs.addKelas(k1);
        mhs.removeKelas(k);
        mhs.display();
    }
}

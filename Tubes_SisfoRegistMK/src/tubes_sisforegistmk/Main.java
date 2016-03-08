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
        Matakuliah m = new Matakuliah("pbo","Pemrograman Berorientasi Objek",3);
        Dosen d = new Dosen(1, "ICM", "Kurniawan Nur Ramadhani, ST., MT.", "Pria", "abc", "+6282222");
        Kelas k = new Kelas("IF-38-04", 30, 10);
        k.addMatakuliah(m, d);
        Mahasiswa mhs = new Mahasiswa(1301141264, 24, "Graham Desmon S", "Pria", "PBB C146", "+6282358997212");
        mhs.tambahKelas(k);
        mhs.display();
    }
}

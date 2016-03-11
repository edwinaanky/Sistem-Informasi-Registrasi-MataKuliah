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
        Matakuliah m = new Matakuliah("PBO", "Pemrograman Berorientasi Objek", 3);
        Matakuliah m1 = new Matakuliah("DAP", "Dasar Algoritma dan Pemrograman", 3);
        Matakuliah m2 = new Matakuliah("ASD", "Algoritma dan Struktur Data", 3);
        Dosen d = new Dosen(1, "ICM", "Kurniawan Nur Ramadhani, ST., MT.", "Pria", "abc", "+6282222");
        Dosen d1 = new Dosen(2, "ICM", "DODY QORI UTAMA, S.T., M.T.", "Pria", "abcd", "+62822223");
        Kelas k = new Kelas("IF-38-04",30);
        k.setMatakuliah(m);
        k.setDosen(d);
        Kelas k1 = new Kelas("IF-38-04",30);
        k1.setMatakuliah(m1);
        k1.setDosen(d1);
        Kelas k2 = new Kelas("IF-38-04",30);
        k2.setMatakuliah(m2);
        k2.setDosen(d1);
        Mahasiswa mhs = new Mahasiswa(1301141264, 24, "Graham Desmon S", "Pria", "PBB C146", "+6282358997212");
        mhs.addKelas(k);
        mhs.addKelas(k1);
        mhs.removeKelas(k1);
        mhs.addKelas(k2);
        Mahasiswa mhs1 = new Mahasiswa(1301140384, 24, "Edwina Anky", "Wanita", "Sukabirus", "+628233333333");
        mhs1.addKelas(k);
        mhs1.addKelas(k1);
        mhs1.addKelas(k2);
        Mahasiswa mhs2 = new Mahasiswa(1103134330, 24, "Muhammad Fajar Septiawan", "Pria", "Sukabirus", "+6282334444");
        mhs2.addKelas(k);
        mhs2.addKelas(k1);
        mhs2.addKelas(k2);
        mhs2.removeKelas(k);
        mhs2.removeKelas(k1);
        mhs2.removeKelas(k2);
        System.out.println("DATA KELAS");
        System.out.println("Kelas              : "+k.getNamaKelas());
        System.out.println("Matakuliah         : "+k.getMatakuliah().getNamaMatkul());
        System.out.println("Dosen              : "+k.getDosen().getName());
        System.out.println("Maksimal Mahasiswa : "+k.getMaxMhs()+" Mahasiswa");
        System.out.println("Jumlah Mahasiswa   : "+k.getJmlMhs()+" Mahasiswa");
        System.out.println();
        System.out.println("Kelas              : "+k1.getNamaKelas());
        System.out.println("Matakuliah         : "+k1.getMatakuliah().getNamaMatkul());
        System.out.println("Dosen              : "+k1.getDosen().getName());
        System.out.println("Maksimal Mahasiswa : "+k1.getMaxMhs()+" Mahasiswa");
        System.out.println("Jumlah Mahasiswa   : "+k1.getJmlMhs()+" Mahasiswa");
        System.out.println();
        System.out.println("Kelas              : "+k2.getNamaKelas());
        System.out.println("Matakuliah         : "+k2.getMatakuliah().getNamaMatkul());
        System.out.println("Dosen              : "+k2.getDosen().getName());
        System.out.println("Maksimal Mahasiswa : "+k2.getMaxMhs()+" Mahasiswa");
        System.out.println("Jumlah Mahasiswa   : "+k2.getJmlMhs()+" Mahasiswa");
        System.out.println();
        System.out.println("DATA MATAKULIAH");
        System.out.println("Nama Matakuliah : "+m.getNamaMatkul());
        System.out.println("Kode Matakuliah : "+m.getKode());
        System.out.println("Jumlah SKS      : "+m.getSks()+" Sks");
        System.out.println();
        System.out.println("Nama Matakuliah : "+m1.getNamaMatkul());
        System.out.println("Kode Matakuliah : "+m1.getKode());
        System.out.println("Jumlah SKS      : "+m1.getSks()+" Sks");
        System.out.println();
        System.out.println("Nama Matakuliah : "+m2.getNamaMatkul());
        System.out.println("Kode Matakuliah : "+m2.getKode());
        System.out.println("Jumlah SKS      : "+m2.getSks()+" Sks");
        System.out.println();
        System.out.println("DATA DOSEN");
        System.out.println("Nama Dosen : "+d.getName());
        System.out.println("NIK Dosen  : "+d.getNik());
        System.out.println("KK         : "+d.getKk());
        System.out.println();
        System.out.println("Nama Dosen : "+d1.getName());
        System.out.println("NIK Dosen  : "+d1.getNik());
        System.out.println("KK         : "+d1.getKk());
        System.out.println();
        System.out.println();
        System.out.println("DATA MAHASISWA");
        mhs.display();
        System.out.println();
        mhs1.display();
        System.out.println();        
        mhs.display();
        System.out.println();
        
    }
}



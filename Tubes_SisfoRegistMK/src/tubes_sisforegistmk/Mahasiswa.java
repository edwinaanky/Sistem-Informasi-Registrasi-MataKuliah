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
public class Mahasiswa extends Orang {

    private long nim;
    private Kelas[] kelas = new Kelas[20];
    private int jumlahSks = 0;
    private int maxSks;
    private int jumlahKelas = 0;

    public Mahasiswa(long nim, int maxSks, String name, String jenisKelamin, String alamat, String telepon) {
        super(name, jenisKelamin, alamat, telepon);
        this.nim = nim;
        this.maxSks = maxSks;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public int getMaxsks() {
        return maxSks;
    }

    public void setMaxsks(int maxSks) {
        this.maxSks = maxSks;
    }

    public void tambahKelas(Kelas k, Matakuliah m) {
        boolean ada = false;
        int matkul = 0;
        for (int i = 0; i < jumlahKelas; i++) {
            for (int j = 0; j < kelas[i].getMaxMatkul(); j++) {
                if (kelas[i].getMatakuliah(j) == m) {
                    matkul = j;
                }

            }
        }
        if (jumlahSks < maxSks) {
            kelas[jumlahKelas] = k;
            jumlahKelas++;
            jumlahSks = jumlahSks + k.getMatakuliah(matkul).getSks();

        } else {
            System.out.println("Tidak dapat menambahkan kelas karena jumlah sks tidak dapat melebihi " + maxSks + " sks");
        }
    }

    public void kurangKelas(Kelas k) {
        int indeks = 21;

        for (int i = 0; i < 20; i++) {
            if (kelas[i] == k) {
                indeks = i;
            }
        }
        if (indeks != 21) {
            jumlahKelas--;
            jumlahSks = jumlahSks - k.getMatakuliah(indeks).getSks();
            for (int j = indeks; j < 20; j++) {
                kelas[j] = kelas[j + 1];
            }

        }
    }

    public Kelas getKelas(int i) {
        return kelas[i];
    }

    public void display() {
        System.out.println("Nama Mahasiswa : " + super.getName());
        System.out.println("Nim Mahasiswa  : " + nim);
        System.out.println("Jumlah Sks     : " + jumlahSks);
        System.out.println("Maksimal Sks   : " + maxSks);
        System.out.println("Kelas dan Mata kuliah yang diambil ");
        for (int i = 0; i < 20; i++) {
            if (kelas[i] != null) {
                for (int j = 0; j < kelas[i].getMaxMatkul(); j++) {
                    if (kelas[i].getMatakuliah(j) != null) {
                        System.out.println(kelas[i].getNamaKelas() + " " + kelas[i].getMatakuliah(j).getNamaMatkul());
                    }
                }
            }
        }
    }
}

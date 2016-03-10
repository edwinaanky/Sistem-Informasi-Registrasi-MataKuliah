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

    public void addKelas(Kelas k) {
        int jumlah = 0;
        if (jumlahSks < maxSks) {
            if (k.getJmlMhs() < k.getMaxMhs()) {
                jumlah = k.getJmlMhs();
                jumlah++;
                k.setJmlMhs(jumlah);
                kelas[jumlahKelas] = k;
                jumlahKelas++;
                jumlahSks = jumlahSks + k.getMatakuliah().getSks();
            } else {
                System.out.println("Tidak dapat mengambil kelas karena penuh");
            }

        } else {
            System.out.println("Tidak dapat menambahkan kelas karena jumlah sks tidak dapat melebihi " + maxSks + " sks");
        }
    }

    public void removeKelas(Kelas k) {
        int indeks = 21;
        int jumlah = 0;
        for (int i = 0; i < 20; i++) {
            if (kelas[i] == k) {
                indeks = i;
            }
        }
        if (indeks != 21) {
            jumlahKelas--;
            jumlah = k.getJmlMhs();
            jumlah--;
            k.setJmlMhs(jumlah);
            jumlahSks = jumlahSks - k.getMatakuliah().getSks();
            if (indeks == 0 && kelas[indeks + 1] == null) {
                kelas[indeks] = null;
            } 
            else if(kelas[indeks + 1] == null){
                kelas[indeks] = null;
            }
            else {
                for (int j = indeks; j < 20 && kelas[j + 1] != null; j++) {

                    kelas[j] = kelas[j + 1];
                    kelas[j + 1] = null;

                }
            }
        } else {
            System.out.println("Kelas tidak ditemukan");
        }
    }

    public Kelas getKelas(int i) {
        return kelas[i];
    }

    public void display() {
        int belum = 0;
        System.out.println("Nama Mahasiswa : " + super.getName());
        System.out.println("Nim Mahasiswa  : " + nim);
        System.out.println("Jenis Kelamin  : " + super.getJenisKelamin());
        System.out.println("Jumlah Sks     : " + jumlahSks);
        System.out.println("Maksimal Sks   : " + maxSks);
        System.out.println("Kelas dan Mata kuliah yang diambil ");
        for (int i = 0; i < 20; i++) {
            if (kelas[i] != null) {
                belum++;
                System.out.println(kelas[i].getNamaKelas() + " " + kelas[i].getMatakuliah().getNamaMatkul());
            }
        }
        if (belum == 0) {
            System.out.println("Belum ada Kelas yang diambil");
        }
    }

    public int getJumlahSks() {
        return jumlahSks;
    }

    public void setJumlahSks(int jumlahSks) {
        this.jumlahSks = jumlahSks;
    }

    public int getMaxSks() {
        return maxSks;
    }

    public void setMaxSks(int maxSks) {
        this.maxSks = maxSks;
    }

    public int getJumlahKelas() {
        return jumlahKelas;
    }

    public void setJumlahKelas(int jumlahKelas) {
        this.jumlahKelas = jumlahKelas;
    }

}

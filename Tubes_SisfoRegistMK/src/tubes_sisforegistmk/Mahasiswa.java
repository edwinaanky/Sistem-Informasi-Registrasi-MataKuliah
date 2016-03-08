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
    private int jumlahsks = 0;
    private int maxsks;
    private int jumlahKelas = 0;

    public Mahasiswa(long nim, int maxsks, String name, String jenisKelamin, String alamat, String telepon) {
        super(name, jenisKelamin, alamat, telepon);
        this.nim = nim;
        this.maxsks = maxsks;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public int getMaxsks() {
        return maxsks;
    }

    public void setMaxsks(int maxsks) {
        this.maxsks = maxsks;
    }

    public void tambahKelas(Kelas k) {
        boolean ada = false;
        int matkul = 0;
        if (jumlahsks < maxsks) {
            kelas[jumlahKelas] = k;
            jumlahKelas++;
            jumlahsks = jumlahsks + k.getMatakuliah(matkul).getSks();

        } else {
            System.out.println("Tidak dapat menambahkan kelas karena jumlah sks tidak dapat melebihi " + maxsks + " sks");
        }
    }

    public void kurangKelas(Kelas k, Matakuliah m) {
        int indeks=21;
        for (int i = 0; i < 20; i++) {
            if(kelas[i]==k){
                indeks=i;
            }
        }
        if(indeks!=21){
            if(indeks==0){
                
            }
        }
    }
}

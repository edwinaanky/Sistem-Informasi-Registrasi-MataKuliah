/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author desmoncode
 */
public class Mahasiswa extends Orang implements Serializable {

    private long nim;
    private ArrayList<Kelas> pilihan = new ArrayList<Kelas>();
    private int jumlahSks = 0;
    private int maxSks;
    private int jumlahKelas = 0;
    private String usernameMhs;
    private String passwordMhs;
    private int semester;
    private String jurusan;

    public Mahasiswa(long nim, int maxSks, String usernameMhs, String passwordMhs, String name, String jenisKelamin, String alamat, String telepon, String jurusan, int semester) {
        super(name, jenisKelamin, alamat, telepon);
        this.nim = nim;
        this.maxSks = maxSks;
        this.usernameMhs = usernameMhs;
        this.passwordMhs = passwordMhs;
        this.jurusan = jurusan;
        this.semester = semester;
    }   

    public Mahasiswa() {
        super();
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    public String getUsernameMhs() {
        return usernameMhs;
    }

    public void setUsernameMhs(String usernameMhs) {
        this.usernameMhs = usernameMhs;
    }

    public String getPasswordMhs() {
        return passwordMhs;
    }

    public void setPasswordMhs(String passwordMhs) {
        this.passwordMhs = passwordMhs;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
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
        pilihan.add(k);

    }

    public void removeKelas(Kelas k) {
        int jumlah = 0;
        for (int i = 0; i < pilihan.size(); i++) {
            if (pilihan.get(i) == k) {
                pilihan.remove(i);
                jumlahKelas--;
                jumlah = k.getJmlMhs();
                jumlah--;
                k.setJmlMhs(jumlah);
                jumlahSks = jumlahSks - k.getMatakuliah().getSks();
            }
        }
       
    }

    public Kelas getKelas(String namaKelas) {
        Kelas kelas = null;
        for (int i = 0; i < pilihan.size(); i++) {
            if (pilihan.get(i).getNamaKelas().equals(namaKelas)) {
                kelas = pilihan.get(i);
            }
        }
        return kelas;
    }

    public Kelas getKelas(int index) {
        return pilihan.get(index);
    }

    public ArrayList<Kelas> getAllKelas() {
        return pilihan;
    }

    public int getTotalKelas() {
        return pilihan.size();
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

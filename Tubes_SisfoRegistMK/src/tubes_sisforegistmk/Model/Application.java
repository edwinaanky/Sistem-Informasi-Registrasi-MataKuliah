/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Model;

import java.util.ArrayList;
import tubes_sisforegistmk.Database.*;

/**
 *
 * @author desmoncode
 */
public class Application {

    private Database connection;
    private ArrayList<Dosen> daftarDosen = null;
    private ArrayList<Mahasiswa> daftarMahasiswa = null;
    private ArrayList<Kelas> daftarKelas = null;
    private ArrayList<Matakuliah> daftarMatakuliah = null;

    public Application() {
        connection = new Database();
        connection.connect();
        daftarDosen = new ArrayList();
        daftarMahasiswa = new ArrayList();
        daftarKelas = new ArrayList();
        daftarMatakuliah = new ArrayList();
    }

    public void addDosen(Dosen d) {
        daftarDosen.add(d);
    }

    public void addMahasiswa(Mahasiswa m) {
        daftarMahasiswa.add(m);
    }

    public void addKelas(Kelas k) {
        daftarKelas.add(k);
    }

    public void addMatakuliah(Matakuliah mk) {
        daftarMatakuliah.add(mk);
    }

    public Dosen getDosen(int id) {
        return daftarDosen.get(id);
    }

    public Mahasiswa getMahasiswa(int id) {
        return daftarMahasiswa.get(id);
    }

    public Kelas getKelas(int id) {
        return daftarKelas.get(id);
    }

    public Matakuliah getMatakuliah(int id) {
        return daftarMatakuliah.get(id);
    }

    public void deleteDosen(int id) {
        daftarDosen.remove(id);
    }

    public void deleteMahasiswa(int id) {
        daftarMahasiswa.remove(id);
    }

    public void deleteKelas(int id) {
        daftarKelas.remove(id);
    }

    public void deleteMatakuliah(int id) {
        daftarMatakuliah.remove(id);
    }

    public void createDosen(long nik, String kk, String status, String name, String jenisKelamin, String alamat, String telepon) {
        Dosen d = new Dosen(nik, kk, status, name, jenisKelamin, alamat, telepon);
        addDosen(d);
        connection.insert_orang_dosen(d);
    }

    public void updateDosen(Dosen d, long nik) {

        for (Dosen list1 : daftarDosen) {

            if (list1.equals(d)) {
                list1.setAlamat(d.getAlamat());
                list1.setNik(d.getNik());
                list1.setKk(d.getKk());
                list1.setStatus(d.getStatus());
                list1.setTelepon(d.getTelepon());
                list1.setJenisKelamin(d.getJenisKelamin());
                list1.setName(d.getName());

            }

        }
        connection.update_orang_dosen(d);

    }

    public ArrayList<Dosen> getDaftarDosen() {
        return connection.getAllDosen();
    }

    public Dosen getDosen(long nik) {
        for (Dosen d : daftarDosen) {
            if (d.getNik() == nik) {
                return d;
            }
        }
        Dosen d = connection.getDosen(nik);
        return d;
    }

    public void deleteDosen(Dosen d) {
        daftarDosen.remove(d);
        connection.deleteDosen(d);
    }

    public void createMatakuliah(String kode, String nama, int sks) {
        Matakuliah m = new Matakuliah(kode, nama, sks);
        addMatakuliah(m);
        connection.insert_matakuliah(m);
    }

    public void updateMatakuliah(Matakuliah m, String kode) {
        for (Matakuliah list1 : daftarMatakuliah) {
            if (list1.equals(m)) {
                list1.setKode(m.getKode());
                list1.setNamaMatkul(m.getNamaMatkul());
                list1.setSks(m.getSks());
            }
        }
        connection.update_matakuliah(m);
    }

    public ArrayList<Matakuliah> getDaftarMatakuliah() {
        return connection.getAllMatakuliah();
    }

    public Matakuliah getMatakuliah(String kode) {
        for (Matakuliah m : daftarMatakuliah) {
            if (m.getKode() == kode) {
                return m;
            }
        }
        Matakuliah m = connection.getMatakuliah(kode);
        return m;
    }

    public void deleteMatakuliah(Matakuliah m) {
        daftarMatakuliah.remove(m);
        connection.deleteMatakuliah(m);
    }

    public void createKelas(String nama, int maxmhs, Dosen d, Matakuliah m) {
        Kelas k = new Kelas(nama, maxmhs);
        k.setDosen(d);
        k.setMatakuliah(m);
        addKelas(k);
        connection.insert_kelas(k);
    }

    public void updateKelas(Kelas k, int id) {
        int no = 0;
        int non = 0;
        for (Kelas list1 : daftarKelas) {
            no++;
            if (list1.getId() == id) {
                non = no;
            }
        }
        daftarKelas.get(non).setNamaKelas(k.getNamaKelas());

        daftarKelas.get(non).setMaxMhs(k.getMaxMhs());
        daftarKelas.get(non).setDosen(k.getDosen());
        daftarKelas.get(non).setMatakuliah(k.getMatakuliah());

        connection.update_kelas(k);
    }

    public ArrayList<Kelas> getDaftarKelas() {
        return connection.getAllKelas();
    }

    public Kelas getKelasByid(int id) {
        for (Kelas k : daftarKelas) {
            if (k.getId() == id) {
                return k;
            }
        }
        Kelas k = connection.getKelas(id);
        return k;
    }

    public void deleteKelas(Kelas k) {
        daftarKelas.remove(k);
        connection.deleteKelas(k);
    }

    public void createMahasiswa(long nim, int maxSks, String usernameMhs, String passwordMhs, String name, String jenisKelamin, String alamat, String telepon, String jurusan, int semester) {

        Mahasiswa mhs = new Mahasiswa(nim, maxSks, usernameMhs, passwordMhs, name, jenisKelamin, alamat, telepon, jurusan, semester);
        addMahasiswa(mhs);
        connection.insert_orang_mahasiswa(mhs);
    }

    public void updateMahasiswa(Mahasiswa mhs, long nim) {

        for (Mahasiswa list1 : daftarMahasiswa) {

            if (list1.equals(mhs)) {
                list1.setAlamat(mhs.getAlamat());
                list1.setJenisKelamin(mhs.getJenisKelamin());
                list1.setJumlahKelas(mhs.getJumlahKelas());
                list1.setJumlahSks(mhs.getJumlahSks());
                list1.setJurusan(mhs.getJurusan());
                list1.setMaxSks(mhs.getMaxSks());
                list1.setName(mhs.getName());
                list1.setNim(mhs.getNim());
                list1.setPasswordMhs(mhs.getPasswordMhs());
                list1.setSemester(mhs.getSemester());
                list1.setTelepon(mhs.getTelepon());
                list1.setUsernameMhs(mhs.getUsernameMhs());
            }
        }

        connection.update_orang_mahasiswa(mhs);
    }

    public ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return connection.getAllMahasiswa();
    }

    public Mahasiswa getMahasiswa(long nim) {
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim() == nim) {
                return mhs;
            }
        }
        Mahasiswa mhs = connection.getMahasiswa(nim);
        return mhs;
    }

    public void deleteMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.remove(mhs);
        connection.deleteMahasiswa(mhs);
    }
    
    public int tambahKelasMhs(Mahasiswa m,Kelas k){
        int jumlah = 0;
        int jml = 0;
        int berhasil = 0;
        Kelas kel = null;
        kel = connection.getKelasById(k.getId());
        if(kel == null){
            if (m.getJumlahSks() < m.getMaxSks()) {
                if (k.getJmlMhs() < k.getMaxMhs()) {
                    jumlah = k.getJmlMhs();
                    jumlah++;
                    m.addKelas(k);
                    jml = m.getJumlahKelas();
                    jml = m.getJumlahSks() + k.getMatakuliah().getSks();
                    m.setJumlahSks(jml);
                    connection.MahasiswaTambahKelas(m, k);
                    return 1;
                    
                } else {
                    return 2;
                }

            } else {
                return 3;
            }
        } else {
            return 0;
        }
        
    }
    
    public ArrayList<Kelas> getAllKelasMahasiswa() {
        return connection.getAllKelasMahasiswa();
    }
}

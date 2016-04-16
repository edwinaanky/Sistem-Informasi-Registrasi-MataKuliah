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
    
    public void createDosen(long nik, String kk, String status, String name, String jenisKelamin, String alamat, String telepon){
        Dosen d = new Dosen(nik, kk, status, name, jenisKelamin, alamat, telepon);
        addDosen(d);
        connection.insert_orang_dosen(d);
    }
    
    public void updateDosen(Dosen d, long nik){
        int no=0;
        int non=0;
         for (Dosen list1 : daftarDosen) {
             no++;
            if (list1.getNik() == nik) {
                non=no;
            }
        }
        daftarDosen.get(non).setAlamat(d.getAlamat());
        daftarDosen.get(non).setNik(d.getNik());
        daftarDosen.get(non).setKk(d.getKk());
        daftarDosen.get(non).setStatus(d.getStatus());
        daftarDosen.get(non).setTelepon(d.getTelepon());
        daftarDosen.get(non).setJenisKelamin(d.getJenisKelamin());
        daftarDosen.get(non).setName(d.getName()); 
        connection.update_orang_dosen(d);
    }
    
    public ArrayList<Dosen> getDaftarDosen(){
        return connection.getAllDosen();
    }
    
    public Dosen getDosen(long nik){
        for(Dosen d : daftarDosen){
            if(d.getNik()==nik){
                return d;
            }
        }
        Dosen d = connection.getDosen(nik);
        return d;
    }
}

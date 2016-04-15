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
        this.connection = new Database();
        this.connection.connect();
        this.daftarDosen = new ArrayList();
        this.daftarMahasiswa = new ArrayList();
        this.daftarKelas = new ArrayList();
        this.daftarMatakuliah = new ArrayList();
    }
    
    
    
}

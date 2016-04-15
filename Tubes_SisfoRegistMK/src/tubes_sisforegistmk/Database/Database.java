/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tubes_sisforegistmk.Model.*;

/**
 *
 * @author desmoncode
 */
public class Database {

    private String server = "jdbc:mysql://localhost/db_registrasi";
    private String dbuser = "root";
    private String dbpassword = "";
    private Statement statement;
    private Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpassword);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Admin autha(String username, String password) {
        Admin admin = null;
        try {
            ResultSet result = statement.executeQuery("select * from admin where username = '" + username + "'");
            if (result.next()) {
                if (password.equals(result.getString("password"))) {
                    int adminId = result.getInt("id");
                    String adminUsername = result.getString("username");
                    String adminPassword = result.getString("password");
                    int orangId = result.getInt("id_orang");

                    result = statement.executeQuery("select * from orang where id = " + orangId);

                    if (result.next()) {
                        String orangName = result.getString("nama");
                        String orangJenisKelamin = result.getString("jeniskelamin");
                        String orangAlamat = result.getString("alamat");
                        String orangTelepon = result.getString("telepon");
                        admin = new Admin(adminId, adminUsername, adminPassword, orangName, orangJenisKelamin, orangAlamat, orangTelepon);

                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return admin;
    }

    public Mahasiswa authm(String username, String password) {
        Mahasiswa mahasiswa = null;
        ResultSet result = null;
        ResultSet rs = null;
        try {
            result = statement.executeQuery("select * from mahasiswa where username = '" + username + "'");
            if (result.next()) {

                if (result.getString("password").equals(password)) {
                    long mahasiswaNim = result.getInt("nim");
                    int mahasiswaJumlahSks = result.getInt("jumlahsks");
                    int mahasiswaMaxSks = result.getInt("maxsks");
                    int mahasiswaJumlahKelas = result.getInt("jumlahkelas");
                    int mahasiswaSemester = result.getInt("semester");
                    String mahasiswaJurusan = result.getString("jurusan");
                    String mahasiwaUsername = result.getString("username");
                    String mahasiswaPassword = result.getString("password");
                    int orangId = result.getInt("id_orang");

                    rs = statement.executeQuery("select * from orang where id = " + orangId);

                    if (rs.next()) {

                        String orangName = rs.getString("nama");
                        String orangJenisKelamin = rs.getString("jeniskelamin");
                        String orangAlamat = rs.getString("alamat");
                        String orangTelepon = rs.getString("telepon");

                        mahasiswa = new Mahasiswa(mahasiswaNim, mahasiswaMaxSks, mahasiwaUsername, mahasiswaPassword, orangName, orangJenisKelamin, orangAlamat, orangTelepon, mahasiswaJurusan, mahasiswaSemester);

                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return mahasiswa;
    }

    public void insert_orang_dosen(Dosen d) {
        Dosen ds = d;
        ResultSet rs = null;
        String query1 = "insert into orang (nama,jeniskelamin,alamat,telepon) values("
                + "'" + ds.getName() + "',"
                + "'" + ds.getJenisKelamin() + "',"
                + "'" + ds.getAlamat() + "',"
                + "'" + ds.getTelepon() + "')";
        String query2 = null;
        try {
            statement.execute(query1, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            ds.setId(generatedId);
            query2 = "insert into dosen values("
                    + ds.getNik() + ","
                    + "'" + ds.getKk() + "',"
                    + "'" + ds.getStatus() + "',"
                    + ds.getId() + ")";
            statement.execute(query2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update_orang_dosen(Dosen d) {
        Dosen ds = d;
        ResultSet rs = null;
        String query1 = "update orang set nama='" + d.getName() + "',"
                + "jeniskelamin='" + d.getJenisKelamin() + "',"
                + "alamat='" + d.getAlamat() + "',"
                + "telepon='" + d.getTelepon() + "' "
                + "where id=" + d.getId();
        String query2 = "update dosen set kk='" + d.getKk() + "',"
                + "status='" + d.getStatus() + "',"
                + "id_orang=" + d.getId()
                + " where nik=" + d.getNik();
        try {
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Dosen> getAllDosen() {
        ArrayList<Dosen> daftarDosen = new ArrayList();
        ResultSet rs = null;
        String query = "select d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id "
                + "from orang as o, dosen as d "
                + "where o.id=d.id_orang";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Dosen d = new Dosen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                d.setId(rs.getInt(8));
                daftarDosen.add(d);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return daftarDosen;
    }

    public Dosen getDosen(long nik) {
        Dosen d = null;
        ResultSet rs = null;
        String query = "select d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id "
                + "from orang as o, dosen as d "
                + "where o.id=d.id_orang and "
                + "nik=" + nik;
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                d = new Dosen(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                d.setId(rs.getInt(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;
    }

    public void deleteDosen(Dosen d) {
        String query = "delete from dosen where nik=" + d.getNik();
        String query1 = "delete from orang where id=" + d.getId();
        try {
            statement.execute(query);
            statement.execute(query1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insert_matakuliah(Matakuliah m) {
        Matakuliah mk = m;
        ResultSet rs = null;
        String query = "insert into matakuliah values("
                + "'" + mk.getKode() + "',"
                + "'" + mk.getNamaMatkul() + "',"
                + mk.getSks() + ")";

        try {
            statement.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update_matakuliah(Matakuliah m) {
        Matakuliah mk = m;

        String query = "update matakuliah set kode='" + m.getKode() + "',"
                + "nama='" + m.getNamaMatkul() + "',"
                + "sks=" + m.getSks()
                + " where kode='" + m.getKode() + "'";

        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Matakuliah> getAllMatakuliah() {
        ArrayList<Matakuliah> daftarMatakuliah = new ArrayList();
        ResultSet rs = null;
        String query = "select * from matakuliah";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Matakuliah m = new Matakuliah(rs.getString(1), rs.getString(2), rs.getInt(3));
                daftarMatakuliah.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return daftarMatakuliah;
    }

    public Matakuliah getMatakuliah(String kode) {
        Matakuliah m = null;
        ResultSet rs = null;
        String query = "select * from matakuliah "
                + "where kode = '" + kode + "'";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                m = new Matakuliah(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return m;
    }

    public void deleteMatakuliah(Matakuliah m) {
        String query = "delete from matakuliah where kode='" + m.getKode() + "'";
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insert_kelas(Kelas k) {
        Kelas ks = k;
        ResultSet rs = null;
        String query = "insert into kelas (namakelas,maxmhs,jmlmhs,id_matkul,id_dosen) values("
                + "'" + ks.getNamaKelas() + "',"
                + ks.getMaxMhs() + ","
                + 0 + ","
                + "'" + ks.getMatakuliah().getKode() + "',"
                + ks.getDosen().getNik() + ")";

        try {
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            ks.setId(generatedId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update_kelas(Kelas k) {
        Kelas ks = k;

        String query = "update kelas set namakelas='" + ks.getNamaKelas() + "',"
                + "maxmhs=" + ks.getMaxMhs() + ","
                + "jmlmhs=" + ks.getJmlMhs() + ","
                + "id_matkul=" + ks.getMatakuliah().getKode() + ","
                + "id_dosen=" + ks.getDosen().getNik()
                + " where id=" + ks.getId();

        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Kelas> getAllKelas() {
        ArrayList<Kelas> daftarKelas = new ArrayList();
        ResultSet rs = null;
        String query = "select k.namakelas,k.maxmhs,k.jmlmhs,k.id_matkul,k.id_dosen, "
                + "d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id,"
                + "m.kode,m.nama,m.sks,k.id "
                + "from kelas as k, dosen as d, orang as o, matakuliah as m "
                + "where o.id=d.id_orang and "
                + "k.id_dosen = d.nik and "
                + "k.id_matkul = m.kode";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {

                Kelas k = new Kelas(rs.getString(1), rs.getInt(2));
                k.setId(rs.getInt(17));
                Matakuliah m = new Matakuliah(rs.getString(4), rs.getString(15), rs.getInt(16));
                Dosen d = new Dosen(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
                d.setId(rs.getInt(13));
                k.setDosen(d);
                k.setMatakuliah(m);
                daftarKelas.add(k);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return daftarKelas;
    }

    public Kelas getKelas(int id) {
        Kelas k = null;
        ResultSet rs = null;
        String query = "select k.namakelas,k.maxmhs,k.jmlmhs,k.id_matkul,k.id_dosen, "
                + "d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id,"
                + "m.kode,m.nama,m.sks,k.id "
                + "from kelas as k, dosen as d, orang as o, matakuliah as m "
                + "where o.id=d.id_orang and "
                + "k.id_dosen = d.nik and "
                + "k.id_matkul = m.kode and "
                + "k.id = " + id;

        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                k = new Kelas(rs.getString(1), rs.getInt(2));
                k.setId(rs.getInt(17));
                Matakuliah m = new Matakuliah(rs.getString(4), rs.getString(15), rs.getInt(16));
                Dosen d = new Dosen(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
                d.setId(rs.getInt(13));
                k.setDosen(d);
                k.setMatakuliah(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return k;
    }

    public void deleteKelas(Kelas k) {
        String query = "delete from kelas where kode=" + k.getId();
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insert_orang_mahasiswa(Mahasiswa m) {
        Mahasiswa mhs = m;
        ResultSet rs = null;
        String query1 = "insert into orang (nama,jeniskelamin,alamat,telepon) values("
                + "'" + mhs.getName() + "',"
                + "'" + mhs.getJenisKelamin() + "',"
                + "'" + mhs.getAlamat() + "',"
                + "'" + mhs.getTelepon() + "')";
        String query2 = null;
        try {
            statement.execute(query1, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            mhs.setId(generatedId);
            query2 = "insert into mahasiswa values("
                    + mhs.getNim() + ","
                    + 0 + ","
                    + mhs.getMaxSks() + ","
                    + 0 + ","
                    + "'" + mhs.getUsernameMhs() + "',"
                    + "'" + mhs.getPasswordMhs() + "',"
                    + mhs.getSemester() + ","
                    + "'" + mhs.getJurusan() + "',"
                    + mhs.getId() + ")";
            statement.execute(query2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update_orang_mahasiswa(Mahasiswa m) {
        Mahasiswa mhs = m;
        ResultSet rs = null;
        String query1 = "update orang set nama='" + mhs.getName() + "',"
                + "jeniskelamin='" + mhs.getJenisKelamin() + "',"
                + "alamat='" + mhs.getAlamat() + "',"
                + "telepon='" + mhs.getTelepon() + "' "
                + "where id=" + mhs.getId();
        String query2 = "update mahasiswa set nim=" + mhs.getNim() + ","
                + "maxsks=" + mhs.getMaxSks() + ","
                + "username='" + mhs.getUsernameMhs() + "',"
                + "password='" + mhs.getPasswordMhs() + "',"
                + "semester=" + mhs.getSemester() + ","
                + "jurusan='" + mhs.getJurusan() + "',"
                + "id_orang=" + mhs.getId()
                + " where nim=" + mhs.getNim();
        try {
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Mahasiswa> getAllMahasiswa() {
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList();
        ResultSet rs = null;
        String query = "select m.nim,m.maxsks,m.username,m.password,o.nama,o.jeniskelamin,o.alamat,o.telepon,m.jurusan,m.semester,o.id "
                + "from orang as o, mahasiswa as m "
                + "where o.id=m.id_orang";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                m.setId(rs.getInt(11));
                daftarMahasiswa.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return daftarMahasiswa;
    }

    public Mahasiswa getMahasiswa(long nim) {
        Mahasiswa mhs = null;
        ResultSet rs = null;
        String query = "select m.nim,m.maxsks,m.username,m.password,o.nama,o.jeniskelamin,o.alamat,o.telepon,m.jurusan,m.semester,o.id "
                + "from orang as o, mahasiswa as m "
                + "where o.id=m.id_orang and "
                + "nim=" + nim;
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                mhs = new Mahasiswa(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
                mhs.setId(rs.getInt(11));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mhs;
    }

    public void deleteMahasiswa(Mahasiswa mhs) {
        String query = "delete from mahasiswa where nim=" + mhs.getNim();
        String query1 = "delete from orang where id=" + mhs.getId();
        try {
            statement.execute(query);
            statement.execute(query1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void MahasiswaTambahKelas(Mahasiswa mhs, Kelas k) {
        ResultSet rs = null;
        String query = "insert into pilihan_kelas values("
                + mhs.getNim() + ","
                + k.getId()+ ")";

        try {
            statement.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void MahasiswaUpdateKelas(Mahasiswa mhs, Kelas k) {
        

        String query = "update pilihan_kelas set id_kelas=" + k.getId()
                + " where id_mahasiswa='" + mhs.getNim() + "'";
        try {
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Kelas> getAllKelasMahasiswa() {
        ArrayList<Kelas> daftarKelas = new ArrayList();
        ResultSet rs = null;
        String query = "select k.id,k.namakelas,k.maxmhs,k.jmlmhs,k.id_matkul,k.id_dosen, "
                + "d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id,"
                + "m.kode,m.nama,m.sks,k.id, kp.id_kelas "
                + "from kelas as k, dosen as d, orang as o, matakuliah as m, pilihan_kelas as kp "
                + "where k.id=kp.id_kelas and "
                + "o.id=d.id_orang and "
                + "k.id_dosen = d.nik and "
                + "k.id_matkul = m.kode";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Kelas k = new Kelas(rs.getString(2), rs.getInt(3));
                k.setId(rs.getInt(1));
                Matakuliah m = new Matakuliah(rs.getString(5), rs.getString(16), rs.getInt(17));
                Dosen d = new Dosen(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                d.setId(rs.getInt(14));
                
                k.setDosen(d);
                k.setMatakuliah(m);
                k.setJmlMhs(rs.getInt(4));
                daftarKelas.add(k);
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return daftarKelas;
    }
    
    public Kelas getKelasById(int id) {
        Kelas k = null;
        ResultSet rs = null;
        String query = "select k.id,k.namakelas,k.maxmhs,k.jmlmhs,k.id_matkul,k.id_dosen, "
                + "d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id,"
                + "m.kode,m.nama,m.sks,k.id, kp.id_kelas "
                + "from kelas as k, dosen as d, orang as o, matakuliah as m, pilihan_kelas as kp "
                + "where k.id=kp.id_kelas and "
                + "o.id=d.id_orang and "
                + "k.id_dosen = d.nik and "
                + "k.id_matkul = m.kode and "
                + "k.id = "+id;
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                k = new Kelas(rs.getString(2), rs.getInt(3));
                k.setId(rs.getInt(1));
                Matakuliah m = new Matakuliah(rs.getString(5), rs.getString(16), rs.getInt(17));
                Dosen d = new Dosen(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                d.setId(rs.getInt(14));
                
                k.setDosen(d);
                k.setMatakuliah(m);
                k.setJmlMhs(rs.getInt(4));
                
            }
        } catch (Exception e) {
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return k;
    }
    
//    public Matakuliah getMatakuliah(String kode) {
//        Matakuliah m = null;
//        ResultSet rs = null;
//        String query = "select * from matakuliah "
//                + "where kode = '" + kode + "'";
//        try {
//            rs = statement.executeQuery(query);
//            while (rs.next()) {
//                m = new Matakuliah(rs.getString(1), rs.getString(2), rs.getInt(3));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return m;
//    }

    public void deleteMahasiswaKelas(Kelas k) {
        String query = "delete from pilihan_kelas where id_kelas=" +k.getId() ;
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

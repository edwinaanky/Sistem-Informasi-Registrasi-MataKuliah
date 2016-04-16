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
    private String server="jdbc:mysql://localhost/db_registrasi";
    private String dbuser="root";
    private String dbpassword="";
    private Statement statement;
    private Connection connection;
    
    public void connect(){
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
                if(password.equals(result.getString("password"))){
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
        try {
            ResultSet result = statement.executeQuery("select * from mahasiswa where username = '" + username + "'");
            if (result.next()) {
                if(password.equals(result.getString("password"))){
                    long mahasiswaNim = result.getInt("nim");
                    int mahasiswaJumlahSks = result.getInt("jumlahsks");
                    int mahasiswaMaxSks = result.getInt("maxsks");
                    int mahasiswaJumlahKelas = result.getInt("jumlahkelas");
                    int mahasiswaSemester = result.getInt("semester");
                    String mahasiswaJurusan = result.getString("jurusan");               
                    String mahasiwaUsername = result.getString("username");
                    String mahasiswaPassword = result.getString("password");
                    int orangId = result.getInt("id_orang");

                    result = statement.executeQuery("select * from orang where id = " + orangId);

                    if (result.next()) {

                        String orangName = result.getString("name");
                        String orangJenisKelamin = result.getString("jeniskelamin");
                        String orangAlamat = result.getString("alamat");
                        String orangTelepon = result.getString("telepon");
                        mahasiswa = new Mahasiswa(mahasiswaNim,mahasiswaMaxSks,mahasiwaUsername,mahasiswaPassword,orangName,orangJenisKelamin,orangAlamat,orangTelepon);

                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return mahasiswa;
    }
    
    public void insert_orang_dosen(Dosen d){
        Dosen ds = d;
        ResultSet rs = null;
        String query1 = "insert into orang (nama,jeniskelamin,alamat,telepon) values("
                +"'"+ds.getName()+"',"
                +"'"+ds.getJenisKelamin()+"',"
                +"'"+ds.getAlamat()+"',"
                +"'"+ds.getTelepon()+"')";
        String query2 = null;
        try {
            statement.execute(query1,Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if(rs.next()){
                generatedId = rs.getInt(1);
            }
            ds.setId(generatedId);
            query2 = "insert into dosen values("
                +ds.getNik()+","
                +"'"+ds.getKk()+"',"
                +"'"+ds.getStatus()+"',"
                +ds.getId()+")";
            statement.execute(query2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void update_orang_dosen(Dosen d){
        Dosen ds = d;
        ResultSet rs = null;
        String query1 = "update orang set nama='"+d.getName()+"',"
                +"jeniskelamin='"+d.getJenisKelamin()+"',"
                +"alamat='"+d.getAlamat()+"',"
                +"telepon='"+d.getTelepon()+"'"
                +"where id="+d.getId();
        String query2 = "update dosen set kk='"+d.getKk()+"',"
                +"status='"+d.getStatus()+"',"
                +"id_orang="+d.getId()
                +"where nik="+d.getNik();
        try {
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Dosen> getAllDosen(){
        ArrayList<Dosen> daftarDosen = new ArrayList();
        ResultSet rs = null;
        String query = "select d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id "
                + "from orang as o, dosen as d "
                + "where o.id=d.id_orang";
        try{
            rs = statement.executeQuery(query);
            while(rs.next()){
                Dosen d = new Dosen(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                d.setId(rs.getInt(8));
                daftarDosen.add(d);
            }
        } catch(Exception e){
            System.out.println("Error load all");
            e.printStackTrace();
        }
        return daftarDosen;
    }
    
    public Dosen getDosen(long nik){
        Dosen d = null;
        ResultSet rs = null;
        String query = "select d.nik,d.kk,d.status,o.nama,o.jeniskelamin,o.alamat,o.telepon,o.id "
                + "from orang as o, dosen as d "
                + "where o.id=d.id_orang and "
                + "nik="+nik;
        try {
            rs=statement.executeQuery(query);
            while(rs.next()){
                d = new Dosen(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                d.setId(rs.getInt(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return d;
    }
}

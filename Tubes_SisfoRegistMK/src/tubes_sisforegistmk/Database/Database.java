/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Database;
import java.sql.*;
import tubes_sisforegistmk.Model.*;
/**
 *
 * @author desmoncode
 */
public class Database {
    private String server="jdbc:mysql://localhost:3306/db_registrasi";
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
        ResultSet rs = null;
        String query = "Select * from admin where username='"+username+"'";
        try {     
            rs = statement.executeQuery(query);
            if (rs.next()) {
                if(password.equals(rs.getString("password"))){
                    int adminId = rs.getInt("id");
                    String adminUsername = rs.getString("username");
                    String adminPassword = rs.getString("password");
                    int orangId = rs.getInt("id_orang");

                    rs = statement.executeQuery("select * from orang where id = " + orangId);

                    if (rs.next()) {
                        String orangName = rs.getString("nama");
                        String orangJenisKelamin = rs.getString("jeniskelamin");
                        String orangAlamat = rs.getString("alamat");
                        String orangTelepon = rs.getString("telepon");
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
        String query2 = "insert into dosen values("
                +ds.getNik()+","
                +"'"+ds.getKk()+"',"
                +"'"+ds.getStatus()+"',"
                +ds.getId()+")";
        try {
            statement.execute(query1,Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if(rs.next()){
                generatedId = rs.getInt(1);
            }
            ds.setId(generatedId);
            statement.executeQuery(query1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        
    }
    
    public void insert_dosen(Dosen d){
        Dosen ds = d;
        try {
            ResultSet result = statement.executeQuery("insert into dosen ('name','jeniskelamin','alamat','telepon') values '" + ds.getName() + "','"+ds.getJenisKelamin()+"','"+ds.getAlamat()+"','"+ds.getTelepon());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

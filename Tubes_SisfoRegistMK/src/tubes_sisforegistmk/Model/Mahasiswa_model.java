/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Model;


import tubes_sisforegistmk.Mahasiswa;
import tubes_sisforegistmk.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author desmoncode
 */
public class Mahasiswa_model {
    private Statement statement = null;

    public Mahasiswa_model() {
        try {
            statement = (Statement) koneksi.GetConnection().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
    public Mahasiswa auth(String username, String password) {
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
}

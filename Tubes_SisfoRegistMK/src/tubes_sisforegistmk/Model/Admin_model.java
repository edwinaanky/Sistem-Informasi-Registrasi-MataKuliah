/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Model;

import tubes_sisforegistmk.*;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author desmoncode
 */
public class Admin_model {

    private Statement statement = null;

    public Admin_model() {
        try {
            statement = (Statement) koneksi.GetConnection().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Admin auth(String username, String password) {
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
                        String orangName = result.getString("name");
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
    
    
}

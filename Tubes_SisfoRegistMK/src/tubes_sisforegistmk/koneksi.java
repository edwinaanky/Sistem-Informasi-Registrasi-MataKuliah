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
import com.mysql.jdbc.Driver;
import java.sql.*;
public class koneksi {
    private static Connection koneksi;
    
    public static Connection GetConnection() throws SQLException{
        if(koneksi==null){
            new Driver();
            
            koneksi=DriverManager.getConnection("jdbc:mysql://localhost/db_registrasi","root","");
        }
        return koneksi;
    }
}

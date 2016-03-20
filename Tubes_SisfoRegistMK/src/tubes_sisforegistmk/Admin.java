/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk;

import java.io.Serializable;

/**
 *
 * @author desmoncode
 */
public class Admin extends Orang implements Serializable {

    private int id;
    private String usernameAdmin;
    private String passwordAdmin;

    public Admin(int id, String usernameAdmin, String passwordAdmin, String name, String jenisKelamin, String alamat, String telepon) {
        super(name, jenisKelamin, alamat, telepon);
        this.id = id;
        this.usernameAdmin = usernameAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public Admin() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }
}

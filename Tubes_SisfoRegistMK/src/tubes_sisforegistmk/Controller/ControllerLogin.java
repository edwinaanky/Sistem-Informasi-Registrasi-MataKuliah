/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tubes_sisforegistmk.*;
import tubes_sisforegistmk.Database.Database;
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerLogin implements ActionListener {

    private Application model;
    Login l = new Login();
    Database db = null;
    Admin admin = null;
    Mahasiswa mahasiswa = null;

//    DashboardMahasiswa dm = null;
    public ControllerLogin() {
        l.setVisible(true);
        l.addActionListener(this);
        db = new Database();
        db.connect();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj.equals(l.getjButtonLogin())) {
            if (l.gettPassword().getText().equals("") && l.gettUsername().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Username dan Password masih kosong", "Username dan Password salah", JOptionPane.ERROR_MESSAGE);
                l.gettUsername().requestFocus();
            } else if (l.gettUsername().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Username kosong", "Username salah", JOptionPane.ERROR_MESSAGE);
                l.gettUsername().requestFocus();
            } else if (l.gettUsername().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Password masih kosong", "Password salah", JOptionPane.ERROR_MESSAGE);
                l.gettPassword().requestFocus();
            } else {

                admin = db.autha(l.gettUsername().getText(), l.gettPassword().getText());
                mahasiswa = db.authm(l.gettUsername().getText(), l.gettPassword().getText());
                if (mahasiswa == null && admin != null) {
//                    System.out.println(db.getAllDosen().get(0).getNik());
                    JOptionPane.showMessageDialog(l, "Selamat Datang Administrator" + admin.getName(), "Admin", JOptionPane.INFORMATION_MESSAGE);
                    ControllerAdmin ca = new ControllerAdmin(admin.getName());
                    l.dispose();

                } else if (admin == null && mahasiswa != null) {
//                    dm = new DashboardMahasiswa();
//                    JOptionPane.showMessageDialog(dm, "Selamat Datang "+admin.getName(), "Mahasiswa", JOptionPane.INFORMATION_MESSAGE);
//                    dm.setVisible(true);

                    l.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Username atau Password salah", "Salah", JOptionPane.INFORMATION_MESSAGE);
                    l.gettUsername().requestFocus();

                }           
            }
        } else if (obj.equals(l.getjButtonCancel())) {
            l.gettUsername().setText("");
            l.gettPassword().setText("");
            l.gettUsername().requestFocus();
        }

    }

}

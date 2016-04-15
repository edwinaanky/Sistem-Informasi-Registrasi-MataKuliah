/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerMahasiswa implements ActionListener{
    Application model;
    DashboardMahasiswa view;
    Mahasiswa m = null;
    
    public ControllerMahasiswa(Mahasiswa mhs) {
        view = new DashboardMahasiswa();
        view.setVisible(true);
        view.AddActionListener(this);
        model = new Application();
        this.m = mhs;
    }
    
    public ControllerMahasiswa() {
        view = new DashboardMahasiswa();
        view.setVisible(true);
        view.AddActionListener(this);
        model = new Application();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(view.getjButtonTambah())){
            new ControllerMahasiswaTambahKelas(m,model);
        }
        else if(obj.equals(view.getjButtonLihat())){
            new ControllerMahasiswaLihatKelas(m,model);
        }
        else if(obj.equals(view.getjButtonKeluar())){
            new ControllerLogin();
            view.dispose();
        }
        
        
    }
}

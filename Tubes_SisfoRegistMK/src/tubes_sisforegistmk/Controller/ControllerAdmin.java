/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes_sisforegistmk.Model.Application;
import tubes_sisforegistmk.View.*;
/**
 *
 * @author desmoncode
 */
public class ControllerAdmin implements ActionListener{
    Application model;
    DashboardAdmin view;
    
    public ControllerAdmin(String nama) {
        view = new DashboardAdmin();
        view.setVisible(true);
        view.addActionListener(this);
        view.getjLabelWelcome().setText("Selamat Datang, "+nama);
        model = new Application();
    }
    
    public ControllerAdmin() {
        view = new DashboardAdmin();
        view.setVisible(true);
        view.addActionListener(this);
        model = new Application();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(view.getjButtonDosen())){
            new ControllerAdminDosen(view.getjLabelWelcome().getText(),model);
            
        }
        else if(obj.equals(view.getjButtonKelas())){
            new ControllerAdminKelas(view.getjLabelWelcome().getText(),model);
        }
        else if(obj.equals(view.getjButtonKeluar())){
            new ControllerLogin();
            view.dispose();
        }
        else if(obj.equals(view.getjButtonMahasiswa())){
            
        }
        else if(obj.equals(view.getjButtonMatakuliah())){
            new ControllerAdminMatakuliah(view.getjLabelWelcome().getText(),model);
        }
        
    }
}

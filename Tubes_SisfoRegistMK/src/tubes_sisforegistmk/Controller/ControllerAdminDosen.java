/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import tubes_sisforegistmk.View.AdminKelolaDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes_sisforegistmk.Model.Application;
import tubes_sisforegistmk.View.*;
/**
 *
 * @author desmoncode
 */
public class ControllerAdminDosen implements ActionListener{
    private Application model;
    private AdminKelolaDosen view;
    String name;
    public ControllerAdminDosen(String nama,Application model) {
        this.model = model;
        view = new AdminKelolaDosen();
        view.setVisible(true);
        view.addActionListener(this);
        this.name = nama;
        view.setTitle("Kelola Dosen");
    }
    public ControllerAdminDosen(Application model) {
        this.model = model;
        view = new AdminKelolaDosen();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Kelola Dosen");
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(view.getjButtonCreate())){
            new ControllerAdminDosenCreate(model);
            view.dispose();
        }
        else if(obj.equals(view.getjButtonDelete())){
            
        }
        else if(obj.equals(view.getjButtonUpdate())){
            
        }
        else if(obj.equals(view.getjTextFieldCari())){
            
        }
        else if(obj.equals(view.getjButtonHome())){
            view.dispose();
            ControllerAdmin ad = new ControllerAdmin(name);
        }
    }
    
    
    
    
}

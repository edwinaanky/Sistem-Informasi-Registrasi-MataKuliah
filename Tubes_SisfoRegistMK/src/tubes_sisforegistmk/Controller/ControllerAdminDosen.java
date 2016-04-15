/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import tubes_sisforegistmk.View.AdminKelolaDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes_sisforegistmk.View.*;
/**
 *
 * @author desmoncode
 */
public class ControllerAdminDosen implements ActionListener{
    AdminKelolaDosen akd = new AdminKelolaDosen();
    String name;
    public ControllerAdminDosen(String nama) {
        akd.setVisible(true);
        akd.addActionListener(this);
        this.name = nama;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(akd.getjButtonCreate())){
            ControllerAdminDosenCreate cadc = new ControllerAdminDosenCreate();
        }
        else if(obj.equals(akd.getjButtonDelete())){
            
        }
        else if(obj.equals(akd.getjButtonUpdate())){
            
        }
        else if(obj.equals(akd.getjTextFieldCari())){
            
        }
        else if(obj.equals(akd.getjButtonHome())){
            akd.dispose();
            ControllerAdmin ad = new ControllerAdmin(name);
        }
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes_sisforegistmk.View.*;
/**
 *
 * @author desmoncode
 */
public class ControllerAdmin implements ActionListener{
    DashboardAdmin da = new DashboardAdmin();
    
    public ControllerAdmin(String nama) {
        da.setVisible(true);
        da.addActionListener(this);
        da.getjLabelWelcome().setText("Selamat Datang, "+nama);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(da.getjButtonDosen())){
            ControllerAdminDosen cad = new ControllerAdminDosen(da.getjLabelWelcome().getText());
            
        }
        else if(obj.equals(da.getjButtonKelas())){
            
        }
        else if(obj.equals(da.getjButtonKeluar())){
            da.dispose();
            ControllerLogin cl = new ControllerLogin();
        }
        else if(obj.equals(da.getjButtonMahasiswa())){
            
        }
        else if(obj.equals(da.getjButtonMatakuliah())){
            
        }
        
    }
}

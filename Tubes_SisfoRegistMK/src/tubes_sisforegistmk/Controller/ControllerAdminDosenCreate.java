/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tubes_sisforegistmk.*;
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.AdminKelolaDosenCreate;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminDosenCreate implements ActionListener{
    AdminKelolaDosenCreate akdc = new AdminKelolaDosenCreate();
    Dosen d = null;

    public ControllerAdminDosenCreate() {
        akdc.setVisible(true);
        akdc.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(akdc.getjButtonCreate())){
            if(akdc.getjTextAreaAlamat().getText().equals("")&&akdc.getjTextFieldNama().getText().equals("")&&akdc.getjTextFieldNik().getText().equals("")&&akdc.getjTextFieldTelepon().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Masih Kosong", "Kosong", JOptionPane.ERROR_MESSAGE);
                akdc.getjTextFieldNik().requestFocus();
            }
            else{
                String status=null;
                String jk=null;
                if(akdc.getjRadioButtonHonorer().isSelected()){
                    status = akdc.getjRadioButtonHonorer().getText();
                }
                else if(akdc.getjRadioButtonTetap().isSelected()){
                    status = akdc.getjRadioButtonTetap().getText();
                }
                if(akdc.getjRadioButtonPria().isSelected()){
                    jk=akdc.getjRadioButtonPria().getText();
                }
                else if(akdc.getjRadioButtonWanita().isSelected()){
                    jk=akdc.getjRadioButtonWanita().getText();
                }
                String nik = akdc.getjTextFieldNik().getText();
                long nikk = Long.parseLong(nik);
                d = new Dosen(nikk,akdc.getjComboBoxKK().getSelectedItem().toString(),status,akdc.getjTextFieldNama().getText(),jk,akdc.getjTextAreaAlamat().getText(),akdc.getjTextFieldTelepon().getText());
                
                Admin_model am = new Admin_model();
                am.insert_orang_dosen(d);
            }
        }
        else if(obj.equals(akdc.getjButtonCancel())){
            
        }
        else if(obj.equals(akdc.getjButtonBack())){
            
        }
    }
    
}

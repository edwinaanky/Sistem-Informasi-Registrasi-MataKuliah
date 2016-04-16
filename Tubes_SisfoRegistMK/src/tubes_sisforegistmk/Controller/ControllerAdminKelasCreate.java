/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tubes_sisforegistmk.Model.Application;
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminKelasCreate implements ActionListener{
    private Application model;
    private AdminKelolaKelasCreate view;
    private Kelas k=null;
    private Dosen d=null;
    private Matakuliah m=null;

    public ControllerAdminKelasCreate(Application model) {
        this.model = model;
        view = new AdminKelolaKelasCreate();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Create Kelas");
        this.k = null;
        ArrayList<Dosen> d = model.getDaftarDosen();
        for (Dosen d1 : d) {
            view.getjComboBoxDosen().addItem(d1.getName());
        }
        ArrayList<Matakuliah> m = model.getDaftarMatakuliah();
        for (Matakuliah m1 : m) {
            view.getjComboBoxMatkul().addItem(m1.getNamaMatkul());
        }
    }

    public ControllerAdminKelasCreate(Application model, Kelas k) {
        this.model = model;
        view = new AdminKelolaKelasCreate();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Update Kelas");
        this.k = k;
        view.getjTextFieldNama().setText(k.getNamaKelas());
        view.getjTextFieldMaxmhs().setText(Integer.toString(k.getMaxMhs()));
        ArrayList<Dosen> d = model.getDaftarDosen();
        for (Dosen d1 : d) {
            view.getjComboBoxDosen().addItem(d1.getName());
        }
        ArrayList<Matakuliah> m = model.getDaftarMatakuliah();
        for (Matakuliah m1 : m) {
            view.getjComboBoxMatkul().addItem(m1.getNamaMatkul());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj.equals(view.getjButtonCreate())) {
                if (k == null) {
                    for(Dosen d : model.getDaftarDosen()){
                        if(d.getName().equals(view.getjComboBoxDosen().getSelectedItem().toString())){
                            this.d = d;
                        }
                    }
                    for(Matakuliah m : model.getDaftarMatakuliah()){
                        if(m.getNamaMatkul().equals(view.getjComboBoxMatkul().getSelectedItem().toString())){
                            this.m = m;
                        }
                    }
                    
                    model.createKelas(view.getjTextFieldNama().getText(), Integer.parseInt(view.getjTextFieldMaxmhs().getText()), d, m);
                    
                    JOptionPane.showMessageDialog(view, "Data Kelas berhasil diinputkan");
                    view.getjTextFieldNama().setText("");
                    view.getjTextFieldMaxmhs().setText("");
                } else {
                    for(Dosen d : model.getDaftarDosen()){
                        if(d.getName().equals(view.getjComboBoxDosen().getSelectedItem().toString())){
                            this.d = d;
                        }
                    }
                    for(Matakuliah m : model.getDaftarMatakuliah()){
                        if(m.getNamaMatkul().equals(view.getjComboBoxMatkul().getSelectedItem().toString())){
                            this.m = m;
                        }
                    }
                    k.setNamaKelas(view.getjTextFieldMaxmhs().getText());
                    k.setMaxMhs(Integer.parseInt(view.getjTextFieldMaxmhs().getText()));
                    Dosen d = model.getDosen(Integer.parseInt(view.getjComboBoxDosen().getSelectedItem().toString()));
                    Matakuliah m = model.getMatakuliah(view.getjComboBoxMatkul().getSelectedItem().toString());
                    k.setDosen(d);
                    k.setMatakuliah(m);
                    model.updateKelas(k, k.getId());
                }
//                d = new Dosen(nikk,view.getjComboBoxKK().getSelectedItem().toString(),status,view.getjTextFieldNama().getText(),jk,view.getjTextAreaAlamat().getText(),view.getjTextFieldTelepon().getText());

//                Admin_model am = new Admin_model();
//                am.insert_orang_dosen(d);
            
        } else if (obj.equals(view.getjButtonCancel())) {
            view.getjTextFieldNama().setText("");
            view.getjTextFieldMaxmhs().setText("");
            view.getjTextFieldNama().requestFocus();
        } else if (obj.equals(view.getjButtonBack())) {
            new ControllerAdminKelas(model);
            view.dispose();
        }
    }
}

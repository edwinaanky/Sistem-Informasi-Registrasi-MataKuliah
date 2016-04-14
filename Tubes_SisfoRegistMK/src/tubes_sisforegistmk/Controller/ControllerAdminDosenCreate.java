/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import sun.org.mozilla.javascript.ScriptRuntime;
import tubes_sisforegistmk.*;
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.AdminKelolaDosenCreate;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminDosenCreate implements ActionListener {

    private Application model;
    private AdminKelolaDosenCreate view;
    private Dosen d;

    public ControllerAdminDosenCreate(Application model) {
        this.model = model;
        view = new AdminKelolaDosenCreate();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Create Dosen");
        this.d = null;
    }

    public ControllerAdminDosenCreate(Application model, Dosen d) {
        this.model = model;
        view = new AdminKelolaDosenCreate();
        view.setVisible(true);
        view.addActionListener(this);
        this.d = d;
        view.getjTextFieldNama().setText(d.getName());
        String nik = Long.toString(d.getNik());
        view.getjTextFieldNik().setText(nik);
        view.setTitle("Edit Dosen");
        view.getjTextFieldTelepon().setText(d.getTelepon());
        if (d.getJenisKelamin().equals("pria")) {
            view.getjRadioButtonPria().doClick();
        } else if (d.getJenisKelamin().equals("wanita")) {
            view.getjRadioButtonWanita().doClick();
        }
        if (d.getStatus().equals("tetap")) {
            view.getjRadioButtonTetap().doClick();
        } else if (d.getStatus().equals("honorer")) {
            view.getjRadioButtonHonorer().doClick();
            
        }
        view.getjButtonCreate().setText("Update");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj.equals(view.getjButtonCreate())) {
            if (view.getjTextAreaAlamat().getText().equals("") && view.getjTextFieldNama().getText().equals("") && view.getjTextFieldNik().getText().equals("") && view.getjTextFieldTelepon().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Masih Kosong", "Kosong", JOptionPane.ERROR_MESSAGE);
                view.getjTextFieldNik().requestFocus();
            } else {
                String status = null;
                String jk = null;
                if (view.getjRadioButtonHonorer().isSelected()) {
                    status = view.getjRadioButtonHonorer().getText();
                } else if (view.getjRadioButtonTetap().isSelected()) {
                    status = view.getjRadioButtonTetap().getText();
                }
                if (view.getjRadioButtonPria().isSelected()) {
                    jk = view.getjRadioButtonPria().getText();
                } else if (view.getjRadioButtonWanita().isSelected()) {
                    jk = view.getjRadioButtonWanita().getText();
                }
                String nik = view.getjTextFieldNik().getText();
                long nikk = Long.parseLong(nik);
                if (d == null) {
                    model.createDosen(nikk, view.getjComboBoxKK().getSelectedItem().toString(), status, view.getjTextFieldNama().getText(), jk, view.getjTextAreaAlamat().getText(), view.getjTextFieldTelepon().getText());
                    JOptionPane.showMessageDialog(view, "Data dosen berhasil diinputkan");
                    view.getjTextAreaAlamat().setText("");
                    view.getjTextFieldNama().setText("");
                    view.getjTextFieldNik().setText("");
                    view.getjTextFieldTelepon().setText("");

                } else {
                    d.setName(view.getjTextFieldNama().getText());
                    d.setAlamat(view.getjTextAreaAlamat().getText());
                    d.setJenisKelamin(jk);
                    d.setStatus(status);
                    d.setKk(view.getjComboBoxKK().getSelectedItem().toString());
                    d.setNik(nikk);
                    d.setTelepon(view.getjTextFieldTelepon().getText());
                    model.updateDosen(d, nikk);
                    JOptionPane.showMessageDialog(view, "Data dosen berhasil diupdate");
                    view.getjTextAreaAlamat().setText("");
                    view.getjTextFieldNama().setText("");
                    view.getjTextFieldNik().setText("");
                    view.getjTextFieldTelepon().setText("");
                    view.dispose();
                }
//                d = new Dosen(nikk,view.getjComboBoxKK().getSelectedItem().toString(),status,view.getjTextFieldNama().getText(),jk,view.getjTextAreaAlamat().getText(),view.getjTextFieldTelepon().getText());

//                Admin_model am = new Admin_model();
//                am.insert_orang_dosen(d);
            }
        } else if (obj.equals(view.getjButtonCancel())) {
            view.getjTextAreaAlamat().setText("");
            view.getjTextFieldNama().setText("");
            view.getjTextFieldNik().setText("");
            view.getjTextFieldTelepon().setText("");
            view.getjTextFieldNik().requestFocus();
        } else if (obj.equals(view.getjButtonBack())) {
            new ControllerAdminDosen(model);
            view.dispose();
        }
    }

}

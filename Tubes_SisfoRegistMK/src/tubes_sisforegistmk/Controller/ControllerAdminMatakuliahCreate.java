/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tubes_sisforegistmk.Model.Application;
import tubes_sisforegistmk.Model.Matakuliah;
import tubes_sisforegistmk.View.AdminKelolaMatakuliahCreate;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminMatakuliahCreate implements ActionListener {

    private Application model;
    private AdminKelolaMatakuliahCreate view;
    private Matakuliah m;

    public ControllerAdminMatakuliahCreate(Application model) {
        this.model = model;
        view = new AdminKelolaMatakuliahCreate();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Create Matakuliah");
        this.m = null;
    }

    public ControllerAdminMatakuliahCreate(Application model, Matakuliah m) {
        this.model = model;
        view = new AdminKelolaMatakuliahCreate();
        view.setVisible(true);
        view.addActionListener(this);
        this.m = m;

        view.getjTextFieldKode().setText(m.getKode());
        view.getjTextFieldNama().setText(m.getNamaMatkul());
        view.getjTextFieldSks().setText(Integer.toString(m.getSks()));
        view.getjButtonCreate().setText("Update");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj.equals(view.getjButtonCreate())) {
            if (view.getjTextFieldKode().getText().equals("") && view.getjTextFieldNama().getText().equals("") && view.getjTextFieldSks().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Masih Kosong", "Kosong", JOptionPane.ERROR_MESSAGE);
                view.getjTextFieldKode().requestFocus();
            } else {

                if (m == null) {
                    model.createMatakuliah(view.getjTextFieldKode().getText(), view.getjTextFieldNama().getText(), Integer.parseInt(view.getjTextFieldSks().getText()));
                    JOptionPane.showMessageDialog(view, "Data dosen berhasil diinputkan");
                    view.getjTextFieldKode().setText("");
                    view.getjTextFieldNama().setText("");
                    view.getjTextFieldSks().setText("");

                } else {
                    m.setKode(view.getjTextFieldKode().getText());
                    m.setNamaMatkul(view.getjTextFieldNama().getText());
                    m.setSks(Integer.parseInt(view.getjTextFieldSks().getText()));
                    model.updateMatakuliah(m, view.getjTextFieldKode().getText());
                    JOptionPane.showMessageDialog(view, "Data dosen berhasil diupdate");
                    view.getjTextFieldKode().setText("");
                    view.getjTextFieldNama().setText("");
                    view.getjTextFieldSks().setText("");
                    view.dispose();
                }
//                d = new Matakuliah(nikk,view.getjComboBoxKK().getSelectedItem().toString(),status,view.getjTextFieldNama().getText(),jk,view.getjTextAreaAlamat().getText(),view.getjTextFieldTelepon().getText());

//                Admin_model am = new Admin_model();
//                am.insert_orang_dosen(d);
            }
        } else if (obj.equals(view.getjButtonCancel())) {
            view.getjTextFieldKode().setText("");
            view.getjTextFieldNama().setText("");
            view.getjTextFieldSks().setText("");
            view.getjTextFieldKode().requestFocus();

        } else if (obj.equals(view.getjButtonBack())) {
            new ControllerAdminMatakuliah(model);
            view.dispose();
        }
    }
}

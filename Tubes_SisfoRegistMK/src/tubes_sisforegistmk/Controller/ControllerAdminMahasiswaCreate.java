/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminMahasiswaCreate implements ActionListener {

    private Application model;
    private AdminKelolaMahasiswaCreate view;
    private Mahasiswa mhs;

    public ControllerAdminMahasiswaCreate(Application model) {
        this.model = model;
        view = new AdminKelolaMahasiswaCreate();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Create Mahasiswa");
        this.mhs = null;
    }

    public ControllerAdminMahasiswaCreate(Application model, Mahasiswa mhs) {
        this.model = model;
        view = new AdminKelolaMahasiswaCreate();
        view.setVisible(true);
        view.addActionListener(this);
        this.mhs = mhs;
        view.getjTextFieldNama().setText(mhs.getName());
        String nim = Long.toString(mhs.getNim());
        view.getjTextFieldNim().setText(nim);
        view.getjTextAreaAlamat().setText(mhs.getAlamat());
        view.getjTextFieldNama().setText(mhs.getName());
        view.getjTextFieldPassword().setText(mhs.getPasswordMhs());
        view.getjTextFieldSks().setText(Integer.toString(mhs.getMaxSks()));
        view.getjTextFieldTelepon().setText(mhs.getTelepon());
        view.getjTextFieldUsername().setText(mhs.getUsernameMhs());
        view.setTitle("Edit Mahasiswa");
        view.getjButtonCreate().setText("Update");
//        if (d.getJenisKelamin().equals("pria")) {
//            view.getjRadioButtonPria().doClick();
//        } else if (d.getJenisKelamin().equals("wanita")) {
//            view.getjRadioButtonWanita().doClick();
//        }
//        if (d.getStatus().equals("tetap")) {
//            view.getjRadioButtonTetap().doClick();
//        } else if (d.getStatus().equals("honorer")) {
//            view.getjRadioButtonHonorer().doClick();
//            view.setTitle("Edit Mahasiswa");
//        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj.equals(view.getjButtonCreate())) {
            if (view.getjTextAreaAlamat().getText().equals("") && view.getjTextFieldNama().getText().equals("") && view.getjTextFieldNim().getText().equals("") && view.getjTextFieldTelepon().getText().equals("") && view.getjTextFieldUsername().getText().equals("") && view.getjTextFieldPassword().getText().equals("") && view.getjTextFieldSks().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Masih Kosong", "Kosong", JOptionPane.ERROR_MESSAGE);
                view.getjTextFieldNim().requestFocus();
            } else {
                String status = null;
                String jk = null;
                if (view.getjRadioButtonPria().isSelected()) {
                    jk = view.getjRadioButtonPria().getText();
                } else if (view.getjRadioButtonWanita().isSelected()) {
                    jk = view.getjRadioButtonWanita().getText();
                }
                String nim = view.getjTextFieldNim().getText();
                long nimm = Long.parseLong(nim);

                if (mhs == null) {
                    model.createMahasiswa(nimm, Integer.parseInt(view.getjTextFieldSks().getText()), view.getjTextFieldUsername().getText(), view.getjTextFieldPassword().getText(), view.getjTextFieldNama().getText(), jk, view.getjTextAreaAlamat().getText(), view.getjTextFieldTelepon().getText(), view.getjComboBoxJurusan().getSelectedItem().toString(), Integer.parseInt(view.getjComboBoxSemester().getSelectedItem().toString()));
                    JOptionPane.showMessageDialog(view, "Data mahasiswa berhasil diinputkan");
                    view.getjTextFieldNama().setText("");
                    view.getjTextFieldNim().setText("");
                    view.getjTextAreaAlamat().setText("");
                    view.getjTextFieldPassword().setText("");
                    view.getjTextFieldUsername().setText("");
                    view.getjTextFieldSks().setText("");
                    view.getjTextFieldTelepon().setText("");

                } else {
                    mhs.setName(view.getjTextFieldNama().getText());
                    mhs.setAlamat(view.getjTextAreaAlamat().getText());
                    mhs.setMaxSks(Integer.parseInt(view.getjTextFieldSks().getText()));
                    mhs.setJurusan(view.getjComboBoxJurusan().getSelectedItem().toString());
                    mhs.setNim(Long.parseLong(view.getjTextFieldNim().getText()));
                    mhs.setPasswordMhs(view.getjTextFieldPassword().getText());
                    mhs.setUsernameMhs(view.getjTextFieldUsername().getText());
                    mhs.setSemester(Integer.parseInt(view.getjComboBoxSemester().getSelectedItem().toString()));
                    mhs.setJenisKelamin(jk);
                    mhs.setTelepon(view.getjTextFieldTelepon().getText());
                    model.updateMahasiswa(mhs, nimm);
                    JOptionPane.showMessageDialog(view, "Data Mahasiswa berhasil diupdate");
                    view.getjTextFieldNama().setText("");
                    view.getjTextFieldNim().setText("");
                    view.getjTextAreaAlamat().setText("");
                    view.getjTextFieldPassword().setText("");
                    view.getjTextFieldUsername().setText("");
                    view.getjTextFieldSks().setText("");
                    view.getjTextFieldTelepon().setText("");
                    view.dispose();
                }
//                d = new Dosen(nikk,view.getjComboBoxKK().getSelectedItem().toString(),status,view.getjTextFieldNama().getText(),jk,view.getjTextAreaAlamat().getText(),view.getjTextFieldTelepon().getText());

//                Admin_model am = new Admin_model();
//                am.insert_orang_dosen(d);
            }
        } else if (obj.equals(view.getjButtonCancel())) {
            view.getjTextFieldNama().setText("");
            view.getjTextFieldNim().setText("");
            view.getjTextAreaAlamat().setText("");
            view.getjTextFieldPassword().setText("");
            view.getjTextFieldUsername().setText("");
            view.getjTextFieldSks().setText("");
            view.getjTextFieldTelepon().setText("");
            view.getjTextFieldNim().requestFocus();
        } else if (obj.equals(view.getjButtonBack())) {
            new ControllerAdminMahasiswa(model);
            view.dispose();
        }
    }
}

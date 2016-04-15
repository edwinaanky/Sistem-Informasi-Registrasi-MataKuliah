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
import javax.swing.table.DefaultTableModel;
import tubes_sisforegistmk.Model.Application;
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminMahasiswa implements ActionListener {

    private Application model;
    private AdminKelolaMahasiswa view;
    String name;
    ArrayList<Mahasiswa> daftarMahasiswa = null;

    public ControllerAdminMahasiswa(String nama, Application model) {
        this.model = model;
        view = new AdminKelolaMahasiswa();
        view.setVisible(true);
        view.addActionListener(this);
        this.name = nama;
        view.setTitle("Kelola Mahasiswa");
        this.daftarMahasiswa = model.getDaftarMahasiswa();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableMahasiswa().getModel();
        for (Mahasiswa mhs : daftarMahasiswa) {
            Object[] row = {mhs.getNim(), mhs.getName(), mhs.getJenisKelamin(), mhs.getJumlahSks(), mhs.getMaxSks(), mhs.getJumlahKelas(), mhs.getSemester(), mhs.getJurusan(), mhs.getUsernameMhs(), mhs.getPasswordMhs(), mhs.getAlamat(), mhs.getTelepon()};
            tmodel.addRow(row);
        }

    }

    public ControllerAdminMahasiswa(Application model) {
        this.model = model;
        view = new AdminKelolaMahasiswa();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Kelola Mahasiswa");
        this.daftarMahasiswa = model.getDaftarMahasiswa();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableMahasiswa().getModel();
        for (Mahasiswa mhs : daftarMahasiswa) {
            Object[] row = {mhs.getNim(), mhs.getName(), mhs.getJenisKelamin(), mhs.getJumlahSks(), mhs.getMaxSks(), mhs.getJumlahKelas(), mhs.getSemester(), mhs.getJurusan(), mhs.getUsernameMhs(), mhs.getPasswordMhs(), mhs.getAlamat(), mhs.getTelepon()};
            tmodel.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj.equals(view.getjButtonCreate())) {
            new ControllerAdminMahasiswaCreate(model);
            view.dispose();
        } else if (obj.equals(view.getjButtonDelete())) {
            String nika = JOptionPane.showInputDialog(view, "Masukkan nik Mahasiswa", "Update", JOptionPane.QUESTION_MESSAGE);
            long nik = Long.parseLong(nika);
            Mahasiswa d = model.getMahasiswa(nik);
            if (!d.equals(null)) {
                int pil = JOptionPane.showConfirmDialog(view, "Apakah yakin untuk menghapus ?", "Confirm delete", JOptionPane.YES_NO_OPTION);
                if (pil == 0) {
                    model.deleteMahasiswa(d);
                    JOptionPane.showMessageDialog(view, "Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (obj.equals(view.getjButtonUpdate())) {
            long nik;
            
            String nika = JOptionPane.showInputDialog(view, "Masukkan nik Mahasiswa", "Update", JOptionPane.QUESTION_MESSAGE);
            nik = Long.parseLong(nika);
            Mahasiswa d = model.getMahasiswa(nik);
            new ControllerAdminMahasiswaCreate(model, d);
        }  else if (obj.equals(view.getjButtonHome())) {
            view.dispose();
            
        }
    }
}

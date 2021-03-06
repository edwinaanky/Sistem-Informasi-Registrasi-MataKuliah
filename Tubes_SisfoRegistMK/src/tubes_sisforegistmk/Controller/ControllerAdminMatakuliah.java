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
import tubes_sisforegistmk.Model.Matakuliah;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminMatakuliah implements ActionListener {

    private Application model;
    private AdminKelolaMatakuliah view;
    String name;
    ArrayList<Matakuliah> daftarMatakuliah = null;
    
    public ControllerAdminMatakuliah(String nama, Application model) {
        this.model = model;
        view = new AdminKelolaMatakuliah();
        view.setVisible(true);
        view.addActionListener(this);
        this.name = nama;
        view.setTitle("Kelola Matakuliah");
        this.daftarMatakuliah = model.getDaftarMatakuliah();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableMatkul().getModel();
        for (Matakuliah m : daftarMatakuliah) {
            Object[] row = {m.getKode(),m.getNamaMatkul(),m.getSks()};
            tmodel.addRow(row);
        }
    }

    public ControllerAdminMatakuliah(Application model) {
        this.model = model;
        view = new AdminKelolaMatakuliah();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Kelola Matakuliah");
        this.daftarMatakuliah = model.getDaftarMatakuliah();
        this.daftarMatakuliah = model.getDaftarMatakuliah();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableMatkul().getModel();
        for (Matakuliah m : daftarMatakuliah) {
            Object[] row = {m.getKode(),m.getNamaMatkul(),m.getSks()};
            tmodel.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj.equals(view.getjButtonCreate())) {
            new ControllerAdminMatakuliahCreate(model);
            view.dispose();
        } else if (obj.equals(view.getjButtonDelete())) {
            String nika = JOptionPane.showInputDialog(view, "Masukkan kode Matakuliah", "Update", JOptionPane.QUESTION_MESSAGE);
            
            Matakuliah m = model.getMatakuliah(nika);
            if (m!=null) {
                int pil = JOptionPane.showConfirmDialog(view, "Apakah yakin untuk menghapus ?", "Confirm delete", JOptionPane.YES_NO_OPTION);
                if (pil == 0) {
                    model.deleteMatakuliah(m);
                    JOptionPane.showMessageDialog(view, "Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(view, "Kode Matakuliah tidak ditemukan","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (obj.equals(view.getjButtonUpdate())) {
            long nik;
            Object nikk = new Object();
            String nika = JOptionPane.showInputDialog(view, "Masukkan nik Matakuliah", "Update", JOptionPane.QUESTION_MESSAGE);
            
            Matakuliah d = model.getMatakuliah(nika);
            new ControllerAdminMatakuliahCreate(model, d);
        }  else if (obj.equals(view.getjButtonHome())) {
            view.dispose();
            
        }
    }
}

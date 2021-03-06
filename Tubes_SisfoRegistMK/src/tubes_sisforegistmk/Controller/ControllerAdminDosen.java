/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.Controller;

import tubes_sisforegistmk.View.AdminKelolaDosen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tubes_sisforegistmk.Model.Application;
import tubes_sisforegistmk.Model.Dosen;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerAdminDosen implements ActionListener{
    private Application model;
    private AdminKelolaDosen view;
    String name;
    ArrayList<Dosen> daftarDosen = null;
    
    public ControllerAdminDosen(String nama,Application model) {
        this.model = model;
        view = new AdminKelolaDosen();
        view.setVisible(true);
        view.addActionListener(this);
        this.name = nama;
        view.setTitle("Kelola Dosen");
        this.daftarDosen = model.getDaftarDosen();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableDosen().getModel();
        for(Dosen d : daftarDosen){
            Object[] row = {d.getNik(),d.getName(),d.getKk(),d.getStatus(),d.getAlamat(),d.getJenisKelamin(),d.getTelepon(),d.getId()};
            tmodel.addRow(row);
        }
        
        
        
    }
    public ControllerAdminDosen(Application model) {
        this.model = model;
        view = new AdminKelolaDosen();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Kelola Dosen");
        this.daftarDosen = model.getDaftarDosen();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableDosen().getModel();
        for(Dosen d : daftarDosen){
            Object[] row = {d.getNik(),d.getName(),d.getKk(),d.getStatus(),d.getAlamat(),d.getJenisKelamin(),d.getTelepon(),d.getId()};
            tmodel.addRow(row);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(view.getjButtonCreate())){
            new ControllerAdminDosenCreate(model);
            view.dispose();
        }
        else if(obj.equals(view.getjButtonDelete())){
            String nika = JOptionPane.showInputDialog(view, "Masukkan nik Dosen", "Update",JOptionPane.QUESTION_MESSAGE);
            long nik = Long.parseLong(nika);
            Dosen d = model.getDosen(nik);
            if(d!=null){
                int pil=JOptionPane.showConfirmDialog(view, "Apakah yakin untuk menghapus ?", "Confirm delete", JOptionPane.YES_NO_OPTION);
                if(pil==0){
                    model.deleteDosen(d);
                    JOptionPane.showMessageDialog(view, "Berhasil Dihapus","Success",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(view, "NIK tidak ditemukan","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(obj.equals(view.getjButtonUpdate())){
            long nik;
            Object nikk = new Object();
            String nika = JOptionPane.showInputDialog(view, "Masukkan nik Dosen", "Update",JOptionPane.QUESTION_MESSAGE);
            nik = Long.parseLong(nika);
            Dosen d = model.getDosen(nik);
            if(d!=null){
                new ControllerAdminDosenCreate(model,d);
                view.dispose();
            }else
            {
                JOptionPane.showMessageDialog(view, "NIK tidak ditemukan","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if(obj.equals(view.getjButtonHome())){
            view.dispose();
            
        }
    }
    
    
    
    
}

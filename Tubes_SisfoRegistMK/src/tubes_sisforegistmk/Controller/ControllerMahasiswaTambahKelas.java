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
import tubes_sisforegistmk.Model.*;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerMahasiswaTambahKelas implements ActionListener{
    private Application model;
    private MahasiswaTambahKelas view;
    ArrayList<Kelas> daftarKelas = null;
    Mahasiswa mhs = null;
    Kelas k = null;
    
    public ControllerMahasiswaTambahKelas(Mahasiswa mhs,Application model) {
        this.model = model;
        view = new MahasiswaTambahKelas();
        view.setVisible(true);
        view.AddActionListener(this);
        this.mhs = mhs;
        view.setTitle("Tambah Kelas");
        this.daftarKelas = model.getDaftarKelas();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableKelas().getModel();
        for(Kelas k : daftarKelas){
            Object[] row = {k.getId(),k.getNamaKelas(),k.getMatakuliah().getNamaMatkul(),k.getDosen().getName(),k.getMatakuliah().getSks()};
            tmodel.addRow(row);
        }
        
        
        
    }
    public ControllerMahasiswaTambahKelas(Application model) {
        this.model = model;
        view = new MahasiswaTambahKelas();
        view.setVisible(true);
        view.AddActionListener(this);
        this.mhs = mhs;
        view.setTitle("Tambah Kelas");
        this.daftarKelas = model.getDaftarKelas();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableKelas().getModel();
        for(Kelas k : daftarKelas){
            Object[] row = {k.getId(),k.getNamaKelas(),k.getMatakuliah().getNamaMatkul(),k.getDosen().getName(),k.getMatakuliah().getSks()};
            tmodel.addRow(row);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(view.getjButtonTambah())){
            if(view.getjTableKelas().getSelectedRow()!=-1){
                int pil=JOptionPane.showConfirmDialog(view, "Apakah yakin untuk mengambil kelas ?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(pil==0){
                    int idKelas = Integer.parseInt(view.getjTableKelas().getModel().getValueAt(view.getjTableKelas().getSelectedRow(), 0).toString());
                    Kelas k = model.getKelasByid(idKelas);
                    if(model.tambahKelasMhs(mhs, k)==1){
                        JOptionPane.showMessageDialog(view, "Berhasil Ditambahkan","Success",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if(model.tambahKelasMhs(mhs, k)==2){
                        JOptionPane.showMessageDialog(view, "Kelas Penuh","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(model.tambahKelasMhs(mhs, k)==3){
                        JOptionPane.showMessageDialog(view, "SKS tidak mencukupi","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(model.tambahKelasMhs(mhs, k)==0){
                        JOptionPane.showMessageDialog(view, "Kelas sudah ada","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        else if(obj.equals(view.getjButtonHome())){
            view.dispose();
            
        }
    }
}

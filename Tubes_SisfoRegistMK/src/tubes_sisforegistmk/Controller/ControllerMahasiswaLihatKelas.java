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
import tubes_sisforegistmk.Model.Kelas;
import tubes_sisforegistmk.Model.Mahasiswa;
import tubes_sisforegistmk.View.*;

/**
 *
 * @author desmoncode
 */
public class ControllerMahasiswaLihatKelas implements ActionListener{
    private Application model;
    private MahasiswaLihatDaftarKelas view;
    ArrayList<Kelas> daftarKelas = null;
    Mahasiswa mhs = null;
    Kelas k = null;
    
    public ControllerMahasiswaLihatKelas(Mahasiswa mhs,Application model) {
        this.model = model;
        view = new MahasiswaLihatDaftarKelas();
        view.setVisible(true);
        view.AddActionListener(this);
        this.mhs = mhs;
        view.setTitle("Lihat Kelas");
        this.daftarKelas = model.getAllKelasMahasiswa();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableKelas().getModel();
        for(Kelas k : daftarKelas){
            Object[] row = {k.getNamaKelas(),k.getMatakuliah().getNamaMatkul(),k.getMatakuliah().getSks()};
            tmodel.addRow(row);
        }
        view.getjLabelSemester().setText(Integer.toString(mhs.getSemester()));
        view.getjLabelSks().setText(Integer.toString(mhs.getTotalKelas()));
        view.getjLabelTotsks().setText(Integer.toString(mhs.getMaxSks()));
        
        
        
    }
    public ControllerMahasiswaLihatKelas(Application model) {
        this.model = model;
        view = new MahasiswaLihatDaftarKelas();
        view.setVisible(true);
        view.AddActionListener(this);
        this.mhs = mhs;
        view.setTitle("Lihat Kelas");
        this.daftarKelas = model.getAllKelasMahasiswa();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableKelas().getModel();
        for(Kelas k : daftarKelas){
            Object[] row = {k.getNamaKelas(),k.getMatakuliah().getNamaMatkul(),k.getMatakuliah().getSks()};
            tmodel.addRow(row);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(view.getjButtonHome())){
            view.dispose();
            
        }
    }
}

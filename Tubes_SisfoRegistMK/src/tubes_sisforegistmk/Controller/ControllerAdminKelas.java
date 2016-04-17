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
import tubes_sisforegistmk.View.*;
/**
 *
 * @author desmoncode
 */
public class ControllerAdminKelas implements ActionListener{
    private Application model;
    private AdminKelolaKelas view;
    String name;
    ArrayList<Kelas> daftarKelas = null;
    
    public ControllerAdminKelas(String nama,Application model) {
        this.model = model;
        view = new AdminKelolaKelas();
        view.setVisible(true);
        view.addActionListener(this);
        this.name = nama;
        view.setTitle("Kelola Kelas");
        this.daftarKelas = model.getDaftarKelas();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableKelas().getModel();
        for(Kelas k : daftarKelas){
            Object[] row = {k.getId(),k.getNamaKelas(),k.getMaxMhs(),k.getJmlMhs(),k.getMatakuliah().getNamaMatkul(),k.getDosen().getName()};
            tmodel.addRow(row);
        }
        
        
        
    }
    public ControllerAdminKelas(Application model) {
        this.model = model;
        view = new AdminKelolaKelas();
        view.setVisible(true);
        view.addActionListener(this);
        view.setTitle("Kelola Kelas");
        this.daftarKelas = model.getDaftarKelas();
        DefaultTableModel tmodel = (DefaultTableModel) view.getjTableKelas().getModel();
        for(Kelas k : daftarKelas){
            Object[] row = {k.getId(),k.getNamaKelas(),k.getMaxMhs(),k.getJmlMhs(),k.getMatakuliah().getNamaMatkul(),k.getDosen().getName()};
            tmodel.addRow(row);
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if(obj.equals(view.getjButtonCreate())){
            new ControllerAdminKelasCreate(model);
            view.dispose();
        }
        else if(obj.equals(view.getjButtonDelete())){
            String nika = JOptionPane.showInputDialog(view, "Masukkan id Kelas", "Update",JOptionPane.QUESTION_MESSAGE);
            long nik = Long.parseLong(nika);
            Kelas k = model.getKelasByid(Integer.parseInt(nika));
            if(k!=null){
                int pil=JOptionPane.showConfirmDialog(view, "Apakah yakin untuk menghapus ?", "Confirm delete", JOptionPane.YES_NO_OPTION);
                if(pil==0){
                    model.deleteKelas(k);
                    JOptionPane.showMessageDialog(view, "Berhasil Dihapus","Success",JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(view, "Id kelas tidak ditemukan","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(obj.equals(view.getjButtonUpdate())){
            long nik;
            Object nikk = new Object();
            String nika = JOptionPane.showInputDialog(view, "Masukkan Id kelas", "Update",JOptionPane.QUESTION_MESSAGE);
            nik = Long.parseLong(nika);
            Kelas k = model.getKelasByid(Integer.parseInt(nika));
            if (k!=null){
                new ControllerAdminKelasCreate(model,k);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(view, "Id kelas tidak ditemukan","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if(obj.equals(view.getjButtonHome())){
            view.dispose();
            
        }
    }
    
}

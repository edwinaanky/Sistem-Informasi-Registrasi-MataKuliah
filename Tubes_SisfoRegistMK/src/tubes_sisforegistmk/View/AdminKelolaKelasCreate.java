/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author desmoncode
 */
public class AdminKelolaKelasCreate extends javax.swing.JFrame {

    /**
     * Creates new form AdminKelolaKelasCreate
     */
    public AdminKelolaKelasCreate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldMaxmhs = new javax.swing.JTextField();
        jComboBoxMatkul = new javax.swing.JComboBox();
        jComboBoxDosen = new javax.swing.JComboBox();
        jButtonCreate = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama Kelas");

        jLabel2.setText("Maksimal Mahasiswa");

        jLabel3.setText("Dosen");

        jLabel4.setText("Matakuliah");

        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });

        jButtonCreate.setText("Create");

        jButtonCancel.setText("Cancel");

        jButtonBack.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCreate)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNama)
                                .addComponent(jTextFieldMaxmhs, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBoxMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonCancel)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonBack)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMaxmhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxDosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreate)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonBack))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

    public JButton getjButtonBack() {
        return jButtonBack;
    }

    public void setjButtonBack(JButton jButtonBack) {
        this.jButtonBack = jButtonBack;
    }

    public JButton getjButtonCancel() {
        return jButtonCancel;
    }

    public void setjButtonCancel(JButton jButtonCancel) {
        this.jButtonCancel = jButtonCancel;
    }

    public JButton getjButtonCreate() {
        return jButtonCreate;
    }

    public void setjButtonCreate(JButton jButtonCreate) {
        this.jButtonCreate = jButtonCreate;
    }

    public JComboBox getjComboBoxDosen() {
        return jComboBoxDosen;
    }

    public void setjComboBoxDosen(JComboBox jComboBoxDosen) {
        this.jComboBoxDosen = jComboBoxDosen;
    }

    public JComboBox getjComboBoxMatkul() {
        return jComboBoxMatkul;
    }

    public void setjComboBoxMatkul(JComboBox jComboBoxMatkul) {
        this.jComboBoxMatkul = jComboBoxMatkul;
    }
    
    public void setjComboMatkul(String[] list){
//        jComboBoxMatkul.setModel();
    }

    public JTextField getjTextFieldMaxmhs() {
        return jTextFieldMaxmhs;
    }

    public void setjTextFieldMaxmhs(JTextField jTextFieldMaxmhs) {
        this.jTextFieldMaxmhs = jTextFieldMaxmhs;
    }

    public JTextField getjTextFieldNama() {
        return jTextFieldNama;
    }

    public void setjTextFieldNama(JTextField jTextFieldNama) {
        this.jTextFieldNama = jTextFieldNama;
    }
    
    public void addActionListener(ActionListener al){
        jButtonCreate.addActionListener(al);
        jButtonCancel.addActionListener(al);
        jButtonBack.addActionListener(al);
        
        
    }
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JComboBox jComboBoxDosen;
    private javax.swing.JComboBox jComboBoxMatkul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldMaxmhs;
    private javax.swing.JTextField jTextFieldNama;
    // End of variables declaration//GEN-END:variables
}

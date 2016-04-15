/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_sisforegistmk.View;

import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author desmoncode
 */
public class AdminKelolaDosenCreate extends javax.swing.JFrame {

    /**
     * Creates new form AdminKelolaDosenCreate
     */
    public AdminKelolaDosenCreate() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNik = new javax.swing.JTextField();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldTelepon = new javax.swing.JTextField();
        jComboBoxKK = new javax.swing.JComboBox();
        jRadioButtonPria = new javax.swing.JRadioButton();
        jRadioButtonWanita = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAlamat = new javax.swing.JTextArea();
        jRadioButtonTetap = new javax.swing.JRadioButton();
        jRadioButtonHonorer = new javax.swing.JRadioButton();
        jButtonCreate = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NIK");

        jLabel2.setText("Nama");

        jLabel3.setText("Kelompok Keahlian");

        jLabel4.setText("Status");

        jLabel5.setText("Alamat");

        jLabel6.setText("Jenis Kelamin");

        jLabel7.setText("Telepon");

        jTextFieldNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNikActionPerformed(evt);
            }
        });

        jComboBoxKK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ICM", "TELE", "SIDE" }));

        buttonGroup1.add(jRadioButtonPria);
        jRadioButtonPria.setText("Pria");

        buttonGroup1.add(jRadioButtonWanita);
        jRadioButtonWanita.setText("Wanita");
        jRadioButtonWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonWanitaActionPerformed(evt);
            }
        });

        jTextAreaAlamat.setColumns(20);
        jTextAreaAlamat.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAlamat);

        buttonGroup2.add(jRadioButtonTetap);
        jRadioButtonTetap.setText("Tetap");

        buttonGroup2.add(jRadioButtonHonorer);
        jRadioButtonHonorer.setText("Honorer");

        jButtonCreate.setText("Create");

        jButtonCancel.setText("Cancel");

        jButtonBack.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(113, 113, 113)
                                .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxKK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonPria)
                                        .addGap(22, 22, 22)
                                        .addComponent(jRadioButtonWanita))
                                    .addComponent(jTextFieldTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonTetap)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonHonorer))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(130, 130, 130)
                                .addComponent(jTextFieldNik, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButtonCreate)
                        .addGap(47, 47, 47)
                        .addComponent(jButtonCancel)
                        .addGap(45, 45, 45)
                        .addComponent(jButtonBack)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxKK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButtonTetap)
                    .addComponent(jRadioButtonHonorer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButtonPria)
                            .addComponent(jRadioButtonWanita))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreate)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonBack))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNikActionPerformed

    private void jRadioButtonWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWanitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonWanitaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminKelolaDosenCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminKelolaDosenCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminKelolaDosenCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminKelolaDosenCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminKelolaDosenCreate().setVisible(true);
            }
        });
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public ButtonGroup getButtonGroup2() {
        return buttonGroup2;
    }

    public void setButtonGroup2(ButtonGroup buttonGroup2) {
        this.buttonGroup2 = buttonGroup2;
    }

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

    public JComboBox getjComboBoxKK() {
        return jComboBoxKK;
    }

    public void setjComboBoxKK(JComboBox jComboBoxKK) {
        this.jComboBoxKK = jComboBoxKK;
    }

    public JRadioButton getjRadioButtonHonorer() {
        return jRadioButtonHonorer;
    }

    public void setjRadioButtonHonorer(JRadioButton jRadioButtonHonorer) {
        this.jRadioButtonHonorer = jRadioButtonHonorer;
    }

    public JRadioButton getjRadioButtonPria() {
        return jRadioButtonPria;
    }

    public void setjRadioButtonPria(JRadioButton jRadioButtonPria) {
        this.jRadioButtonPria = jRadioButtonPria;
    }

    public JRadioButton getjRadioButtonTetap() {
        return jRadioButtonTetap;
    }

    public void setjRadioButtonTetap(JRadioButton jRadioButtonTetap) {
        this.jRadioButtonTetap = jRadioButtonTetap;
    }

    public JRadioButton getjRadioButtonWanita() {
        return jRadioButtonWanita;
    }

    public void setjRadioButtonWanita(JRadioButton jRadioButtonWanita) {
        this.jRadioButtonWanita = jRadioButtonWanita;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextAreaAlamat() {
        return jTextAreaAlamat;
    }

    public void setjTextAreaAlamat(JTextArea jTextAreaAlamat) {
        this.jTextAreaAlamat = jTextAreaAlamat;
    }

    public JTextField getjTextFieldNama() {
        return jTextFieldNama;
    }

    public void setjTextFieldNama(JTextField jTextFieldNama) {
        this.jTextFieldNama = jTextFieldNama;
    }

    public JTextField getjTextFieldNik() {
        return jTextFieldNik;
    }

    public void setjTextFieldNik(JTextField jTextFieldNik) {
        this.jTextFieldNik = jTextFieldNik;
    }

    public JTextField getjTextFieldTelepon() {
        return jTextFieldTelepon;
    }

    public void setjTextFieldTelepon(JTextField jTextFieldTelepon) {
        this.jTextFieldTelepon = jTextFieldTelepon;
    }
    
    public void addActionListener(ActionListener al){
        jButtonCreate.addActionListener(al);
        jButtonCancel.addActionListener(al);
        jButtonBack.addActionListener(al);
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JComboBox jComboBoxKK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButtonHonorer;
    private javax.swing.JRadioButton jRadioButtonPria;
    private javax.swing.JRadioButton jRadioButtonTetap;
    private javax.swing.JRadioButton jRadioButtonWanita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAlamat;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldNik;
    private javax.swing.JTextField jTextFieldTelepon;
    // End of variables declaration//GEN-END:variables
}
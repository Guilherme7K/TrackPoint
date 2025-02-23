/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplication.rastrear;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class AlterarRastrear extends javax.swing.JFrame {

    /**
     * Creates new form Alterar
     */
    public AlterarRastrear() {
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

        txtIdRastreio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        txtLocal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar pedido");
        getContentPane().setLayout(null);

        txtIdRastreio.setBackground(new java.awt.Color(0, 36, 20));
        txtIdRastreio.setForeground(new java.awt.Color(255, 255, 255));
        txtIdRastreio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdRastreioActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdRastreio);
        txtIdRastreio.setBounds(220, 70, 130, 30);

        jLabel2.setForeground(new java.awt.Color(0, 36, 20));
        jLabel2.setText("ID Rastreio");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 70, 90, 16);

        btnAlterar.setBackground(new java.awt.Color(0, 36, 20));
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(240, 230, 110, 40);

        txtLocal.setBackground(new java.awt.Color(0, 36, 20));
        txtLocal.setForeground(new java.awt.Color(255, 255, 255));
        txtLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalActionPerformed(evt);
            }
        });
        getContentPane().add(txtLocal);
        txtLocal.setBounds(220, 120, 130, 30);

        jLabel3.setForeground(new java.awt.Color(0, 36, 20));
        jLabel3.setText("local");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 130, 60, 16);

        txtStatus.setBackground(new java.awt.Color(0, 36, 20));
        txtStatus.setForeground(new java.awt.Color(255, 255, 255));
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        getContentPane().add(txtStatus);
        txtStatus.setBounds(220, 170, 130, 30);

        jLabel4.setForeground(new java.awt.Color(0, 36, 20));
        jLabel4.setText("Status");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 180, 60, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundoVerde.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 490, 370);

        setSize(new java.awt.Dimension(505, 371));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdRastreioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdRastreioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRastreioActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String id, local, status;
        id = txtIdRastreio.getText();
        local = txtLocal.getText();
        status = txtStatus.getText();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/trackpoint", "root", "");
            PreparedStatement st = conectar.prepareStatement("UPDATE rastrear SET local = ?, status = ? WHERE id_rastreio = ?");
            st.setString(1, local);
            st.setString(2, status);
            st.setString(3, id);
            st.executeUpdate(); // executa o comando insert
            JOptionPane.showMessageDialog(null, "Rastreio alterado com sucesso"); //mostra msg
            txtIdRastreio.setText("");
            txtStatus.setText("");// limpa os campos
            txtIdRastreio.requestFocus(); // deixa o cursor no 1 campo (usuario)
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte erro: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarRastrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarRastrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarRastrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarRastrear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarRastrear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtIdRastreio;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}

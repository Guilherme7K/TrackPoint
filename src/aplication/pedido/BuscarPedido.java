/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplication.pedido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
/**
 *
 * @author lucas
 */
public class BuscarPedido extends javax.swing.JFrame {

    /**
     * Creates new form Buscar
     */
    public BuscarPedido() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListar = new javax.swing.JTable();
        txtIdPedido = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar produtos");
        setBackground(new java.awt.Color(0, 36, 20));
        getContentPane().setLayout(null);

        tblListar.setBackground(new java.awt.Color(174, 209, 0));
        tblListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_pedido", "quantidade", "CPF cliente", "logradouro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListar);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 70, 880, 590);

        txtIdPedido.setBackground(new java.awt.Color(0, 36, 20));
        txtIdPedido.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtIdPedido);
        txtIdPedido.setBounds(310, 20, 90, 30);

        btnEnter.setBackground(new java.awt.Color(0, 36, 20));
        btnEnter.setText("Buscar");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnter);
        btnEnter.setBounds(410, 20, 100, 30);

        jLabel1.setBackground(new java.awt.Color(0, 36, 20));
        jLabel1.setForeground(new java.awt.Color(0, 36, 20));
        jLabel1.setText("Id Do Pedido");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 30, 80, 16);

        setSize(new java.awt.Dimension(892, 397));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        String id;
        id = txtIdPedido.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/trackpoint", "root", "");
            PreparedStatement st = conectar.prepareStatement("SELECT * FROM pedido WHERE id_pedido=?");
            st.setString(1, id);
            ResultSet produtos = st.executeQuery();
            DefaultTableModel tblModelo = (DefaultTableModel) tblListar.getModel();
            while (produtos.next()){
                String linha[] = {
                    produtos.getString("id_pedido"),
                    produtos.getString("quantidade"),
                    produtos.getString("cpf_cliente"),
                    produtos.getString("logradouro")
                };
                tblModelo.addRow(linha);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEnterActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListar;
    private javax.swing.JTextField txtIdPedido;
    // End of variables declaration//GEN-END:variables
}

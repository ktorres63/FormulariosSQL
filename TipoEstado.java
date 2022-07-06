/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formsjava_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author boris
 */
public class TipoEstado extends javax.swing.JFrame {

    private final String dbName    = Conexion_MYSQL.getDbName();
    private final String userName  = Conexion_MYSQL.getUserName();
    private final String password  = Conexion_MYSQL.getPassword();
    private final String url       = Conexion_MYSQL.getUrl();
    private final String driver    = Conexion_MYSQL.getDriver();
    
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public TipoEstado() {
        initComponents();
        upDateDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //=================================function============================================
    
    public void upDateDB(){
        try{
            Class.forName(driver).newInstance();
            sqlConn = DriverManager.getConnection(url + dbName, userName,password);
            pst = sqlConn.prepareStatement("SELECT * FROM GZZ_TIPO_ESTADO");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);
            while(rs.next()){
                Vector columnData = new Vector();
                for(i = 1; i <= q;i++){
                    columnData.add(rs.getString("TipEstCod"));
                    columnData.add(rs.getString("TipEstDes"));
                    columnData.add(rs.getString("TipEstReg"));
                }
                RecordTable.addRow(columnData);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    //=================================function============================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        estCod = new javax.swing.JTextField();
        estDes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        estEst = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnReactivar = new javax.swing.JButton();
        btnInactivar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Codigo:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel4.setText("Descripción:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        estCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estCodActionPerformed(evt);
            }
        });
        jPanel2.add(estCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 160, -1));
        jPanel2.add(estDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 270, -1));

        jLabel5.setText("Estado de Registro");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        estEst.setText("A");
        estEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estEstActionPerformed(evt);
            }
        });
        jPanel2.add(estEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 20, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 870, 140));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(200, 255, 255));

        jTable1.setBackground(new java.awt.Color(255, 250, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Estado de Registro"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 690, 110));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 870, 140));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel4.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 100, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 110, -1));

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel4.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        btnReactivar.setText("Reactivar");
        btnReactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReactivarActionPerformed(evt);
            }
        });
        jPanel4.add(btnReactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 110, -1));

        btnInactivar.setText("Inactivar");
        btnInactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivarActionPerformed(evt);
            }
        });
        jPanel4.add(btnInactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 110, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 870, 150));

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("TIPO DE ESTADO");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 40));

        jLabel2.setText("Registro de tipo de estado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 200, -1));

        jLabel6.setText("Tabla tipo de estado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 930, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private int[] flags = new int[5];
    private JFrame frame;
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        estCod.setText("");
        estDes.setText("");
        estEst.setText("A");
        flags[0] = 1;
        estEst.setEditable(false);
        estCod.setEditable(true);
        estDes.setEditable(true);
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Confima si quieras salir", "MySQL Connector",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
        
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estCod.setText("");
        estDes.setText("");
        estEst.setText("");
        flagsZero();
        estEst.setEditable(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void flagsZero(){
        for(int i = 0;i < flags.length; i++)
            flags[i] = 0;
    }
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(flags[0]==1)insert();
        else if(flags[1]==1)update();
        else if(flags[2]==1)delete();
        else if(flags[3]==1)inactive();
        else if(flags[4]==1)reactive();
        else
            JOptionPane.showMessageDialog(this, "Ninguna Accion por hacer");
        flagsZero();  
    }//GEN-LAST:event_btnActualizarActionPerformed
    private void insert(){
        try{
            Class.forName(driver).newInstance();
            sqlConn = DriverManager.getConnection(url + dbName, userName,password);
            
            pst = sqlConn.prepareStatement("INSERT INTO GZZ_TIPO_ESTADO (TipEstCod,TipEstDes,TipEstReg)"
                    + "VALUES (?,?,?) ");
            pst.setString(1, estCod.getText());
            pst.setString(2, estDes.getText());
            pst.setString(3, estEst.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Added");            
            upDateDB();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    private void update(){
        try{
            Class.forName(driver).newInstance();
            sqlConn = DriverManager.getConnection(url + dbName, userName,password);
            
            pst = sqlConn.prepareStatement("UPDATE GZZ_TIPO_ESTADO SET TipEstDes = ? WHERE TipEstCod = ? ");
            pst.setString(1, estDes.getText());
            pst.setString(2, estCod.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Uptaded");            
            upDateDB();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    private void delete(){
        try{
            Class.forName(driver).newInstance();
            sqlConn = DriverManager.getConnection(url + dbName, userName,password);
            
            pst = sqlConn.prepareStatement("UPDATE GZZ_TIPO_ESTADO  SET TipEstReg = ? WHERE TipEstCod = ?");
            pst.setString(1, "*");
            pst.setString(2, estCod.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Deleted");            
            upDateDB();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void inactive(){
        try{
            Class.forName(driver).newInstance();
            sqlConn = DriverManager.getConnection(url + dbName, userName,password);
            
            pst = sqlConn.prepareStatement("UPDATE GZZ_TIPO_ESTADO SET TipEstReg = ? WHERE TipEstCod = ?");
            pst.setString(1, "I");
            pst.setString(2, estCod.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Inactive");            
            upDateDB();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
      private void reactive(){
        try{
            Class.forName(driver).newInstance();
            sqlConn = DriverManager.getConnection(url + dbName, userName,password);
            pst = sqlConn.prepareStatement("UPDATE GZZ_TIPO_ESTADO SET TipEstReg = ? WHERE TipEstCod = ?");
            pst.setString(1, "A");
            pst.setString(2, estCod.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record Reactive");            
            upDateDB();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        estCod.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        estDes.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        estEst.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        estCod.setEditable(false);
        estDes.setEditable(false);
        estEst.setEditable(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void estEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estEstActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        estDes.setEditable(true);
        flags[1] = 1;
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        flags[2] = 1;
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivarActionPerformed
        flags[3] = 1;
    }//GEN-LAST:event_btnInactivarActionPerformed

    private void btnReactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReactivarActionPerformed
        flags[4] = 1;
    }//GEN-LAST:event_btnReactivarActionPerformed

    private void estCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estCodActionPerformed

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
            java.util.logging.Logger.getLogger(TipoEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoEstado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TipoEstado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInactivar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnReactivar;
    private javax.swing.JTextField estCod;
    private javax.swing.JTextField estDes;
    private javax.swing.JTextField estEst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Conn;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class FormListado extends javax.swing.JFrame {

    LinkedList listaPacientes;
    LinkedList listaControles;
    Conn conn;
    private boolean esNuevaHistoria;
    String cedPaciente;
    private boolean esNuevoMiniControl;
    
    /**
     * Creates new form FormListado
     */
    public FormListado() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 569) / 2, (d.height - 456) / 2);
        initComponents();
        setTitle("Lista de pacientes");
        listaPacientes = new LinkedList();
        listaControles = new LinkedList();
        conn = new Conn();
        esNuevaHistoria = false;
        esNuevoMiniControl = false;
        cedPaciente = "";
        jLabel1.setText("Se han encontrado los siguientes pacientes:");
    }
    
    public void cargarPacientes(LinkedList l)
    {
        for(; !l.isEmpty(); list1.add((new StringBuilder()).append((String)listaPacientes.getLast()).append(" - ").append((String)l.removeFirst()).toString()))
            listaPacientes.addLast(l.remove());

    }

    public void cargarTodo()
    {
        LinkedList l = conn.reporteSQL("SELECT cc, nombre FROM pacientes;");
        cargarPacientes(l);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
        if(isEsNuevaHistoria())
        {
            Vista.FormHistoria fh = new Vista.FormHistoria();
            fh.setPaciente((String)listaPacientes.get(list1.getSelectedIndex()));
            fh.setVisible(true);
            dispose();
        } else
        if(isEsNuevoMiniControl())
        {
            Vista.FormMiniControl fmc = new Vista.FormMiniControl();
            fmc.setCedPaciente((String)listaPacientes.get(list1.getSelectedIndex()));
            fmc.setVisible(true);
            dispose();
        } else
        {
            try
            {
                FormPaciente fp = new FormPaciente();
                fp.cargarPaciente((String)listaPacientes.get(list1.getSelectedIndex()));
                fp.cargarHistorias();
                fp.cargarMiniControles();
                fp.setVisible(true);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e.toString());
            }
        }
    }//GEN-LAST:event_list1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormListado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the esNuevaHistoria
     */
    public boolean isEsNuevaHistoria() {
        return esNuevaHistoria;
    }

    /**
     * @param esNuevaHistoria the esNuevaHistoria to set
     */
    public void setEsNuevaHistoria(boolean esNuevaHistoria) {
        this.esNuevaHistoria = esNuevaHistoria;
    }

    /**
     * @return the esNuevoMiniControl
     */
    public boolean isEsNuevoMiniControl() {
        return esNuevoMiniControl;
    }

    /**
     * @param esNuevoMiniControl the esNuevoMiniControl to set
     */
    public void setEsNuevoMiniControl(boolean esNuevoMiniControl) {
        this.esNuevoMiniControl = esNuevoMiniControl;
    }
}

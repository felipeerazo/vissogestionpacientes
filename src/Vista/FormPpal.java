/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Conn;
import Controlador.CtrlPaciente;
import Modelo.Paciente;
import java.awt.Toolkit;
import java.util.LinkedList;

/**
 *
 * @author Felipe Erazo
 */
public class FormPpal extends javax.swing.JFrame {

    FormBackUp formBackUp;
    FormBuscador formBuscador;
    FormBuscador fb1;
    FormBuscador fb2;
    FormListado formListado;
    Conn conn;
    LinkedList<Paciente> pacientesCumpleanos;
    LinkedList<Paciente> pacientesControl;

    /**
     * Creates new form FormPpal
     */
    public FormPpal() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Imagenes/icon.png")));
        setLocationRelativeTo(null);
        setTitle("Men\372 principal");
        setResizable(false);
        formBackUp = null;
        formBuscador = null;
        fb1 = null;
        fb2 = null;
        formListado = null;
        conn = new Conn();
        pacientesCumpleanos = new LinkedList();
        pacientesControl = new LinkedList();
        cargarCumpleanos();
        cargarControlesHoy();
    }

    public void cargarCumpleanos() {
        pacientesCumpleanos = new CtrlPaciente().listarCumpleanos();
        lstVistaCumpleanos.removeAll();
        for (int i = 0; i < pacientesCumpleanos.size(); i++) {
            lstVistaCumpleanos.add(pacientesCumpleanos.get(i).getNombre() + ", " + pacientesCumpleanos.get(i).getEdad() + " años");
        }
    }

    public void cargarControlesHoy() {
        pacientesControl = new CtrlPaciente().listarParaControlHoy();
        lstVistaControlesHoy.removeAll();
        for (int i = 0; i < pacientesControl.size(); i++) {
            lstVistaControlesHoy.add(pacientesControl.get(i).getNombre());

        }
        //listaPacientes2.addLast(l.removeFirst());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        btnHistoriaClinica = new javax.swing.JButton();
        btnMiniControl = new javax.swing.JButton();
        btnPaciente = new javax.swing.JButton();
        btnBackUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lstVistaCumpleanos = new java.awt.List();
        jLabel2 = new javax.swing.JLabel();
        lstVistaControlesHoy = new java.awt.List();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/lupa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnHistoriaClinica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/hist.png"))); // NOI18N
        btnHistoriaClinica.setText("Nueva Historia Clínica");
        btnHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoriaClinicaActionPerformed(evt);
            }
        });

        btnMiniControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/mini.png"))); // NOI18N
        btnMiniControl.setText("Nuevo Mini Control");
        btnMiniControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniControlActionPerformed(evt);
            }
        });

        btnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/user-paciente.png"))); // NOI18N
        btnPaciente.setText("Nuevo Paciente");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        btnBackUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/cajafuerte.png"))); // NOI18N
        btnBackUp.setText("Backup");
        btnBackUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackUpActionPerformed(evt);
            }
        });

        jLabel1.setText("Cumpleaños:");

        lstVistaCumpleanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstVistaCumpleanosActionPerformed(evt);
            }
        });

        jLabel2.setText("Controles para hoy:");

        lstVistaControlesHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstVistaControlesHoyActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/visso3.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(lstVistaControlesHoy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lstVistaCumpleanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHistoriaClinica, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPaciente, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMiniControl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBackUp, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBackUp, btnBuscar, btnHistoriaClinica, btnMiniControl, btnPaciente});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHistoriaClinica)
                            .addComponent(btnMiniControl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPaciente)
                            .addComponent(btnBackUp)))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lstVistaCumpleanos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lstVistaControlesHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBackUp, btnHistoriaClinica, btnMiniControl, btnPaciente});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lstVistaControlesHoy, lstVistaCumpleanos});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (formBuscador != null) {
            formBuscador.dispose();
        }
        formBuscador = new FormBuscador();
        formBuscador.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBackUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackUpActionPerformed
        // TODO add your handling code here:
        if (formBackUp != null) {
            formBackUp.dispose();
        }
        formBackUp = new FormBackUp();
        formBackUp.setVisible(true);
    }//GEN-LAST:event_btnBackUpActionPerformed

    private void btnMiniControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniControlActionPerformed
        // TODO add your handling code here:
        if (fb2 != null) {
            fb2.dispose();
        }
        fb2 = new FormBuscador();
        fb2.setEtiqueta("Busque el paciente para el nuevo mini control:");
        fb2.esNuevoMiniControl = true;
        fb2.setVisible(true);
    }//GEN-LAST:event_btnMiniControlActionPerformed

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        // TODO add your handling code here:
        FormPaciente formPaciente = new FormPaciente();
        formPaciente.activarNuevoPaciente();
        formPaciente.setSize(680, 430);
        formPaciente.setVisible(true);
    }//GEN-LAST:event_btnPacienteActionPerformed

    private void btnHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoriaClinicaActionPerformed
        // TODO add your handling code here:
        if (fb1 != null) {
            fb1.dispose();
        }
        fb1 = new FormBuscador();
        fb1.setEtiqueta("Busque el paciente para la nueva historia cl\355nica:");
        fb1.esNuevaHistoria = true;
        fb1.setVisible(true);
    }//GEN-LAST:event_btnHistoriaClinicaActionPerformed

    private void lstVistaCumpleanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstVistaCumpleanosActionPerformed
        // TODO add your handling code here:
        FormPaciente formPaciente = new FormPaciente();
        formPaciente.cargarPaciente(pacientesCumpleanos.get(lstVistaCumpleanos.getSelectedIndex()));
        formPaciente.cargarHistorias();
        formPaciente.cargarMiniControles();
        formPaciente.setVisible(true);
    }//GEN-LAST:event_lstVistaCumpleanosActionPerformed

    private void lstVistaControlesHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstVistaControlesHoyActionPerformed
        // TODO add your handling code here:
        FormPaciente formPaciente = new FormPaciente();
        formPaciente.cargarPaciente(pacientesControl.get(lstVistaControlesHoy.getSelectedIndex()));
        formPaciente.cargarHistorias();
        formPaciente.cargarMiniControles();
        formPaciente.setVisible(true);
    }//GEN-LAST:event_lstVistaControlesHoyActionPerformed

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
            java.util.logging.Logger.getLogger(FormPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPpal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPpal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackUp;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnHistoriaClinica;
    private javax.swing.JButton btnMiniControl;
    private javax.swing.JButton btnPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.List lstVistaControlesHoy;
    private java.awt.List lstVistaCumpleanos;
    // End of variables declaration//GEN-END:variables

    public void mostrarTodo() {
        if (formListado != null) {
            formListado.dispose();
        }
        formListado = new FormListado();
        formListado.cargarTodo();
        formListado.setVisible(true);
    }

}

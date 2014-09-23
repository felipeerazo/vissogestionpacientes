// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:50:31 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormPaciente.java

package recuperados;

import Controlador.Conn;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

// Referenced classes of package Vista:
//            FormHistoria, FormMiniControl

public class FormPaciente extends JFrame
{

    public FormPaciente()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 722) / 2, (d.height - 564) / 2);
        initComponents();
        setTitle("Nuevo paciente...");
        setDefaultCloseOperation(2);
        conn = new Conn();
        listaCodHistorias = new LinkedList();
        listaCodMiniControles = new LinkedList();
        campoFuc.setVisible(false);
        jLabel9.setVisible(false);
        etiquetaEdad.setVisible(false);
        edicion = false;
    }

    public void cargarPaciente(String cc)
    {
        setTitle("Paciente");
        campoFuc.setVisible(true);
        jLabel9.setVisible(true);
        LinkedList l = conn.reporteSQL((new StringBuilder()).append("SELECT * FROM pacientes WHERE cc=").append(cc).toString());
        campoCc.setText((String)l.removeFirst());
        cedPaciente = campoCc.getText();
        campoNombre.setText((String)l.removeFirst());
        etiquetaEdad.setText((new StringBuilder()).append((String)conn.reporteSQL((new StringBuilder()).append("SELECT (current_date -fechanac)/365 FROM pacientes WHERE cc=").append(cc).toString()).getFirst()).append(" a\361os").toString());
        etiquetaEdad.setVisible(true);
        campoFechanac.setText((String)l.removeFirst());
        String aux = (String)l.remove();
        if(aux != null && aux.equals("MASCULINO"))
            jRadioButton1.setSelected(true);
        else
            jRadioButton2.setSelected(true);
        campoTel.setText((String)l.removeFirst());
        campoDirecc.setText((String)l.removeFirst());
        campoFuc.setText(conn.reporteSQL((new StringBuilder()).append("select fecha from historias where cc_paciente=").append(cc).append(" order by fecha desc limit 1;").toString()).toString());
        campoCelular.setText((String)l.removeFirst());
        campoEmail.setText((String)l.removeFirst());
        campoOcup.setText((String)l.removeFirst());
        jTextArea1.setText((String)l.remove());
        jTextArea2.setText((String)l.remove());
        campoCc.setEditable(false);
        campoNombre.setEditable(false);
        campoFechanac.setEditable(false);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        campoTel.setEditable(false);
        campoDirecc.setEditable(false);
        campoFuc.setEditable(false);
        campoCelular.setEditable(false);
        campoEmail.setEditable(false);
        jTextArea1.setEditable(false);
        jTextArea2.setEditable(false);
        campoOcup.setEditable(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton6.setVisible(false);
    }

    public void cargarHistorias()
    {
        list1.removeAll();
        listaCodHistorias = new LinkedList();
        for(LinkedList lh = conn.reporteSQL((new StringBuilder()).append("SELECT historia_id, fecha, motivo FROM historias WHERE cc_paciente=").append(cedPaciente).toString()); !lh.isEmpty(); list1.add((new StringBuilder()).append((String)lh.remove()).append(" - MOTIVO: ").append((String)lh.remove()).toString()))
            listaCodHistorias.add(lh.remove());

    }

    public void cargarMiniControles()
    {
        list2.removeAll();
        listaCodMiniControles = new LinkedList();
        for(LinkedList lmc = conn.reporteSQL((new StringBuilder()).append("SELECT minicontrol_id, fecha, motivo FROM minicontroles WHERE cc_paciente=").append(campoCc.getText()).toString()); !lmc.isEmpty(); list2.add((new StringBuilder()).append((String)lmc.remove()).append(" - MOTIVO: ").append((String)lmc.remove()).toString()))
            listaCodMiniControles.add(lmc.remove());

    }

    private void initComponents()
    {
        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jLabel4 = new JLabel();
        jLabel1 = new JLabel();
        campoCc = new JTextField();
        jLabel3 = new JLabel();
        campoNombre = new JTextField();
        campoFechanac = new JTextField();
        jLabel5 = new JLabel();
        campoOcup = new JTextField();
        jLabel6 = new JLabel();
        campoTel = new JTextField();
        jLabel7 = new JLabel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jLabel8 = new JLabel();
        campoDirecc = new JTextField();
        jLabel9 = new JLabel();
        campoFuc = new JTextField();
        jLabel10 = new JLabel();
        campoCelular = new JTextField();
        jLabel11 = new JLabel();
        campoEmail = new JTextField();
        jLabel12 = new JLabel();
        etiquetaEdad = new JLabel();
        jPanel2 = new JPanel();
        list1 = new java.awt.List();
        jLabel13 = new JLabel();
        jButton3 = new JButton();
        jLabel14 = new JLabel();
        jButton4 = new JButton();
        list2 = new java.awt.List();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton5 = new JButton();
        jPanel4 = new JPanel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jScrollPane3 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jScrollPane1 = new JScrollPane();
        jTextArea2 = new JTextArea();
        jButton6 = new JButton();
        setDefaultCloseOperation(3);
        setResizable(false);
        jPanel1.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel4.setText("F. nacimiento:");
        jLabel1.setText("Nombre:");
        jLabel3.setText("Documento de identidad:");
        campoFechanac.setText("1990-12-31");
        jLabel5.setText("Ocupaci\363n:");
        jLabel6.setText("Sexo:");
        jLabel7.setText("Tel\351fono:");
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("M");
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("F");
        jLabel8.setText("Direc. residencia:");
        jLabel9.setText("FUC:");
        jLabel10.setText("Celular:");
        jLabel11.setText("E-mail:");
        jLabel12.setText("Datos del paciente (debe llenar todos los campos):");
        etiquetaEdad.setText("jLabel2");
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel12)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel10).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoCelular, -2, 117, -2).addGap(18, 18, 18).addComponent(jLabel11).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoEmail).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(campoFuc, -2, 79, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoDirecc, -2, 376, -2).addGap(18, 18, 18).addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoTel, -2, 93, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(campoNombre, -2, 336, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel6).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jRadioButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jRadioButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoFechanac, -2, 76, -2).addGap(40, 40, 40).addComponent(etiquetaEdad))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoCc, -2, 103, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoOcup))))))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel12).addGap(17, 17, 17).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jLabel3).addComponent(campoCc, -2, -1, -2).addComponent(campoNombre, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(jRadioButton1).addComponent(jRadioButton2).addComponent(jLabel4).addComponent(campoFechanac, -2, -1, -2).addComponent(jLabel5).addComponent(campoOcup, -2, -1, -2).addComponent(etiquetaEdad)).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel8).addComponent(campoDirecc, -2, -1, -2).addComponent(campoTel, -2, -1, -2).addComponent(jLabel7)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel10).addComponent(campoCelular, -2, -1, -2).addComponent(jLabel11).addComponent(campoEmail, -2, -1, -2).addComponent(jLabel9).addComponent(campoFuc, -2, -1, -2)).addContainerGap(-1, 32767)));
        jPanel2.setBorder(BorderFactory.createEtchedBorder(0));
        list1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                list1ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        jLabel13.setText("Historias:");
        jButton3.setText("Nueva historia");
        jButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        jLabel14.setText("Mini controles:");
        jButton4.setText("Nuevo minicontrol");
        jButton4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        list2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                list2ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel13).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jButton3)).addComponent(list1, -2, 296, -2)).addGap(46, 49, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(list2, javax.swing.GroupLayout.Alignment.TRAILING, -2, 298, -2).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(jLabel14).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jButton4))).addContainerGap()));
        jPanel2Layout.linkSize(0, new Component[] {
            list1, list2
        });
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel14).addComponent(jButton4).addComponent(jButton3).addComponent(jLabel13)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(list2, -2, 109, -2).addComponent(list1, -2, 117, -2)).addContainerGap(-1, 32767)));
        jPanel2Layout.linkSize(1, new Component[] {
            list1, list2
        });
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        jButton2.setText("Solo guardar");
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        jButton5.setText("Editar");
        jButton5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        jPanel4.setBorder(BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new Dimension(706, 104));
        jLabel15.setText("Observaciones (opcional):");
        jLabel16.setText("M\341s detalles (opcional):");
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Tahoma", 0, 11));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.setToolTipText("");
        jTextArea1.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt)
            {
                jTextArea1KeyPressed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        jScrollPane3.setViewportView(jTextArea1);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new Font("Tahoma", 0, 11));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(3);
        jTextArea2.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt)
            {
                jTextArea2KeyPressed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        jScrollPane1.setViewportView(jTextArea2);
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel15).addComponent(jScrollPane3, -2, 299, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel16).addComponent(jScrollPane1, -2, 296, -2)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel15)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, 32767).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane1, -1, 50, 32767).addComponent(jScrollPane3)).addGap(18, 18, 18)));
        jButton6.setText("Guardar y crear historia");
        jButton6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton6ActionPerformed(evt);
            }

            final FormPaciente this$0;

            
            {
                this$0 = FormPaciente.this;
                super();
            }
        }
);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(jButton5, -2, 80, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jButton6).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1)).addComponent(jPanel1, -1, -1, 32767).addComponent(jPanel4, -1, 669, 32767).addComponent(jPanel2, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jPanel2, -2, 174, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1).addComponent(jButton2).addComponent(jButton5).addComponent(jButton6)).addContainerGap(-1, 32767)));
        pack();
    }

    private void list1ActionPerformed(ActionEvent evt)
    {
        FormHistoria fh = new FormHistoria();
        fh.setPaciente(cedPaciente);
        fh.cargarHistoria(conn.reporteSQL((new StringBuilder()).append("select * from historias where historia_id=").append((String)listaCodHistorias.get(list1.getSelectedIndex())).toString()));
        fh.setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt)
    {
        guardar(0);
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        dispose();
    }

    private void jButton3ActionPerformed(ActionEvent evt)
    {
        FormHistoria fh = new FormHistoria();
        fh.setTitle("Nueva historia...");
        fh.setPaciente(cedPaciente);
        fh.setFormPaciente(this);
        fh.setVisible(true);
    }

    private void jButton4ActionPerformed(ActionEvent evt)
    {
        FormMiniControl fmc = new FormMiniControl();
        fmc.setTitle("Nuevo minicontrol...");
        fmc.setFormPaciente(this);
        fmc.setVisible(true);
    }

    private void list2ActionPerformed(ActionEvent evt)
    {
        FormMiniControl fmc = new FormMiniControl();
        fmc.cargarMiniControl(conn.reporteSQL((new StringBuilder()).append("select fecha, motivo, observaciones from minicontroles where minicontrol_id=").append((String)listaCodMiniControles.get(list2.getSelectedIndex())).toString()));
        fmc.setVisible(true);
    }

    private void jButton5ActionPerformed(ActionEvent evt)
    {
        FormPaciente formPaciente = new FormPaciente();
        formPaciente.activarEdicion(cedPaciente);
        formPaciente.setVisible(true);
        dispose();
    }

    private void jTextArea1KeyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 9)
        {
            jTextArea2.requestFocus();
            evt.consume();
        }
    }

    private void jTextArea2KeyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 9)
            evt.consume();
    }

    private void jButton6ActionPerformed(ActionEvent evt)
    {
        guardar(1);
    }

    public static void main(String args[])
    {
        try
        {
            javax.swing.UIManager.LookAndFeelInfo arr$[] = UIManager.getInstalledLookAndFeels();
            int len$ = arr$.length;
            int i$ = 0;
            do
            {
                if(i$ >= len$)
                    break;
                javax.swing.UIManager.LookAndFeelInfo info = arr$[i$];
                if("Nimbus".equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                i$++;
            } while(true);
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(Vista/FormPaciente.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormPaciente.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormPaciente.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormPaciente.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormPaciente()).setVisible(true);
            }

        }
);
    }

    void limpiarForm()
    {
        jPanel2.setVisible(false);
        jButton5.setVisible(false);
    }

    private void activarEdicion(String cedPaciente)
    {
        cargarPaciente(cedPaciente);
        campoFuc.setVisible(false);
        ajustarParaEdicion();
        edicion = true;
    }

    public void ajustarParaEdicion()
    {
        setSize(723, 386);
        jLabel9.setVisible(false);
        etiquetaEdad.setVisible(false);
        campoCc.setEditable(true);
        campoNombre.setEditable(true);
        campoFechanac.setEditable(true);
        jRadioButton1.setEnabled(true);
        jRadioButton2.setEnabled(true);
        campoTel.setEditable(true);
        campoDirecc.setEditable(true);
        campoCelular.setEditable(true);
        campoEmail.setEditable(true);
        campoOcup.setEditable(true);
        jTextArea1.setEditable(true);
        jTextArea2.setEditable(true);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton6.setVisible(true);
        limpiarForm();
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton2.setText("Guardar");
    }

    private void guardar(int n)
    {
        String sexo = "FEMENINO";
        if(jRadioButton1.isSelected())
            sexo = "MASCULINO";
        if(edicion)
        {
            String res = conn.actualizar((new StringBuilder()).append("UPDATE pacientes SET nombre='").append(campoNombre.getText()).append("', cc=").append(campoCc.getText()).append(", fechanac='").append(campoFechanac.getText()).append("', sexo='").append(sexo).append("', tel='").append(campoTel.getText()).append("', direcc='").append(campoDirecc.getText()).append("', celular='").append(campoCelular.getText()).append("', email='").append(campoEmail.getText()).append("', ocup='").append(campoOcup.getText()).append("', observ='").append(jTextArea1.getText()).append("',mas='").append(jTextArea2.getText()).append("' where cc=").append(cedPaciente).append(";").toString());
            if(!res.equals("1"))
            {
                JOptionPane.showMessageDialog(null, (new StringBuilder()).append("El paciente no ha sido editado.\nError: ").append(res).toString(), "Error al editar", 0);
            } else
            {
                FormPaciente formPaciente = new FormPaciente();
                formPaciente.cargarPaciente(campoCc.getText());
                formPaciente.cargarHistorias();
                formPaciente.cargarMiniControles();
                formPaciente.setVisible(true);
                dispose();
            }
        } else
        {
            String res = conn.insertar((new StringBuilder()).append("insert into pacientes values (").append(campoCc.getText()).append(",'").append(campoNombre.getText()).append("','").append(campoFechanac.getText()).append("','").append(sexo).append("',").append(campoTel.getText()).append(",'").append(campoDirecc.getText()).append("', ").append(campoCelular.getText()).append(", '").append(campoEmail.getText()).append("', '").append(campoOcup.getText()).append("', '").append(jTextArea1.getText()).append("', '").append(jTextArea2.getText()).append("');").toString());
            if("".equals(res))
            {
                if(n == 0)
                {
                    dispose();
                } else
                {
                    FormHistoria fh = new FormHistoria();
                    fh.setTitle("Nueva historia...");
                    fh.setPaciente(campoCc.getText());
                    fh.setVisible(true);
                    dispose();
                }
            } else
            {
                JOptionPane.showMessageDialog(null, (new StringBuilder()).append("El paciente no ha sido guardado.\nError: ").append(res).toString(), "Error al guardar", 0);
            }
        }
    }

    Conn conn;
    LinkedList listaCodHistorias;
    LinkedList listaCodMiniControles;
    String cedPaciente;
    boolean edicion;
    private ButtonGroup buttonGroup1;
    private JTextField campoCc;
    private JTextField campoCelular;
    private JTextField campoDirecc;
    private JTextField campoEmail;
    private JTextField campoFechanac;
    private JTextField campoFuc;
    private JTextField campoNombre;
    private JTextField campoOcup;
    private JTextField campoTel;
    private JLabel etiquetaEdad;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private java.awt.List list1;
    private java.awt.List list2;










}

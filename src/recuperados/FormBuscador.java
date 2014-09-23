// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:46:30 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormBuscador.java

package recuperados;

import Controlador.Conn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

// Referenced classes of package Vista:
//            FormListado, FormPaciente

public class FormBuscador extends JFrame
{

    public FormBuscador()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 520) / 2, (d.height - 169) / 2);
        initComponents();
        setTitle("Buscar...");
        setDefaultCloseOperation(2);
        lista = new LinkedList();
        esNuevaHistoria = false;
        esNuevoMiniControl = false;
    }

    private void initComponents()
    {
        buttonGroup1 = new ButtonGroup();
        jPanel1 = new JPanel();
        jRadioButton2 = new JRadioButton();
        jRadioButton1 = new JRadioButton();
        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        setDefaultCloseOperation(3);
        setResizable(false);
        jPanel1.setBorder(BorderFactory.createEtchedBorder(0));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Nombre (o parte del nombre) del paciente");
        jRadioButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jRadioButton2ActionPerformed(evt);
            }

            final FormBuscador this$0;

            
            {
                this$0 = FormBuscador.this;
                super();
            }
        }
);
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Documento de identidad del paciente");
        jTextField1.setFocusCycleRoot(true);
        jTextField1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField1ActionPerformed(evt);
            }

            final FormBuscador this$0;

            
            {
                this$0 = FormBuscador.this;
                super();
            }
        }
);
        jLabel1.setText("Buscar:");
        jButton1.setText("Buscar");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }

            final FormBuscador this$0;

            
            {
                this$0 = FormBuscador.this;
                super();
            }
        }
);
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField1, -2, 201, -2).addGap(0, 0, 32767)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 4, 32767).addComponent(jRadioButton1).addGap(18, 18, 18).addComponent(jRadioButton2)))).addGroup(jPanel1Layout.createSequentialGroup().addGap(200, 200, 200).addComponent(jButton1).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jTextField1, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jRadioButton1).addComponent(jRadioButton2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addComponent(jButton1).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        FormListado fl;
        if(jTextField1.getText() == null)
            break MISSING_BLOCK_LABEL_206;
        fl = new FormListado();
        fl.esNuevaHistoria = esNuevaHistoria;
        fl.esNuevoMiniControl = esNuevoMiniControl;
        if(jRadioButton1.isSelected())
        {
            lista = (new Conn()).reporteSQL((new StringBuilder()).append("select cc, nombre from pacientes where cc=").append(jTextField1.getText()).toString());
            FormPaciente fp = new FormPaciente();
            fp.cargarPaciente((String)lista.getFirst());
            fp.cargarHistorias();
            fp.setVisible(true);
            dispose();
            return;
        }
        try
        {
            lista = (new Conn()).reporteSQL((new StringBuilder()).append("select cc, nombre from pacientes where lower(nombre) like lower('%").append(jTextField1.getText()).append("%');").toString());
        }
        catch(Exception e) { }
        if(lista.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No hay resultados para esta b\372squeda.", "Resultado de la b\372squeda", 0);
        } else
        {
            fl.cargarPacientes(lista);
            fl.setVisible(true);
            dispose();
        }
    }

    private void jRadioButton2ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField1ActionPerformed(ActionEvent evt)
    {
        if(evt.getActionCommand() != null)
            jButton1.doClick();
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
            Logger.getLogger(Vista/FormBuscador.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormBuscador.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormBuscador.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormBuscador.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormBuscador()).setVisible(true);
            }

        }
);
    }

    void setEtiqueta(String string)
    {
        jLabel1.setText(string);
    }

    LinkedList lista;
    boolean esNuevaHistoria;
    boolean esNuevoMiniControl;
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField jTextField1;



}

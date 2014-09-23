// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:50:18 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormMiniControl.java

package recuperados;

import Controlador.Conn;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

// Referenced classes of package Vista:
//            FormPaciente

public class FormMiniControl extends JFrame
{

    public FormMiniControl()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 402) / 2, (d.height - 298) / 2);
        initComponents();
        setTitle("Mini control");
        setDefaultCloseOperation(2);
        conn = new Conn();
        formPaciente = null;
        Date utilDate = new Date();
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
        jTextField2.setText(sqlDate.toString());
        jTextArea1.setLineWrap(true);
    }

    private void initComponents()
    {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jPanel1 = new JPanel();
        jTextField2 = new JTextField();
        jLabel3 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel1 = new JLabel();
        setDefaultCloseOperation(3);
        setResizable(false);
        jButton1.setText("Guardar");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }

            final FormMiniControl this$0;

            
            {
                this$0 = FormMiniControl.this;
                super();
            }
        }
);
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }

            final FormMiniControl this$0;

            
            {
                this$0 = FormMiniControl.this;
                super();
            }
        }
);
        jPanel1.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel3.setText("Fecha:");
        jLabel2.setText("Motivo de consulta:");
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jScrollPane1.setViewportView(jTextArea1);
        jLabel1.setText("Observaciones:");
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jScrollPane1, -1, 328, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField2, -2, 165, -2)).addComponent(jLabel2).addComponent(jLabel1).addComponent(jTextField1)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jTextField2, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, -2, 77, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(jButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton2)).addComponent(jPanel1, -2, -1, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1).addComponent(jButton2)).addContainerGap(-1, 32767)));
        pack();
    }

    private void jButton2ActionPerformed(ActionEvent evt)
    {
        dispose();
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        String res = conn.insertar((new StringBuilder()).append("INSERT INTO minicontroles VALUES ((select nextval('secuencia_minicontroles')), ").append(cedPaciente).append(", '").append(jTextField2.getText()).append("', '").append(jTextField1.getText()).append("','").append(jTextArea1.getText()).append("');").toString());
        if(res.equals(""))
        {
            dispose();
            if(formPaciente != null)
                formPaciente.cargarMiniControles();
        } else
        {
            JOptionPane.showMessageDialog(null, res, "Error al guardar minicontrol", 0);
        }
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
            Logger.getLogger(Vista/FormMiniControl.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormMiniControl.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormMiniControl.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormMiniControl.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormMiniControl()).setVisible(true);
            }

        }
);
    }

    void setFormPaciente(FormPaciente aThis)
    {
        formPaciente = aThis;
        cedPaciente = formPaciente.cedPaciente;
    }

    void cargarMiniControl(LinkedList l)
    {
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jTextField2.setText((String)l.remove());
        jTextField1.setText((String)l.remove());
        jTextArea1.setText((String)l.remove());
        jTextArea1.setEditable(false);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
    }

    Conn conn;
    String cedPaciente;
    FormPaciente formPaciente;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;


}

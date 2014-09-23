// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:49:17 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormListado.java

package recuperados;

import Controlador.Conn;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

// Referenced classes of package Vista:
//            FormHistoria, FormMiniControl, FormPaciente

public class FormListado extends JFrame
{

    public FormListado()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 569) / 2, (d.height - 456) / 2);
        initComponents();
        setTitle("Lista de pacientes");
        setDefaultCloseOperation(2);
        listaPacientes = new LinkedList();
        listaControles = new LinkedList();
        conn = new Conn();
        esNuevaHistoria = false;
        esNuevoMiniControl = false;
        cedPaciente = "";
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

    private void initComponents()
    {
        list1 = new java.awt.List();
        jLabel1 = new JLabel();
        setDefaultCloseOperation(3);
        list1.setCursor(new Cursor(0));
        list1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                list1ActionPerformed(evt);
            }

            final FormListado this$0;

            
            {
                this$0 = FormListado.this;
                super();
            }
        }
);
        jLabel1.setText("Se han encontrado los siguientes pacientes:");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(0, 82, 32767)).addComponent(list1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(list1, -1, 243, 32767).addContainerGap()));
        pack();
    }

    private void list1ActionPerformed(ActionEvent evt)
    {
        if(esNuevaHistoria)
        {
            FormHistoria fh = new FormHistoria();
            fh.setPaciente((String)listaPacientes.get(list1.getSelectedIndex()));
            fh.setVisible(true);
            dispose();
        } else
        if(esNuevoMiniControl)
        {
            FormMiniControl fmc = new FormMiniControl();
            fmc.cedPaciente = (String)listaPacientes.get(list1.getSelectedIndex());
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
            Logger.getLogger(Vista/FormListado.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormListado.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormListado.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormListado.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormListado()).setVisible(true);
            }

        }
);
    }

    LinkedList listaPacientes;
    LinkedList listaControles;
    Conn conn;
    boolean esNuevaHistoria;
    String cedPaciente;
    boolean esNuevoMiniControl;
    private JLabel jLabel1;
    private java.awt.List list1;

}

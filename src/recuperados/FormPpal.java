// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:50:48 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormPpal.java

package recuperados;

import Controlador.Conn;
import java.awt.Component;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

// Referenced classes of package Vista:
//            FormListado, FormBuscador, FormBackUp, FormPaciente

public class FormPpal extends JFrame
{

    public FormPpal()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 543) / 2, (d.height - 430) / 2);
        initComponents();
        setTitle("Men\372 principal");
        formBackUp = null;
        formBuscador = null;
        fb1 = null;
        fb2 = null;
        fl = null;
        conn = new Conn();
        listaPacientes = new LinkedList();
        listaPacientes2 = new LinkedList();
        cargarCumpleanos();
        cargarControlesHoy();
    }

    public void cargarCumpleanos()
    {
        for(LinkedList l = conn.reporteSQL("SELECT cc, nombre, date_part('year', current_date)-date_part('year', fechanac) FROM pacientes WHERE date_part('month', fechanac)=date_part('month', current_date) AND date_part('day', fechanac)=date_part('day', current_date);"); !l.isEmpty(); list1.add((new StringBuilder()).append((String)l.removeFirst()).append(" (").append((String)l.removeFirst()).append(" a\361os)").toString()))
            listaPacientes.add(l.removeFirst());

    }

    public void cargarControlesHoy()
    {
        for(LinkedList l = conn.reporteSQL("SELECT p.cc, p.nombre FROM pacientes p, historias h WHERE p.cc=h.cc_paciente AND h.control=current_date;"); !l.isEmpty(); list2.add((new StringBuilder()).append((String)listaPacientes2.getLast()).append(" - ").append((String)l.removeFirst()).toString()))
            listaPacientes2.addLast(l.removeFirst());

    }

    private void initComponents()
    {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jLabel1 = new JLabel();
        list1 = new java.awt.List();
        jLabel2 = new JLabel();
        list2 = new java.awt.List();
        jLabel3 = new JLabel();
        setDefaultCloseOperation(3);
        setCursor(new Cursor(0));
        setResizable(false);
        jButton1.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/listar.png")));
        jButton1.setText("Mostrar todo");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jButton2.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/lupa.png")));
        jButton2.setText("Buscar");
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jButton3.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/user-paciente.png")));
        jButton3.setText("Nuevo paciente");
        jButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jButton4.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/hist.png")));
        jButton4.setText("Nueva historia cl\355nica");
        jButton4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jButton5.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/cajafuerte.png")));
        jButton5.setText("Backup");
        jButton5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jButton6.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/mini.png")));
        jButton6.setText("Nuevo mini control");
        jButton6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton6ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/visso3.jpg")));
        jLabel1.setPreferredSize(new Dimension(93, 51));
        list1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                list1ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jLabel2.setText("Cumplea\361os:");
        list2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                list2ActionPerformed(evt);
            }

            final FormPpal this$0;

            
            {
                this$0 = FormPpal.this;
                super();
            }
        }
);
        jLabel3.setText("Controles para hoy:");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(list2, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jLabel2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jButton1, -1, 167, 32767).addComponent(jButton2, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jButton3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton5, -2, 169, -2)).addGroup(layout.createSequentialGroup().addComponent(jButton4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton6, -2, 169, -2)))).addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, -2, 93, -2).addComponent(list1, -1, -1, 32767)).addComponent(jLabel3)).addGap(0, 0, 32767))).addContainerGap()));
        layout.linkSize(0, new Component[] {
            jButton1, jButton2, jButton3, jButton4, jButton5, jButton6
        });
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(33, 33, 33).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton2, -2, 57, -2).addComponent(jButton4, -2, 57, -2).addComponent(jButton6)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1, -2, 57, -2).addComponent(jButton3, -2, 57, -2).addComponent(jButton5)).addGap(18, 18, 18).addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(list1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(list2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel1, -2, 16, -2).addContainerGap(-1, 32767)));
        layout.linkSize(1, new Component[] {
            jButton1, jButton2, jButton3, jButton4, jButton5, jButton6
        });
        layout.linkSize(1, new Component[] {
            list1, list2
        });
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        if(fl != null)
            fl.dispose();
        fl = new FormListado();
        fl.cargarTodo();
        fl.setVisible(true);
    }

    private void jButton2ActionPerformed(ActionEvent evt)
    {
        if(formBuscador != null)
            formBuscador.dispose();
        formBuscador = new FormBuscador();
        formBuscador.setVisible(true);
    }

    private void jButton5ActionPerformed(ActionEvent evt)
    {
        if(formBackUp != null)
            formBackUp.dispose();
        formBackUp = new FormBackUp();
        formBackUp.setVisible(true);
    }

    private void jButton3ActionPerformed(ActionEvent evt)
    {
        FormPaciente fp = new FormPaciente();
        fp.limpiarForm();
        fp.setSize(723, 386);
        fp.setVisible(true);
    }

    private void jButton4ActionPerformed(ActionEvent evt)
    {
        if(fb1 != null)
            fb1.dispose();
        fb1 = new FormBuscador();
        fb1.setEtiqueta("Busque el paciente para la nueva historia cl\355nica:");
        fb1.esNuevaHistoria = true;
        fb1.setVisible(true);
    }

    private void jButton6ActionPerformed(ActionEvent evt)
    {
        if(fb2 != null)
            fb2.dispose();
        fb2 = new FormBuscador();
        fb2.setEtiqueta("Busque el paciente para el nuevo mini control:");
        fb2.esNuevoMiniControl = true;
        fb2.setVisible(true);
    }

    private void list1ActionPerformed(ActionEvent evt)
    {
        FormPaciente fp = new FormPaciente();
        fp.cargarPaciente((String)listaPacientes.get(list1.getSelectedIndex()));
        fp.cargarHistorias();
        fp.cargarMiniControles();
        fp.setVisible(true);
    }

    private void list2ActionPerformed(ActionEvent evt)
    {
        FormPaciente fp = new FormPaciente();
        fp.cargarPaciente((String)listaPacientes2.get(list2.getSelectedIndex()));
        fp.cargarHistorias();
        fp.cargarMiniControles();
        fp.setVisible(true);
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
            Logger.getLogger(Vista/FormPpal.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormPpal.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormPpal.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormPpal.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormPpal()).setVisible(true);
            }

        }
);
    }

    FormBackUp formBackUp;
    FormBuscador formBuscador;
    FormBuscador fb1;
    FormBuscador fb2;
    FormListado fl;
    Conn conn;
    LinkedList listaPacientes;
    LinkedList listaPacientes2;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private java.awt.List list1;
    private java.awt.List list2;








}

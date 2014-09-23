// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:11:30 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormBackUp.java

package recuperados;

import Controlador.Conn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FormBackUp extends JFrame
{

    public FormBackUp()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 642) / 2, (d.height - 155) / 2);
        initComponents();
        setTitle("Backup");
        setDefaultCloseOperation(2);
        conn = new Conn();
    }

    private void initComponents()
    {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        setDefaultCloseOperation(3);
        setResizable(false);
        jButton1.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/backup.png")));
        jButton1.setText("Hacer copia de seguridad");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }

            final FormBackUp this$0;

            
            {
                this$0 = FormBackUp.this;
                super();
            }
        }
);
        jButton2.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/restore.png")));
        jButton2.setText("Restaurar desde una copia de seguridad");
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }

            final FormBackUp this$0;

            
            {
                this$0 = FormBackUp.this;
                super();
            }
        }
);
        jButton3.setText("Volver");
        jButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }

            final FormBackUp this$0;

            
            {
                this$0 = FormBackUp.this;
                super();
            }
        }
);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jButton1).addGap(18, 18, 18).addComponent(jButton2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(jButton3))).addContainerGap()));
        layout.linkSize(0, new Component[] {
            jButton1, jButton2
        });
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1).addComponent(jButton2)).addGap(18, 18, 18).addComponent(jButton3).addContainerGap(12, 32767)));
        layout.linkSize(1, new Component[] {
            jButton1, jButton2
        });
        pack();
    }

    private void jButton3ActionPerformed(ActionEvent evt)
    {
        dispose();
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de texto (.txt)", new String[] {
            "txt"
        });
        jfc.setFileFilter(filtro);
        jfc.showSaveDialog(this);
        try
        {
            if(jfc.getSelectedFile() != null)
            {
                File f = jfc.getSelectedFile();
                String ruta = (new StringBuilder()).append(f.getAbsolutePath()).append(".txt").toString();
                conn.guardarRegistros(ruta);
            }
        }
        catch(HeadlessException e)
        {
            JOptionPane.showMessageDialog(null, "Ocurri\363 un error con el manejador de archivo (JFileChooser).", "Error de archivo", 0);
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt)
    {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", new String[] {
            "txt"
        });
        jfc.setFileFilter(filtro);
        jfc.showOpenDialog(this);
        try
        {
            if(jfc.getSelectedFile() != null)
            {
                File f = jfc.getSelectedFile();
                String ruta = f.getAbsolutePath();
                conn.ejecutar("BEGIN; DELETE FROM minicontroles; DELETE FROM historias; DELETE FROM pacientes;");
                try
                {
                    conn.restaurar(abrirArchivo(ruta));
                    conn.ejecutar((new StringBuilder()).append("SELECT setval ('secuencia',").append((String)conn.reporteSQL("SELECT coalesce(max(historia_id)+1,1) FROM historias").remove()).append(");").toString());
                    conn.ejecutar((new StringBuilder()).append("SELECT setval ('secuencia_minicontroles',").append((String)conn.reporteSQL("SELECT coalesce(max(minicontrol_id)+1,1) FROM minicontroles;").remove()).append(");").toString());
                }
                catch(Exception e)
                {
                    conn.ejecutar("ROLLBACK;");
                    System.out.println("xxxxx");
                }
            }
        }
        catch(HeadlessException e)
        {
            conn.ejecutar("ROLLBACK;");
            JOptionPane.showMessageDialog(null, (new StringBuilder()).append("Error en la lectura del archivo.\n").append(e.toString()).toString(), "Error", 0);
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
            Logger.getLogger(Vista/FormBackUp.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormBackUp.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormBackUp.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormBackUp.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormBackUp()).setVisible(true);
            }

        }
);
    }

    public String abrirArchivo(String ruta)
    {
        FileReader fr;
        String salida;
        File archivo = null;
        fr = null;
        BufferedReader br = null;
        salida = "";
        File archivo = new File(ruta);
        fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea = br.readLine()) != null) 
            salida = (new StringBuilder()).append(salida).append(linea).append("\n").toString();
        try
        {
            if(null != fr)
                fr.close();
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_155;
        Exception e;
        e;
        e.printStackTrace();
        try
        {
            if(null != fr)
                fr.close();
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_155;
        Exception exception;
        exception;
        try
        {
            if(null != fr)
                fr.close();
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
        }
        throw exception;
        return salida;
    }

    public void guardarArchivo(String ruta, String texto)
    {
        FileWriter fichero;
        fichero = null;
        PrintWriter pw = null;
        fichero = new FileWriter(ruta);
        PrintWriter pw = new PrintWriter(fichero);
        pw.println(texto);
        try
        {
            if(null != fichero)
                fichero.close();
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_105;
        Exception e;
        e;
        e.printStackTrace();
        try
        {
            if(null != fichero)
                fichero.close();
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_105;
        Exception exception;
        exception;
        try
        {
            if(null != fichero)
                fichero.close();
        }
        catch(Exception e2)
        {
            e2.printStackTrace();
        }
        throw exception;
    }

    Conn conn;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;



}

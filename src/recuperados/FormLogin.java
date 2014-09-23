// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:50:00 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormLogin.java

package recuperados;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

// Referenced classes of package Vista:
//            FormPpal

public class FormLogin extends JFrame
{

    public FormLogin()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 500) / 2, (d.height - 288) / 2);
        initComponents();
    }

    private void initComponents()
    {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jButton1 = new JButton();
        setDefaultCloseOperation(3);
        setTitle("Ingreso");
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/visso1.jpg")));
        jLabel2.setText("Clave:");
        jPasswordField1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jPasswordField1ActionPerformed(evt);
            }

            final FormLogin this$0;

            
            {
                this$0 = FormLogin.this;
                super();
            }
        }
);
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }

            final FormLogin this$0;

            
            {
                this$0 = FormLogin.this;
                super();
            }
        }
);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(77, 77, 77).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1).addGroup(layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPasswordField1, -2, 166, -2).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(jButton1))))).addContainerGap(76, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jPasswordField1, -2, -1, -2).addComponent(jLabel2)).addGap(18, 18, 18).addComponent(jButton1).addContainerGap(-1, 32767)));
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        if(jPasswordField1.getText().equals("contraste"))
        {
            (new FormPpal()).setVisible(true);
            dispose();
        } else
        {
            JOptionPane.showMessageDialog(null, "Clave incorrecta!", "Ingreso", 0);
            jPasswordField1.setText(null);
        }
    }

    private void jPasswordField1ActionPerformed(ActionEvent evt)
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
            Logger.getLogger(Vista/FormLogin.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormLogin.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormLogin.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormLogin.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormLogin()).setVisible(true);
            }

        }
);
    }

    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPasswordField jPasswordField1;


}

// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:48:19 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   FormHistoria.java

package recuperados;

import Controlador.Conn;
import Controlador.PDF;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.*;

// Referenced classes of package Vista:
//            FormPaciente

public class FormHistoria extends JFrame
{

    public FormHistoria()
    {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 847) / 2, (d.height - 584) / 2);
        setExtendedState(4);
        initComponents();
        setTitle("Historia cl\355nica");
        setDefaultCloseOperation(2);
        historiaId = "";
        cedPaciente = "";
        conn = new Conn();
        formPaciente = null;
        campoFecha.setText(conn.reporteSQL("SELECT to_char(current_date, 'yyyy-mm-dd')").toString());
        jTextField45.setText(conn.reporteSQL("SELECT to_char(current_date+365, 'yyyy-mm-dd')").toString());
        jTextField46.setEditable(false);
        jTextField47.setEditable(false);
        jTextField48.setEditable(false);
        cargarListaCodG();
    }

    public void cargarHistoria(LinkedList l)
    {
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        historiaId = (String)l.remove();
        jTextField46.setText(historiaId);
        cedPaciente = (String)l.remove();
        campoFecha.setText((String)l.remove());
        if(((String)l.remove()).equals("e"))
            jRadioButton2.setSelected(true);
        else
            jRadioButton1.setSelected(true);
        campoAcomp.setText((String)l.remove());
        campoParentesco.setText((String)l.remove());
        campoTel.setText((String)l.remove());
        textoMotivo.setText((String)l.remove());
        textoAntec.setText((String)l.remove());
        campoSc_vl_d2.setText((String)l.remove());
        campoSc_vl_d3.setText((String)l.remove());
        jTextField2.setText((String)l.remove());
        campoSc_vl_d1.setText((String)l.remove());
        campoSc_vl_d4.setText((String)l.remove());
        jTextField3.setText((String)l.remove());
        jTextField1.setText((String)l.remove());
        jTextField4.setText((String)l.remove());
        jTextField5.setText((String)l.remove());
        jTextField6.setText((String)l.remove());
        jTextField13.setText((String)l.remove());
        jTextField7.setText((String)l.remove());
        jTextField8.setText((String)l.remove());
        jTextField9.setText((String)l.remove());
        jTextField10.setText((String)l.remove());
        jTextField11.setText((String)l.remove());
        jTextField12.setText((String)l.remove());
        jTextField14.setText((String)l.remove());
        jTextField15.setText((String)l.remove());
        jTextField16.setText((String)l.remove());
        jTextField17.setText((String)l.remove());
        jTextField18.setText((String)l.remove());
        jTextField19.setText((String)l.remove());
        jTextField20.setText((String)l.remove());
        jTextField21.setText((String)l.remove());
        jTextField22.setText((String)l.remove());
        jTextField23.setText((String)l.remove());
        jTextField24.setText((String)l.remove());
        jTextField25.setText((String)l.remove());
        jTextField26.setText((String)l.remove());
        jTextField28.setText((String)l.remove());
        jTextField27.setText((String)l.remove());
        jTextField29.setText((String)l.remove());
        jTextField30.setText((String)l.remove());
        jTextField31.setText((String)l.remove());
        jTextField32.setText((String)l.remove());
        jTextField34.setText((String)l.remove());
        jTextField33.setText((String)l.remove());
        jTextField36.setText((String)l.remove());
        jTextField35.setText((String)l.remove());
        jTextField38.setText((String)l.remove());
        jTextField49.setText((String)l.remove());
        jTextField37.setText((String)l.remove());
        jTextField39.setText((String)l.remove());
        jTextField40.setText((String)l.remove());
        jTextField41.setText((String)l.remove());
        jTextField42.setText((String)l.remove());
        jComboBox1.setSelectedItem(l.remove());
        jTextField44.setText((String)l.remove());
        jTextField45.setText((String)l.remove());
        jTextArea1.setText((String)l.remove());
        campoFecha.setEditable(false);
        jRadioButton1.setEnabled(false);
        jRadioButton2.setEnabled(false);
        campoAcomp.setEditable(false);
        campoParentesco.setEditable(false);
        campoTel.setEditable(false);
        textoMotivo.setEditable(false);
        textoAntec.setEditable(false);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        jTextField9.setEditable(false);
        jTextField10.setEditable(false);
        jTextField11.setEditable(false);
        jTextField12.setEditable(false);
        jTextField14.setEditable(false);
        jTextField15.setEditable(false);
        jTextField16.setEditable(false);
        jTextField17.setEditable(false);
        jTextField18.setEditable(false);
        jTextField19.setEditable(false);
        jTextField20.setEditable(false);
        jTextField21.setEditable(false);
        jTextField22.setEditable(false);
        jTextField23.setEditable(false);
        jTextField24.setEditable(false);
        jTextField25.setEditable(false);
        jTextField26.setEditable(false);
        jTextField27.setEditable(false);
        jTextField28.setEditable(false);
        jTextField29.setEditable(false);
        jTextField30.setEditable(false);
        jTextField31.setEditable(false);
        jTextField32.setEditable(false);
        jTextField33.setEditable(false);
        jTextField34.setEditable(false);
        jTextField35.setEditable(false);
        jTextField36.setEditable(false);
        jTextField37.setEditable(false);
        jTextField38.setEditable(false);
        jTextField39.setEditable(false);
        jTextField40.setEditable(false);
        jTextField41.setEditable(false);
        jTextField42.setEditable(false);
        jComboBox1.setEnabled(false);
        jTextField44.setEditable(false);
        jTextField45.setEditable(false);
        jTextField49.setEditable(false);
        jTextArea1.setEditable(false);
        campoSc_vl_d1.setEditable(false);
        campoSc_vl_d2.setEditable(false);
        campoSc_vl_d3.setEditable(false);
        campoSc_vl_d4.setEditable(false);
        jTextField13.setEditable(false);
    }

    private void initComponents()
    {
        buttonGroup1 = new ButtonGroup();
        jPanel14 = new JPanel();
        jScrollPane3 = new JScrollPane();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        campoTel = new JTextField();
        campoParentesco = new JTextField();
        jLabel7 = new JLabel();
        jLabel5 = new JLabel();
        jScrollPane2 = new JScrollPane();
        textoAntec = new JTextArea();
        campoAcomp = new JTextField();
        jLabel4 = new JLabel();
        jRadioButton2 = new JRadioButton();
        jLabel3 = new JLabel();
        jLabel2 = new JLabel();
        jRadioButton1 = new JRadioButton();
        jScrollPane1 = new JScrollPane();
        textoMotivo = new JTextArea();
        jLabel6 = new JLabel();
        campoFecha = new JTextField();
        jLabel1 = new JLabel();
        jPanel3 = new JPanel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jTextField2 = new JTextField();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        campoSc_vl_d1 = new JTextField();
        campoSc_vl_d2 = new JTextField();
        jTextField3 = new JTextField();
        jLabel14 = new JLabel();
        campoSc_vl_d3 = new JTextField();
        campoSc_vl_d4 = new JTextField();
        jPanel4 = new JPanel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jTextField1 = new JTextField();
        jLabel17 = new JLabel();
        jTextField4 = new JTextField();
        jPanel5 = new JPanel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jLabel20 = new JLabel();
        jLabel61 = new JLabel();
        jTextField13 = new JTextField();
        jPanel6 = new JPanel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        jTextField7 = new JTextField();
        jTextField8 = new JTextField();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jTextField9 = new JTextField();
        jTextField10 = new JTextField();
        jLabel25 = new JLabel();
        jPanel7 = new JPanel();
        jLabel26 = new JLabel();
        jLabel27 = new JLabel();
        jTextField11 = new JTextField();
        jTextField12 = new JTextField();
        jLabel28 = new JLabel();
        jPanel8 = new JPanel();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jTextField14 = new JTextField();
        jLabel31 = new JLabel();
        jTextField15 = new JTextField();
        jLabel32 = new JLabel();
        jTextField16 = new JTextField();
        jPanel9 = new JPanel();
        jLabel33 = new JLabel();
        jLabel34 = new JLabel();
        jTextField17 = new JTextField();
        jLabel35 = new JLabel();
        jTextField18 = new JTextField();
        jPanel10 = new JPanel();
        jLabel36 = new JLabel();
        jLabel37 = new JLabel();
        jTextField19 = new JTextField();
        jLabel38 = new JLabel();
        jTextField20 = new JTextField();
        jLabel39 = new JLabel();
        jTextField21 = new JTextField();
        jTextField22 = new JTextField();
        jPanel11 = new JPanel();
        jLabel40 = new JLabel();
        jLabel41 = new JLabel();
        jTextField23 = new JTextField();
        jLabel42 = new JLabel();
        jTextField24 = new JTextField();
        jLabel43 = new JLabel();
        jTextField25 = new JTextField();
        jTextField26 = new JTextField();
        jTextField27 = new JTextField();
        jTextField28 = new JTextField();
        jLabel44 = new JLabel();
        jPanel12 = new JPanel();
        jLabel45 = new JLabel();
        jLabel46 = new JLabel();
        jLabel47 = new JLabel();
        jLabel48 = new JLabel();
        jLabel49 = new JLabel();
        jLabel50 = new JLabel();
        jLabel51 = new JLabel();
        jTextField29 = new JTextField();
        jTextField30 = new JTextField();
        jTextField31 = new JTextField();
        jTextField32 = new JTextField();
        jTextField33 = new JTextField();
        jTextField34 = new JTextField();
        jTextField35 = new JTextField();
        jTextField36 = new JTextField();
        jTextField38 = new JTextField();
        jTextField49 = new JTextField();
        jLabel65 = new JLabel();
        jPanel13 = new JPanel();
        jLabel52 = new JLabel();
        jTextField37 = new JTextField();
        jLabel53 = new JLabel();
        jTextField39 = new JTextField();
        jPanel15 = new JPanel();
        jLabel54 = new JLabel();
        jTextField40 = new JTextField();
        jTextField41 = new JTextField();
        jLabel55 = new JLabel();
        jPanel16 = new JPanel();
        jLabel56 = new JLabel();
        jTextField42 = new JTextField();
        jLabel57 = new JLabel();
        jComboBox1 = new JComboBox();
        jPanel17 = new JPanel();
        jLabel58 = new JLabel();
        jTextField44 = new JTextField();
        jPanel18 = new JPanel();
        jLabel59 = new JLabel();
        jTextField45 = new JTextField();
        jPanel19 = new JPanel();
        jLabel60 = new JLabel();
        jScrollPane4 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton1 = new JButton();
        jPanel20 = new JPanel();
        jLabel62 = new JLabel();
        jTextField46 = new JTextField();
        jTextField47 = new JTextField();
        jLabel63 = new JLabel();
        jTextField48 = new JTextField();
        jLabel64 = new JLabel();
        GroupLayout jPanel14Layout = new GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        setDefaultCloseOperation(3);
        jScrollPane3.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt)
            {
                jScrollPane3KeyPressed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jPanel2.setBorder(BorderFactory.createEtchedBorder(0));
        campoParentesco.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent evt)
            {
                campoParentescoFocusGained(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jLabel7.setText("Anamnesis y antecedentes:");
        jLabel5.setText("Tel\351fono:");
        textoAntec.setColumns(20);
        textoAntec.setLineWrap(true);
        textoAntec.setRows(2);
        textoAntec.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt)
            {
                textoAntecKeyPressed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jScrollPane2.setViewportView(textoAntec);
        jLabel4.setText("Parentesco:");
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Empresa");
        jLabel3.setText("Nombre del acompa\361ante:");
        jLabel2.setText("Tipo:");
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Particular");
        textoMotivo.setColumns(20);
        textoMotivo.setLineWrap(true);
        textoMotivo.setRows(2);
        textoMotivo.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt)
            {
                textoMotivoKeyPressed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jScrollPane1.setViewportView(textoMotivo);
        jLabel6.setText("Motivo de la consulta:");
        jLabel1.setText("Fecha:");
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel7).addComponent(jLabel6)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane2).addComponent(jScrollPane1))).addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoFecha, -2, 75, -2).addGap(68, 68, 68).addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jRadioButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jRadioButton2).addGap(0, 0, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoAcomp).addGap(18, 18, 18).addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoParentesco, -2, 91, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoTel, -2, 75, -2))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(campoFecha, -2, -1, -2).addComponent(jLabel2).addComponent(jRadioButton1).addComponent(jRadioButton2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(campoAcomp, -2, -1, -2).addComponent(jLabel4).addComponent(campoParentesco, -2, -1, -2).addComponent(jLabel5).addComponent(campoTel, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel6).addComponent(jScrollPane1, -2, 57, -2)).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(jLabel7)).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane2, -2, 57, -2))).addContainerGap(14, 32767)));
        jPanel3.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel8.setText("Agudeza visual");
        jLabel9.setText("SC VL OD:");
        jLabel10.setText("OI:");
        jLabel11.setText("VP:");
        jLabel12.setText("CC VL OD:");
        jLabel13.setText("OI:");
        campoSc_vl_d1.setText("20/");
        campoSc_vl_d2.setText("20/");
        jLabel14.setText("VP:");
        campoSc_vl_d3.setText("20/");
        campoSc_vl_d4.setText("20/");
        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoSc_vl_d2, -2, 46, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel10).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoSc_vl_d3, -2, 61, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel11).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField2, -2, 51, -2)).addComponent(jLabel8).addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel12).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoSc_vl_d1, -2, 46, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel13).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(campoSc_vl_d4, -2, 61, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel14).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField3, -2, 51, -2))).addContainerGap(42, 32767)));
        jPanel3Layout.linkSize(0, new Component[] {
            campoSc_vl_d1, campoSc_vl_d2, campoSc_vl_d3, campoSc_vl_d4, jTextField2, jTextField3
        });
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel8).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9).addComponent(jLabel11).addComponent(jTextField2, -2, -1, -2).addComponent(campoSc_vl_d2, -2, -1, -2).addComponent(jLabel10).addComponent(campoSc_vl_d3, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel14).addComponent(jTextField3, -2, -1, -2)).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel12).addComponent(campoSc_vl_d1, -2, -1, -2).addComponent(jLabel13).addComponent(campoSc_vl_d4, -2, -1, -2))).addContainerGap(20, 32767)));
        jPanel4.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel15.setText("PH");
        jLabel16.setText("OD:");
        jLabel17.setText("OI:");
        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel17).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField4, -2, 38, -2)).addComponent(jLabel15).addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel16).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField1, -2, 38, -2))).addContainerGap(18, 32767)));
        jPanel4Layout.linkSize(0, new Component[] {
            jLabel16, jLabel17
        });
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel15).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel16).addComponent(jTextField1, -2, -1, -2)).addGap(9, 9, 9).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel17).addComponent(jTextField4, -2, -1, -2)).addContainerGap(34, 32767)));
        jPanel5.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel18.setText("RX en uso:");
        jLabel19.setText("OD:");
        jTextField5.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField5ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jTextField6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField6ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jLabel20.setText("OI:");
        jLabel61.setText("ADD:");
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel19).addComponent(jLabel20)).addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField5).addComponent(jTextField6))).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel18).addGroup(jPanel5Layout.createSequentialGroup().addGap(60, 60, 60).addComponent(jLabel61).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField13, -2, 126, -2))).addGap(0, 65, 32767))).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(jLabel18).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel19).addComponent(jTextField5, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField6, -2, -1, -2).addComponent(jLabel20)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel61).addComponent(jTextField13, -2, -1, -2)).addContainerGap(-1, 32767)));
        jPanel6.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel21.setText("Descripci\363n biomicrosc\363pica:");
        jLabel22.setText("OD:");
        jTextField7.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField7ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jTextField7.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent evt)
            {
                jTextField7FocusGained(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jLabel23.setText("OI:");
        jLabel24.setText("PIO:");
        jLabel25.setText("PIO:");
        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel21).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel22).addComponent(jLabel23)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jTextField7, -1, 169, 32767).addComponent(jTextField8)).addGap(38, 38, 38).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel6Layout.createSequentialGroup().addComponent(jLabel25).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField10)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(jLabel24).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField9, -2, 66, -2))))).addContainerGap(52, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(jLabel21).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel24).addComponent(jTextField9, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel25).addComponent(jTextField10, -2, -1, -2))).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel22).addComponent(jTextField7, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel23).addComponent(jTextField8, -2, -1, -2)))).addContainerGap(23, 32767)));
        jPanel7.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel26.setText("Descripci\363n fondo de ojo");
        jLabel27.setText("OD:");
        jTextField11.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField11ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jTextField12.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField12ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jLabel28.setText("OI:");
        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(jLabel26).addGap(0, 214, 32767)).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel27).addComponent(jLabel28)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField12).addComponent(jTextField11)))).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(jLabel26).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel27).addComponent(jTextField11, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel28).addComponent(jTextField12, -2, -1, -2)).addContainerGap(23, 32767)));
        jPanel8.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel29.setText("CVT");
        jLabel30.setText("VL:");
        jLabel31.setText("VP:");
        jLabel32.setText("PPC:");
        jTextField16.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField16ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(36, 36, 36).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel29).addGroup(jPanel8Layout.createSequentialGroup().addComponent(jLabel30).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField14, -2, 103, -2).addGap(18, 18, 18).addComponent(jLabel32).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField16, -2, 91, -2)).addGroup(jPanel8Layout.createSequentialGroup().addComponent(jLabel31).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField15, -2, 102, -2))).addContainerGap(91, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(jLabel29).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel30).addComponent(jTextField14, -2, -1, -2)).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel32).addComponent(jTextField16, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel31).addComponent(jTextField15, -2, -1, -2)).addContainerGap(24, 32767)));
        jPanel9.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel33.setText("Queratometr\355a");
        jLabel34.setText("OD:");
        jTextField17.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField17ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jLabel35.setText("OI:");
        jTextField18.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jTextField18ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(64, 64, 64).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel33).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel34).addComponent(jLabel35)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jTextField17).addComponent(jTextField18, -2, 193, -2)))).addContainerGap(72, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(jLabel33).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel34).addComponent(jTextField17, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField18, -2, -1, -2).addComponent(jLabel35)).addContainerGap(23, 32767)));
        jPanel10.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel36.setText("Refracci\363n");
        jLabel37.setText("OD:");
        jLabel38.setText("OI:");
        jLabel39.setText("AV");
        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel10Layout.createSequentialGroup().addComponent(jLabel38).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField20)).addGroup(jPanel10Layout.createSequentialGroup().addComponent(jLabel37).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField19, -2, 200, -2)).addComponent(jLabel36)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addComponent(jLabel39).addGap(24, 24, 24)).addComponent(jTextField21, javax.swing.GroupLayout.Alignment.TRAILING, -2, 49, -2).addComponent(jTextField22, javax.swing.GroupLayout.Alignment.TRAILING, -2, 49, -2)).addGap(26, 26, 26)));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel36).addComponent(jLabel39)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField19, -2, -1, -2).addComponent(jLabel37).addComponent(jTextField21, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField20, -2, -1, -2).addComponent(jLabel38).addComponent(jTextField22, -2, -1, -2)).addContainerGap(23, 32767)));
        jPanel11.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel40.setText("Subjetivo");
        jLabel41.setText("OD:");
        jLabel42.setText("OI:");
        jLabel43.setText("ADD");
        jLabel44.setText("AVCC");
        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(jLabel40).addGap(0, 177, 32767)).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel41).addComponent(jLabel42)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField24).addComponent(jTextField23)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jLabel43)).addComponent(jTextField26, -2, 49, -2).addComponent(jTextField25, -2, 49, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jLabel44)).addComponent(jTextField27, -2, 49, -2).addComponent(jTextField28, -2, 49, -2)).addContainerGap()));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(jLabel43).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField25, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField26, -2, -1, -2).addComponent(jTextField24, -2, -1, -2))).addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(jLabel40).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel41).addComponent(jTextField23, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel42)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(jLabel44).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField28, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField27, -2, -1, -2)))).addContainerGap(23, 32767)));
        jPanel12.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel45.setText("Prescripci\363n final");
        jLabel46.setText("ADD");
        jLabel47.setText("AV VL");
        jLabel48.setText("AV VP");
        jLabel49.setText("DP");
        jLabel50.setText("OD:");
        jLabel51.setText("OI:");
        jTextField29.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent evt)
            {
                jTextField29FocusGained(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jLabel65.setText("AO");
        GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel12Layout.createSequentialGroup().addComponent(jLabel45).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jLabel46).addGap(26, 26, 26).addComponent(jLabel47).addGap(17, 17, 17)).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel50).addComponent(jLabel51)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jTextField29).addComponent(jTextField30, -2, 208, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jTextField32, -2, 28, -2).addComponent(jTextField31, -2, 39, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jTextField34, -2, 47, -2).addComponent(jTextField33, -2, 47, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jTextField36).addComponent(jTextField35, -2, 47, -2).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup().addComponent(jLabel48).addGap(9, 9, 9))).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(jTextField38, -2, 61, -2)).addGroup(jPanel12Layout.createSequentialGroup().addGap(57, 57, 57).addComponent(jLabel49))).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jTextField49, -2, 117, -2)).addGroup(jPanel12Layout.createSequentialGroup().addGap(69, 69, 69).addComponent(jLabel65))).addGap(47, 47, 47)));
        jPanel12Layout.linkSize(0, new Component[] {
            jTextField31, jTextField32, jTextField33, jTextField34, jTextField35, jTextField36
        });
        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel48).addComponent(jLabel47).addComponent(jLabel46).addComponent(jLabel45)).addGap(5, 5, 5).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel50).addComponent(jTextField29, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel51).addComponent(jTextField30, -2, -1, -2))).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField34, -2, -1, -2).addComponent(jTextField31, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField32, -2, -1, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup().addComponent(jTextField36, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField35, -2, -1, -2).addComponent(jTextField33, -2, -1, -2))))).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel12Layout.createSequentialGroup().addComponent(jLabel65).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField49, -2, -1, -2)).addGroup(jPanel12Layout.createSequentialGroup().addComponent(jLabel49).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField38, -2, -1, -2))).addGap(13, 13, 13))).addContainerGap(-1, 32767)));
        jPanel12Layout.linkSize(1, new Component[] {
            jTextField31, jTextField32, jTextField33, jTextField34, jTextField35, jTextField36
        });
        jPanel13.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel52.setText("Tipo de lente:");
        jLabel53.setText("Uso:");
        GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel53).addComponent(jLabel52)).addGap(18, 18, 18).addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField39).addComponent(jTextField37)).addContainerGap()));
        jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel52).addComponent(jTextField37, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel53).addComponent(jTextField39, -2, -1, -2)).addContainerGap(-1, 32767)));
        jPanel15.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel54.setText("Test de color:");
        jLabel55.setText("Test de profundidad:");
        GroupLayout jPanel15Layout = new GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(jLabel54).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField40, -2, 267, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel55).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField41).addContainerGap()));
        jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel54).addComponent(jTextField40, -2, -1, -2).addComponent(jLabel55)).addComponent(jTextField41, -2, -1, -2)).addContainerGap(-1, 32767)));
        jPanel16.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel56.setText("Diagn\363stico:");
        jLabel57.setText("CODG RIPS:");
        jComboBox1.setEditable(true);
        GroupLayout jPanel16Layout = new GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel57).addComponent(jLabel56)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(jComboBox1, 0, 628, 32767).addComponent(jTextField42)).addContainerGap()));
        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel56).addComponent(jTextField42, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel57).addComponent(jComboBox1, -2, -1, -2)).addContainerGap(-1, 32767)));
        jPanel17.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel58.setText("Conducta:");
        GroupLayout jPanel17Layout = new GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addContainerGap().addComponent(jLabel58).addGap(18, 18, 18).addComponent(jTextField44, -1, 638, 32767).addContainerGap())));
        jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 45, 32767).addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel58).addComponent(jTextField44, -2, -1, -2)).addContainerGap(13, 32767))));
        jPanel18.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel59.setText("Fecha pr\363x. control:");
        jTextField45.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent evt)
            {
                jTextField45FocusGained(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        GroupLayout jPanel18Layout = new GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 758, 32767).addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addComponent(jLabel59).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jTextField45, -2, 636, -2).addContainerGap())));
        jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 45, 32767).addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel59).addComponent(jTextField45, -2, -1, -2)).addContainerGap(13, 32767))));
        jPanel19.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel60.setText("Observaciones:");
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt)
            {
                jTextArea1KeyPressed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jScrollPane4.setViewportView(jTextArea1);
        GroupLayout jPanel19Layout = new GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup().addContainerGap().addComponent(jLabel60).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane4).addContainerGap()));
        jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup().addContainerGap().addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane4, -2, -1, -2).addComponent(jLabel60)).addContainerGap(-1, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel13, -1, -1, 32767).addComponent(jPanel12, -1, -1, 32767).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jPanel10, -1, -1, 32767).addGap(17, 17, 17).addComponent(jPanel11, -2, -1, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jPanel6, -1, -1, 32767).addGap(18, 18, 18).addComponent(jPanel7, -2, -1, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jPanel8, -1, -1, 32767).addGap(17, 17, 17).addComponent(jPanel9, -2, -1, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(jPanel3, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel5, -2, -1, -2)).addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(jPanel15, -1, -1, 32767).addComponent(jPanel16, -1, -1, 32767).addComponent(jPanel17, -1, -1, 32767).addComponent(jPanel18, -1, -1, 32767).addComponent(jPanel19, -1, -1, 32767)).addGap(23, 23, 23)));
        jPanel1Layout.linkSize(0, new Component[] {
            jPanel11, jPanel7, jPanel9
        });
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(29, 32767).addComponent(jPanel2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel3, -2, -1, -2).addComponent(jPanel4, -2, -1, -2).addComponent(jPanel5, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel6, -2, -1, -2).addComponent(jPanel7, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel9, -2, -1, -2).addComponent(jPanel8, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jPanel10, -2, -1, -2).addComponent(jPanel11, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel12, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel13, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel15, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel16, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel17, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel18, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel19, -2, -1, -2).addContainerGap()));
        jPanel1Layout.linkSize(1, new Component[] {
            jPanel10, jPanel11, jPanel6, jPanel7, jPanel8, jPanel9
        });
        jPanel1Layout.linkSize(1, new Component[] {
            jPanel3, jPanel4, jPanel5
        });
        jScrollPane3.setViewportView(jPanel1);
        jButton2.setText("Guardar");
        jButton2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jButton1.setIcon(new ImageIcon(getClass().getResource("/Vista/Im\341genes/pdf icon2.gif")));
        jButton1.setText("Generar PDF");
        jButton1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }

            final FormHistoria this$0;

            
            {
                this$0 = FormHistoria.this;
                super();
            }
        }
);
        jPanel20.setBorder(BorderFactory.createEtchedBorder(0));
        jLabel62.setText("Historia No. :");
        jTextField46.setFont(new Font("Tahoma", 0, 14));
        jTextField47.setFont(new Font("Tahoma", 0, 14));
        jLabel63.setText("Nombre:");
        jTextField48.setFont(new Font("Tahoma", 0, 14));
        jLabel64.setText("C\351dula:");
        GroupLayout jPanel20Layout = new GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addContainerGap().addComponent(jLabel62).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jTextField46, -2, 44, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel64).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField48, -2, 127, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel63, -2, 49, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jTextField47, -2, 348, -2).addContainerGap(-1, 32767)));
        jPanel20Layout.setVerticalGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addContainerGap().addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jTextField47, -2, -1, -2).addComponent(jLabel63)).addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel62).addComponent(jTextField46, -2, -1, -2).addComponent(jLabel64).addComponent(jTextField48, -2, -1, -2))).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(jButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton3)).addComponent(jScrollPane3, -2, -1, -2).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jPanel20, -2, -1, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(jPanel20, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScrollPane3, -2, 422, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton2).addComponent(jButton3).addComponent(jButton1)).addGap(16, 16, 16)));
        jScrollPane3.getAccessibleContext().setAccessibleName("");
        pack();
    }

    private void jTextField5ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField6ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField7ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField11ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField12ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField16ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField17ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jTextField18ActionPerformed(ActionEvent actionevent)
    {
    }

    private void jButton3ActionPerformed(ActionEvent evt)
    {
        dispose();
    }

    private void jButton2ActionPerformed(ActionEvent evt)
    {
        try
        {
            String tipo = "EMPRESA";
            if(jRadioButton1.isSelected())
                tipo = "PARTICULAR";
            if("".equals(campoTel.getText()))
                campoTel.setText("0");
            String s = conn.insertar((new StringBuilder()).append("insert into historias values ((select nextval('secuencia')),").append(cedPaciente).append(", '").append(campoFecha.getText()).append("', '").append(tipo).append("', '").append(campoAcomp.getText()).append("', '").append(campoParentesco.getText()).append("', ").append(campoTel.getText()).append(", '").append(textoMotivo.getText()).append("', '").append(textoAntec.getText()).append("', '").append(campoSc_vl_d2.getText()).append("', '").append(campoSc_vl_d3.getText()).append("', '").append(jTextField2.getText()).append("', '").append(campoSc_vl_d1.getText()).append("', '").append(campoSc_vl_d4.getText()).append("', '").append(jTextField3.getText()).append("', '").append(jTextField1.getText()).append("', '").append(jTextField4.getText()).append("', '").append(jTextField5.getText()).append("', '").append(jTextField6.getText()).append("', '").append(jTextField13.getText()).append("', '").append(jTextField7.getText()).append("', '").append(jTextField8.getText()).append("', '").append(jTextField9.getText()).append("', '").append(jTextField10.getText()).append("', '").append(jTextField11.getText()).append("', '").append(jTextField12.getText()).append("', '").append(jTextField14.getText()).append("', '").append(jTextField15.getText()).append("', '").append(jTextField16.getText()).append("', '").append(jTextField17.getText()).append("', '").append(jTextField18.getText()).append("', '").append(jTextField19.getText()).append("', '").append(jTextField20.getText()).append("', '").append(jTextField21.getText()).append("', '").append(jTextField22.getText()).append("', '").append(jTextField23.getText()).append("', '").append(jTextField24.getText()).append("', '").append(jTextField25.getText()).append("', '").append(jTextField26.getText()).append("', '").append(jTextField28.getText()).append("', '").append(jTextField27.getText()).append("', '").append(jTextField29.getText()).append("', '").append(jTextField30.getText()).append("', '").append(jTextField31.getText()).append("', '").append(jTextField32.getText()).append("', '").append(jTextField34.getText()).append("', '").append(jTextField33.getText()).append("', '").append(jTextField36.getText()).append("', '").append(jTextField35.getText()).append("', '").append(jTextField38.getText()).append("', '").append(jTextField49.getText()).append("', '").append(jTextField37.getText()).append("', '").append(jTextField39.getText()).append("', '").append(jTextField40.getText()).append("', '").append(jTextField41.getText()).append("', '").append(jTextField42.getText()).append("', '").append(jComboBox1.getSelectedItem().toString()).append("', '").append(jTextField44.getText()).append("', '").append(jTextField45.getText()).append("', '").append(jTextArea1.getText()).append("');").toString());
            System.out.println(s);
            if(s.equals(""))
            {
                if(formPaciente != null)
                    formPaciente.cargarHistorias();
                dispose();
            } else
            {
                JOptionPane.showMessageDialog(null, (new StringBuilder()).append("Error: ").append(s).toString(), "Error al guardar", 0);
            }
        }
        catch(RuntimeException e)
        {
            JOptionPane.showMessageDialog(null, "Se encontr\363 un error con alg\372n campo que llen\363.\nPor favor reviselo e int\351ntelo de nuevo.", "Error aen alg\372n campo", 0);
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt)
    {
        try
        {
            new PDF(conn.reporteSQL((new StringBuilder()).append("select * from pacientes where cc=").append(cedPaciente).append(";").toString()), conn.reporteSQL((new StringBuilder()).append("select * from historias where historia_id=").append(historiaId).append(";").toString()));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void jScrollPane3KeyPressed(KeyEvent keyevent)
    {
    }

    private void campoParentescoFocusGained(FocusEvent focusevent)
    {
    }

    private void jTextField7FocusGained(FocusEvent evt)
    {
        jScrollPane3.getViewport().setViewPosition(new Point(0, 373));
    }

    private void jTextField29FocusGained(FocusEvent evt)
    {
        jScrollPane3.getViewport().setViewPosition(new Point(0, 715));
    }

    private void jTextField45FocusGained(FocusEvent evt)
    {
        jScrollPane3.getViewport().setViewPosition(new Point(0, 868));
    }

    private void textoMotivoKeyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 9)
        {
            textoAntec.requestFocus();
            evt.consume();
        }
    }

    private void textoAntecKeyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 9)
        {
            campoSc_vl_d2.requestFocus();
            evt.consume();
        }
    }

    private void jTextArea1KeyPressed(KeyEvent evt)
    {
        if(evt.getKeyCode() == 9)
            evt.consume();
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
            Logger.getLogger(Vista/FormHistoria.getName()).log(Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            Logger.getLogger(Vista/FormHistoria.getName()).log(Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            Logger.getLogger(Vista/FormHistoria.getName()).log(Level.SEVERE, null, ex);
        }
        catch(UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Vista/FormHistoria.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {

            public void run()
            {
                (new FormHistoria()).setVisible(true);
            }

        }
);
    }

    void setFormPaciente(FormPaciente aThis)
    {
        formPaciente = aThis;
        cedPaciente = aThis.cedPaciente;
        jButton1.setVisible(false);
    }

    void setPaciente(String ced)
    {
        cedPaciente = ced;
        jTextField48.setText(cedPaciente);
        jTextField47.setText((String)conn.reporteSQL((new StringBuilder()).append("SELECT nombre FROM pacientes where cc=").append(cedPaciente).append(";").toString()).remove());
        jTextField46.setText((String)conn.reporteSQL("SELECT last_value+1 FROM secuencia;").remove());
    }

    private void cargarListaCodG()
    {
        String lista[] = {
            "", "H000 Orzuelo", "H010 Blefaritis", "H102 Otras conjuntivitis agudas", "H110 Pterigio", "H250 Catarata senil incipiente", "H521 Miop\355a", "H522 Astigmatismo", "H523 Anisometrop\355a y aniseiconia", "H524 Presbicie", 
            "H525 Transtornos de acomodaci\363n"
        };
        for(int i = 0; i < lista.length; i++)
            jComboBox1.addItem(lista[i]);

    }

    String historiaId;
    String cedPaciente;
    Conn conn;
    FormPaciente formPaciente;
    private ButtonGroup buttonGroup1;
    private JTextField campoAcomp;
    private JTextField campoFecha;
    private JTextField campoParentesco;
    private JTextField campoSc_vl_d1;
    private JTextField campoSc_vl_d2;
    private JTextField campoSc_vl_d3;
    private JTextField campoSc_vl_d4;
    private JTextField campoTel;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JComboBox jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel53;
    private JLabel jLabel54;
    private JLabel jLabel55;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JLabel jLabel6;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JLabel jLabel62;
    private JLabel jLabel63;
    private JLabel jLabel64;
    private JLabel jLabel65;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel18;
    private JPanel jPanel19;
    private JPanel jPanel2;
    private JPanel jPanel20;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField10;
    private JTextField jTextField11;
    private JTextField jTextField12;
    private JTextField jTextField13;
    private JTextField jTextField14;
    private JTextField jTextField15;
    private JTextField jTextField16;
    private JTextField jTextField17;
    private JTextField jTextField18;
    private JTextField jTextField19;
    private JTextField jTextField2;
    private JTextField jTextField20;
    private JTextField jTextField21;
    private JTextField jTextField22;
    private JTextField jTextField23;
    private JTextField jTextField24;
    private JTextField jTextField25;
    private JTextField jTextField26;
    private JTextField jTextField27;
    private JTextField jTextField28;
    private JTextField jTextField29;
    private JTextField jTextField3;
    private JTextField jTextField30;
    private JTextField jTextField31;
    private JTextField jTextField32;
    private JTextField jTextField33;
    private JTextField jTextField34;
    private JTextField jTextField35;
    private JTextField jTextField36;
    private JTextField jTextField37;
    private JTextField jTextField38;
    private JTextField jTextField39;
    private JTextField jTextField4;
    private JTextField jTextField40;
    private JTextField jTextField41;
    private JTextField jTextField42;
    private JTextField jTextField44;
    private JTextField jTextField45;
    private JTextField jTextField46;
    private JTextField jTextField47;
    private JTextField jTextField48;
    private JTextField jTextField49;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JTextField jTextField9;
    private JTextArea textoAntec;
    private JTextArea textoMotivo;



















}

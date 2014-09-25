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
public class FormPaciente extends javax.swing.JFrame {

    Conn conn;
    LinkedList listaCodHistorias;
    LinkedList listaCodMiniControles;
    String cedPaciente;
    boolean edicion;
    
    /**
     * Creates new form FormPaciente
     */
    public FormPaciente() {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((d.width - 722) / 2, (d.height - 564) / 2);
        initComponents();
        setTitle("Nuevo paciente...");
        conn = new Conn();
        listaCodHistorias = new LinkedList();
        listaCodMiniControles = new LinkedList();
        lblFuc.setVisible(false);
        fldFuc.setVisible(false);
        lblEdad.setVisible(false);
        fldEdad.setVisible(false);
        edicion = false;
    }
    
    public void cargarPaciente(String cc)
    {
        setTitle("Paciente");
        fldFuc.setVisible(true);
        lblFuc.setVisible(true);
        LinkedList l = conn.reporteSQL((new StringBuilder()).append("SELECT * FROM pacientes WHERE cc=").append(cc).toString());
        fldCc.setText((String)l.removeFirst());
        cedPaciente = fldCc.getText();
        fldNombre.setText((String)l.removeFirst());
        fldEdad.setText((new StringBuilder()).append((String)conn.reporteSQL((new StringBuilder()).append("SELECT (current_date -fechanac)/365 FROM pacientes WHERE cc=").append(cc).toString()).getFirst()).append(" a\361os").toString());
        lblEdad.setVisible(true);
        fldFechaNac.setText((String)l.removeFirst());
        String aux = (String)l.remove();
        if(aux != null && aux.equals("MASCULINO"))
            radMasculino.setSelected(true);
        else
            radFemenino.setSelected(true);
        fldTelefono.setText((String)l.removeFirst());
        fldDireccion.setText((String)l.removeFirst());
        fldFuc.setText(conn.reporteSQL((new StringBuilder()).append("select fecha from historias where cc_paciente=").append(cc).append(" order by fecha desc limit 1;").toString()).toString());
        fldCelular.setText((String)l.removeFirst());
        fldEmail.setText((String)l.removeFirst());
        fldOcupacion.setText((String)l.removeFirst());
        areObservaciones.setText((String)l.remove());
        areDetalles.setText((String)l.remove());
        bloquearCampos();
        
    }
    
    public void cargarHistorias()
    {
        lstMinicontroles.removeAll();
        listaCodHistorias = new LinkedList();
        for(LinkedList lh = conn.reporteSQL((new StringBuilder()).append("SELECT historia_id, fecha, motivo FROM historias WHERE cc_paciente=").append(cedPaciente).toString()); !lh.isEmpty(); lstMinicontroles.add((new StringBuilder()).append((String)lh.remove()).append(" - MOTIVO: ").append((String)lh.remove()).toString()))
            listaCodHistorias.add(lh.remove());

    }

    public void cargarMiniControles()
    {
        lstHistorias.removeAll();
        listaCodMiniControles = new LinkedList();
        for(LinkedList lmc = conn.reporteSQL((new StringBuilder()).append("SELECT minicontrol_id, fecha, motivo FROM minicontroles WHERE cc_paciente=").append(fldCc.getText()).toString()); !lmc.isEmpty(); lstHistorias.add((new StringBuilder()).append((String)lmc.remove()).append(" - MOTIVO: ").append((String)lmc.remove()).toString()))
            listaCodMiniControles.add(lmc.remove());

    }
    
    void limpiarForm()
    {
        jPanel2.setVisible(false);
        btnEditar.setVisible(false);
    }

    private void activarEdicion(String cedPaciente)
    {
        cargarPaciente(cedPaciente);
        fldFuc.setVisible(false);
        ajustarParaEdicion();
        edicion = true;
    }

    public void ajustarParaEdicion()
    {
        setSize(723, 386);
        lblFuc.setVisible(false);
        lblEdad.setVisible(false);
        fldCc.setEditable(true);
        fldNombre.setEditable(true);
        fldFechaNac.setEditable(true);
        radMasculino.setEnabled(true);
        radFemenino.setEnabled(true);
        fldTelefono.setEditable(true);
        fldDireccion.setEditable(true);
        fldCelular.setEditable(true);
        fldEmail.setEditable(true);
        fldOcupacion.setEditable(true);
        areObservaciones.setEditable(true);
        areDetalles.setEditable(true);
        btnCancelar.setVisible(true);
        btnSoloGuardar.setVisible(true);
        btnGuardarCrearHistoria.setVisible(true);
        limpiarForm();
        btnEditar.setVisible(false);
        btnGuardarCrearHistoria.setVisible(false);
        btnSoloGuardar.setText("Guardar");
    }
    
    private void bloquearCampos(){
        fldCc.setEditable(false);
        fldNombre.setEditable(false);
        fldFechaNac.setEditable(false);
        radMasculino.setEnabled(false);
        radFemenino.setEnabled(false);
        fldTelefono.setEditable(false);
        fldDireccion.setEditable(false);
        fldFuc.setEditable(false);
        fldCelular.setEditable(false);
        fldEmail.setEditable(false);
        areObservaciones.setEditable(false);
        areDetalles.setEditable(false);
        fldOcupacion.setEditable(false);
        btnCancelar.setVisible(false);
        btnSoloGuardar.setVisible(false);//btnSoloGuardar
        btnGuardarCrearHistoria.setVisible(false);
    }

    private void guardar(int n)
    {
        String sexo = "FEMENINO";
        if(radMasculino.isSelected())
            sexo = "MASCULINO";
        if(edicion)
        {
            String res = conn.actualizar((new StringBuilder()).append("UPDATE pacientes SET nombre='").append(fldNombre.getText()).append("', cc=").append(fldCc.getText()).append(", fechanac='").append(fldFechaNac.getText()).append("', sexo='").append(sexo).append("', tel='").append(fldTelefono.getText()).append("', direcc='").append(fldDireccion.getText()).append("', celular='").append(fldCelular.getText()).append("', email='").append(fldEmail.getText()).append("', ocup='").append(fldOcupacion.getText()).append("', observ='").append(areObservaciones.getText()).append("',mas='").append(areDetalles.getText()).append("' where cc=").append(cedPaciente).append(";").toString());
            if(!res.equals("1"))
            {
                JOptionPane.showMessageDialog(null, (new StringBuilder()).append("El paciente no ha sido editado.\nError: ").append(res).toString(), "Error al editar", 0);
            } else
            {
                FormPaciente formPaciente = new FormPaciente();
                formPaciente.cargarPaciente(fldCc.getText());
                formPaciente.cargarHistorias();
                formPaciente.cargarMiniControles();
                formPaciente.setVisible(true);
                dispose();
            }
        } else
        {
            String res = conn.insertar((new StringBuilder()).append("insert into pacientes values (").append(fldCc.getText()).append(",'").append(fldNombre.getText()).append("','").append(fldFechaNac.getText()).append("','").append(sexo).append("',").append(fldTelefono.getText()).append(",'").append(fldDireccion.getText()).append("', ").append(fldCelular.getText()).append(", '").append(fldEmail.getText()).append("', '").append(fldOcupacion.getText()).append("', '").append(areObservaciones.getText()).append("', '").append(areDetalles.getText()).append("');").toString());
            if("".equals(res))
            {
                if(n == 0)
                {
                    dispose();
                } else
                {
                    FormHistoria fh = new FormHistoria();
                    fh.setTitle("Nueva historia...");
                    fh.setPaciente(fldCc.getText());
                    fh.setVisible(true);
                    dispose();
                }
            } else
            {
                JOptionPane.showMessageDialog(null, (new StringBuilder()).append("El paciente no ha sido guardado.\nError: ").append(res).toString(), "Error al guardar", 0);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnCancelar = new javax.swing.JButton();
        btnSoloGuardar = new javax.swing.JButton();
        btnGuardarCrearHistoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        fldNombre = new javax.swing.JTextField();
        lblDocumento = new javax.swing.JLabel();
        fldCc = new javax.swing.JTextField();
        fldFechaNac = new javax.swing.JTextField();
        lblFechaNac = new javax.swing.JLabel();
        radFemenino = new javax.swing.JRadioButton();
        radMasculino = new javax.swing.JRadioButton();
        lblGenero = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        fldDireccion = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        fldCelular = new javax.swing.JTextField();
        lblOcupacion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        fldEmail = new javax.swing.JTextField();
        fldTelefono = new javax.swing.JTextField();
        fldOcupacion = new javax.swing.JTextField();
        lblFuc = new javax.swing.JLabel();
        fldFuc = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        fldEdad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areObservaciones = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areDetalles = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lstMinicontroles = new java.awt.List();
        lstHistorias = new java.awt.List();
        lbHistorias = new javax.swing.JLabel();
        lbHistorias1 = new javax.swing.JLabel();
        btnNuevoControl = new javax.swing.JButton();
        btnNuevaHistoria = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSoloGuardar.setText("Solo guardar");
        btnSoloGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoloGuardarActionPerformed(evt);
            }
        });

        btnGuardarCrearHistoria.setText("Guardar y crear historia");
        btnGuardarCrearHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCrearHistoriaActionPerformed(evt);
            }
        });

        jLabel1.setText("Datos del paciente (debe llenar todos los campos):");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNombre.setText("Nombre:");

        lblDocumento.setText("Documento:");

        lblFechaNac.setText("F. nacimiento:");

        buttonGroup1.add(radFemenino);
        radFemenino.setText("F");

        buttonGroup1.add(radMasculino);
        radMasculino.setText("M");

        lblGenero.setText("Género:");

        lblDireccion.setText("Dir. residencia:");

        lblCelular.setText("Celular:");

        lblOcupacion.setText("Ocupación:");

        lblTelefono.setText("Teléfono:");

        lblEmail.setText("E-mail:");

        lblFuc.setText("FUC:");

        lblEdad.setText("Edad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDireccion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCelular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(lblDocumento))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radFemenino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFechaNac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(fldCc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblFuc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fldFuc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(113, 113, 113)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblTelefono)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblEmail)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(80, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblEdad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOcupacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(fldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDocumento)
                    .addComponent(fldCc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFuc)
                    .addComponent(fldFuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEdad))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGenero)
                        .addComponent(fldFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaNac)
                        .addComponent(radFemenino)
                        .addComponent(radMasculino)
                        .addComponent(lblOcupacion)
                        .addComponent(fldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(fldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono)
                    .addComponent(fldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelular)
                    .addComponent(fldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(fldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Observaciones (opcional):");

        areObservaciones.setColumns(20);
        areObservaciones.setRows(5);
        jScrollPane1.setViewportView(areObservaciones);

        areDetalles.setColumns(20);
        areDetalles.setRows(5);
        jScrollPane2.setViewportView(areDetalles);

        jLabel3.setText("Más detalles (opcional):");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbHistorias.setText("Historias:");

        lbHistorias1.setText("Controles:");

        btnNuevoControl.setText("Nuevo Control");
        btnNuevoControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoControlActionPerformed(evt);
            }
        });

        btnNuevaHistoria.setText("Nueva Historia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbHistorias)
                .addGap(60, 60, 60)
                .addComponent(btnNuevaHistoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbHistorias1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevoControl))
                    .addComponent(lstMinicontroles, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(lstHistorias, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(443, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHistorias)
                    .addComponent(lbHistorias1)
                    .addComponent(btnNuevoControl)
                    .addComponent(btnNuevaHistoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lstMinicontroles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(lstHistorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarCrearHistoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSoloGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSoloGuardar)
                    .addComponent(btnGuardarCrearHistoria)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSoloGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoloGuardarActionPerformed
        // TODO add your handling code here:
        guardar(0);
    }//GEN-LAST:event_btnSoloGuardarActionPerformed

    private void btnGuardarCrearHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCrearHistoriaActionPerformed
        // TODO add your handling code here:
        guardar(1);
    }//GEN-LAST:event_btnGuardarCrearHistoriaActionPerformed

    private void btnNuevoControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoControlActionPerformed
        // TODO add your handling code here:
        FormMiniControl fmc = new FormMiniControl();
        fmc.setTitle("Nuevo minicontrol...");
        fmc.setFormPaciente(this);
        fmc.setVisible(true);
    }//GEN-LAST:event_btnNuevoControlActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        FormPaciente formPaciente = new FormPaciente();
        formPaciente.activarEdicion(cedPaciente);
        formPaciente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areDetalles;
    private javax.swing.JTextArea areObservaciones;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardarCrearHistoria;
    private javax.swing.JButton btnNuevaHistoria;
    private javax.swing.JButton btnNuevoControl;
    private javax.swing.JButton btnSoloGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fldCc;
    private javax.swing.JTextField fldCelular;
    private javax.swing.JTextField fldDireccion;
    private javax.swing.JTextField fldEdad;
    private javax.swing.JTextField fldEmail;
    private javax.swing.JTextField fldFechaNac;
    private javax.swing.JTextField fldFuc;
    private javax.swing.JTextField fldNombre;
    private javax.swing.JTextField fldOcupacion;
    private javax.swing.JTextField fldTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHistorias;
    private javax.swing.JLabel lbHistorias1;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFuc;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOcupacion;
    private javax.swing.JLabel lblTelefono;
    private java.awt.List lstHistorias;
    private java.awt.List lstMinicontroles;
    private javax.swing.JRadioButton radFemenino;
    private javax.swing.JRadioButton radMasculino;
    // End of variables declaration//GEN-END:variables
}

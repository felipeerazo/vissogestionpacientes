/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlHistoria;
import Controlador.CtrlMiniControl;
import Controlador.CtrlPaciente;
import Modelo.Historia;
import Modelo.MiniControl;
import Modelo.Paciente;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class FormPaciente extends javax.swing.JFrame {

    LinkedList<Historia> listaHistorias;
    LinkedList<MiniControl> listaMiniControles;
    private Paciente paciente;
    boolean edicion;

    /**
     * Creates new form FormPaciente
     */
    public FormPaciente() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(2);
        setTitle("Nuevo paciente...");
        listaHistorias = new LinkedList();
        listaMiniControles = new LinkedList();
        lblFuc.setVisible(false);
        fldFuc.setVisible(false);
        lblEdad.setVisible(false);
        fldEdad.setVisible(false);
        edicion = false;
        
    }

    public void cargarPaciente(Paciente paciente) {
        this.setPaciente(paciente);
        setTitle("Paciente");
        fldFuc.setVisible(true);
        lblFuc.setVisible(true);
        fldEdad.setVisible(true);
        lblEdad.setVisible(true);
        //LinkedList l = conn.reporteSQL((new StringBuilder()).append("SELECT * FROM pacientes WHERE cc=").append(cc).toString());
        fldCc.setText(String.valueOf(paciente.getCc()));
        fldNombre.setText(paciente.getNombre());
        fldEdad.setText(String.valueOf(new CtrlPaciente().consultarEdad(paciente.getCc())));
        fldFechaNac.setText(paciente.getFechanac());
        String aux = paciente.getSexo();
        if (aux != null && aux.equals("MASCULINO")) {
            radMasculino.setSelected(true);
        } else {
            radFemenino.setSelected(true);
        }
        fldTelefono.setText(String.valueOf(paciente.getTel()));
        fldDireccion.setText(paciente.getDirecc());
        fldFuc.setText(new CtrlPaciente().consultarFuc(paciente.getCc()));
//        System.out.println("fuc: "+new CtrlPaciente().consultarFuc(paciente.getCc()));
//        
        fldCelular.setText(String.valueOf(paciente.getCelular()));
        fldEmail.setText(paciente.getEmail());
        fldOcupacion.setText(paciente.getOcup());
        areObservaciones.setText(paciente.getObserv());
        areDetalles.setText(paciente.getMas());
        bloquearCampos();
    }

    public void cargarHistorias() {
        lstVistaHistorias.removeAll();
        listaHistorias = new CtrlHistoria().listar(paciente.getCc());
        for (int i = 0; i < listaHistorias.size(); i++) {
            lstVistaHistorias.add(listaHistorias.get(i).getFecha() + " - Motivo: " + listaHistorias.get(i).getMotivo());
        }
    }

    public void cargarMiniControles() {
        lstVistaMinicontroles.removeAll();
        listaMiniControles = new CtrlMiniControl().listar(paciente.getCc());
        for (int i = 0; i < listaMiniControles.size(); i++) {
            lstVistaMinicontroles.add(listaMiniControles.get(i).getFecha() + " - Motivo: " + listaMiniControles.get(i).getMotivo());
        }
    }

    void limpiarForm() {
        jPanel3.setVisible(false);
        btnEditar.setVisible(false);
    }

    private void activarEdicion(Paciente paciente) {
        cargarPaciente(paciente);
        ajustarParaEdicion();
        edicion = true;
    }

    public void ajustarParaEdicion() {
        setSize(680, 430);
        fldFuc.setVisible(false);
        lblFuc.setVisible(false);
        lblEdad.setVisible(false);
        fldEdad.setVisible(false);
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

    private void bloquearCampos() {
        fldCc.setEditable(false);
        fldNombre.setEditable(false);
        fldFechaNac.setEditable(false);
        fldEdad.setEditable(false);
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

    private void guardar(int n) {
        String sexo = "FEMENINO";
        if (radMasculino.isSelected()) {
            sexo = "MASCULINO";
        }
        Paciente nuevoPaciente = new Paciente();
        try {
            nuevoPaciente.setCc(Long.parseLong(fldCc.getText()));
            nuevoPaciente.setNombre(fldNombre.getText());
            nuevoPaciente.setFechanac(fldFechaNac.getText());
            nuevoPaciente.setSexo(sexo);
            nuevoPaciente.setTel(fldTelefono.getText());
            nuevoPaciente.setDirecc(fldDireccion.getText());
            nuevoPaciente.setCelular(fldCelular.getText());
            nuevoPaciente.setEmail(fldEmail.getText());
            nuevoPaciente.setOcup(fldOcupacion.getText());
            nuevoPaciente.setObserv(areObservaciones.getText());
            nuevoPaciente.setMas(areDetalles.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al leer los campos: " + e.getMessage(), "Error", 0);
            return;
        }
        if (edicion) {
            //String res = conn.actualizar((new StringBuilder()).append("UPDATE pacientes SET nombre='").append(fldNombre.getText()).append("', cc=").append(fldCc.getText()).append(", fechanac='").append(fldFechaNac.getText()).append("', sexo='").append(sexo).append("', tel='").append(fldTelefono.getText()).append("', direcc='").append(fldDireccion.getText()).append("', celular='").append(fldCelular.getText()).append("', email='").append(fldEmail.getText()).append("', ocup='").append(fldOcupacion.getText()).append("', observ='").append(areObservaciones.getText()).append("',mas='").append(areDetalles.getText()).append("' where cc=").append(getPaciente().getCc()).append(";").toString());
            String res = new CtrlPaciente().actualizar(paciente.getCc(), nuevoPaciente);
            if (!res.equals("1")) {
                JOptionPane.showMessageDialog(null, (new StringBuilder()).append("El paciente no ha sido editado.\nError: ").append(res).toString(), "Error al editar", 0);
            } else {
                FormPaciente formPaciente = new FormPaciente();
                //formPaciente.cargarPaciente(new CtrlPaciente().consultar(Long.parseLong(fldCc.getText())));
                formPaciente.cargarPaciente(nuevoPaciente);
                formPaciente.cargarHistorias();
                formPaciente.cargarMiniControles();
                formPaciente.setVisible(true);
                dispose();
            }
        } else {
            //String res = conn.insertar((new StringBuilder()).append("insert into pacientes values (").append(fldCc.getText()).append(",'").append(fldNombre.getText()).append("','").append(fldFechaNac.getText()).append("','").append(sexo).append("',").append(fldTelefono.getText()).append(",'").append(fldDireccion.getText()).append("', ").append(fldCelular.getText()).append(", '").append(fldEmail.getText()).append("', '").append(fldOcupacion.getText()).append("', '").append(areObservaciones.getText()).append("', '").append(areDetalles.getText()).append("');").toString());
            String res = new CtrlPaciente().crear(nuevoPaciente);
            if ("1".equals(res)) {
                if (n == 0) {
                    dispose();
                } else {
                    FormHistoria formHistoria = new FormHistoria();
                    formHistoria.setFormPaciente(this);
                    formHistoria.setPaciente(nuevoPaciente);
                    formHistoria.cargarProximoId();
                    formHistoria.cargarPaciente();
                    formHistoria.ocultarBotonesPdf();
                    formHistoria.cargarFechaActual();
                    formHistoria.cargarFechaProximoControl();
                    formHistoria.seleccionarTipoParticular();
                    formHistoria.setTitle("Nueva Historia Clinica...");
                    formHistoria.setVisible(true);
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no ha sido guardado.\nError: "+res, "Error al guardar", 0);
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
        lstVistaMinicontroles = new java.awt.List();
        lstVistaHistorias = new java.awt.List();
        lbHistorias = new javax.swing.JLabel();
        lbHistorias1 = new javax.swing.JLabel();
        btnNuevoControl = new javax.swing.JButton();
        btnNuevaHistoria = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        bntRemision = new javax.swing.JButton();

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

        fldFechaNac.setText("1990-12-31");

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
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblGenero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCelular, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOcupacion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radFemenino)
                        .addGap(18, 18, 18)
                        .addComponent(radMasculino))
                    .addComponent(fldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fldCc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEdad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldFuc, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fldDireccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNac, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDocumento, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(344, 344, 344))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fldCc, fldCelular, fldEdad, fldEmail, fldFechaNac, fldFuc, fldNombre, fldOcupacion, fldTelefono});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(fldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDocumento)
                            .addComponent(fldCc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFuc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenero)
                            .addComponent(radFemenino)
                            .addComponent(radMasculino)
                            .addComponent(lblFechaNac)
                            .addComponent(fldFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEdad))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(fldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelular)
                            .addComponent(fldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fldFuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOcupacion)
                    .addComponent(fldOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion)
                    .addComponent(fldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Observaciones (opcional):");

        areObservaciones.setColumns(20);
        areObservaciones.setLineWrap(true);
        areObservaciones.setRows(1);
        areObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areObservacionesKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(areObservaciones);

        areDetalles.setColumns(20);
        areDetalles.setLineWrap(true);
        areDetalles.setRows(1);
        areDetalles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areDetallesKeyPressed(evt);
            }
        });
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lstVistaMinicontroles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstVistaMinicontrolesActionPerformed(evt);
            }
        });

        lstVistaHistorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstVistaHistoriasActionPerformed(evt);
            }
        });

        lbHistorias.setText("Historias:");

        lbHistorias1.setText("Mini Controles:");

        btnNuevoControl.setText("Nuevo Mini Control");
        btnNuevoControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoControlActionPerformed(evt);
            }
        });

        btnNuevaHistoria.setText("Nueva Historia");
        btnNuevaHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaHistoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbHistorias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevaHistoria))
                    .addComponent(lstVistaHistorias, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbHistorias1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevoControl))
                    .addComponent(lstVistaMinicontroles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lstVistaMinicontroles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lstVistaHistorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        bntRemision.setText("Remisión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bntRemision)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarCrearHistoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSoloGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnEditar)
                    .addComponent(bntRemision))
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
        FormMiniControl formMiniControl = new FormMiniControl();
        formMiniControl.setTitle("Nuevo minicontrol...");
        formMiniControl.setFormPaciente(this);
        formMiniControl.setPaciente(paciente);
        formMiniControl.setVisible(true);
    }//GEN-LAST:event_btnNuevoControlActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        FormPaciente formPaciente = new FormPaciente();
        formPaciente.activarEdicion(getPaciente());
        formPaciente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void lstVistaMinicontrolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstVistaMinicontrolesActionPerformed
        // TODO add your handling code here:
        Vista.FormMiniControl formMiniControl = new Vista.FormMiniControl();
        formMiniControl.cargarMiniControl(listaMiniControles.get(lstVistaMinicontroles.getSelectedIndex()));
        formMiniControl.setVisible(true);
    }//GEN-LAST:event_lstVistaMinicontrolesActionPerformed

    private void btnNuevaHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaHistoriaActionPerformed
        // TODO add your handling code here:
        FormHistoria formHistoria = new FormHistoria();
        formHistoria.setFormPaciente(this);
        formHistoria.setPaciente(paciente);
        formHistoria.cargarProximoId();
        formHistoria.cargarPaciente();
        formHistoria.ocultarBotonesPdf();
        formHistoria.cargarFechaActual();
        formHistoria.cargarFechaProximoControl();
        formHistoria.seleccionarTipoParticular();
        formHistoria.setTitle("Nueva Historia Clinica...");
        formHistoria.setVisible(true);
    }//GEN-LAST:event_btnNuevaHistoriaActionPerformed

    private void lstVistaHistoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstVistaHistoriasActionPerformed
        // TODO add your handling code here:
        FormHistoria formHistoria = new FormHistoria();
        formHistoria.setHistoria(listaHistorias.get(lstVistaHistorias.getSelectedIndex()));
        formHistoria.cargarHistoria(listaHistorias.get(lstVistaHistorias.getSelectedIndex()));
        formHistoria.setPaciente(paciente);
        formHistoria.cargarPaciente();
        formHistoria.ocultarBtnGuardar();
        formHistoria.bloquearCampos();
        formHistoria.setVisible(true);
    }//GEN-LAST:event_lstVistaHistoriasActionPerformed

    private void areObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areObservacionesKeyPressed
        // TODO add your handling code here:
        //para evitar que se guarden \r
        // y se pase al siguiente elemento de la interfaz
        if (evt.getKeyCode() == evt.VK_TAB) {
            evt.consume();
            areDetalles.requestFocus();
        }
    }//GEN-LAST:event_areObservacionesKeyPressed

    private void areDetallesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areDetallesKeyPressed
        // TODO add your handling code here:
        //para evitar que se guarden \r
        if (evt.getKeyCode() == evt.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_areDetallesKeyPressed

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
    private javax.swing.JButton bntRemision;
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
    private java.awt.List lstVistaHistorias;
    private java.awt.List lstVistaMinicontroles;
    private javax.swing.JRadioButton radFemenino;
    private javax.swing.JRadioButton radMasculino;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

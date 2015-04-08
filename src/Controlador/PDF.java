// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 30/12/2013 12:38:23 p.m.
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PDF.java
package Controlador;

import Modelo.Historia;
import Modelo.Paciente;
import Modelo.PrescripcionFinal;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PDF {

    public PDF() {
        ruta_destino = null;
    }

    void generar(LinkedList lp, LinkedList lh)
            throws Exception {
        ruta_destino = null;
        conn = new Conn();
        Image imagen;
        Paragraph linea;
        Phrase para;
        Paragraph fecha;
        Document documento;
        String encabezado = "HISTORIA CLINICA DE OPTOMETRIA";
        Date date = new Date();
        long lnMilisegundos = date.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
        Font fuente = new Font(Font.getFamily("ARIAL"), 12F, 1);
        String choro = "Sandra Liliana Guerrero Betancurt. O.D reg 2661";
        imagen = Image.getInstance(getClass().getResource("/Vista/Imagenes/visso2.jpg"));
        imagen.setAlignment(4);
        linea = new Paragraph(encabezado, fuente);
        para = new Phrase(choro);
        fecha = new Paragraph((new StringBuilder()).append(String.valueOf(sqlDate)).append("\n").append("\n").toString());
        documento = new Document(PageSize.LETTER);
        colocarDestino();
        if (ruta_destino != null) {
            PdfWriter.getInstance(documento, new FileOutputStream((new StringBuilder()).append(ruta_destino).append(".pdf").toString()));
        } else {
            return;
        }
        try {
            documento.open();
            documento.add(imagen);
            documento.add(linea);
            documento.add(para);
            documento.add(fecha);
            documento.add(Tabla_compleja(lp, lh));
            documento.close();
        } catch (Exception ex) {
            System.out.println((new StringBuilder()).append("error ").append(ex).append(" en metodo prueba").toString());
        }
        return;
    }

    public void crear_PDF(String titulo, String autor, String asunto, String palabrasClaves, String contenido) {
        colocarDestino();
        if (ruta_destino != null) {
            try {
                Document mipdf = new Document();
                PdfWriter.getInstance(mipdf, new FileOutputStream((new StringBuilder()).append(ruta_destino).append(".pdf").toString()));
                mipdf.open();
                mipdf.addTitle(titulo);
                mipdf.addAuthor(autor);
                mipdf.addSubject(asunto);
                mipdf.addKeywords(palabrasClaves);
                mipdf.add(new Paragraph(contenido));
                mipdf.close();
                JOptionPane.showMessageDialog(null, "Documento PDF creado");
            } catch (DocumentException ex) {
            } catch (FileNotFoundException ex) {
            }
        }
    }

    public void colocarDestino() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF", new String[]{
            "pdf", "PDF"
        });
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == 0) {
            ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
    }

    public PdfPTable Tabla_compleja(LinkedList lp, LinkedList lh) {
        PdfPTable mitablacompleja = new PdfPTable(8);
        mitablacompleja.setWidthPercentage(100F);
        String camposPaciente[] = {
            "DOCUMENTO", "NOMBRE", "EDAD", "FECHA NAC", "GENERO", "TELEFONO", "DIRECCION", "CELULAR", "EMAIL", "OCUPACION"
        };
        String camposHistoria[] = {
            "HISTORIA No.", "FECHA", "TIPO", "ACOMPA\321ANTE", "PARENTESCO", "TELEFONO", "MOTIVO", "ANEMNESIS Y ANTEC.", "SC VL OD", "SC VL OI",
            "VP", "CC VL OD", "CC VL OI", "VP", "OD", "OI", "PIO OD", "PIO OI", "VL", "VP",
            "PPC", "AV OD", "AV OI", "ADD OD", "ADD OI", "AVCC OD", "AVCC OI", "AV VL OD", "AV VL OI", "AV VP OD",
            "AV VP OI", "DP", "AO", "TIPO LENTE", "USO", "T. COLOR", "T. PROFUND.", "DIAGNOSTICO", "CODG RIPS", "CONDUCTA",
            "CONTROL", "OBSERVAC."
        };
        String cc = (String) lp.getFirst();
        Font f = FontFactory.getFont("arial", 7F, 0, BaseColor.BLACK);
        Font fTitulo = FontFactory.getFont("", 9F, 1, BaseColor.BLACK);
        Font fCont = FontFactory.getFont("", 8F, 2, BaseColor.BLACK);
        PdfPCell celda;
        for (int i = 0; i < camposPaciente.length; i++) {
            Paragraph p = new Paragraph(camposPaciente[i], f);
            p.setAlignment(3);
            celda = new PdfPCell(p);
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lp.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("FUC", f));
        celda.setColspan(1);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph(conn.reporteSQL((new StringBuilder()).append("select to_char(fecha,'YYYY-MM-DD') from historias where cc_paciente=").append(cc).append(" order by fecha desc limit 1").toString()).toString(), fCont));
        celda.setColspan(3);
        mitablacompleja.addCell(celda);
        lh.remove(1);
        for (int i = 0; i < 7; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph(camposHistoria[7], f));
        celda.setColspan(1);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
        celda.setColspan(7);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph("AGUDEZA VISUAL", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 8; i < 14; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("PH", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 16; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("RX EN USO", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 16; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("ADD", f));
        celda.setColspan(1);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
        celda.setColspan(7);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph("DESCRIPCION BIOMICROSCOPICA", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 18; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("DESCRIPCION FONDO DE OJO", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 16; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("CVT", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 18; i < 20; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(2);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph(camposHistoria[20], f));
        celda.setColspan(1);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
        celda.setColspan(1);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph("QUERATOMETRIA", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 16; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("REFRACCION", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 16; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        for (int i = 21; i < 23; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("SUBJETIVO", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 16; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        for (int i = 23; i < 27; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph("PRESCRIPCION FINAL", fTitulo));
        celda.setColspan(8);
        mitablacompleja.addCell(celda);
        for (int i = 14; i < 16; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(3);
            mitablacompleja.addCell(celda);
        }

        for (int i = 23; i < 25; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
        }

        for (int i = 27; i < 33; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
        }

        for (int i = 33; i < 41; i++) {
            celda = new PdfPCell(new Paragraph(camposHistoria[i], f));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
            celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
            celda.setColspan(1);
            mitablacompleja.addCell(celda);
        }

        celda = new PdfPCell(new Paragraph(camposHistoria[41], f));
        celda.setColspan(1);
        mitablacompleja.addCell(celda);
        celda = new PdfPCell(new Paragraph((String) lh.remove(), fCont));
        celda.setColspan(7);
        mitablacompleja.addCell(celda);
        return mitablacompleja;
    }

    private File ruta_destino;
    private Conn conn;

    public void crearPdf(Paciente paciente, Historia historia) {
        LinkedList<String> camposPaciente = new LinkedList<>();
        camposPaciente.add(String.valueOf(paciente.getCc()));
        camposPaciente.add(paciente.getNombre());
        camposPaciente.add(String.valueOf(new CtrlPaciente().consultarEdad(paciente.getCc())));
        camposPaciente.add(paciente.getFechanac());
        camposPaciente.add(paciente.getSexo());
        camposPaciente.add(paciente.getTel());
        camposPaciente.add(paciente.getDirecc());
        camposPaciente.add(paciente.getCelular());
        camposPaciente.add(paciente.getEmail());
        camposPaciente.add(paciente.getOcup());

        LinkedList<String> camposHistoria = new LinkedList<>();
        camposHistoria.add(String.valueOf(historia.getHistoria_id()));
        camposHistoria.add(String.valueOf(historia.getCc_paciente()));
        camposHistoria.add(historia.getFecha());
        camposHistoria.add(historia.getTipo());
        camposHistoria.add(historia.getAcomp());
        camposHistoria.add(historia.getParentesco());
        camposHistoria.add(String.valueOf(historia.getTel()));
        camposHistoria.add(historia.getMotivo());
        camposHistoria.add(historia.getAntec());
        camposHistoria.add(historia.getSc_vl_d());
        camposHistoria.add(historia.getSc_vl_i());
        camposHistoria.add(historia.getVp());
        camposHistoria.add(historia.getCc_vl_d());
        camposHistoria.add(historia.getCc_vl_i());
        camposHistoria.add(historia.getVp2());
        camposHistoria.add(historia.getPh_d());
        camposHistoria.add(historia.getPh_i());
        camposHistoria.add(historia.getRx_d());
        camposHistoria.add(historia.getRx_i());
        camposHistoria.add(historia.getRx_add());
        camposHistoria.add(historia.getDb_d());
        camposHistoria.add(historia.getDb_i());
        camposHistoria.add(historia.getPio_d());
        camposHistoria.add(historia.getPio_i());
        camposHistoria.add(historia.getDfo_d());
        camposHistoria.add(historia.getDfo_i());
        camposHistoria.add(historia.getCvt_vl());
        camposHistoria.add(historia.getCvt_vp());
        camposHistoria.add(historia.getCvt_ppc());
        camposHistoria.add(historia.getQ_d());
        camposHistoria.add(historia.getQ_i());
        camposHistoria.add(historia.getRefr_d());
        camposHistoria.add(historia.getRefr_i());
        camposHistoria.add(historia.getAv_d());
        camposHistoria.add(historia.getAv_i());
        camposHistoria.add(historia.getSubjetivo_d());
        camposHistoria.add(historia.getSubjetivo_i());
        camposHistoria.add(historia.getAdd_d());
        camposHistoria.add(historia.getAdd_i());
        camposHistoria.add(historia.getAvcc_d());
        camposHistoria.add(historia.getAvcc_i());
        camposHistoria.add(historia.getPrescrip_f_d());
        camposHistoria.add(historia.getPrescrip_f_i());
        camposHistoria.add(historia.getAdd_f_d());
        camposHistoria.add(historia.getAdd_f_i());
        camposHistoria.add(historia.getAv_vl_d());
        camposHistoria.add(historia.getAv_vl_i());
        camposHistoria.add(historia.getAv_vp_d());
        camposHistoria.add(historia.getAv_vp_i());
        camposHistoria.add(historia.getDp());
        camposHistoria.add(historia.getAo());
        camposHistoria.add(historia.getTipo_lente());
        camposHistoria.add(historia.getUso());
        camposHistoria.add(historia.getTest_color());
        camposHistoria.add(historia.getTest_profund());
        camposHistoria.add(historia.getDiagnostico());
        camposHistoria.add(historia.getCodg_rips());
        camposHistoria.add(historia.getConducta());
        camposHistoria.add(historia.getControl());
        camposHistoria.add(historia.getObservaciones());
        try {
            generar(camposPaciente, camposHistoria);
        } catch (Exception ex) {
            System.out.println("Excepción método PDF.generar: " + ex);
        }
    }

    /**
     * para crar la tabla de prescripcion final en PDF
     *
     * @param paciente
     * @param prescripcionFinal
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public void generarPdfPrescripcionFinal(Paciente paciente, PrescripcionFinal prescripcionFinal) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        //tabla para el encabezado
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.getDefaultCell().setBorder(0);
//Logo de Visso
        Image imagen = Image.getInstance(getClass().getResource("/Vista/Imagenes/visso4.jpg"));
        imagen.setAlignment(4);
        encabezado.addCell(imagen);
        encabezado.addCell("");
        //Fecha
//        Paragraph fecha = new Paragraph(prescripcionFinal.getFecha());        
        encabezado.addCell(crearCeldaContenido(prescripcionFinal.getFecha()));
        //Paciente
        Paragraph paraNombrePaciente = new Paragraph("Paciente: "+paciente.getNombre());
        PdfPCell celdaNombrePaciente= new PdfPCell(paraNombrePaciente);
        celdaNombrePaciente.setColspan(2);
        celdaNombrePaciente.setBorder(0);
        encabezado.addCell(celdaNombrePaciente);
        encabezado.addCell("Documento: " + paciente.getCc());
// Este codigo genera una tabla de n columnas
        PdfPTable table = new PdfPTable(6);
        PdfPCell cell;
        /**
         * fila encabezado
         */
        //agrega una celda a la tabla, el cambio de fila.
        //El cambio de fila ocurre automáticamente.
        table.addCell("");
        table.addCell("");
        table.addCell(crearCeldaEncabezado("ESFERA"));
        table.addCell(crearCeldaEncabezado("CILINDRO"));
        table.addCell(crearCeldaEncabezado("EJE"));
        table.addCell(crearCeldaEncabezado("AV VL"));
        /**
         * fila de lejos
         */
        //fila de lejos D
        cell = crearCeldaEncabezado("LEJOS");
        cell.setRowspan(2);//para que la celda ocupe el espacio de dos filas
        table.addCell(cell);
        table.addCell(crearCeldaEncabezado("OD"));
        table.addCell(crearCeldaContenido(prescripcionFinal.getLejosEsferaD()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getLejosCilindroD()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getLejosEjeD()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getAvVlD()));
        //fila de lejos I        
        table.addCell(crearCeldaEncabezado("OI"));
        table.addCell(crearCeldaContenido(prescripcionFinal.getLejosEsferaI()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getLejosCilindroI()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getLejosEjeI()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getAvVlI()));
        /**
         * fila de cerCa
         */
        //fila de cerca D
        cell = crearCeldaEncabezado("CERCA");
        cell.setRowspan(2);//para que la celda ocupe el espacio de dos filas
        table.addCell(cell);
        table.addCell(crearCeldaEncabezado("OD"));
        table.addCell(crearCeldaContenido(prescripcionFinal.getCercaEsferaD()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getCercaCilindroD()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getCercaEjeD()));
        table.addCell("");
        //fila de cerca I        
        table.addCell(crearCeldaEncabezado("OI"));
        table.addCell(crearCeldaContenido(prescripcionFinal.getCercaEsferaI()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getCercaCilindroI()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getCercaEjeI()));
        table.addCell(crearCeldaEncabezado("AV VP"));
        /**
         * fila de adicion
         */
        //fila de cerca D
        cell = crearCeldaEncabezado("ADD");
        cell.setRowspan(2);//para que la celda ocupe el espacio de dos filas
        table.addCell(cell);
        table.addCell(crearCeldaEncabezado("OD"));
        table.addCell(crearCeldaContenido(prescripcionFinal.getAdicionEsferaD()));
        table.addCell("");
        table.addCell(crearCeldaEncabezado("DP"));
        table.addCell(crearCeldaContenido(prescripcionFinal.getAvVpD()));
        //fila de cerca I
        table.addCell(crearCeldaEncabezado("OI"));
        table.addCell(crearCeldaContenido(prescripcionFinal.getAdicionEsferaI()));
        table.addCell("");
        table.addCell(crearCeldaContenido(prescripcionFinal.getDp()));
        table.addCell(crearCeldaContenido(prescripcionFinal.getAvVpI()));
        //abrir filechooser
        Document documento = new Document(PageSize.LETTER);
        colocarDestino();
        if (ruta_destino != null) {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta_destino + ".pdf"));
        } else {
            return;
        }
        try {
            documento.open();
            documento.add(encabezado);
            documento.add(table);
            documento.close();
        } catch (Exception ex) {
            System.out.println("Excepción método PDF.generarPdfPrescripcionFinal = " + ex.getMessage());
        }
    }

    private PdfPCell crearCeldaEncabezado(String s) {
        PdfPCell cell = new PdfPCell(new Phrase(s,
                FontFactory.getFont("arial", // fuente
                        10, // tamaño
                        Font.BOLD, // estilo
                        BaseColor.BLACK)));//color
        cell.setHorizontalAlignment(cell.ALIGN_CENTER);
        cell.setVerticalAlignment(cell.ALIGN_MIDDLE);
        return cell;
    }

    private PdfPCell crearCeldaContenido(String s) {
        PdfPCell cell = new PdfPCell(new Phrase(s,
                FontFactory.getFont("arial", // fuente
                        9, // tamaño
                        Font.NORMAL, // estilo
                        BaseColor.BLACK)));//color
        cell.setHorizontalAlignment(cell.ALIGN_CENTER);
        cell.setVerticalAlignment(cell.ALIGN_MIDDLE);
        return cell;
    }
    
    /**
     * para cambiar la primera letra de cada palabra en mayúsculas
     * @param s
     * @return 
     */
    private String getNombreTitulo(String s){
        String[] vec=s.split(" ");
        String res="";
        for (int i = 0; i < vec.length; i++) {
            vec[i].replaceFirst(String.valueOf(vec[i].charAt(0)), String.valueOf(vec[i].charAt(0)).toUpperCase());
            res=res+" "+vec[i];
        }
        return res;
    }

}

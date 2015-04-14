/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PrescripcionFinal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class CtrlPrescripcionFinal {

    public String crear(String cc, PrescripcionFinal prescripcionFinal) {
        Conn conn = new Conn();
        String res = "";
        if (existe(cc)) {
            //actualizar
            res = conn.actualizar("update prescripcion_final set "
                    + "lejos_esfera_d='" + prescripcionFinal.getLejosEsferaD() + "', "
                    + "lejos_esfera_i='" + prescripcionFinal.getLejosEsferaI() + "', "
                    + "lejos_cilindro_d='" + prescripcionFinal.getLejosCilindroD() + "', "
                    + "lejos_cilindro_i='" + prescripcionFinal.getLejosCilindroI() + "', "
                    + "lejos_eje_d='" + prescripcionFinal.getLejosEjeD() + "', "
                    + "lejos_eje_i='" + prescripcionFinal.getLejosEjeI() + "', "
                    + "av_vl_d='" + prescripcionFinal.getAvVlD() + "', "
                    + "av_vl_i='" + prescripcionFinal.getAvVlI() + "', "
                    + "cerca_esfera_d='" + prescripcionFinal.getCercaEsferaD() + "', "
                    + "cerca_esfera_i='" + prescripcionFinal.getCercaEsferaI() + "', "
                    + "cerca_cilindro_d='" + prescripcionFinal.getCercaCilindroD() + "', "
                    + "cerca_cilindro_i='" + prescripcionFinal.getCercaCilindroI() + "', "
                    + "cerca_eje_d='" + prescripcionFinal.getCercaEjeD() + "', "
                    + "cerca_eje_i='" + prescripcionFinal.getCercaEjeI() + "', "
                    + "adicion_esfera_d='" + prescripcionFinal.getAdicionEsferaD() + "', "
                    + "adicion_esfera_i='" + prescripcionFinal.getAdicionEsferaI() + "', "
                    + "dp='" + prescripcionFinal.getDp() + "', "
                    + "av_vp_d='" + prescripcionFinal.getAvVpD() + "', "
                    + "av_vp_i='" + prescripcionFinal.getAvVpI() + "', "
                    + "observ='" + prescripcionFinal.getObserv() + "' "
                    + "where cc_paciente=" + cc + ";");
        } else {
            //insertar
            res = conn.insertar("insert into prescripcion_final values "
                    + "(" + consultarNextId()
                    + ", " + cc
                    + ", '" + prescripcionFinal.getLejosEsferaD() + "'"
                    + ", '" + prescripcionFinal.getLejosEsferaI() + "'"
                    + ", '" + prescripcionFinal.getLejosCilindroD() + "'"
                    + ", '" + prescripcionFinal.getLejosCilindroI() + "'"
                    + ", '" + prescripcionFinal.getLejosEjeD() + "'"
                    + ", '" + prescripcionFinal.getLejosEjeI() + "'"
                    + ", '" + prescripcionFinal.getAvVlD() + "'"
                    + ", '" + prescripcionFinal.getAvVlI() + "'"
                    + ", '" + prescripcionFinal.getCercaEsferaD() + "'"
                    + ", '" + prescripcionFinal.getCercaEsferaI() + "'"
                    + ", '" + prescripcionFinal.getCercaCilindroD() + "'"
                    + ", '" + prescripcionFinal.getCercaCilindroI() + "'"
                    + ", '" + prescripcionFinal.getCercaEjeD() + "'"
                    + ", '" + prescripcionFinal.getCercaEjeI() + "'"
                    + ", '" + prescripcionFinal.getAdicionEsferaD() + "'"
                    + ", '" + prescripcionFinal.getAdicionEsferaI() + "'"
                    + ", '" + prescripcionFinal.getDp() + "'"
                    + ", '" + prescripcionFinal.getAvVpD() + "'"
                    + ", '" + prescripcionFinal.getAvVpI() + "'"
                    + ", '" + prescripcionFinal.getObserv() + "');");
        }
        conn.cerrar();
        return res;
    }

    /**
     * retorna el id mayor más 1 de la tabla prescripcion_final. Si no hay
     * registros, retorna 1. Si ocurre un error, retorna -1
     *
     *
     * @return id del siguiente registro
     */
    public String consultarNextId() {
        String s;
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("select case "
                + "WHEN max(id) is null THEN 0 "
                + "ELSE max(id)+1 "
                + "END "
                + "from prescripcion_final;");
        try {
            resultSet.next();
            s = String.valueOf(resultSet.getLong(1));
        } catch (SQLException ex) {
            s = "-1";
        }
        conn.cerrar();
        return s;
    }

    /**
     * para saber si existe un registro
     *
     * @param cc paciente
     * @return true si existe, false si no
     */
    public boolean existe(String cc) {
        boolean b = false;
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("select 1 "
                + "from prescripcion_final "
                + "where cc_paciente=" + cc + ";");
        try {
            if (resultSet.next()) {
                b = true;
            }
        } catch (SQLException ex) {
            b = false;
        }
        conn.cerrar();
        return b;
    }

    public PrescripcionFinal consultar(String cc) {
        PrescripcionFinal prescripcionFinal = new PrescripcionFinal();
        Conn conn = new Conn();
        ResultSet resultSet = null;
        resultSet = conn.consultar("select * from prescripcion_final where cc_paciente = " + cc + ";");
        try {
            while (resultSet.next()) {
                prescripcionFinal.setLejosEsferaD(resultSet.getString(3));
                prescripcionFinal.setLejosEsferaI(resultSet.getString(4));
                prescripcionFinal.setLejosCilindroD(resultSet.getString(5));
                prescripcionFinal.setLejosCilindroI(resultSet.getString(6));
                prescripcionFinal.setLejosEjeD(resultSet.getString(7));
                prescripcionFinal.setLejosEjeI(resultSet.getString(8));
                prescripcionFinal.setAvVlD(resultSet.getString(9));
                prescripcionFinal.setAvVlI(resultSet.getString(10));
                prescripcionFinal.setCercaEsferaD(resultSet.getString(11));
                prescripcionFinal.setCercaEsferaI(resultSet.getString(12));
                prescripcionFinal.setCercaCilindroD(resultSet.getString(13));
                prescripcionFinal.setCercaCilindroI(resultSet.getString(14));
                prescripcionFinal.setCercaEjeD(resultSet.getString(15));
                prescripcionFinal.setCercaEjeI(resultSet.getString(16));
                prescripcionFinal.setAdicionEsferaD(resultSet.getString(17));
                prescripcionFinal.setAdicionEsferaI(resultSet.getString(18));
                prescripcionFinal.setDp(resultSet.getString(19));
                prescripcionFinal.setAvVpD(resultSet.getString(20));
                prescripcionFinal.setAvVpI(resultSet.getString(21));
                prescripcionFinal.setObserv(resultSet.getString(22));
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPrescripcionFinal.consultar = " + ex.getMessage());
        }
        conn.cerrar();
        return prescripcionFinal;
    }

}

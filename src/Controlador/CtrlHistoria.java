/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Historia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author salas
 */
public class CtrlHistoria {

    public CtrlHistoria() {
    }

    public LinkedList<Historia> listar(Long cc) {
        LinkedList<Historia> listaHistorias = new LinkedList();
        Conn conn = new Conn();
        ResultSet resultSet = null;
        resultSet = conn.consultar("select * from historias where cc_paciente=" + cc + ";");
        try {
            while (resultSet.next()) {
                Historia historia = new Historia();
                historia.setHistoria_id(resultSet.getInt(1));
                historia.setCc_paciente(resultSet.getLong(2));
                historia.setFecha(resultSet.getString(3));
                historia.setTipo(resultSet.getString(4));
                historia.setAcomp(resultSet.getString(5));
                historia.setParentesco(resultSet.getString(6));
                historia.setTel(resultSet.getLong(7));
                historia.setMotivo(resultSet.getString(8));
                historia.setAntec(resultSet.getString(9));
                historia.setSc_vl_d(resultSet.getString(10));
                historia.setSc_vl_i(resultSet.getString(11));
                historia.setVp(resultSet.getString(12));
                historia.setCc_vl_d(resultSet.getString(13));
                historia.setCc_vl_i(resultSet.getString(14));
                historia.setVp2(resultSet.getString(15));
                historia.setPh_d(resultSet.getString(16));
                historia.setPh_i(resultSet.getString(17));
                historia.setRx_d(resultSet.getString(18));
                historia.setRx_i(resultSet.getString(19));
                historia.setRx_add(resultSet.getString(20));
                historia.setDb_d(resultSet.getString(21));
                historia.setDb_i(resultSet.getString(22));
                historia.setPio_d(resultSet.getString(23));
                historia.setPio_i(resultSet.getString(24));
                historia.setDfo_d(resultSet.getString(25));
                historia.setDfo_i(resultSet.getString(26));
                historia.setCvt_vl(resultSet.getString(27));
                historia.setCvt_vp(resultSet.getString(28));
                historia.setCvt_ppc(resultSet.getString(29));
                historia.setQ_d(resultSet.getString(30));
                historia.setQ_i(resultSet.getString(31));
                historia.setRefr_d(resultSet.getString(32));
                historia.setRefr_i(resultSet.getString(33));
                historia.setAv_d(resultSet.getString(34));
                historia.setAv_i(resultSet.getString(35));
                historia.setSubjetivo_d(resultSet.getString(36));
                historia.setSubjetivo_i(resultSet.getString(37));
                historia.setAdd_d(resultSet.getString(38));
                historia.setAdd_i(resultSet.getString(39));
                historia.setAvcc_d(resultSet.getString(40));
                historia.setAvcc_i(resultSet.getString(41));
                historia.setPrescrip_f_d(resultSet.getString(42));
                historia.setPrescrip_f_i(resultSet.getString(43));
                historia.setAdd_f_d(resultSet.getString(44));
                historia.setAdd_f_i(resultSet.getString(45));
                historia.setAv_vl_d(resultSet.getString(46));
                historia.setAv_vl_i(resultSet.getString(47));
                historia.setAv_vp_d(resultSet.getString(48));
                historia.setAv_vp_i(resultSet.getString(49));
                historia.setDp(resultSet.getString(50));
                historia.setAo(resultSet.getString(51));
                historia.setTipo_lente(resultSet.getString(52));
                historia.setUso(resultSet.getString(53));
                historia.setTest_color(resultSet.getString(54));
                historia.setTest_profund(resultSet.getString(55));
                historia.setDiagnostico(resultSet.getString(56));
                historia.setCodg_rips(resultSet.getString(57));
                historia.setConducta(resultSet.getString(58));
                historia.setControl(resultSet.getString(59));
                historia.setObservaciones(resultSet.getString(60));
                listaHistorias.add(historia);
            }
        } catch (Exception ex) {
            System.out.println("Excepción método CtrlHistoria.listar = " + ex.getMessage());
        }
        conn.cerrar();
        return listaHistorias;
    }

    public int consultarProximoId() {
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("select last_value+1 as proximo from secuencia;");
        int id = -1;
        try {
            while (resultSet.next()) {
                id = resultSet.getInt("proximo");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlHistoria.consultarProximoId = " + ex.getMessage());
        }
        conn.cerrar();
        return id;
    }

    public String crear(Historia historia) {
        Conn conn = new Conn();
        String res = conn.insertar("insert into historias values "
                + "(" + historia.getHistoria_id() + ", "
                + historia.getCc_paciente() + ", "
                + "'" + historia.getFecha() + "', "
                + "'" + historia.getTipo() + "', "
                + "'" + historia.getAcomp() + "', "
                + "'" + historia.getParentesco() + "', "
                + historia.getTel() + ", "
                + "'" + historia.getMotivo() + "', "
                + "'" + historia.getAntec() + "', "
                + "'" + historia.getSc_vl_d() + "', "
                + "'" + historia.getSc_vl_i() + "', "
                + "'" + historia.getVp() + "', "
                + "'" + historia.getCc_vl_d() + "', "
                + "'" + historia.getCc_vl_i() + "', "
                + "'" + historia.getVp2() + "', "
                + "'" + historia.getPh_d() + "', "
                + "'" + historia.getPh_i() + "', "
                + "'" + historia.getRx_d() + "', "
                + "'" + historia.getRx_i() + "', "
                + "'" + historia.getRx_add() + "', "
                + "'" + historia.getDb_d() + "', "
                + "'" + historia.getDb_i() + "', "
                + "'" + historia.getPio_d() + "', "
                + "'" + historia.getPio_i() + "', "
                + "'" + historia.getDfo_d() + "', "
                + "'" + historia.getDfo_i() + "', "
                + "'" + historia.getCvt_vl() + "', "
                + "'" + historia.getCvt_vp() + "', "
                + "'" + historia.getCvt_ppc() + "', "
                + "'" + historia.getQ_d() + "', "
                + "'" + historia.getQ_i() + "', "
                + "'" + historia.getRefr_d() + "', "
                + "'" + historia.getRefr_i() + "', "
                + "'" + historia.getAv_d() + "', "
                + "'" + historia.getAv_i() + "', "
                + "'" + historia.getSubjetivo_d() + "', "
                + "'" + historia.getSubjetivo_i() + "', "
                + "'" + historia.getAdd_d() + "', "
                + "'" + historia.getAdd_i() + "', "
                + "'" + historia.getAvcc_d() + "', "
                + "'" + historia.getAvcc_i() + "', "
                + "'" + historia.getPrescrip_f_d() + "', "
                + "'" + historia.getPrescrip_f_i() + "', "
                + "'" + historia.getAdd_f_d() + "', "
                + "'" + historia.getAdd_f_i() + "', "
                + "'" + historia.getAv_vl_d() + "', "
                + "'" + historia.getAv_vl_i() + "', "
                + "'" + historia.getAv_vp_d() + "', "
                + "'" + historia.getAv_vp_i() + "', "
                + "'" + historia.getDp() + "', "
                + "'" + historia.getAo() + "', "
                + "'" + historia.getTipo_lente() + "', "
                + "'" + historia.getUso() + "', "
                + "'" + historia.getTest_color() + "', "
                + "'" + historia.getTest_profund() + "', "
                + "'" + historia.getDiagnostico() + "', "
                + "'" + historia.getCodg_rips() + "', "
                + "'" + historia.getConducta() + "', "
                + "'" + historia.getControl() + "', "
                + "'" + historia.getObservaciones() + "');");        
        conn.cerrar();
        return res;
    }

    public void aumentarSecuencia() {
        Conn conn = new Conn();
        conn.ejecutar("select nextval('secuencia'); commit;");
        conn.cerrar();
    }
}

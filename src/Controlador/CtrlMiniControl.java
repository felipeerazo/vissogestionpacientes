/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MiniControl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author salas
 */
public class CtrlMiniControl {

    public CtrlMiniControl() {
    }

    public String crear(MiniControl miniControl) {
        Conn conn = new Conn();
        String res = conn.insertar("insert into minicontroles values "
                + "((select nextval('secuencia_minicontroles')), "
                + miniControl.getCcPaciente() + ", "
                + "'" + miniControl.getFecha() + "', "
                + "'" + miniControl.getMotivo() + "', "
                + "'" + miniControl.getObservaciones() + "');");
        conn.cerrar();
        return res;
    }
    
    public LinkedList<MiniControl> listar(Long cc) {
        LinkedList<MiniControl> listaMiniControles = new LinkedList();
        Conn conn = new Conn();
        ResultSet resultSet = null;
        resultSet = conn.consultar("select * from minicontroles where cc_paciente="+cc+";");
        try {
            while (resultSet.next()) {
                MiniControl miniControl = new MiniControl();
                miniControl.setId(resultSet.getInt("minicontrol_id"));
                miniControl.setCcPaciente(resultSet.getLong("cc_paciente"));
                miniControl.setFecha(resultSet.getString("fecha"));
                miniControl.setMotivo(resultSet.getString("motivo"));
                miniControl.setObservaciones(resultSet.getString("observaciones"));
                listaMiniControles.add(miniControl);
            }
        } catch (Exception ex) {
            System.out.println("Excepción método CtrlMiniControl.listar = " + ex.getMessage());
        }
        conn.cerrar();
        return listaMiniControles;
    }

}

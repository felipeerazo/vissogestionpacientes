/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MiniControl;

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

}

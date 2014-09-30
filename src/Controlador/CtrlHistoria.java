/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author salas
 */
public class CtrlHistoria {

    public CtrlHistoria() {
    }
    
    public int consultarProximoId(){
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author salas
 */
public class CtrlPaciente {

    
    
    public CtrlPaciente() {

    }

    public LinkedList<Paciente> listarPacientes(String campo, String valor) {
        LinkedList<Paciente> pacientes = new LinkedList<>();
        Conn conn = new Conn();
        ResultSet resultSet = null;
        if(campo.equals("cc")){
            resultSet = conn.consultar("select * from pacientes where cc = "+valor+";");
        }
        else if(campo.equals("nombre")){
            resultSet = conn.consultar("select * from pacientes where lower(nombre) like lower('%"+valor+"%');");
        }
        try {
            while(resultSet.next()){
                Paciente p= new Paciente();
                p.setCc(resultSet.getInt("cc"));
                p.setNombre(resultSet.getString("nombre"));
                p.setFechanac(resultSet.getString("fechanac"));
                p.setSexo(resultSet.getString("fechanac"));
                p.setTel(resultSet.getInt("tel"));
                p.setDirecc(resultSet.getString("direcc"));
                p.setCelular(resultSet.getLong("celular"));
                p.setEmail(resultSet.getString("email"));
                p.setOcup(resultSet.getString("ocup"));
                p.setObserv(resultSet.getString("observ"));
                p.setMas(resultSet.getString("mas"));
                p.setEdad(consultarEdad(p.getCc()));
                pacientes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.listarPacientes = " + ex.getMessage());
        }
        return pacientes;
    }
    
    public int consultarEdad(int cc){
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("SELECT (current_date -fechanac)/365 as edad FROM pacientes WHERE cc = "+cc);
        try {
            while(resultSet.next()){
                return resultSet.getInt("edad");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.consultarEdad = " + ex.getMessage());
        }
        return -1;
    }
}

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

    public LinkedList<Paciente> listar(String campo, String valor) {
        LinkedList<Paciente> pacientes = new LinkedList();
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
                p.setSexo(resultSet.getString("sexo"));
                p.setTel(resultSet.getInt("tel"));
                p.setDirecc(resultSet.getString("direcc"));
                p.setCelular(resultSet.getLong("celular"));
                p.setEmail(resultSet.getString("email"));
                p.setOcup(resultSet.getString("ocup"));
                p.setObserv(resultSet.getString("observ"));
                p.setMas(resultSet.getString("mas"));
                pacientes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.listar = " + ex.getMessage());
        }
        conn.cerrar();
        return pacientes;
    }
    
    public int consultarEdad(int cc){
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("SELECT (current_date -fechanac)/365 as edad FROM pacientes WHERE cc = "+cc);
        int edad=-1;
        try {
            while(resultSet.next()){
                edad= resultSet.getInt("edad");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.consultarEdad = " + ex.getMessage());
        }
        conn.cerrar();
        return edad;
    }
    
    public LinkedList<Paciente> listarTodos(){
        LinkedList<Paciente> pacientes = new LinkedList();
        Conn conn = new Conn();
        ResultSet resultSet = null;        
            resultSet = conn.consultar("select * from pacientes;");
        try {
            while(resultSet.next()){
                Paciente p= new Paciente();
                p.setCc(resultSet.getInt("cc"));
                p.setNombre(resultSet.getString("nombre"));
                p.setFechanac(resultSet.getString("fechanac"));
                p.setSexo(resultSet.getString("sexo"));
                p.setTel(resultSet.getInt("tel"));
                p.setDirecc(resultSet.getString("direcc"));
                p.setCelular(resultSet.getLong("celular"));
                p.setEmail(resultSet.getString("email"));
                p.setOcup(resultSet.getString("ocup"));
                p.setObserv(resultSet.getString("observ"));
                p.setMas(resultSet.getString("mas"));
                pacientes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.listarTodos = " + ex.getMessage());
        }
        conn.cerrar();
        return pacientes;
    }
    
    public String consultarFuc(int cc){
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("select fecha from historias where cc_paciente="+cc+" order by fecha desc limit 1;");
        String fuc="No tiene";
        try {
            while(resultSet.next()){
                fuc= resultSet.getString("fecha");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.consultarFuc = " + ex.getMessage());
        }
        conn.cerrar();
        return fuc;
    }
}

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

    public LinkedList<Paciente> listarTodos() {
        LinkedList<Paciente> pacientes = new LinkedList();
        Conn conn = new Conn();
        ResultSet resultSet = null;
        resultSet = conn.consultar("select * from pacientes;");
        try {
            while (resultSet.next()) {
                Paciente p = new Paciente();
                p.setCc(resultSet.getLong("cc"));
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

    public LinkedList<Paciente> listar(String campo, String valor) {
        LinkedList<Paciente> pacientes = new LinkedList();
        Conn conn = new Conn();
        ResultSet resultSet = null;
        if (campo.equals("cc")) {
            resultSet = conn.consultar("select * from pacientes where cc = " + valor + ";");
        } else if (campo.equals("nombre")) {
            resultSet = conn.consultar("select * from pacientes where lower(nombre) like lower('%" + valor + "%');");
        }
        try {
            while (resultSet.next()) {
                Paciente p = new Paciente();
                p.setCc(resultSet.getLong("cc"));
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

    public Paciente consultar(Long cc) {
        Paciente paciente = new Paciente();
        Conn conn = new Conn();
        ResultSet resultSet = null;
        resultSet = conn.consultar("select * from pacientes where cc = " + cc + ";");
        try {
            while (resultSet.next()) {
                paciente.setCc(resultSet.getLong("cc"));
                paciente.setNombre(resultSet.getString("nombre"));
                paciente.setFechanac(resultSet.getString("fechanac"));
                paciente.setSexo(resultSet.getString("sexo"));
                paciente.setTel(resultSet.getInt("tel"));
                paciente.setDirecc(resultSet.getString("direcc"));
                paciente.setCelular(resultSet.getLong("celular"));
                paciente.setEmail(resultSet.getString("email"));
                paciente.setOcup(resultSet.getString("ocup"));
                paciente.setObserv(resultSet.getString("observ"));
                paciente.setMas(resultSet.getString("mas"));
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.consultar = " + ex.getMessage());
        }
        conn.cerrar();
        return paciente;
    }

    public int consultarEdad(Long cc) {
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("select (current_date -fechanac)/365 as edad from pacientes where cc = " + cc);
        int edad = -1;
        try {
            while (resultSet.next()) {
                edad = resultSet.getInt("edad");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.consultarEdad = " + ex.getMessage());
        }
        conn.cerrar();
        return edad;
    }

    public String consultarFuc(Long cc) {
        Conn conn = new Conn();
        ResultSet resultSet = conn.consultar("select fecha from historias where cc_paciente=" + cc + " order by fecha desc limit 1;");
        String fuc = "No tiene";
        try {
            while (resultSet.next()) {
                fuc = resultSet.getString("fecha");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción método CtrlPaciente.consultarFuc = " + ex.getMessage());
        }
        conn.cerrar();
        return fuc;
    }

    public String actualizar(Long ccVieja, Paciente nuevoPaciente) {
        Conn conn = new Conn();
        String res = conn.actualizar("update pacientes SET nombre='" + nuevoPaciente.getNombre() + "', "
                + "cc=" + nuevoPaciente.getCc() + ", "
                + "fechanac='" + nuevoPaciente.getFechanac() + "', "
                + "sexo='" + nuevoPaciente.getSexo() + "', "
                + "tel=" + nuevoPaciente.getTel() + ", "
                + "direcc='" + nuevoPaciente.getDirecc() + "', "
                + "celular=" + nuevoPaciente.getCelular() + ", "
                + "email='" + nuevoPaciente.getEmail() + "', "
                + "ocup='" + nuevoPaciente.getOcup() + "', "
                + "observ='" + nuevoPaciente.getObserv() + "', "
                + "mas='" + nuevoPaciente.getMas() + "' "
                + "where cc=" + ccVieja + ";");
        conn.cerrar();
        return res;
    }

    public String crear(Paciente paciente) {
        Conn conn = new Conn();
        String res=conn.insertar("insert into pacientes values "
                + "(" + paciente.getCc() + ", "
                + "'" + paciente.getNombre() + "', "
                + "'" + paciente.getFechanac() + "', "
                + "'" + paciente.getSexo() + "', "
                + paciente.getTel() + ", "
                + "'" + paciente.getDirecc() + "', "
                + paciente.getCelular() + ", "
                + "'" + paciente.getEmail() + "', "
                + "'" + paciente.getOcup() + "', "
                + "'" + paciente.getObserv() + "', "
                + "'" + paciente.getMas() + "');");
        conn.cerrar();
        return res;
    }
    
    public LinkedList<Paciente> listarCumpleanos(){
        LinkedList<Paciente> pacientes = new LinkedList();
        Conn conn = new Conn();
        ResultSet resultSet = null;
            resultSet = conn.consultar("select *, date_part('year', current_date)-date_part('year', fechanac) from pacientes where date_part('month', fechanac)=date_part('month', current_date) and date_part('day', fechanac)=date_part('day', current_date);");
        try {
            while (resultSet.next()) {
                Paciente p = new Paciente();
                p.setCc(resultSet.getLong("cc"));
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
}

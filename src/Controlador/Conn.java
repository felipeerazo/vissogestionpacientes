/**
 * Clase que funciona para conectar con BD
 * @author Felipe Erazo Guerrero
 */
package Controlador;

import java.io.Serializable;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Conn implements Serializable {

    ResultSet resultSet;
    private Connection conn;
    Statement st;
    String driver;
    String url;
    String userDB;
    String passDB;
    
    public Conn() {
        resultSet = null;
        conn = null;
        st = null;
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/v6.1";
        userDB = "postgres";
        passDB = "admin";
        conectar();
    }

    public int conectar() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver :(. "+e.getMessage());
            return -1;
        }
        try {
            conn = DriverManager.getConnection(url, userDB, passDB);
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la conexion :(. "+e.getMessage());
            return -2;
        }
        return 1;
    }

    public void insertar2(String sql) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pipe", "postgres", "admin");
            CallableStatement cs = con.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                System.out.println((new StringBuilder()).append("valor").append(rs.getInt(1)).toString());
            }
        } catch (Exception e) {
            System.out.println("fallo conexion ");
            e.printStackTrace();
        }
    }

    public String insertar(String sql) {
        try {
            st = getConn().createStatement();
            st.execute(sql);
            st.close();
            return "";
        } catch (SQLException e) {
            return e.toString();
        }
    }

    public ResultSet consultar(String sql) {
        try {
            st = getConn().createStatement();
            resultSet = st.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
        return resultSet;
    }

    public int verificar(String sql) throws SQLException {
        st = getConn().createStatement();
        resultSet = st.executeQuery(sql);
        if (resultSet.next()) {
            return 1;
        }
        try {
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public String actualizar(String sql) {
        try {
            st = getConn().createStatement();
            st.executeUpdate(sql);
            st.close();
            return "1";
        } catch (SQLException e) {
            return e.toString();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public LinkedList reporteSQL(String sql) {
        LinkedList sb = new LinkedList();
        try {
            st = getConn().createStatement();
            for (resultSet = st.executeQuery(sql); resultSet.next();) {
                int x = 1;
                while (resultSet.getMetaData().getColumnCount() >= x) {
                    sb.add(resultSet.getString(x));
                    x++;
                }
            }

        } catch (SQLException e) {
            System.out.println((new StringBuilder()).append("error en metodo reporteSQL: ").append(e).toString());
        }
        return sb;
    }

    public void guardarRegistros(String ruta) {
        try {
            st = getConn().createStatement();
            st.execute((new StringBuilder()).append("COPY (select 'insert into pacientes values('||cc||', '''||nombre||''', '''||fechanac||''', '''||sexo||''', '''||tel||''', '''||direcc||''', '''||celular||''', '''||email||''', '''||ocup  ||''', '''||observ||''', '''||mas||''');' as a from pacientes union select 'insert into historias values('||historia_id||', '||cc_paciente||', '''||fecha||''', '''||tipo||''', '''||acomp||''', '''||parentesco||''', '''||tel||''', '''||motivo||''', '''||antec||''', '''||sc_vl_d ||''', '''||sc_vl_i||''', '''||vp||''', '''||cc_vl_d||''', '''||cc_vl_i||''', '''||vp2||''', '''||ph_d||''', '''||ph_i||''', '''||rx_d||''', '''||rx_i||''', '''||rx_add||''', '''||db_d||''', '''||db_i||''', '''||pio_d||''', '''||pio_i||''', '''||dfo_d||''', '''||dfo_i||''', '''||cvt_vl||''', '''||cvt_vp||''', '''||cvt_ppc||''', '''||q_d||''', '''||q_i||''', '''||refr_d||''', '''||refr_i||''', '''||av_d||''', '''||av_i||''', '''||subjetivo_d||''', '''||subjetivo_i||''', '''||add_d||''', '''||add_i||''', '''||avcc_d||''', '''||avcc_i||''', '''||prescrip_f_d||''', '''||prescrip_f_i||''', '''||add_f_d||''', '''||add_f_i||''', '''||av_vl_d||''', '''||av_vl_i||''', '''||av_vp_d||''', '''||av_vp_i||''', '''||dp||''', '''||ao||''', '''||tipo_lente||''', '''||uso||''', '''||test_color||''', '''||test_profund||''', '''||diagnostico||''', '''||codg_rips||''', '''||conducta||''', '''||control||''', '''||observaciones||''');' from historias union select 'insert into minicontroles values('||minicontrol_id||', '||cc_paciente||', '''||fecha||''', '''||motivo||''', '''||observaciones||''');' from minicontroles order by a desc) TO '").append(ruta).append("';").toString());
            st.close();
            JOptionPane.showMessageDialog(null, "La copia de seguridad finaliz\363 sin errores.", "Guardado correctamente", 1);
        } catch (SQLException e) {
            System.out.println((new StringBuilder()).append("Error en el m\351todo guardarRegistros(): ").append(e).toString());
            JOptionPane.showMessageDialog(null, (new StringBuilder()).append("Se produjo un error y no fue posible realizar la copia de seguridad.\n").append(e).toString(), "Error al guardar", 0);
        }
    }

    public void ejecutar(String sql) {
        try {
            st = getConn().createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println((new StringBuilder()).append("Error en el m\351todo ejecutar(): ").append(sql).toString());
            JOptionPane.showMessageDialog(null, "Se produjo un error y no se ejecut\363 la orden.", "Error al ejecutar", 0);
        }
    }

    public void restaurar(String sql) {
        try {
            st = getConn().createStatement();
            st.execute((new StringBuilder()).append(sql).append("commit;").toString());
            st.close();
            JOptionPane.showMessageDialog(null, "La base de datos fu\351 restaurada sin errores.", "Completo", 1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error al Restaurar", 0);
        }
    }
    
}

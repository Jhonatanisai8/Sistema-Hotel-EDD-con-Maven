package org.jhonatan.app.Logica;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.InterfacesDao.TrabajadorDao;
import org.jhonatan.app.Datos.Trabajador;
import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class TrabajadorImple implements TrabajadorDao {
//instacion de la conexion;

    Conexion conexion = Conexion.getInstancia();
    private String sql = "";
    private String sql2 = "";
    public int totalRegistros;

    @Override
    public DefaultTableModel mostrarTrabajadores(String buscar) {
        Connection conex = conexion.conectarBD();
        DefaultTableModel modelo;
        String[] cabezera = {"ID", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "DOC", "Nº. DOC", "DIRECCIÓN", "TELÉFONO", "EMAIL", "SUELDO", "ACCESO", "LOGIN", "PASSWORD", "ESTADO"};
        String[] registros = new String[cabezera.length];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, cabezera);

        //consulta
        sql = "SELECT p.idpersona,"
                + "p.nombre,"
                + "p.apateno,"
                + "p.amaterno,"
                + "p.tipo_documento,"
                + "p.num_documento,"
                + "p.direccion,"
                + "p.telefono,"
                + "p.email,"
                + "t.sueldo,"
                + "t.acceso,"
                + "t.login,"
                + "t.password,"
                + "t.estado "
                + " FROM persona p INNER JOIN trabajador t "
                + " ON p.idpersona = t.idpersona WHERE num_documento like '%" + buscar + "%' ORDER BY idpersona DESC";

        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //recorremos los registros
            while (rs.next()) {
                registros[0] = rs.getString("idpersona");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apateno");
                registros[3] = rs.getString("amaterno");
                registros[4] = rs.getString("tipo_documento");
                registros[5] = rs.getString("num_documento");
                registros[6] = rs.getString("direccion");
                registros[7] = rs.getString("telefono");
                registros[8] = rs.getString("email");

                registros[9] = rs.getString("sueldo");
                registros[10] = rs.getString("acceso");
                registros[11] = rs.getString("login");
                registros[12] = rs.getString("password");
                registros[13] = rs.getString("estado");

                totalRegistros++;
                modelo.addRow(registros);
            }
            // conexion.desconectarBD();
            return modelo;
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos de la tabla trabahajador; " + e.toString());
            return null;
        } finally {
            try {
                conexion.desconectarBD();
            } catch (SQLException ex) {
                System.out.println("Error la cerrar la conexion en el metodo mostrar trabajadores");
            }
        }
    }

    @Override
    public void insertarTrabajador(Trabajador trabajador) {
    }

    @Override
    public void modificarTrabajador(Trabajador trabajador) {
    }

    @Override
    public void eliminarTrabajador(Trabajador trabajador) {
    }

}

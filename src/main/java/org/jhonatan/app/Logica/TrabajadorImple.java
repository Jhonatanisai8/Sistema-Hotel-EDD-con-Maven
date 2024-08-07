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
        sql = "INSERT INTO persona"
                + " (nombre,apateno,amaterno,tipo_documento,num_documento,direccion,telefono,email)"
                + "  VALUES (?,?,?,?,?,?,?,?)";
        sql2 = "INSERT INTO trabajador (idpersona,sueldo,acceso,login,password,estado)"
                + "VALUES ((SELECT idpersona FROM persona ORDER BY idpersona DESC LIMIT 1),?,?,?,?,?)";
        try {
            Connection conex = conexion.conectarBD();

            PreparedStatement pst = conex.prepareStatement(sql);
            PreparedStatement pst2 = conex.prepareStatement(sql2);

            //insertamos
            pst.setString(1, trabajador.getNombre());
            pst.setString(2, trabajador.getAppPaterno());
            pst.setString(3, trabajador.getAppMaterno());
            pst.setString(4, trabajador.getTipoDocumento());
            pst.setString(5, trabajador.getNumeroDocumento());
            pst.setString(6, trabajador.getDireccion());
            pst.setString(7, trabajador.getTelefono());
            pst.setString(8, trabajador.getEmail());

            //para la segunda consulta
            pst2.setDouble(1, trabajador.getSueldo());
            pst2.setString(2, trabajador.getAcceso());
            pst2.setString(3, trabajador.getLogin());
            pst2.setString(4, trabajador.getPassword());
            pst2.setString(5, trabajador.getEstado());

            //ejecutamos
            pst.executeUpdate();
            pst2.executeUpdate();

            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al insertar trabajador: "
                    + e.toString());
        }
    }

    @Override
    public void modificarTrabajador(Trabajador trabajador) {
        sql = "UPDATE persona "
                + "SET nombre = ?,"
                + "apateno = ?,"
                + "amaterno = ?,"
                + "tipo_documento = ?,"
                + "num_documento = ?,"
                + "direccion = ?, "
                + "telefono = ?,"
                + "email = ?"
                + " WHERE idpersona = ?";

        sql2 = "UPDATE trabajador "
                + "SET sueldo = ?, acceso = ?, login = ?, password = ?, estado = ? WHERE idpersona = ?";
        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);
            PreparedStatement pst2 = conex.prepareStatement(sql2);

            //insertamos
            pst.setString(1, trabajador.getNombre());
            pst.setString(2, trabajador.getAppPaterno());
            pst.setString(3, trabajador.getAppMaterno());
            pst.setString(4, trabajador.getTipoDocumento());
            pst.setString(5, trabajador.getNumeroDocumento());
            pst.setString(6, trabajador.getDireccion());
            pst.setString(7, trabajador.getTelefono());
            pst.setString(8, trabajador.getEmail());
            pst.setInt(9, trabajador.getIdPersona());

            //para la segunda consulta
            pst2.setDouble(1, trabajador.getSueldo());
            pst2.setString(2, trabajador.getAcceso());
            pst2.setString(3, trabajador.getLogin());
            pst2.setString(4, trabajador.getPassword());
            pst2.setString(5, trabajador.getEstado());
            pst2.setInt(6, trabajador.getIdPersona());

            //ejecutamos
            pst.executeUpdate();
            pst2.executeUpdate();
            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al modificar trabajador: " + e.toString());
        }
    }

    @Override
    public void eliminarTrabajador(Trabajador trabajador) {
        //consulta
        sql = "DELETE from trabajador WHERE idpersona = ?";
        sql2 = "DELETE from trabajador WHERE idpersona = ?";

        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);
            PreparedStatement pst2 = conex.prepareStatement(sql2);

            //eliminamos
            pst.setInt(1, trabajador.getIdPersona());
            pst2.setInt(1, trabajador.getIdPersona());

            pst.executeUpdate();
            pst2.executeUpdate();

            conexion.desconectarBD();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.toString());
        }
    }

    @Override
    public DefaultTableModel login(String login, String password) {
        Connection conex = conexion.conectarBD();
        DefaultTableModel modelo;
        String[] cabezera = {"ID", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "ACCESO", "LOGIN", "PASSWORD", "ESTADO"};
        String[] registros = new String[cabezera.length];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, cabezera);

        //consulta
        sql = "SELECT p.idpersona,"
                + "p.nombre,"
                + "p.apateno,"
                + "p.amaterno,"
                + "t.acceso, "
                +"t.login,"
                +"t.password,"
                +"t.estado"
                + " FROM persona p INNER JOIN trabajador t "
                + " ON p.idpersona = t.idpersona WHERE t.login = '" + login +"' and t.password = '"+password+"'"
                + " and t.estado = 'A'";

        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //recorremos los registros
            while (rs.next()) {
                registros[0] = rs.getString("idpersona");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apateno");
                registros[3] = rs.getString("amaterno");
                
                registros[4] = rs.getString("acceso");
                registros[5] = rs.getString("login");
                registros[6] = rs.getString("password");
                registros[7] = rs.getString("estado");

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
}

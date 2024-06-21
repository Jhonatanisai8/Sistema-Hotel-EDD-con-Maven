package org.jhonatan.app.Logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.Cliente;
import org.jhonatan.app.Datos.InterfacesDao.ClienteDao;

/**
 *
 * @author Jhonatan
 */
public class ClienteImple implements ClienteDao {

    //instacion de la conexion;
    Conexion conexion = Conexion.getInstancia();
    private String sql = "";
    private String sql2 = "";
    public int totalRegistros;

    @Override
    public DefaultTableModel mostrarClientes(String buscar) {
        Connection conex = conexion.conectarBD();
        DefaultTableModel modelo;
        String[] cabezera = {"ID", "NOMBRE", "AP. PATERNO", "AP. MATERNO", "DOC", "Nº. DOC", "DIRECCIÓN", "TELÉFONO", "EMAIL", "CÓDIGO CLI"};
        String[] registros = new String[10];
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
                + "c.codigo_cliente"
                + " FROM persona p INNER JOIN cliente c "
                + " ON p.idpersona = c.idpersona WHERE num_documento like '%" + buscar + "%' ORDER BY idpersona DESC";

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
                registros[9] = rs.getString("codigo_cliente");

                totalRegistros++;
                modelo.addRow(registros);
            }
            // conexion.desconectarBD();
            return modelo;
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos de la tabla clientes; " + e.toString());
            return null;
        } finally {
            try {
                conexion.desconectarBD();
            } catch (SQLException ex) {
                System.out.println("Error la cerrar la conexion en el metodo mostra productos");
            }
        }
    }

    @Override
    public void insertarCliente(Cliente cliente) {
        sql = "INSERT INTO persona"
                + " (nombre,apateno,amaterno,tipo_documento,num_documento,direccion,telefono,email)"
                + "  VALUES (?,?,?,?,?,?,?,?)";
        sql2 = "INSERT INTO cliente (idpersona,codigo_cliente)"
                + "VALUES ((SELECT idpersona FROM persona ORDER BY idpersona DESC LIMIT 1),?)";
        try {
            Connection conex = conexion.conectarBD();

            PreparedStatement pst = conex.prepareStatement(sql);
            PreparedStatement pst2 = conex.prepareStatement(sql2);

            //insertamos
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getAppPaterno());
            pst.setString(3, cliente.getAppMaterno());
            pst.setString(4, cliente.getTipoDocumento());
            pst.setString(5, cliente.getNumeroDocumento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());

            //para la segunda consulta
            pst2.setString(1, cliente.getCodigoCliente());
            //ejecutamos
            pst.executeUpdate();
            pst2.executeUpdate();

            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: "
                    + e.toString());
        }
    }

    @Override
    public void modificarCliente(Cliente cliente) {
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

        sql2 = "UPDATE cliente "
                + "SET codigo_cliente = ? WHERE idpersona = ?";
        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);
            PreparedStatement pst2 = conex.prepareStatement(sql2);

            //insertamos
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getAppPaterno());
            pst.setString(3, cliente.getAppMaterno());
            pst.setString(4, cliente.getTipoDocumento());
            pst.setString(5, cliente.getNumeroDocumento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());
            pst.setInt(9, cliente.getIdPersona());

            //para la segunda consulta
            pst2.setString(1, cliente.getCodigoCliente());
            pst2.setInt(2, cliente.getIdPersona());

            //ejecutamos
            pst.executeUpdate();
            pst2.executeUpdate();
            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al modificar cliente: " + e.toString());
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        //consulta
        sql = "DELETE from cliente WHERE idpersona = ?";
        sql2 = "DELETE from persona WHERE idpersona = ?";

        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);
            PreparedStatement pst2 = conex.prepareStatement(sql2);

            //eliminamos
            pst.setInt(1, cliente.getIdPersona());
            pst2.setInt(1, cliente.getIdPersona());

            pst.executeUpdate();
            pst2.executeUpdate();

            conexion.desconectarBD();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente: " + e.toString());
        }
    }

}

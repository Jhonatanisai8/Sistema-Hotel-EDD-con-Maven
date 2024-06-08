package org.jhonatan.app.Logica;

import java.sql.Connection;
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
        sql = "SELECT p.idPersona,"
                + "p.nombre,"
                + "p.apaterno,"
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
                registros[0] = rs.getString("idPersona");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apaterno");
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
            conexion.desconectarBD();
            return modelo;
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos de la tabla producto; " + e.toString());
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

    }

    @Override
    public void modificarCliente(Cliente cliente) {

    }

    @Override
    public void eliminarCliente(Cliente cliente) {

    }

}

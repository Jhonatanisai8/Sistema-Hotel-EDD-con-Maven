package org.jhonatan.app.Logica;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.InterfacesDao.ProductoDao;
import org.jhonatan.app.Datos.Producto;
import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class ProductoImplementacion implements ProductoDao {

    //instacion de la conexion;
    Conexion conexion = Conexion.getInstancia();
    private String sql = "";
    private int totalRegistros;

    @Override
    public DefaultTableModel mostrarProductos(String buscar) {
        Connection conex = conexion.conectarBD();
        DefaultTableModel modelo;
        String[] cabezera = {"ID", "PRODUCTO", "DESCRIPCIÓN", "UNIDAD DE MEDIDA", "PRECIO"};
        String[] registros = new String[5];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, cabezera);

        //consulta
        sql = "SELECT * FROM producto WHERE nombre LIKE '%" + buscar + "%' ORDER BY idProducto";

        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //recorremos los registros
            while (rs.next()) {
                registros[0] = rs.getString("idProducto");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("unidad_medida");
                registros[4] = rs.getString("precio_venta");
                totalRegistros++;
                modelo.addRow(registros);
            }
            conexion.desconectarBD();
            return modelo;
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos de la tabla habitacion; " + e.toString());
            return null;
        }
    }

    @Override
    public void insertarProducto(Producto producto) {
    }

    @Override
    public void modificarProducto(Producto producto) {
    }

    @Override
    public void eliminarProducto(Producto producto) {
    }

}

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
    public void insertarProducto(Producto producto) {
        sql = "INSERT INTO producto"
                + " (nombre,descripcion,unidad_medida,precio_venta)"
                + "  VALUES (?,?,?,?)";
        try {
            Connection conex = conexion.conectarBD();

            PreparedStatement pst = conex.prepareStatement(sql);

            //insertamos
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDescripcion());
            pst.setString(3, producto.getUnidadMedida());
            pst.setDouble(4, producto.getPrecioVenta());
            //ejecutamos
            pst.executeUpdate();
            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: "
                    + e.toString());
        }
    }

    @Override
    public void modificarProducto(Producto producto) {
        sql = "UPDATE producto SET nombre = ?,descripcion = ?,"
                + "unidad_medida = ?,precio_venta = ?  WHERE idProducto = ?";
        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);

            //modificamos
            pst.setString(1, producto.getNombre());
            pst.setString(2, producto.getDescripcion());
            pst.setString(3, producto.getUnidadMedida());
            pst.setDouble(4, producto.getPrecioVenta());

            //  conexion.desconectarBD();
            pst.executeUpdate();
            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al modificar producto: " + e.toString());
        }
    }

    @Override
    public void eliminarProducto(Producto producto) {
        sql = "DELETE from producto WHERE idproducto = ?";
        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);

            //eliminamos
            pst.setInt(1, producto.getIdProducto());
            pst.executeUpdate();
            conexion.desconectarBD();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.toString());
        }
    }

}

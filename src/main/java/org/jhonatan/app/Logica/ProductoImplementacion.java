package org.jhonatan.app.Logica;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.InterfacesDao.ProductoDao;
import org.jhonatan.app.Datos.Producto;

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

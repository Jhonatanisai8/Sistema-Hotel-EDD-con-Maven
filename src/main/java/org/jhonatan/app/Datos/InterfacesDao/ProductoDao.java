package org.jhonatan.app.Datos.InterfacesDao;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.Producto;

/**
 *
 * @author Jhonatan
 */
public interface ProductoDao {

    //métodos
    public DefaultTableModel mostrarProductos(String buscar);

    public void insertarProducto(Producto producto);

    public void modificarProducto(Producto producto);

    public void eliminarProducto(Producto producto);

}

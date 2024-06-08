package org.jhonatan.app.Datos.InterfacesDao;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.Cliente;

/**
 *
 * @author Jhonatan
 */
public interface ClienteDao {
    //métodos

    public DefaultTableModel mostrarClientes(String buscar);

    public void insertarCliente(Cliente cliente);

    public void modificarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

}

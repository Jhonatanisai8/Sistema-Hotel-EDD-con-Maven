package org.jhonatan.app.Datos.InterfacesDao;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.Trabajador;

/**
 *
 * @author Jhonatan
 */
public interface TrabajadorDao {
    //métodos

    public DefaultTableModel mostrarTrabajadores(String buscar);

    public void insertarTrabajador(Trabajador trabajador);

    public void modificarTrabajador(Trabajador trabajador);

    public void eliminarTrabajador(Trabajador trabajador);

    public DefaultTableModel login(String login, String password);
}

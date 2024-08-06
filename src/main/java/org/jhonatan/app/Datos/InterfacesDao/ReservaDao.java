package org.jhonatan.app.Datos.InterfacesDao;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.Reserva;

public interface ReservaDao {

    //métodos
    public DefaultTableModel mostrarReservas(String buscar);

    public void insertarReserva(Reserva reserva);

    public void modificarReserva(Reserva reserva);

    public void eliminarReserva(Reserva reserva);

}

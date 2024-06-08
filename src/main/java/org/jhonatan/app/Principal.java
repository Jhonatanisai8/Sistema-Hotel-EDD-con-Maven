package org.jhonatan.app;

import org.jhonatan.app.Presentacion.frmHabitacion;
import org.jhonatan.app.Presentacion.frmProductos;

/**
 *
 * @author Jhonaatan
 */
public class Principal {

    public static void main(String[] args) {
        //formularioHabitaciones();
        formularioProductos();
    }

    public static void formularioProductos() {
        frmProductos ventanaRegistro = new frmProductos();
        ventanaRegistro.setVisible(true);
    }

    public static void formularioHabitaciones() {
        frmHabitacion habitacion = new frmHabitacion();
        habitacion.setVisible(true);
    }
}

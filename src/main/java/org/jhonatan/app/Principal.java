package org.jhonatan.app;

import org.jhonatan.app.Presentacion.frmClientes;
import org.jhonatan.app.Presentacion.frmHabitacion;
import org.jhonatan.app.Presentacion.frmInicio;
import org.jhonatan.app.Presentacion.frmLoginUsuario;
import org.jhonatan.app.Presentacion.frmProductos;
import org.jhonatan.app.Presentacion.frmTrabajador;

/**
 *
 * @author Jhonaatan
 */
public class Principal {

    public static void main(String[] args) {
        //formularioHabitaciones();
        //formularioProductos();
        //formularioClientes();
        //formularioTrabajador();
        frmInicioa();
        //frmlogin();
    }

    public static void frmlogin() {
        frmLoginUsuario e = new frmLoginUsuario();
        e.setVisible(true);
    }

    public static void frmInicioa() {
        frmInicio d = new frmInicio();
        d.setVisible(true);
    }

    public static void formularioProductos() {
        frmProductos ventanaRegistro = new frmProductos();
        ventanaRegistro.setVisible(true);
    }

    public static void formularioHabitaciones() {
        frmHabitacion habitacion = new frmHabitacion();
        habitacion.setVisible(true);
    }

    public static void formularioClientes() {
        frmClientes clientes = new frmClientes();
        clientes.setVisible(true);
    }

    public static void formularioTrabajador() {
        frmTrabajador d = new frmTrabajador();
        d.setVisible(true);
    }
}

package org.jhonatan.app.Logica;

import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class FHabitacion {

    Conexion conexion = Conexion.getInstancia();
    private Connection conex = conexion.conectarBD();
    private String sql = "";

    public int totalRegistros;
    
    
}

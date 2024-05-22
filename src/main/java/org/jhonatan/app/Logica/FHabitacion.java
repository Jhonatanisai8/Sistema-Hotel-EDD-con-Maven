package org.jhonatan.app.Logica;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jhonatan
 */
public class FHabitacion {

    Conexion conexion = Conexion.getInstancia();
    private Connection conex = conexion.conectarBD();
    private String sql = "";

    public int totalRegistros;

    //funciones
    public DefaultTableModel mostrarDatos(String buscar) {
        DefaultTableModel modelo;
        String[] cabezera = {"ID", "NÚMERO", "PISO", "DESCRIPCIÓN", "CARACTERISTICAS", "PRECIO DIARIO", "ESTADO", "TIPO DE HABITACIÓN"};
        String[] registros = new String[8];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, cabezera);

        //consulta
        sql = "SELECT * FROM habitacion WHERE piso LIKE '%" + buscar + "'% ORDER BY idhabitacion";

        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //recorremos los registros
            while (rs.next()) {
                registros[0] = rs.getString("idhabitacion");
                registros[1] = rs.getString("numero");
                registros[2] = rs.getString("piso");
                registros[3] = rs.getString("descripcion");
                registros[4] = rs.getString("caracteristicas");
                registros[5] = rs.getString("precio_diario");
                registros[6] = rs.getString("estado");
                registros[7] = rs.getString("tipo_habitacion");
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

}

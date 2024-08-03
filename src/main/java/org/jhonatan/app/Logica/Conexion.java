package org.jhonatan.app.Logica;

import java.sql.*;

/**
 *
 * @author Jhonatan
 */
public class Conexion {

    private Conexion() {

    }

    private static Connection conexion;
    private static Conexion instancia;

    private static final String baseDatos = "BASERESERVA";

    //creadenciales
    private static final String URL = "jdbc:mysql://localhost:3306/" + baseDatos + "?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    //METODO PARA CONECTRANOS
    public Connection conectarBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.toString());
        }
        return conexion;
    }

    public void desconectarBD() throws SQLException {
        try {
            conexion.close();
            System.out.println("Desconectado");
        } catch (SQLException e) {
            conexion.close();
            System.out.println("Error al desconectar: " + e.toString());
        } finally {
            conexion.close();
        }
    }

    //PATRON SINGLETON
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}

package org.jhonatan.app.Logica;

import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.Producto;
import java.sql.*;
import org.jhonatan.app.Datos.InterfacesDao.ReservaDao;
import org.jhonatan.app.Datos.Reserva;

/**
 *
 * @author Jhonatan
 */
public class ReservaImplementacion implements ReservaDao {

    //instacion de la conexion;
    Conexion conexion = Conexion.getInstancia();
    private String sql = "";
    public int totalRegistros;

    @Override
    public DefaultTableModel mostrarReservas(String buscar) {
        Connection conex = conexion.conectarBD();
        DefaultTableModel modelo;
        String[] cabezera = {"ID-R", "ID-H", "NUMERO", "ID-C", "CLIENTE",
            "ID-T", "TIPO RESERVA", "F-RESERVA", "F-INGRESO", "F-SALIDA",
            "C-ALOJAMIENTO", "ESTADO"};
        String[] registros = new String[cabezera.length];
        totalRegistros = 0;

        modelo = new DefaultTableModel(null, cabezera);

        //consulta y dentro de ellas hay sub consultas
        sql = "SELECT r. FROM reserva"
                + " r.idreserva,"
                + "r.idhabitacion,"
                + "h.numero, "
                + "r.idcliente,"
                + " (SELECT nombre FROM persona WHERE idpersona = r.idcliente ) AS clienten , "
                + " (SELECT apateno FROM persona WHERE idpersona = r.idcliente ) AS clientAP ,"
                + " r.idtrabajador, "
                + " (SELECT nombre FROM persona WHERE idpersona = r.idtrabajador) AS trabajadorn, "
                + "  (SELECT apateno FROM persona WHERE idpersona = r.idtrabajador) AS trabajadorap, "
                + " r.tipo_reserva,"
                + " r.fecha_reserva, "
                + " r.fecha_ingresa, "
                + " r.fecha_salida, "
                + " r.costo_alojamiento,"
                + " r.estado "
                + "INNER JOIN habitacion h ON r.idhabitacion = h.idhabitacion WHERE tipo_reserva LIKE '%" + buscar + "%' ORDER BY idreserva DESC";

        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //recorremos los registros
            while (rs.next()) {
                registros[0] = rs.getString("idreserva");
                registros[1] = rs.getString("idhabitacion");
                registros[2] = rs.getString("numero");
                registros[3] = rs.getString("idcliente");
                registros[4] = rs.getString("clienten") + " " + rs.getString("clientAP");

                registros[5] = rs.getString("idtrabajador");
                registros[6] = rs.getString("trabajadorn ") + " " + rs.getString("trabajadorap");
                registros[7] = rs.getString("tipo_reserva");
                registros[8] = rs.getString("fecha_reserva");
                registros[9] = rs.getString("fecha_ingresa");
                registros[10] = rs.getString("fecha_salida");

                registros[11] = rs.getString("costo_alojamiento");
                registros[12] = rs.getString("estado");

                totalRegistros++;
                modelo.addRow(registros);
            }
            conexion.desconectarBD();
            return modelo;
        } catch (SQLException e) {
            System.out.println("Error al mostrar datos de la tabla reserva; " + e.toString());
            return null;
        } finally {
            try {
                conexion.desconectarBD();
            } catch (SQLException ex) {
                System.out.println("Error la cerrar la conexion en el metodo mostra reservas");
            }
        }
    }

    @Override
    public void insertarReserva(Reserva reserva) {
        sql = "INSERT INTO reserva "
                + "(idhabitacion,idcliente,idtrabajador,tipo_reserva,fecha_reserva,fecha_ingresa,fecha_salida,costo_alojamiento,estado) "
                + "(?,?,?,?,?,?,?,?,?)";
        try {
            Connection conex = conexion.conectarBD();

            PreparedStatement pst = conex.prepareStatement(sql);

            //insertamos
            pst.setInt(1, reserva.getIdHabitacion());
            pst.setInt(2, reserva.getIdCliente());
            pst.setInt(3, reserva.getIdTrabajador());
            pst.setString(4, reserva.getTipoReserva());
            pst.setDate(5, reserva.getFechaReserva());
            pst.setDate(6, reserva.getFechaIngreso());
            pst.setDate(7, reserva.getFechaSalida());
            pst.setDouble(8, reserva.getCostoAlojamiento());
            pst.setString(9, reserva.getEstado());

            //ejecutamos
            pst.executeUpdate();
            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al insertar reserva: "
                    + e.toString());
        }
    }

    @Override
    public void modificarReserva(Reserva reserva) {
        sql = "UPDATE reserva SET idhabitacion = ?, idcliente = ?, idtrabajador = ?,"
                + "tipo_reserva = ?, fecha_reserva = ?, fecha_ingresa = ?, fecha_salida = ?,"
                + " costo_alojamiento = ?, estado = ? WHERE idreserva = ?";
        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);

            //modificamos
            pst.setInt(1, reserva.getIdHabitacion());
            pst.setInt(2, reserva.getIdCliente());
            pst.setInt(3, reserva.getIdTrabajador());
            pst.setString(4, reserva.getTipoReserva());
            pst.setDate(5, reserva.getFechaReserva());
            pst.setDate(6, reserva.getFechaIngreso());
            pst.setDate(7, reserva.getFechaSalida());
            pst.setDouble(8, reserva.getCostoAlojamiento());
            pst.setString(9, reserva.getEstado());

            pst.setInt(10, reserva.getIdReserva());

            //  conexion.desconectarBD();
            pst.executeUpdate();
            conexion.desconectarBD();
        } catch (SQLException e) {
            System.out.println("Error al modificar reserva: " + e.getMessage());
        }
    }

    @Override
    public void eliminarReserva(Reserva reserva) {
        sql = "DELETE from reserva WHERE idreserva = ?";
        try {
            Connection conex = conexion.conectarBD();
            PreparedStatement pst = conex.prepareStatement(sql);

            //eliminamos
            pst.setInt(1, reserva.getIdReserva());
            pst.executeUpdate();
            conexion.desconectarBD();

        } catch (SQLException e) {
            System.out.println("Error al eliminar la reserva: " + e.getMessage());
        }
    }

}

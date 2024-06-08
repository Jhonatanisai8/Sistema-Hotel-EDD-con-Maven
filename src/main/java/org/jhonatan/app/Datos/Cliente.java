package org.jhonatan.app.Datos;

/**
 *
 * @author Jhonatan
 */

//clase hija de persona
public class Cliente extends Persona {

    private String codigoCliente;

    public Cliente() {
    }

    public Cliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

}

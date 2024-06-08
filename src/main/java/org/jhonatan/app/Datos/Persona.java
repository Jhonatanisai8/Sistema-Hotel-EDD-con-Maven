package org.jhonatan.app.Datos;

/**
 *
 * @author jhonatan
 */
public class Persona {

    //atributos
    private int idPersona;
    private String nombre;
    private String appPaterno;
    private String appMaterno;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private String telefono;
    private String email;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String appPaterno, String appMaterno, String tipoDocumento, String numeroDocumento, String direccion, String telefono, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.appPaterno = appPaterno;
        this.appMaterno = appMaterno;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

}

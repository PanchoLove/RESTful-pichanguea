package principal.equipo;

import java.util.Date;

public class Equipo {

    int id ;
    String nombre;
    //byte[] escudo
    String descripcion;
    String url;
    String email;
    String contacto;
    String contactoFono;
    String contactoCelular;
    String contactoMail;
    Date creacion;

    public Equipo(){}

    public Equipo(int id, String nombre, String descripcion, String url, String email, String contacto, String contactoFono, String contactoCelular, String contactoMail, Date creacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.email = email;
        this.contacto = contacto;
        this.contactoFono = contactoFono;
        this.contactoCelular = contactoCelular;
        this.contactoMail = contactoMail;
        this.creacion = creacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }

    public String getContacto() {
        return contacto;
    }

    public String getContactoFono() {
        return contactoFono;
    }

    public String getContactoCelular() {
        return contactoCelular;
    }

    public String getContactoMail() {
        return contactoMail;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setContactoFono(String contactoFono) {
        this.contactoFono = contactoFono;
    }

    public void setContactoCelular(String contactoCelular) {
        this.contactoCelular = contactoCelular;
    }

    public void setContactoMail(String contactoMail) {
        this.contactoMail = contactoMail;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
}

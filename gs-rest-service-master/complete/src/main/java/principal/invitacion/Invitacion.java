package principal.invitacion;

import java.util.Date;

public class Invitacion {

    //int id ;
    int idEquipo;
    int idJugador;
    String estado;
    String creacion;
    String modificacion;

    public Invitacion(int idEquipo, int idJugador, String estado, String creacion, String modificacion) {
        this.idEquipo = idEquipo;
        this.idJugador = idJugador;
        this.estado = estado;
        this.creacion = creacion;
        this.modificacion = modificacion;
    }

    public Invitacion(){}

    public int getIdEquipo() {
        return idEquipo;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public String getEstado() {
        return estado;
    }

    public String getCreacion() {
        return creacion;
    }

    public String getModificacion() {
        return modificacion;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public void setModificacion(String modificacion) {
        this.modificacion = modificacion;
    }
}

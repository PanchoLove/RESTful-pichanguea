package principal.sesion;

import principal.Jugador.Jugador;
import principal.Partido.Partido;
import principal.equipo.Equipo;

import java.util.List;

public class Sesion {
    Jugador usuario;
    List<Equipo> equipos ;
    List<Partido> partidos;
    String token;

    public Sesion(Jugador usuario, List<Equipo> equipos, List<Partido> partidos, String token) {
        this.usuario = usuario;
        this.equipos = equipos;
        this.partidos = partidos;
        this.token = token;
    }

    public Jugador getUsuario() {
        return usuario;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public String getToken() {
        return token;
    }

    public void setUsuario(Jugador usuario) {
        this.usuario = usuario;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

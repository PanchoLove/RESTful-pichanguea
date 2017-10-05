package principal.Partido;

public class Partido {
    int idPartido;
    int idEquipo;
    String fecha;
    String Hora;
    String rival;
    String complejo;
    String cancha;
    String ubicacion;
    String geoReferencia;
    String estado;
    String creacion;


    public Partido(int idPartido, int idEquipo, String fecha, String hora, String rival, String complejo, String cancha, String ubicacion, String geoReferencia, String estado, String creacion) {
        this.idPartido = idPartido;
        this.idEquipo = idEquipo;
        this.fecha = fecha;
        this.Hora = hora;
        this.rival = rival;
        this.complejo = complejo;
        this.cancha = cancha;
        this.ubicacion = ubicacion;
        this.geoReferencia = geoReferencia;
        this.estado = estado;
        this.creacion = creacion;
    }

    public Partido(){}

    public int getIdPartido() {
        return idPartido;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return Hora;
    }

    public String getRival() {
        return rival;
    }

    public String getComplejo() {
        return complejo;
    }

    public String getCancha() {
        return cancha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getGeoReferencia() {
        return geoReferencia;
    }

    public String getEstado() {
        return estado;
    }

    public String getCreacion() {
        return creacion;
    }


    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        Hora = hora;
    }

    public void setRival(String rival) {
        this.rival = rival;
    }

    public void setComplejo(String complejo) {
        this.complejo = complejo;
    }

    public void setCancha(String cancha) {
        this.cancha = cancha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setGeoReferencia(String geoReferencia) {
        this.geoReferencia = geoReferencia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }
}

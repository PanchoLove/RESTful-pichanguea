package principal.Jugador;

public class Jugador {

    private String nombreUsuario;
    private String clave;
    private String rutSinDigito;
    private String rutConDigito;
    private String nombre;
    private String paterno;
    private String materno;
    private String celular;
    private String mail;
    private String apodo;


    public Jugador(String nombreUsuario, String clave, String rutSinDigito, String rutConDigito, String nombre, String paterno, String materno, String celular, String mail, String apodo) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rutSinDigito = rutSinDigito;
        this.rutConDigito = rutConDigito;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.celular = celular;
        this.mail = mail;
        this.apodo = apodo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public String getRutSinDigito() {
        return rutSinDigito;
    }

    public String getRutConDigito() {
        return rutConDigito;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public String getCelular() {
        return celular;
    }

    public String getMail() {
        return mail;
    }

    public String getApodo() {
        return apodo;
    }
}

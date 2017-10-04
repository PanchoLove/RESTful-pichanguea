package principal.Jugador;

public class JugadorToken {
    Jugador jug;
    String token;

    public JugadorToken(Jugador jug, String token) {
        this.jug = jug;
        this.token = token;
    }

    public JugadorToken() {
        this.jug = new Jugador();
        this.token = null;
    }

    public Jugador getJug() {
        return jug;
    }

    public void setJug(Jugador jug) {
        this.jug = jug;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

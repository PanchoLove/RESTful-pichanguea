package principal.Jugador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import principal.Greeting.Greeting;

@RestController
public class ControladorJugador {


    JugadorToken jt = new JugadorToken();
    Jugador jug1 = new Jugador();

    @RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
    public ResponseEntity<JugadorToken> crearUsuario(@RequestBody Jugador jug) {
        //Comprobar datos
        //Mandar solicitud a la BD
        //generar token
        String tok = "123";
        //retornar
        if (true) //si todo sale bien
        {
            jug1 = jug;
            jug1.setClave("***");
            jt.setJug(jug1);
            jt.setToken(tok);
            return new ResponseEntity<JugadorToken>(jt, HttpStatus.CREATED);
        }

        jt.setJug(jug1);
        return new ResponseEntity<JugadorToken>(jt,HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public Jugador crear() {
        //Comprobar datos
        //Mandar solicitud a la BD
        //retornar

        return new Jugador("a","a","a","a","a","a","a","a","a","a");
    }

}



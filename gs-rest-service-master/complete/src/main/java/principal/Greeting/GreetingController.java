package principal.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import principal.Jugador.Jugador;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    Greeting g = new Greeting();

    @RequestMapping(value = "/crearG", method = RequestMethod.POST)
    public ResponseEntity<Greeting> crearG(@RequestBody Greeting jug) {
        g = jug;
        //Comprobar datos
        //Mandar solicitud a la BD
        //retornar
        if (true)
            return new ResponseEntity<Greeting>(g, HttpStatus.CREATED);

        return new ResponseEntity<Greeting>(g,HttpStatus.CREATED);
    }
}

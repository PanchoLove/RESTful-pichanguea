package principal.Jugador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import principal.Greeting.Greeting;
import principal.Retornos.JugadorToken;
import principal.equipo.Test;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControladorJugador {


  JugadorToken jt = new JugadorToken();
  Jugador jug1 = new Jugador();




  @RequestMapping(value = "/crearUsuario", method = RequestMethod.POST)
  public ResponseEntity<JugadorToken> crearUsuario(@RequestBody Jugador jugador) {
    //Comprobar datos
    //Mandar solicitud a la BD
    //generar token
    String tok = "123";
    //retornar
    if (true) //si todo sale bien
    {
      jug1 = jugador;
      jt.setJug(jug1);
      jt.setToken(tok);
      return new ResponseEntity<JugadorToken>(jt, HttpStatus.CREATED);
    }

    jt.setJug(jug1);
    return new ResponseEntity<JugadorToken>(jt,HttpStatus.BAD_REQUEST);
  }

  @RequestMapping(value = "/jugador", method = RequestMethod.POST)
  public JugadorToken crearJugador(@RequestBody Jugador jugador){


    JugadorToken jugtk= new JugadorToken();
    jugtk.setJug(jugador);
    jugtk.setToken("holasoyuntoken:D");
    return jugtk;
  }





  @RequestMapping(value = "/test", method = RequestMethod.POST)
  @ResponseBody public Jugador test(@RequestBody Test t) {
    return jugadorRandomAsNombre(t.getData());
  }


  @RequestMapping(value = "/crear", method = RequestMethod.GET)
  public Jugador crear() {
    //Comprobar datos
    //Mandar solicitud a la BD
    //retornar

    return new Jugador(1,"a","a","a","a","a","a","a","a","a","a");
  }


  /*  @RequestMapping("/jugador")
    public Jugador jugadorPrueba(@RequestParam(value="nombre", defaultValue="no") String name) {
        return jugadorRandom();
    }*/

  /*@RequestMapping("/jugador")
  public ArregloJugadores jugadoresPorNombre(@RequestParam(value="nombre", defaultValue="no") String name) {

    return obtenerJugadorPorNombreBD();
  }*/



  @RequestMapping("/jugadores")
  @ResponseBody public List<Jugador> jugadoresPorNombreOId(@RequestParam(value="nombreJugador", defaultValue="") String nombreJugador ,
                                                        @RequestParam(value="idJugador", defaultValue="-1") int idJugador
                                                        ) {
    if(idJugador==-1){
      if(!(nombreJugador.equals(""))) {
        return jugadoresPorNombreBD(nombreJugador);
      }
      else
        return new ArrayList<Jugador>();
    }
    else{
      ArrayList<Jugador> l= new ArrayList<>();
      l.add(jugadorRandomAsId(idJugador));
      return l;
    }
    //aca va un if de comprobacion y volas
  }

  @RequestMapping("/jugador")
  @ResponseBody Jugador jugadorPorId(@RequestParam(value="idJugador", defaultValue="-1") int idJugador ,
                                    @RequestParam(value ="nombreJugador", defaultValue = "")String nombreJugador){

    if(idJugador==-1 && nombreJugador.equals("")){
      return null;
    }
    if(idJugador!=-1){
    return jugadorPorIdBD(idJugador);}
    else{return  jugadorRandomAsNombre(nombreJugador);}
  }





  /********************** supuesta comunicacion con la base de datos****************/



  public List<Jugador> jugadoresPorNombreBD(String nombre)
  {
    int cantidad = (int)(Math.random() * 5)+1;
    List<Jugador> j = new ArrayList<Jugador>();
    for(int i=0; i<cantidad; i++){
      j.add(jugadorRandomAsNombre(nombre));
    }
    return j;
  }

  public List<Jugador> jugadoresPorId(int id)
  {
    int cantidad = (int)(Math.random() * 5)+1;
    List<Jugador> j = new ArrayList<Jugador>();
    for(int i=0; i<cantidad; i++){
      j.add(jugadorRandomAsId(id));
    }
    return j;
  }

  public Jugador jugadorPorIdBD(int id){
    return jugadorRandomAsId(id);
  }

  //****** trucherio****//


  public static  final String nombres[]  = {"rodrigo",
                        "juan",
                        "hector",
                        "mauricio",
                        "franco",
                        "francisco",
                        "javiera",
                        "diego",
                        "gustavo",
                        "huenseslao"};

  public static  final String paternos[]  = {"rodriguez",
          "poblete",
          "ruiz",
          "cardenaz",
          "romero",
          "coccio",
          "undurraga",
          "riquelme",
          "quiroga",
          "perez"};

  public static  final String maternos[]  = {"flores",
          "perez",
          "olmos",
          "oliva",
          "rivero",
          "leyva",
          "acuña",
          "camirioaga",
          "espinoza",
          "gonzales"};


  public static  final String celulares[]  = {"+56994060942",
          "+56923432442",
          "+56994060939",
          "+56994060239",
          "+56994060323",
          "+56994060932",
          "+56994060943",
          "+56994060943",
          "+56994060949",
          "+56994060909"};

  public static  final String claves[]  = {"***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***"};






  public Jugador jugadorRandom(){

    return new Jugador(1,
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1));
  }

  public Jugador jugadorRandomAsNombre(String nombre){

    return new Jugador(1,
            nombre,
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1));


  }

  public Jugador jugadorRandomAsId(int id){

    return new Jugador(id,
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1),
            String.valueOf((int)(Math.random() * 2000)+1));


  }



}

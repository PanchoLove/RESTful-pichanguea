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


  public static  final String nombresj[]  = {"rodrigo",
          "juan",
          "hector",
          "mauricio",
          "franco",
          "francisco",
          "javiera",
          "diego",
          "gustavo",
          "huenseslao"};

  public static  final String paternosj[]  = {"rodriguez",
          "poblete",
          "ruiz",
          "cardenaz",
          "romero",
          "coccio",
          "undurraga",
          "riquelme",
          "quiroga",
          "perez"};

  public static  final String maternosj[]  = {"flores",
          "perez",
          "olmos",
          "oliva",
          "rivero",
          "leyva",
          "acuña",
          "camirioaga",
          "espinoza",
          "gonzales"};


  public static  final String celularesj[]  = {"+56994060942",
          "+56923432442",
          "+56994060939",
          "+56994060239",
          "+56994060323",
          "+56994060932",
          "+56994060943",
          "+56994060943",
          "+56994060949",
          "+56994060909"};

  public static  final String rutsj[]  = {"18060203",
          "16765777",
          "21324234",
          "10032443",
          "14324324",
          "19324324",
          "05699239",
          "19323244",
          "14032433",
          "128062344"};

  public static final String mailsj[]= {"@gmail.com","@hotmail.com","@yahoo.com"};



  public static  final String clavesj[]  = {"***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***",
          "***"};

  public static  final String digitosj[]  = {"1",
          "2",
          "3",
          "4",
          "5",
          "6",
          "7",
          "8",
          "9",
          "k"};

  public static  final String nobresEquiposj[]  = {"Supercampeones",
          "Manchester United",
          "Inter de millan",
          "Cebollitas F.C",
          "Curifuta F.C",
          "Tuercebotas F.C",
          "los pibes chorros",
          "Tricolor de paine",
          "Los Fracturadores",
          "Hachazo F.C"};

  public static  final String fechasj[]  = {"20-10-2016",
          "20-02-2017",
          "12-04-2015",
          "22-07-2014",
          "13-08-2010",
          "23-02-2012",
          "24-09-2013",
          "19-04-2015",
          "09-02-2016",
          "15-02-2016"};

  public static  final String fechas2j[]  = {"20-10-2017",
          "20-11-2017",
          "12-12-2017",
          "22-10-2017",
          "13-11-2017",
          "23-12-2017",
          "24-12-2017",
          "19-11-2017",
          "09-12-2017",
          "15-12-2017"};

  public static  final String horasj[]  = {"17:05",
          "14:05",
          "16:00",
          "08:00",
          "09:30",
          "11:45",
          "12:30",
          "13:40",
          "14:55",
          "16:50"};






  public Jugador jugadorRandom(){


    String n = nombresj[((int)(Math.random() * 9)+0)];

    return new Jugador(1,
            n,
            "***",
            rutsj[((int)(Math.random() * 9)+0)],
            digitosj[((int)(Math.random() * 9)+0)],
            nombresj[((int)(Math.random() * 9)+0)],
            paternosj[((int)(Math.random() * 9)+0)],
            maternosj[((int)(Math.random() * 9)+0)],
            celularesj[((int)(Math.random() * 9)+0)],
            n+mailsj[((int)(2)+0)],
            n);
  }

  public Jugador jugadorRandomAsNombre(String nombre){

    return new Jugador(1,
            nombre,
            "***",
            rutsj[((int)(Math.random() * 9)+0)],
            digitosj[((int)(Math.random() * 9)+0)],
            nombresj[((int)(Math.random() * 9)+0)],
            paternosj[((int)(Math.random() * 9)+0)],
            maternosj[((int)(Math.random() * 9)+0)],
            celularesj[((int)(Math.random() * 9)+0)],
            nombre+mailsj[((int)(2)+0)],
            nombre);


  }

  public Jugador jugadorRandomAsId(int id){

    String n = nombresj[((int)(Math.random() * 9)+0)];


    return new Jugador(id,
            n,
            "***",
            rutsj[((int)(Math.random() * 9)+0)],
            digitosj[((int)(Math.random() * 9)+0)],
            nombresj[((int)(Math.random() * 9)+0)],
            paternosj[((int)(Math.random() * 9)+0)],
            maternosj[((int)(Math.random() * 9)+0)],
            celularesj[((int)(Math.random() * 9)+0)],
            n+mailsj[((int)(2)+0)],
            n);


  }



}

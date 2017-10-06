package principal.equipo;

import org.springframework.web.bind.annotation.*;
import principal.Jugador.Jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ControladorEquipo {



    /****************declaracion de contratos************************/
    @RequestMapping("/equipos")
    @ResponseBody
    public List<Equipo> equiposPorNombre(@RequestParam(value="nombreEquipo", defaultValue="") String nombreEquipo ,
                                            @RequestParam(value="idJugador", defaultValue="-1") int idJugador
    ) {

        if(idJugador==-1){
            if(!(nombreEquipo.equals(""))){
                return equiposPorNombreBD(nombreEquipo);
            }else{
                return null;
            }

        }else {
            if(!nombreEquipo.equals("")){
                return null;//implementar equipos por nombre y jugador al mismo tiempo, parece innecesario
            }else{
                return equiposPorIdJugadorBD(idJugador);
            }

        }
    }

    //agregar obtener equipo por id
    @RequestMapping("/equipo")
    public Equipo equipoPorNombre(@RequestParam(value="nombreEquipo", defaultValue="") String nombreEquipo,
                                  @RequestParam(value="idJugador", defaultValue="-1") int idJugador,
                                  @RequestParam(value="idEquipo", defaultValue="-1") int idEquipo
    ){
        if(idEquipo!=-1) {
            return equipoRandomAsId(idEquipo);
        }else {
            if (nombreEquipo.equals("")) {
                return null;
            } else {
                return equipoPorNombreBD(nombreEquipo);
            }
        }
    }


    @RequestMapping(value = "/equipo",method = RequestMethod.POST)
    @ResponseBody Equipo crearEquipo(@RequestBody Equipo nuevo){

        return agregarEquipoBD(nuevo);
    }

    @RequestMapping(value = "/equipos",method = RequestMethod.POST)
    @ResponseBody Equipo crearEquipos(@RequestBody Equipo nuevo){

        return agregarEquipoBD(nuevo);
    }


    /********************** supuesta comunicacion con la base de datos****************/
                        //(*remplazar el contenido de las funciones cuando se tenga acceso a la BD)

    public List<Equipo> equiposPorNombreBD(String nombre){

        List<Equipo> l = new ArrayList<>();
        int cantidad = (int)(Math.random() * 4)+1;

        for(int i=0; i< cantidad; i++){
            l.add(equipoRandomAsnombre(nombre));
        }

        return l;
    }

    public List<Equipo> equiposPorIdJugadorBD(int id){

        List<Equipo> l = new ArrayList<>();
        int cantidad = (int)(Math.random() * 4)+1;

        for(int i=0; i< cantidad; i++){
            l.add(equipoRandom());
        }

        return l;
    }

    
    public Equipo equipoPorNombreBD(String nombre){
        return equipoRandomAsnombre(nombre);
    }

    public  Equipo agregarEquipoBD(Equipo e){
        return e;
    }

    public Equipo equipoPorIdEquipo(int id){
        return equipoRandomAsId(id);
    }

    //****** trucherio****//


    public static  final String nombrese[]  = {"rodrigo",
            "juan",
            "hector",
            "mauricio",
            "franco",
            "francisco",
            "javiera",
            "diego",
            "gustavo",
            "huenseslao"};

    public static  final String paternose[]  = {"rodriguez",
            "poblete",
            "ruiz",
            "cardenaz",
            "romero",
            "coccio",
            "undurraga",
            "riquelme",
            "quiroga",
            "perez"};

    public static  final String maternose[]  = {"flores",
            "perez",
            "olmos",
            "oliva",
            "rivero",
            "leyva",
            "acuña",
            "camirioaga",
            "espinoza",
            "gonzales"};


    public static  final String celularese[]  = {"+56994060942",
            "+56923432442",
            "+56994060939",
            "+56994060239",
            "+56994060323",
            "+56994060932",
            "+56994060943",
            "+56994060943",
            "+56994060949",
            "+56994060909"};

    public static  final String rutse[]  = {"18060203",
            "16765777",
            "21324234",
            "10032443",
            "14324324",
            "19324324",
            "05699239",
            "19323244",
            "14032433",
            "128062344"};

    public static final String mailse[]= {"@gmail.com","@hotmail.com","@yahoo.com"};



    public static  final String clavese[]  = {"***",
            "***",
            "***",
            "***",
            "***",
            "***",
            "***",
            "***",
            "***",
            "***"};

    public static  final String digitose[]  = {"1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "k"};

    public static  final String nobresEquipose[]  = {"Supercampeones",
            "Manchester United",
            "Inter de millan",
            "Cebollitas F.C",
            "Curifuta F.C",
            "Tuercebotas F.C",
            "los pibes chorros",
            "Tricolor de paine",
            "Los Fracturadores",
            "Hachazo F.C"};

    public static  final String fechase[]  = {"20-10-2016",
            "20-02-2017",
            "12-04-2015",
            "22-07-2014",
            "13-08-2010",
            "23-02-2012",
            "24-09-2013",
            "19-04-2015",
            "09-02-2016",
            "15-02-2016"};

    public static  final String fechas2e[]  = {"20-10-2017",
            "20-11-2017",
            "12-12-2017",
            "22-10-2017",
            "13-11-2017",
            "23-12-2017",
            "24-12-2017",
            "19-11-2017",
            "09-12-2017",
            "15-12-2017"};

    public static  final String horase[]  = {"17:05",
            "14:05",
            "16:00",
            "08:00",
            "09:30",
            "11:45",
            "12:30",
            "13:40",
            "14:55",
            "16:50"};



    public Equipo equipoRandom(){

        String n = nobresEquipose[((int)(Math.random() * 9)+0)];

        return new Equipo(1,
                n,
                n,
                "" ,
                n+mailse[((int)(Math.random() * 2)+0)],
                n+mailse[((int)(Math.random() * 2)+0)],
                celularese[((int)(Math.random() * 9)+0)],
                celularese[((int)(Math.random() * 9)+0)],
                n+mailse[((int)(Math.random() * 2)+0)]
                ,new Date()
                );
    }

    public Equipo equipoRandomAsId(int id){


        String n = nobresEquipose[((int)(Math.random() * 9)+0)];

        return new Equipo(id,
                n,
                n,
                "" ,
                n+mailse[((int)(Math.random() * 2)+0)],
                n+mailse[((int)(Math.random() * 2)+0)],
                celularese[((int)(Math.random() * 9)+0)],
                celularese[((int)(Math.random() * 9)+0)],
                n+mailse[((int)(Math.random() * 2)+0)]
                ,new Date()
        );
    }


    public Equipo equipoRandomAsnombre(String nombre){


        return new Equipo(1,
                nombre,
                nombre,
                "" ,
                nombre+mailse[((int)(Math.random() * 2)+0)],
                nombre+mailse[((int)(Math.random() * 2)+0)],
                celularese[((int)(Math.random() * 9)+0)],
                celularese[((int)(Math.random() * 9)+0)],
                nombre+mailse[((int)(Math.random() * 2)+0)]
                ,new Date()
        );
    }
}

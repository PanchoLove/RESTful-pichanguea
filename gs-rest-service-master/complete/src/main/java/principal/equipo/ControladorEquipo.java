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

    public Equipo equipoRandom(){


        return new Equipo(1,
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1)
                ,new Date()
                );
    }

    public Equipo equipoRandomAsId(int
                                           id){


        return new Equipo(id,
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1)
                ,new Date()
        );
    }


    public Equipo equipoRandomAsnombre(String nombre){


        return new Equipo(1,
                nombre,
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1)
                ,new Date()
        );
    }
}

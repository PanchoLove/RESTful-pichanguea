package principal.invitacion;

import org.springframework.web.bind.annotation.*;
import principal.Jugador.Jugador;
import principal.equipo.Test;

@RestController
public class ControladorInvitacion {

    /****************declaracion de contratos************************/

    @RequestMapping(value = "/invitacion", method = RequestMethod.POST)
    @ResponseBody
    public Invitacion invitarJugadorEquipo(@RequestParam(value ="idEquipo", defaultValue = "-1" ) int idEquipo,
                                           @RequestParam(value ="idJugador" , defaultValue="-1") int idJugador) {

        if(idEquipo!=-1&&idJugador!=-1){
            return agregarInvitacionBD(idJugador,idEquipo);
        }

        return null;
    }

    @RequestMapping(value = "/invitacion", method =  RequestMethod.PUT)
    @ResponseBody
    public String accepted(@RequestParam(value="idInvitacion",defaultValue = "-1") int idInvitacion,
                           @RequestParam(value="respuesta",defaultValue="-1") int respuesta ){

        if(idInvitacion==-1||respuesta==-1){return  "faltan parametros";}
        else{
                if(respuesta==0){
                    responderInvitacionBD(idInvitacion,respuesta);
                    return "invitacion rechazada";
                }
                if(respuesta==1){
                    responderInvitacionBD(idInvitacion,respuesta);
                    return "invitacion acpetada";
                }
                return "parametros fuera de rango";
        }


    }

    /********************** supuesta comunicacion con la base de datos****************/
    //(*remplazar el contenido de las funciones cuando se tenga acceso a la BD)

    public Invitacion agregarInvitacionBD(int idJugador, int idEquipo){

        return new Invitacion(idEquipo, idJugador, "pendiente", "", "");
    }

    public void responderInvitacionBD(int id, int respuesta ){}

}

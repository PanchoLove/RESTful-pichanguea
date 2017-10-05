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

    /********************** supuesta comunicacion con la base de datos****************/
    //(*remplazar el contenido de las funciones cuando se tenga acceso a la BD)

    public Invitacion agregarInvitacionBD(int idJugador, int idEquipo){

        return new Invitacion(idEquipo, idJugador, "pendiente", "", "");
    }


}

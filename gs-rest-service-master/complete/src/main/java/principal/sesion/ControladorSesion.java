package principal.sesion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import principal.Jugador.Jugador;
import principal.Partido.Partido;
import principal.equipo.Equipo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ControladorSesion {


    /****declaracion de contratos*****/
    @RequestMapping("/sesion")
    @ResponseBody Sesion iniciarSesion(@RequestParam(value="usuario",defaultValue = "") String usuario,
                                       @RequestParam(value="pass",defaultValue = "") String pass){

        if(!(usuario.equals("")||pass.equals(""))){
            Sesion s = obtenerSesionBD(usuario,pass);
            if(s==null){return null;}
            else{return s;}
        }
        return null;
    }


    /**supuesta interaccion con la bse de datos **/
    public Sesion obtenerSesionBD(String usuario, String pass){
        return sesionRandom(usuario, pass);
    }

    /***trucherio****////
    public Sesion sesionRandom(String usuario, String Contraseña){

        Jugador jugador = new Jugador(1,
                usuario,
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1),
                String.valueOf((int)(Math.random() * 2000)+1));

        List<Equipo> equipos =new ArrayList<>();

        int cantidad = (int)(Math.random() * 3)+1;

        for(int i=0; i< cantidad; i++){
            equipos.add(new Equipo(i,
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1)
                    ,new Date()
            ));
        }




        List<Partido> partidos = new ArrayList<>();
        cantidad = (int)(Math.random() * 4)+1;
        for(int i=0; i< cantidad; i++){
            partidos.add(new Partido(i,12,
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1)
                    ));
        }

        String token="holasoyuntoken:D";

        return new Sesion(jugador,equipos,partidos,token);
    }




}

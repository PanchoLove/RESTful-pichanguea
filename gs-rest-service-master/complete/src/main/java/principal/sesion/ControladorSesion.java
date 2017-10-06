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


    public static  final String nombress[]  = {"rodrigo",
            "juan",
            "hector",
            "mauricio",
            "franco",
            "francisco",
            "javiera",
            "diego",
            "gustavo",
            "huenseslao"};

    public static  final String paternoss[]  = {"rodriguez",
            "poblete",
            "ruiz",
            "cardenaz",
            "romero",
            "coccio",
            "undurraga",
            "riquelme",
            "quiroga",
            "perez"};

    public static  final String maternoss[]  = {"flores",
            "perez",
            "olmos",
            "oliva",
            "rivero",
            "leyva",
            "acuña",
            "camirioaga",
            "espinoza",
            "gonzales"};


    public static  final String celularess[]  = {"+56994060942",
            "+56923432442",
            "+56994060939",
            "+56994060239",
            "+56994060323",
            "+56994060932",
            "+56994060943",
            "+56994060943",
            "+56994060949",
            "+56994060909"};

    public static  final String rutss[]  = {"18060203",
            "16765777",
            "21324234",
            "10032443",
            "14324324",
            "19324324",
            "05699239",
            "19323244",
            "14032433",
            "128062344"};

    public static final String mails[]= {"@gmail.com","@hotmail.com","@yahoo.com"};



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

    public static  final String digitoss[]  = {"1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "k"};

    public static  final String nobresEquiposs[]  = {"Supercampeones",
            "Manchester United",
            "Inter de millan",
            "Cebollitas F.C",
            "Curifuta F.C",
            "Tuercebotas F.C",
            "los pibes chorros",
            "Tricolor de paine",
            "Los Fracturadores",
            "Hachazo F.C"};

    public static  final String fechass[]  = {"20-10-2016",
            "20-02-2017",
            "12-04-2015",
            "22-07-2014",
            "13-08-2010",
            "23-02-2012",
            "24-09-2013",
            "19-04-2015",
            "09-02-2016",
            "15-02-2016"};

    public static  final String fechas2s[]  = {"20-10-2017",
            "20-11-2017",
            "12-12-2017",
            "22-10-2017",
            "13-11-2017",
            "23-12-2017",
            "24-12-2017",
            "19-11-2017",
            "09-12-2017",
            "15-12-2017"};

    public static  final String horass[]  = {"17:05",
            "14:05",
            "16:00",
            "08:00",
            "09:30",
            "11:45",
            "12:30",
            "13:40",
            "14:55",
            "16:50"};


    public Sesion sesionRandom(String usuario, String Contraseña){


        Jugador jugador = new Jugador(1,
                usuario,
                "***",
                rutss[((int)(Math.random() * 9)+0)],
                digitoss[((int)(Math.random() * 9)+0)],
                nombress[((int)(Math.random() * 9)+0)],
                paternoss[((int)(Math.random() * 9)+0)],
                maternoss[((int)(Math.random() * 9)+0)],
                celularess[((int)(Math.random() * 9)+0)],
                usuario+mails[((int)(2)+0)],
                usuario);

        List<Equipo> equipos =new ArrayList<>();

        int cantidad = (int)(Math.random() * 3)+1;

        for(int i=0; i< cantidad; i++){

            String n = nobresEquiposs[((int)(Math.random() * 9)+0)];
            equipos.add(new Equipo(i,
                    n,
                    n,
                    "" ,
                    n+mails[((int)(Math.random() * 2)+0)],
                    n+mails[((int)(Math.random() * 2)+0)],
                    celularess[((int)(Math.random() * 9)+0)],
                    celularess[((int)(Math.random() * 9)+0)],
                    n+mails[((int)(Math.random() * 2)+0)]
                    ,new Date()
            ));
        }




        List<Partido> partidos = new ArrayList<>();
        cantidad = (int)(Math.random() * 4)+1;
        for(int i=0; i< cantidad; i++){
            partidos.add(new Partido(i,12,
                    fechas2s[((int)(Math.random() * 9)+0)],
                    horass[((int)(Math.random() * 9)+0)],
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    String.valueOf((int)(Math.random() * 2000)+1),
                    "",
                    String.valueOf((int)(Math.random() * 2000)+1),
                    "vigente",
                    fechass[((int)(Math.random() * 9)+0)]
            ));
        }

        String token="holasoyuntoken:D";

        return new Sesion(jugador,equipos,partidos,token);
    }




}

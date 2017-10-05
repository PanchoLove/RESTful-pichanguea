# RESTful-pichanguea

<!-- toc -->

- [Instrucciones de instalación y ejecución](#Instrucciones de instalación y ejecución)

<!-- tocstop -->


## Instrucciones de instalación y ejecución

1. Se debe tener instalado gradle y agregar el path correspondiente  (https://gradle.org/install/)
2. Dentro de la terminal de linux o el cmd de windows se debe ingresar a la carpeta "complete" dentro del proyecto ("cd /RESTful-pichanguea/gs-rest-service-master/complete")
3. Una vez en la carpeta ejecutar "./gradlew bootRun" (linux) o "gradlew.bat bootRun" (windows).
4. El servicio es accesible desde "localhost:8080/" , para probar que efectivamente esta funcionando se puede acceder a "localhost:8080/greeting" que entregara un hola mundo de respuesta.

## Lista de funciones

De momento el servicio no esta conectado a la base de datos asi que solo rentrega datos aleatories. De momento tampoco se ha implementado el uso de tokens.

Se recomienda que todas las llamadas al servicio se realicen incluyendo el header:

```("Content-Type", "application/json")``` 

(o al menos los @POST)




### /Crear Usuario

Recibe un objeto Json de tipo usuario y crea un usuario cualquiera, retorna el mismo usuario en caso de ser aceptado. No deberia estar implementado con ese nombre (existe una funcion similar en /jugador) pero se deja por si resulata mas comodo.

@POST : ```/crearUsuario```


Objeto json a enviar en el post (ejemplo):
```
   {
        "nombreUsuario": "sadsad",
        "clave": "506",
        "rutSinDigito": "1511",
        "rutConDigito": "1022",
        "nombre": "141",
        "paterno": "527",
        "materno": "1430",
        "celular": "1995",
        "mail": "842",
        "apodo": "949",
    }
```

Respuesta (ejemplo):
```
{
    "jug": {
        "nombreUsuario": "sadsad",
        "clave": "506",
        "rutSinDigito": "1511",
        "rutConDigito": "1022",
        "nombre": "141",
        "paterno": "527",
        "materno": "1430",
        "celular": "1995",
        "mail": "842",
        "apodo": "949",
        "id": -1
    },
    "token": "123"
}
```

### /sesion

funcion para el inicio de sesion, retorna un json con el jugador que representa al usuario, la lista de partidos de esta, la lista de equipos y un token.

@GET: ``` /sesion?usuario=(usuario sin parentesis)&pass=(pass sin parentesis) ```


### /jugador y /jugadores
la funcion /jugador retorna objetos de tipo jugador, mientras que la funcion /jugadores retorna listas de jugadores

#### crear un nuevo usuario 
se pueden enviar exactamente los mimos parametros de /crearJugador a la funcion /jugador a travez de un @POST y esta realizara la misma operacion.


#### obtener un jugador por su id

@GET: ``` /jugador?id=(aqui va la id del jugador sin parentesis ni nada) ```
(retorna un objeto jugador con el id)

@GET: ``` /jugadores?id=(aqui va la id del jugador sin parentesis ni nada) ```
(retorna el mismo objeto pero dentro de una lista)

#### obtener jugadores por nombre
obtener una lista de jugadores que coincidan con el nombre buscado 

@GET: ``` /jugadores?nombreJugador=(nombre del jugador sin comillas ni nada)```
 (retorna una lista de jugadores que coincidan con el nombre).

@GET: ``` /jugadore?nombreJugador=(nombre del jugador sin comillas ni nada)``` 
(retorna el primer jugador que se coincida con el nombre indicado).

### /equipo y /equipos

##### buscar equipos por nombre

@GET: ```/equipos?nombreEquipo=(nombre del equipo sin parentesis)```
(retorna una lista de todos los equipos que coincidan con el nombre)

@GET : ``` /equipo?nombreEquipo=(nombre del equipo sin parentesis)```
(retorna el primer equipo que coincida con el nombre)

#### obtener los equipos de un jugador

@GET : ```/equipos?idJugador```
(retorna una lista con los equipos asociados al jugador)

#### obtener un equipo por su id

@GET : ```/equipo?idEquipo=(id del equipo sin parentesis)```
(retorna el equipo)


@GET : ```/equipos?idEquipo=(id del equipo sin parentesis)```
(retorna el mismo equipo en una lista)

#### crear un equipo

@POST ```/equipo```


Objeto json a enviar en el post (ejemplo) : ```{
    "nombre": "1535",
    "descripcion": "1078",
    "url": "1687",
    "email": "1065",
    "contacto": "809",
    "contactoFono": "911",
    "contactoCelular": "521",
    "contactoMail": "1081",
    "creacion": 1507186592323
} ```

de respuesta se obtiene un json con el equipo creado.

se puede realizar exactamente la misma operacion con /equipos , ambas funciones realizan la misma operacion cuando se les llama como post y se les envia el json


## /invitacionEquipo 

#### invitar a un jugador a un equipo

@POST: ```/invitacionEquipo?idEquipo=(id del equipo)&idEquipo=(id del equipo)```

un objeto de tipo invitacion en caso de ser exitoso

#### Responder una invitacion

@PUT ```/invitacionEquipo?idInvitacion=(id de invitacion)&respuesta=(0 o 1)```

(o si se rechaza la invitacion, 1 si se acepta)



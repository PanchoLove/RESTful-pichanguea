# RESTful-pichanguea

##contenidos

<!-- toc -->
- [Instrucciones de instalación y ejecución](#instrucciones-de-instalación-y-ejecución]
-[Lista de funciones](#lista-de-funciones)
 -[/Crear Usuario](#/crear-usuario)
 -[/Sesion](#/sesion)
 -[/Jugador](#/usuario)
 -[/Equipo](#/equipo)
 -[/Invitacion](#/invitacion)

<!-- tocstop -->

## Instrucciones de instalación y ejecución

1. Se debe tener instalado gradle y agregar el path correspondiente  (https://gradle.org/install/)
2. Dentro de la terminal de linux o el cmd de windows se debe ingresar a la carpeta "complete" dentro del proyecto ("cd /RESTful-pichanguea/gs-rest-service-master/complete")
3. Una vez en la carpeta ejecutar "./gradlew bootRun" (linux) o "gradlew.bat bootRun" (windows).
4. El servicio es accesible desde "localhost:8080/" , para probar que efectivamente esta funcionando se puede acceder a "localhost:8080/greeting" que entregara un hola mundo de respuesta.

##Lista de funciones
De momento el servicio no esta conectado a la base de datos asi solo rentrega datos aleatories. De momento tampoco se ha implementado el uso de tokens.

### /Crear Usuario

Recibe un objeto Json de tipo usuario y crea un usuario cualquiera, retorna el mismo usuario en caso de ser aceptado. No deberia estar implementado con ese nombre (existe una funcion similar en /jugador) pero se deja por si resulata mas comodo.

Url:
```/crearUsuario```
Metodo: POST

headers:

```("Content-Type", "application/json")```

Body (ejemplo):
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
        "id": 1
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


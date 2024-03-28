
# Prueba Técnica 2
Este proyecto se basa en un CRUD creado mediante JPA y JSP.
En el se nos pide la creacion de un "turnero" que asigne turnos de forma automática.



## Funcionalidades
**Crear Ciudado**: Permite el alta en la base de datos de un nuevo ciudadano al sistema ingresando:
- Nombre
- Apellido
- DNI

**Mostrar los ciudadanos**: Muestra en una tabla todos los ciudadanos registrados previamente.

**Obtener turno**: Ingresando el id del ciudadano, el tramite que quiere realizar y la fecha, podra ir obteniendo un turno por cada registro que haga, un mismo ciudadano puede tener varios turnos.

**Listar turnos**: Los turnos son listados en una tabla, en la cual se pueden hacer filtrados por estado, y por fecha.

Dentro de esta misma lista se puede hacer el cambio de estado de "En espera" a "Ya atendido".




## Running Tests

Se han realizado test de funcionamiento, que han sido los siguientes:

- Creacion de distintos ciudadnos. Se han intentado ingresar distintas fechas de manera incorrecta para comprobar el funcionamiento.

- Listado por estado. Se han realizado varios test para ver que el filtrado se realiza de forma correcta

- Filtrado por fecha: Se han realizado varios test, para comprobar el correcto filtrado por fecha

- Listar los ciudadanos: Se ha usado List para el correcto listado de los elementos que hay en la base de datos.

- Editar estado: Se han editado el estado mediante un botón de cambio de estado


## Supuestos
- Se ha supuesto que la persona tiene que listar primero a los ciudadanos para conocer su id.

- Se asume que los datos van a ser facilitados por el usuario del programa.

- Se ha supuesto que siempre que se genera un turno para las distintas gestiones, esta gestion está en espera y una vez realizado el tramite, pasa al estado "Ya atendido" pulsando el botón de cambio de estado.

- Dependencia de la entrada de datos: se confia en que el usuario ingrese datos validos ya que no hay una validación más allá que para la DNI.

-Para la validación del DNI he usado REGEX.





## Ejecucion

- Clona el repositorio en el direcorio que desees.
- Abre una terminal y navega hasta el directorio raíz del proyecto.
- Ejecuta la aplicación.
## Uso

- Sólo hay que seguir los pasos que se muestran en la interfaz grafica.
## Documentation

- [regex](https://regexr.com/)
- [querys](https://www.arquitecturajava.com/jpa-query-language-objetos-vs-tablas/)
- [Uso de la fecha](https://www.campusmvp.es/recursos/post/como-manejar-correctamente-fechas-en-java-el-paquete-java-time.aspx)
- [Uso de la fecha](https://www.w3schools.com/java/java_date.asp)
- [Stream y filter](https://www.arquitecturajava.com/java-stream-filter-y-predicates/)
- [Stream y filter](https://codingfactsblog.wordpress.com/2017/08/01/jugando-con-streams-y-predicates-en-java/)
- [JPA](https://github.com/juanmacintas/tallerJPASpringData)


## Authors

- Juan Manuel Garcia


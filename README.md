# TareaSemestral
Al inicar el codigo es posible que no compile por el JCalendar, si esto sucede lo que se tiene que hacer  es:
-Ir a "Project Structure"
-Agregar carpeta Lib
-Aplicar

uno de los 2 patrones utilizado fue el patron strategy, lo que llevo a usar este patron fue:
-Al principio se penso en implementar distintos metodos dentro de la clase Torneo para cada formato, como por ejemplo crearTorneoEliminacionDoble. Sin embargo, se observo que este enfoque resultaba ineficiente y poco escalable. Tras investigar, se opto por aplicar el patron Strategy, lo que permitio que la clase Torneo funcionara con cualquier tipo de formato (Liga, Eliminación Doble, Eliminación Directa) sin necesidad de modificar sus métodos.
Gracias a este patron, en lugar de tener métodos específicos como jugarEliminacionDirecta, se puede utilizar simplemente Torneo.jugar(), y el comportamiento sera definido por el formato asignado. Esto hace que el codigo sea abierto a la extensión (permitiendo agregar nuevos formatos fácilmente) y cerrado a la modificacion (no es necesario alterar la logica interna de Torneo).

El otro patron fue:
-Singleton esta se usa para que unicamente haya 1 ventana principal activa evitando tener errores visuales o consumo innecesario de recursos, tambien al usarse en todo "view" se asegura de que todas las clases puedan acceder a ella usando Ventana.getInstancia o poder actualizarla con un Ventana.actualizar, evitando asi errores por multiples instancias y mejor manejo en el codigo


Desiciones claves
-Implementar la funcion Escalar
-Crear una clase para los botones,textos y fields(Ayudo a la Implementacion del codigo del codigo)
-La implementacion del Patron Strategy
-Hacer la clase Participantes para Trabajar a los equipos y Deportistas como Participantes

Como utilizar el software:
El codigo funciona con los txts que estan en resources, los cuales estan separados por equipos y Deportistas si quiere agregar mas equipos o deportistas se tienen que agregar ahi, para agregar deportistas hay que seguir el formato:
Nombre contacto edad
Nombre2 contacto2 edad2
para agregar Equipos hay que seguir el siguiente formato:
NombreEquipo1 contactoEquipo1 añosEquipo1
NombreMiembroEquipo1 contactoMienbroEquipo1$ <-- Indica al ultimo integrante del equipo, cada vez que se termina de agregar un equipo se termina con este simbolo $ y se sigue con el otro

Alguna limitaciones de nuestro codigo son:
Eliminacion Directa solo funciona con 4,8,16 Participantes(Equipo/Deportistas)
Eliminacion Doble solo con 8 Participantes
Hay que asegurarse de que hay la cantidad necesaria de participantes
En cambio liga simple no tiene limitaciones con los participantes


Si bien se termino la logica del codigo de eliminacion Doble, en la parte de llevarla a la interfaz grafica no se pudo lograr con total satisfaccion, se intento arreglar de muchas maneras pero no llegamos a la solucion, uno de los problemas que no logramos solucionar fue que se ejecutaba una parte del codigo aunque no se debia de ejecutar, probramos cambiando las condicionales, parametros, creando contadores, pero ninguna nos llevo a solucionar el problema, por lo que el problema sigue persistiendo, el error ocurre en la segunda ronda del lowerBracket, donde se ejecuta un if() que no deberia ejecutarse haciendo que la interfaz grafica se estropee, por otro lado la logica sigue funcionando aun teniendo ese error, por lo que deducimos que es un error solo en la interfaz grafica.
Con esta situacion se empezo a plantear el como pudimos haber empezado este proyecto llegando a la conclusion de que nos falto pensar bien lo que ibamos a hacer antes de empezar el proyecto y pensar los futuros errores que tendriamos mientras creabamos los metodos de cada clase.

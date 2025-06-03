#Gestor de Turnos de Consulta Médica


##Descripción del Proyecto

Este proyecto implementa un sistema básico de gestión de turnos para una consulta médica, desarrollado en Java. Permite añadir pacientes con diferentes prioridades, atenderlos según su urgencia, consultar el estado de la cola y cancelar turnos.


##Estructura del Proyecto

![image](https://github.com/user-attachments/assets/68140209-fd5f-426b-9de5-bfa6d11ad4a6)


    
##Requisitos

Java JDK 11 o superior
JUnit 5 para las pruebas (incluido en el classpath si usas Maven/Gradle)


##Cómo usar las clases

###1. Clase Paciente

Representa a un paciente con:
Nombre
Motivo de consulta
Prioridad (1=alta, 2=media, 3=baja)
Ejemplo de creación:
Paciente paciente = new Paciente("Juan Pérez", "Dolor de cabeza", 2);

###2. Clase GestorTurnos

Métodos disponibles:
agregarPaciente(Paciente p): Añade un paciente a la lista de espera
atenderSiguientePaciente(): Atiende y remueve al paciente con mayor prioridad
contarPacientesPorPrioridad(): Devuelve array con conteos por prioridad [alta, media, baja]
obtenerNombreSiguientePaciente(): Devuelve nombre del próximo paciente sin atenderlo
eliminarTurno(String nombre): Cancela el turno del paciente con ese nombre
Ejemplo básico de uso
GestorTurnos gestor = new GestorTurnos();
// Añadir pacientes
gestor.agregarPaciente(new Paciente("Ana López", "Fiebre alta", 1));
gestor.agregarPaciente(new Paciente("Carlos Ruiz", "Control rutinario", 3));
// Atender pacientes
Paciente siguiente = gestor.atenderSiguientePaciente();
System.out.println("Atendiendo a: " + siguiente.getNombre());
// Consultar estado
int[] espera = gestor.contarPacientesPorPrioridad();
System.out.println("Pacientes en espera: Alta=" + espera[0] + ", Media=" + espera[1] + ", Baja=" + espera[2]);


##Incidencias registradas

###Problema

No se validaba prioridad fuera de rango (1-3)	

Eliminación dejaba lista inconsistente	

###Solución Aplicada

Se añadió validación en constructor de Paciente

Se corrigió el método eliminarTurno()


##Ejecución de Pruebas

Las pruebas unitarias verifican:
Correcto añadido de pacientes
Prioridad en la atención
Conteo por prioridades
Cancelación de turnos
Comportamiento con lista vacía

##Para ejecutar las pruebas:

Asegúrate de tener JUnit 5 en tu classpath
Ejecuta GestorTurnosTest desde tu IDE

##Notas importantes

Se diseñó para ser extendido fácilmente con:
Persistencia de datos
Interfaz de usuario
Nuevas funcionalidades


##Autor

Diego Capellán Fernández - Estudiante de desarrollo de aplicaciones web.

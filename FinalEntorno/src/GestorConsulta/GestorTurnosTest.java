package gestorConsulta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GestorTurnosTest {
    
    @Test
    public void testAgregarPaciente() {
        GestorTurnos gestor = new GestorTurnos();
        Paciente paciente = new Paciente("Juan", "Dolor de cabeza", 2);
        
        gestor.agregarPaciente(paciente);
        int[] conteo = gestor.contarPacientesPorPrioridad();
        
        assertEquals(1, conteo[1]); // Prioridad 2 está en índice 1
    }
    
    @Test
    public void testAtenderSiguientePacientePrioridad() {
        GestorTurnos gestor = new GestorTurnos();
        gestor.agregarPaciente(new Paciente("Ana", "Fiebre", 2));
        gestor.agregarPaciente(new Paciente("Luis", "Fractura", 1));
        gestor.agregarPaciente(new Paciente("Marta", "Control", 3));
        
        Paciente siguiente = gestor.atenderSiguientePaciente();
        assertEquals("Luis", siguiente.getNombre());
    }
    
    @Test
    public void testContarPacientesPorPrioridad() {
        GestorTurnos gestor = new GestorTurnos();
        gestor.agregarPaciente(new Paciente("Ana", "Fiebre", 2));
        gestor.agregarPaciente(new Paciente("Luis", "Fractura", 1));
        gestor.agregarPaciente(new Paciente("Marta", "Control", 3));
        gestor.agregarPaciente(new Paciente("Carlos", "Dolor", 2));
        
        int[] conteo = gestor.contarPacientesPorPrioridad();
        assertArrayEquals(new int[]{1, 2, 1}, conteo);
    }
    
    @Test
    public void testEliminarTurno() {
        GestorTurnos gestor = new GestorTurnos();
        gestor.agregarPaciente(new Paciente("Ana", "Fiebre", 2));
        gestor.agregarPaciente(new Paciente("Luis", "Fractura", 1));
        
        boolean eliminado = gestor.eliminarTurno("Ana");
        assertTrue(eliminado);
        assertEquals(1, gestor.contarPacientesPorPrioridad()[0]); // Solo queda Luis con prioridad 1
    }
    
    @Test
    public void testObtenerNombreSiguientePaciente() {
        GestorTurnos gestor = new GestorTurnos();
        gestor.agregarPaciente(new Paciente("Ana", "Fiebre", 2));
        gestor.agregarPaciente(new Paciente("Luis", "Fractura", 1));
        
        String nombre = gestor.obtenerNombreSiguientePaciente();
        assertEquals("Luis", nombre);
    }
    
    @Test
    public void testAtenderConListaVacia() {
        GestorTurnos gestor = new GestorTurnos();
        Paciente siguiente = gestor.atenderSiguientePaciente();
        assertNull(siguiente);
    }
}
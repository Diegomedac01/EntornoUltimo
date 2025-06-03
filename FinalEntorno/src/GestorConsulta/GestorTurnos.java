package GestorConsulta;

import java.util.ArrayList;
import java.util.List;

public class GestorTurnos {
    private List<Paciente> listaPacientes;
    
    public GestorTurnos() {
        listaPacientes = new ArrayList<>();
    }
    
    public void agregarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }
        listaPacientes.add(paciente);
    }
    
    private Paciente encontrarSiguientePaciente() {
        if (listaPacientes.isEmpty()) {
            return null;
        }
        
        Paciente siguiente = listaPacientes.get(0);
        for (Paciente p : listaPacientes) {
            if (p.getPrioridad() < siguiente.getPrioridad()) {
                siguiente = p;
            }
        }
        return siguiente;
    }
    
    public Paciente atenderSiguientePaciente() {
        Paciente siguiente = encontrarSiguientePaciente();
        if (siguiente != null) {
            listaPacientes.remove(siguiente);
        }
        return siguiente;
    }
    
    public int[] contarPacientesPorPrioridad() {
        int[] contadores = new int[3];
        for (Paciente p : listaPacientes) {
            contadores[p.getPrioridad() - 1]++;
        }
        return contadores;
    }
    
    public String obtenerNombreSiguientePaciente() {
        Paciente siguiente = encontrarSiguientePaciente();
        return siguiente != null ? siguiente.getNombre() : null;
    }
    
    public boolean eliminarTurno(String nombre) {
        for (Paciente p : listaPacientes) {
            if (p.getNombre().equals(nombre)) {
                listaPacientes.remove(p);
                return true;
            }
        }
        return false;
    }
}
package GestorConsulta;

public class Paciente {
    private String nombre;
    private String motivoConsulta;
    private int prioridad; // 1=alta, 2=media, 3=baja
    
    public Paciente(String nombre, String motivoConsulta, int prioridad) {
        this.nombre = nombre;
        this.motivoConsulta = motivoConsulta;
        this.prioridad = prioridad;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getMotivoConsulta() {
        return motivoConsulta;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
}
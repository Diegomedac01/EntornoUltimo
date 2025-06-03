package GestorConsulta;


import java.util.ArrayList;
import java.util.List;

public class GestorTurnos {
	private List<Paciente> lista = new ArrayList<>();
	
	public void a(Paciente paciente) {
	   lista.add(paciente);
	}
	
	public Paciente s() {
	   if (lista.isEmpty()) {
	       return null;
	   }
	   
	   Paciente siguiente = null;
	   for (Paciente p : lista) {
	       if (siguiente == null || p.p < siguiente.p) {
	           siguiente = p;
	       }
	   }
	   
	   lista.remove(siguiente);
	   return siguiente;
	}
	
	public int[] c() {
	   int[] contadores = new int[3];
	   for (Paciente p : lista) {
	       contadores[p.p - 1]++;
	   }
	   return contadores;
	}
	
	public String n() {
	   if (lista.isEmpty()) {
	       return null;
	   }
	   
	   Paciente siguiente = null;
	   for (Paciente p : lista) {
	       if (siguiente == null || p.p < siguiente.p) {
	           siguiente = p;
	       }
	   }
	   
	   return siguiente.n;
	}
	
	public boolean e(String nombre) {
	   for (Paciente p : lista) {
	       if (p.n.equals(nombre)) {
	           lista.remove(p);
	           return true;
	       }
	   }
	   return false;
	}
}
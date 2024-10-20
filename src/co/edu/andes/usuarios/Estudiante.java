package co.edu.andes.usuarios;

import java.util.*;
import LearningPath.LearningPath;
import LearningPath.Resena;
import Actividades.*;
import java.time.*;


public class Estudiante extends Usuario{
	
	private HashMap<Integer, LearningPath> lpInscritos;
	private HashMap<Integer, Actividad> actividadesEnviadas;
	private HashMap<Integer, Actividad> actividadesCompletadas;
	

	public Estudiante(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        super(nombre, nombreUsuario, password, "Estudiante");
        this.lpInscritos = new HashMap<Integer, LearningPath>();
    }

	public HashMap<Integer, LearningPath> getLpInscritos() {
		return lpInscritos;
	}
	  
	//crear en lp una lista o mapa de instancias
	public LocalDateTime iniciarLp(int idLp) {
		return null;
		
	}
	    
	public LocalDateTime finalizarLp(int idLp) {
	}

	public LocalDateTime iniciarActividad() {
		
	}

	public LocalDateTime enviarActividad() {
		
	}
	
	public void anadirMapaCalificadas(int idActividad,float nota) {
		
	}
	
	public void getActividadesEnviadas() {
		
	}
	
	
	
}
	
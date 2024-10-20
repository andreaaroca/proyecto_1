package co.edu.andes.usuarios;

import java.util.*;
import LearningPath.LearningPath;
import LearningPath.Resena;
import Persistencias.persistenciaLP;
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
	
	 public static void inscribirLearningPath(persistenciaLP lpControl, Estudiante estudiante, Scanner scanner) {
	        System.out.print("Ingrese el código del Learning Path que desea inscribir: ");
	        int idLP = scanner.nextInt();

	        LearningPath lp = lpControl.obtenerLearningPath(idLP); // Busca el lp en la persistencia
	        if (lp != null) {
	            if (estudiante.getLpInscritos().containsKey(idLP)) {
	                System.out.println("Ya estás inscrito en este Learning Path.");
	            } else {
	                estudiante.getLpInscritos().put(idLP, lp);
	                System.out.println("Learning Path inscrito exitosamente: " + lp.getTitulo());
	            }
	        } else {
	            System.out.println("No se encontró un Learning Path con el código proporcionado.");
	        }
	    }
}
	

	
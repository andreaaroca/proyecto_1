package co.edu.andes.usuarios;

import java.util.*;
import LearningPath.LearningPath;
import LearningPath.Resena;
import Persistencias.persistenciaEstudiante;
import Persistencias.persistenciaLP;
import Actividades.*;
import java.time.*;


public class Estudiante extends Usuario {
	
	private HashMap<Integer, LearningPath> lpInscritos;
	private HashMap<Integer, Actividad> actividadesEnviadas;
	private HashMap<Integer, Actividad> actividadesCompletadas;
	private static persistenciaEstudiante persistenciaEstudiante;

	public Estudiante(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        super(nombre, nombreUsuario, password, "Estudiante");
        this.lpInscritos = new HashMap<Integer, LearningPath>();
        Estudiante.persistenciaEstudiante = new persistenciaEstudiante();
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

	        LearningPath lp = lpControl.obtenerLearningPath(idLP); 
	        if (lp != null) {
	            if (estudiante.getLpInscritos().containsKey(idLP)) {
	                System.out.println("Ya estás inscrito en este Learning Path.");
	            } else {
	                estudiante.getLpInscritos().put(idLP, lp);
	                persistenciaEstudiante persistenciaEstudiante = new persistenciaEstudiante();
	                persistenciaEstudiante.guardarLpInscritos(estudiante);
	                System.out.println("Learning Path inscrito exitosamente: " + lp.getTitulo());
	                
	            }
	        } else {
	            System.out.println("No se encontró un Learning Path con el código proporcionado.");
	        }
	    }
	 
	 public void crearReseñaLearningPath(int idLp, String opinionActividad, int rating, int idActividad) {
		    LearningPath lp = lpInscritos.get(idLp);
		    if (lp != null) {
		        lp.agregarReseña( opinionActividad, rating, idActividad);  
		        
		       
		        persistenciaLP persistencia = new persistenciaLP();
		        persistencia.actualizarRating(idLp, lp.getPromedioCalificaciones());
		    } else {
		        System.out.println("LearningPath no encontrado en los inscritos.");
		    }
		}
	 @Override
	    public String toString() {
	        return nombre; 
	    }

	    public String getNombreUsuario() {
	        return nombreUsuario; 
	    }
}
	

	
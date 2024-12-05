package co.edu.andes.usuarios;

import java.util.*;
import LearningPath.LearningPath;
import LearningPath.Resena;
import Persistencias.persistenciaEstudiante;
import Persistencias.persistenciaLP;
import Actividades.*;

import java.io.Serializable;
import java.time.*;


public class Estudiante extends Usuario implements Serializable{
	
	private HashMap<Integer, LearningPath> lpInscritos;
	private HashMap<Integer, Actividad> actividadesIniciadas;
	private HashMap<Integer, LocalDateTime> actividadesIniciadasTiempo;
	private HashMap<Integer, LocalDateTime> lpInscritosTiempoI;
	private HashMap<Integer, LocalDateTime> lpInscritosTiempoF;
	private HashMap<Integer, Actividad> actividadesEnviadas;
	private HashMap<Integer, LocalDateTime> actividadesEnviadasTiempo;
	private HashMap<Integer, Actividad> actividadesCompletadas;
	private HashMap<Integer, Float> actividadesCalificadas;
	

	private static persistenciaEstudiante persistenciaEstudiante;

	public Estudiante(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        super(nombre, nombreUsuario, password, "Estudiante");
        this.lpInscritos = new HashMap<Integer, LearningPath>();
        this.lpInscritosTiempoI = new HashMap<Integer, LocalDateTime>();
        this.lpInscritosTiempoF = new HashMap<Integer, LocalDateTime>();   
        this.actividadesIniciadas = new HashMap<Integer, Actividad>();
        this.actividadesIniciadasTiempo = new HashMap<Integer, LocalDateTime>();
        this.actividadesEnviadas = new HashMap<Integer, Actividad>();
        this.actividadesEnviadasTiempo = new HashMap<Integer, LocalDateTime>();
        this.actividadesCompletadas= new HashMap<Integer, Actividad>();
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
		return null;
	}
	
	
	

	public HashMap<Integer, Float> getActividadesCalificadas() {
		return actividadesCalificadas;
	}

	public void setActividadesCalificadas(HashMap<Integer, Float> actividadesCalificadas) {
		this.actividadesCalificadas = actividadesCalificadas;
	}

	public void iniciarActividad(int idLp, int idActividad) {
		
		if (lpInscritos.containsKey(idLp)) {
			LearningPath LpEspecifico=lpInscritos.get(idLp);
			if (LpEspecifico.getActividades().containsKey(idActividad)) {
				Actividad actividadIniciar=LpEspecifico.getActividades().get(idActividad);
				actividadesIniciadas.put(idActividad,actividadIniciar);
				LocalDateTime tiempo=LocalDateTime.now();
				actividadesIniciadasTiempo.put(idActividad,tiempo);
				
				
			}
			else {System.out.println("Actividad ausente en LP");
		        
				}
		}
		else {System.out.println("LP no inscrito");
			}
			
		}

	public void enviarActividad(int idLp, int idActividad) {
		if (lpInscritos.containsKey(idLp)) {
			LearningPath LpEspecifico=lpInscritos.get(idLp);
			if ((LpEspecifico.getActividades().containsKey(idActividad))&&(actividadesIniciadas.containsKey(idActividad))) {
				Actividad actividadEnviar=LpEspecifico.getActividades().get(idActividad);
				actividadesEnviadas.put(idActividad,actividadEnviar);
				LocalDateTime tiempo=LocalDateTime.now();
				actividadesEnviadasTiempo.put(idActividad,tiempo);
				
				
			}
			else {System.out.println("Actividad ausente en LP");
		        
				}
		}
		else {System.out.println("LP no inscrito");
			}
			
		}
		
		
		
	
	
	public HashMap<Integer, Actividad> getActividadesIniciadas() {
		return actividadesIniciadas;
	}

	public void setActividadesIniciadas(HashMap<Integer, Actividad> actividadesIniciadas) {
		this.actividadesIniciadas = actividadesIniciadas;
	}

	public HashMap<Integer, LocalDateTime> getActividadesIniciadasTiempo() {
		return actividadesIniciadasTiempo;
	}

	public void setActividadesIniciadasTiempo(HashMap<Integer, LocalDateTime> actividadesIniciadasTiempo) {
		this.actividadesIniciadasTiempo = actividadesIniciadasTiempo;
	}

	public HashMap<Integer, LocalDateTime> getActividadesEnviadasTiempo() {
		return actividadesEnviadasTiempo;
	}

	public void setActividadesEnviadasTiempo(HashMap<Integer, LocalDateTime> actividadesEnviadasTiempo) {
		this.actividadesEnviadasTiempo = actividadesEnviadasTiempo;
	}

	public HashMap<Integer, Actividad> getActividadesCompletadas() {
		return actividadesCompletadas;
	}

	public void setActividadesCompletadas(HashMap<Integer, Actividad> actividadesCompletadas) {
		this.actividadesCompletadas = actividadesCompletadas;
	}

	public void setLpInscritos(HashMap<Integer, LearningPath> lpInscritos) {
		this.lpInscritos = lpInscritos;
	}

	public void setActividadesEnviadas(HashMap<Integer, Actividad> actividadesEnviadas) {
		this.actividadesEnviadas = actividadesEnviadas;
	}

	public void anadirMapaCompletadas(int idActividad) {
		
		if (actividadesEnviadas.containsKey(idActividad)) {
			Actividad actividadCompleta=actividadesEnviadas.get(idActividad);
			actividadesCompletadas.put(idActividad,actividadCompleta);
		}
		
	}
	
	public void anadirMapaCalificadas(int idActividad, float nota) {
			
			if (actividadesEnviadas.containsKey(idActividad)) {
				actividadesCalificadas.put(idActividad,nota);
				anadirMapaCompletadas(idActividad);
				
			}
			
		}
	

	
	 public HashMap<Integer, Actividad> getActividadesEnviadas() {
		return actividadesEnviadas;
	}
	 
	

	public HashMap<Integer, LocalDateTime> getLpInscritosTiempoI() {
		return lpInscritosTiempoI;
	}

	public void setLpInscritosTiempoI(HashMap<Integer, LocalDateTime> lpInscritosTiempoI) {
		this.lpInscritosTiempoI = lpInscritosTiempoI;
	}

	public HashMap<Integer, LocalDateTime> getLpInscritosTiempoF() {
		return lpInscritosTiempoF;
	}

	public void setLpInscritosTiempoF(HashMap<Integer, LocalDateTime> lpInscritosTiempoF) {
		this.lpInscritosTiempoF = lpInscritosTiempoF;
	}

	public static void inscribirLearningPath(persistenciaLP lpControl, Estudiante estudiante, int idLP) {
	       
	        LearningPath lp = lpControl.obtenerLearningPath(idLP); 
	        if (lp != null) {
	            if (estudiante.getLpInscritos().containsKey(idLP)) {
	                System.out.println("Ya estás inscrito en este Learning Path.");
	            } else {
	                estudiante.getLpInscritos().put(idLP, lp);
	                persistenciaEstudiante.guardarLpInscritos(estudiante);
	                System.out.println("Learning Path inscrito exitosamente: " + lp.getTitulo());
	                LocalDateTime tiempo=LocalDateTime.now();
	                estudiante.getLpInscritosTiempoI().put(idLP,tiempo);
	                
	                
	            }
	        } else {
	            System.out.println("No se encontró un Learning Path con el código proporcionado.");
	        }
	    }
	
	 public void FinalizarLP(int idLp) {
		 if (lpInscritos.containsKey(idLp)) {
			LearningPath LpEspecifico=lpInscritos.get(idLp);
			Map<Integer, Actividad> lpActividades =LpEspecifico.getActividades();
			List<Integer> ListaActividadesLp = new ArrayList<Integer>(lpActividades.keySet());
			List<Integer> ListaActividadesCompletadas = new ArrayList<Integer>(actividadesCompletadas.keySet());
			if (ListaActividadesCompletadas.containsAll(ListaActividadesLp)) {
				System.out.println("Learning Path finalizado exitosamente: " + idLp);
				LocalDateTime tiempo=LocalDateTime.now();
                lpInscritosTiempoF.put(idLp,tiempo);
			}
			else { System.out.println("Aun faltan actividades por completar");}
		 }
		 else { System.out.println("LP no inscrito");}
				
			 
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
	


		
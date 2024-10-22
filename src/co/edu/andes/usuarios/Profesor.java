package co.edu.andes.usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;

import Actividades.*;
import LearningPath.LearningPath;
import LearningPath.Resena;
import Persistencias.persistenciaLP;

import java.lang.Class;



public class Profesor extends Usuario implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private List <Actividad> actividadesCreadas;
	 private Map<Integer, LearningPath> learningPathsCreados  = new HashMap<>();
	 private persistenciaLP persistenciaLP;
	
    public Profesor(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        super(nombre, nombreUsuario, password, "Profesor");
        this.persistenciaLP = new persistenciaLP();
        this.actividadesCreadas = new ArrayList<>();
    }
    

    @Override
    public String toString() {
        return nombre; 
    }

    public String getNombre() {
        return nombre; 
    }
    public void crearLearningPath(Integer codigo, String titulo, String descripcion, String objetivos, String dificultad, String duracion, Map<String, Actividad> actividades, Usuario creador) {
    		LearningPath nuevoLearningPath = new LearningPath(codigo, titulo, descripcion, objetivos, dificultad, duracion, actividades, creador);

    		learningPathsCreados.put(codigo, nuevoLearningPath);
    		persistenciaLP.guardarLearningPaths(learningPathsCreados); 
    		System.out.println("Learning Path creado exitosamente: " + titulo);
    }

    public Map<Integer, LearningPath> getLearningPathsMap() {
        return learningPathsCreados;
    }
    
    public void mostrarLearningPathsDesdeArchivo() {
        persistenciaLP.mostrarLearningPathsDesdeArchivo(); 
       
    }
           
    public void crearTarea(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
		 String ejercisio, int idLp){
        
    	Tarea nuevaTarea = new Tarea(idActividad, descripcion, objetivo, dificultad, duracion, ejercisio);
    	//crear parametro obligatorio
    	actividadesCreadas.add(nuevaTarea);

    	if (learningPathsCreados.containsKey(idLp)) {
			LearningPath lp=learningPathsCreados.get(idLp);
    			lp.anadirActividad(nuevaTarea);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    	
    	
        
 
    public void crearEncuesta(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, int idLp) {
    	
    	Encuesta nuevaEncuesta = new Encuesta(idActividad, descripcion, objetivo, dificultad, duracion);
    	actividadesCreadas.add(nuevaEncuesta);
    	//crear parametro obligatorio
    	
    		if (learningPathsCreados.containsKey(idLp)) {
    			LearningPath lp=learningPathsCreados.get(idLp);
    			lp.anadirActividad(nuevaEncuesta);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    	
    public void crearQuiz(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
			Double notaAprovacion, int idLp) {
    	
    	Quiz nuevoQuiz = new Quiz(idActividad, descripcion, objetivo, dificultad, duracion, notaAprovacion, idLp );
    	actividadesCreadas.add(nuevoQuiz);
    	//crear parametro obligatorio
    	
    		if (learningPathsCreados.containsKey(idLp)) {
    			LearningPath lp=learningPathsCreados.get(idLp);
    			lp.anadirActividad(nuevoQuiz);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    
    public void crearExamen(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
			Double notaAprovacion, int idLp) {
    	
    	Examen nuevoExamen = new Examen(idActividad, descripcion, objetivo, dificultad, duracion, notaAprovacion, idLp );
    	actividadesCreadas.add(nuevoExamen);
    	//crear parametro obligatorio
    	
    		if (learningPathsCreados.containsKey(idLp)) {
    			LearningPath lp=learningPathsCreados.get(idLp);
    			lp.anadirActividad(nuevoExamen);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    
    
    public void crearRevisarRecurso(int idActividad, String descripcion, String objetivo, String dificultad, String duracion
			, String recursoLink, int idLp) {
    	
    	RevisarRecurso nuevoRevisarRecurso = new RevisarRecurso(idActividad, descripcion, objetivo, dificultad, duracion, recursoLink);
    	actividadesCreadas.add(nuevoRevisarRecurso);
    	//crear parametro obligatorio
    	if (learningPathsCreados.containsKey(idLp)) {
			LearningPath lp=learningPathsCreados.get(idLp);
    			lp.anadirActividad(nuevoRevisarRecurso);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    
    
  
    public void calificarActividad (Estudiante estudiante, int idActividad, float nota) {
    	
    	for (Actividad actividad:actividadesCreadas) {
    		if ((actividad.getIdActividad()==idActividad) && (estudiante.getActividadesEnviadas().containsKey(idActividad))) {
    			if((actividad instanceof Quiz)||(actividad instanceof Evaluacion)) {
    				estudiante.anadirMapaCalificadas(idActividad,nota);
    				MonitoreoActividad.setCompletado();
    			}
    			else {
    				System.out.println("no es una actividad calificable"); } }
    		else { 
    			System.out.println("el estudiante no ha enviado la actividad");
    		}}
    		}
    		
    		
    	
  	
    public void eliminarLearningPath(int idLp) {
    	
    	if (learningPathsCreados.containsKey(idLp)) {
			LearningPath lp=learningPathsCreados.get(idLp);
    			learningPathsCreados.remove(lp);
    			lp=null; }
    		else { System.out.println("No se encontro el learning path a eliminar"); }
    	

    	}
    	
    
    
    public void eliminarActividad (int idLp, int idActividad) {
    	
    		if (LearningPath.containsKey()==idLp) {
    			if(LearningPath.getMapaActividades().containsKey(idActividad)){
    				Actividad actividadElim=LearningPath.getMapaActividades().get(idActividad);
    				lp.getMapaActividades().remove(idActividad);
    				actividadesCreadas.remove(actividadElim);
    				actividadElim=null;}
    			else {System.out.println("no existe actividad con ese id en el learning path");}
    		}
    			
    		else {System.out.println("no se encontro el learning path especificado para borrar una actividad en el");
    				
    				
    			}
    			
    }
    	
    
    	//no hay que recorrer la lista porque si la actividad esta en un learning path preado por un profesor tambien va a estar en la lista de actividades
    
    
    public List<Actividad> getActividadesCreadas() {
		return actividadesCreadas;
    }
			    
}


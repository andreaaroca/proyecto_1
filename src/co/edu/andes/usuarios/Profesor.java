package co.edu.andes.usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import Actividades.*;
import LearningPath.LearningPath;
import LearningPath.Resena;

import java.lang.Class;



public class Profesor extends Usuario {
	
	 private List<LearningPath> learningPathsCreados;
	 private List <Actividad> actividadesCreadas;
	
    public Profesor(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        super(nombre, nombreUsuario, password, "Profesor");
        this.learningPathsCreados = new ArrayList<>();
        this.actividadesCreadas = new ArrayList<>();
    }
    public LearningPath crearLearningPath(String titulo, String descripcion, String objetivos, String dificultad) {
        LearningPath nuevoLearningPath = new LearningPath(this, titulo, descripcion, objetivos, dificultad);
        learningPathsCreados.add(nuevoLearningPath);
        return nuevoLearningPath;
        }
    
        
    public List<LearningPath> obtenerLearningPathsCreados() {
         return learningPathsCreados;
         
        }
    
    
    public void crearTarea(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
		 String ejercisio, int idLp){
        
    	Tarea nuevaTarea = new Tarea(idActividad, descripcion, objetivo, dificultad, duracion, ejercisio);
    	//crear parametro obligatorio
    	actividadesCreadas.add(nuevaTarea);

    	for (LearningPath lp:learningPathsCreados) {
    		if (lp.getIdLp()==idLp) {
    			lp.anadirActividad(nuevaTarea);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    	
    	
        }
 
    public void crearEncuesta(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, int idLp) {
    	
    	Encuesta nuevaEncuesta = new Encuesta(idActividad, descripcion, objetivo, dificultad, duracion);
    	actividadesCreadas.add(nuevaEncuesta);
    	//crear parametro obligatorio
    	for (LearningPath lp:learningPathsCreados) {
    		if (lp.getIdLp()==idLp) {
    			lp.anadirActividad(nuevaEncuesta);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    	
    }
    
    public void crearRevisarRecurso(int idActividad, String descripcion, String objetivo, String dificultad, String duracion
			, String recursoLink, int idLp) {
    	
    	RevisarRecurso nuevoRevisarRecurso = new RevisarRecurso(idActividad, descripcion, objetivo, dificultad, duracion, recursoLink);
    	actividadesCreadas.add(nuevoRevisarRecurso);
    	//crear parametro obligatorio
    	for (LearningPath lp:learningPathsCreados) {
    		if (lp.getIdLp()==idLp) {
    			lp.anadirActividad(nuevoRevisarRecurso);
    			
    			
    		} 
    		else {
    			System.out.println("Learning Path inexistente, no se puede añadir actividad");}
    		}
    }
    
    public void editarActividad(int idLp, int idActividad, String paramEditar, String edicion) {
    	for (LearningPath lp:learningPathsCreados) {
    		if (lp.getIdLp()==idLp) {
    			if(().containsKey(idActividad)) {
    				lp.getMapaActividades().get(idActividad);	
    			
    				if (paramEditar=="descripcion"){
    					edicion=edicion.toString();
    					Actividad.setDescripcion(edicion);
    				}
    					
    				}
    		}
    		}
    			
   
    }
    
    public void calificarActividad (Estudiante estudiante, int idActividad, float nota) {
    	for (Actividad actividad:actividadesCreadas) {
    		if ((actividad.getIdActividad()==idActividad) && (estudiante.getActividadesEnviadas().contains(idActividad))) {
    			if(actividad instanceof Evaluacion) {
    				estudiante.anadirMapaCalificadas(idActividad,nota);
    			}
    			else {
    				System.out.println("no es una actividad calificable"); } }
    		else { 
    			System.out.println("el estudiante no ha enviado la actividad");
    		}}
    		}
    		
    		
    	
  	
    public void eliminarLearningPath(int idLp) {
    	
    	for (LearningPath lp: learningPathsCreados) {
    		if (lp.getIdLp()==idLp) {
    			learningPathsCreados.remove(lp);
    			lp=null; }
    		else { System.out.println("No se encontro el learning path a eliminar"); }
    	

    	}
    	
    }
    
    public void eliminarActividad (int idLp, int idActividad) {
    	for (LearningPath lp: learningPathsCreados) {
    		if (lp.getIdLp()==idLp) {
    			if(lp.getMapaActividades().containsKey(idActividad)){
    				Actividad actividadElim=lp.getMapaActividades().get(idActividad);
    				lp.getMapaActividades().remove(idActividad);
    				actividadesCreadas.remove(actividadElim);
    				actividadElim=null;}
    			else {System.out.println("no existe actividad con ese id en el learning path");}
    		}
    			
    		else {System.out.println("no se encontro el learning path especificado para borrar una actividad en el");
    				
    				
    			}
    			
    }}
    	
    
    	//no hay que recorrer la lista porque si la actividad esta en un learning path preado por un profesor tambien va a estar en la lista de actividades
    
    
    public List<Actividad> getActividadesCreadas() {
		return actividadesCreadas;
    }
		
		

		

	
		
	
	public void guardarLearningPathsEnArchivo() {
        String archivoPath = "learningPaths.txt";
        try (FileWriter fw = new FileWriter(archivoPath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            for (LearningPath lp : learningPathsCreados) {
                pw.println(lp.getTitulo() + "," + "," + getNombreUsuario());
            }
            System.out.println("LearningPaths guardados exitosamente en " + archivoPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}


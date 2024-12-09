package Persistencias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

import LearningPath.LearningPath;
import Actividades.*;
import co.edu.andes.usuarios.*;

public class persistenciaLP implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String ARCHIVO_LP = "learningPaths.ser"; 
	 
	 private Map<Integer, LearningPath> learningPathsCreados;
	 public persistenciaLP() {
	        this.learningPathsCreados= cargarLearningPaths();
	    }
	 @SuppressWarnings("unchecked")
	 public Map<Integer, LearningPath> cargarLearningPaths() {
		
		 File archivo = new File(ARCHIVO_LP);
	     if (archivo.exists()) { 
	         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
	             return (Map<Integer, LearningPath>) ois.readObject(); 
	         } catch (IOException | ClassNotFoundException e) {
	             e.printStackTrace();
	         }
	     }
	     return new HashMap<>(); 
	 }
	 
	 
	 
	 public void guardarLearningPaths(Map<Integer, LearningPath> nuevosLearningPaths) {
		    
		    Map<Integer, LearningPath> learningPathsExistentes = cargarLearningPaths();

		    learningPathsExistentes.putAll(nuevosLearningPaths); 
		    File archivo = new File(ARCHIVO_LP);

		    try {
		        if (!archivo.exists()) {
		            archivo.createNewFile(); 
		        }
		
		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
		            oos.writeObject(learningPathsExistentes); 
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	 
	 public void EliminarLearningPaths(int idLp) {
		    
		    Map<Integer, LearningPath> learningPathsExistentes = cargarLearningPaths();
		    if (learningPathsExistentes.keySet().contains(idLp)){
			    learningPathsExistentes.remove(idLp); 
			    File archivo = new File(ARCHIVO_LP);
	
			    try {
			        if (!archivo.exists()) {
			            archivo.createNewFile(); 
			        }
			
			        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
			            oos.writeObject(learningPathsExistentes); 
			        }
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		    }
		}
	 
	 public void actualizarRating(int idLp, double nuevoRating) {
		    Map<Integer, LearningPath> learningPaths = cargarLearningPaths(); 
		    if (learningPaths.containsKey(idLp)) 
		    { 
		        LearningPath lp = learningPaths.get(idLp);
		        lp.setPromedioCalificaciones(nuevoRating); 
		        guardarLearningPaths(learningPaths);
		    }
		    else
		    {
		        System.out.println("LearningPath con ID " + idLp + " no encontrado en el archivo.");
		    }
		
		}
	 
	 public void actualizarActividades(int idLp, int idActividad, Actividad actividad) {
		    Map<Integer, LearningPath> learningPaths = cargarLearningPaths(); 
		    if (learningPaths.containsKey(idLp)) 
		    { 
		        LearningPath lp = learningPaths.get(idLp);
		        
		        lp.agregarActividades(actividad); 
		        
		        guardarLearningPaths(learningPaths);
		    }
		    else
		    {
		        System.out.println("LearningPath con ID " + idLp + " no encontrado en el archivo.");
		    }
	 }
	 
	 
	    
	    public void mostrarLearningPathsDesdeArchivo() {
	        Map<Integer, LearningPath> learningPaths = cargarLearningPaths(); 
	        if (learningPaths.isEmpty()) {
	            System.out.println("No hay Learning Paths registrados en el archivo.");
	        } else {
	            System.out.println("Learning Paths registrados:");
	            for (LearningPath lp : learningPaths.values()) {
	                System.out.println("Profesor Creador: " + lp.getProfesorCreador().getNombre());
	                System.out.println("Código: " + lp.getIdLP());
	                System.out.println("Título: " + lp.getTitulo());
	                System.out.println("Descripción: " + lp.getDescripcion());
	                System.out.println("Objetivos: " + lp.getObjetivos());
	                System.out.println("Dificultad: " + lp.getDificultad());
	                System.out.println("Duración: " + lp.getDuracion());
	                System.out.println("Rating: " + lp.getPromedioCalificaciones());
	                System.out.println("Actividades: " + lp.getListaActividades().keySet());
	                System.out.println("------------------------------------");
	                //Prueba
	            }
	        }
	    }
	    
	    public String obtenerLearningPathsComoTexto() {
	        StringBuilder sb = new StringBuilder();
	        Map<Integer, LearningPath> learningPaths = cargarLearningPaths(); 

	        if (learningPaths.isEmpty()) {
	            sb.append("No hay Learning Paths registrados en el archivo.\n");
	        } else {
	            sb.append("Learning Paths registrados:\n");
	            for (LearningPath lp : learningPaths.values()) {
	                sb.append("Profesor Creador: ").append(lp.getProfesorCreador().getNombre()).append("\n");
	                sb.append("Código: ").append(lp.getIdLP()).append("\n");
	                sb.append("Título: ").append(lp.getTitulo()).append("\n");
	                sb.append("Descripción: ").append(lp.getDescripcion()).append("\n");
	                sb.append("Objetivos: ").append(lp.getObjetivos()).append("\n");
	                sb.append("Dificultad: ").append(lp.getDificultad()).append("\n");
	                sb.append("Duración: ").append(lp.getDuracion()).append("\n");
	                sb.append("Rating: ").append(lp.getPromedioCalificaciones()).append("\n");
	                sb.append("Actividades: ").append(lp.getListaActividades().keySet()).append("\n");
	                sb.append("------------------------------------\n");
	            }
	        }

	        return sb.toString();
	    }
	    
	    public String obtenerLearningPathsCreadosPCComoTexto(String nombre) {
	        StringBuilder sb = new StringBuilder();
	        Map<Integer, LearningPath> learningPaths = cargarLearningPaths(); 
	        
	        if (learningPaths.isEmpty()) {
	            sb.append("No hay Learning Paths registrados en el archivo.\n");
	        } else {
	            sb.append("Learning Paths creados:\n");
	            for (LearningPath lp : learningPaths.values()) {
	            	
		                sb.append("Profesor Creador: ").append(lp.getProfesorCreador().getNombre()).append("\n");
		                sb.append("Código: ").append(lp.getIdLP()).append("\n");
		                sb.append("Título: ").append(lp.getTitulo()).append("\n");
		                sb.append("Descripción: ").append(lp.getDescripcion()).append("\n");
		                sb.append("Objetivos: ").append(lp.getObjetivos()).append("\n");
		                sb.append("Dificultad: ").append(lp.getDificultad()).append("\n");
		                sb.append("Duración: ").append(lp.getDuracion()).append("\n");
		                sb.append("Rating: ").append(lp.getPromedioCalificaciones()).append("\n");
		                sb.append("Actividades: ").append(lp.getListaActividades().keySet()).append("\n");
		                sb.append("------------------------------------\n");
	            
	            	
	            	}
	        }

	        return sb.toString();
	    }
	    
	    
	    
	    public  Map<Integer, LearningPath> obtenerLearningPaths() {
	        return learningPathsCreados;
	    }

	    public LearningPath obtenerLearningPath(Integer codigo) {
	        return learningPathsCreados.get(codigo);
	    }
	    
	    
	    
	    
	    
	}
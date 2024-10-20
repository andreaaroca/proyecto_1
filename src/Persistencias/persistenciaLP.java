package Persistencias;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import LearningPath.LearningPath;

public class persistenciaLP {
	
	 private Map<String, LearningPath> learningPaths  = new HashMap<>(); 
	 private static final String ARCHIVO_LP = "learningPaths.ser"; // Archivo para la serialización
	 
	 public persistenciaLP() {
	        this.learningPaths = cargarLearningPaths();
	    }

	    public void agregarLearningPath(String codigo, LearningPath lp) {
	        learningPaths.put(codigo, lp);
	        guardarLearningPaths();
	    }

	    // Guardar el mapa de LearningPaths en un archivo
	    private void guardarLearningPaths() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_LP))) {
	            oos.writeObject(learningPaths);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public Map<String, LearningPath> cargarLearningPaths() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_LP))) {
	            return (Map<String, LearningPath>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return new HashMap<>();
	        }
	    }

	    public LearningPath obtenerLearningPath(String codigo) {
	        return learningPaths.get(codigo);
	    }
	    
	    public Map<String, LearningPath> obtenerLearningPaths() {
	        return learningPaths;
	    }
	    
	    public boolean verificarAgregarLearningPath(LearningPath lp) {
	        if (learningPaths.containsKey(lp.getIdLP())) {
	            System.out.println("Error: El código del Learning Path ya está registrado. Debe crear otro código.");
	            return false; 
	        }
	        agregarLearningPath(lp.getIdLP(), lp);
	        System.out.println("Learning Path agregado exitosamente.");
	        return true;
	    }
	}




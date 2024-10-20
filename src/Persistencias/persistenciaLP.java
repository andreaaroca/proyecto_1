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
	
	 private Map<Integer, LearningPath> learningPathsMap  = new HashMap<>(); 
	 private static final String ARCHIVO_LP = "learningPaths.ser"; // Archivo para la serialización
	 
	 public persistenciaLP() {
	        this.learningPathsMap= cargarLearningPaths();
	    }
	 
	 public boolean agregarLearningPath(LearningPath lp) {
	        int codigo = lp.getIdLP();

	        if (learningPathsMap.containsKey(codigo)) {
	            System.out.println("El código del Learning Path ya existe. Por favor, ingrese un código diferente.");
	            return false; 
	        }
	        
	        learningPathsMap.put(codigo, lp);
	        guardarLearningPaths();
	        System.out.println("Learning Path agregado exitosamente.");
	        return true; 
	    }

	    // Guardar el mapa de LearningPaths en un archivo
	    private void guardarLearningPaths() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_LP))) {
	            oos.writeObject(learningPathsMap);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public Map<Integer, LearningPath> cargarLearningPaths() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_LP))) {
	            return (Map<Integer, LearningPath>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            return new HashMap<>();
	        }
	    }

	    public LearningPath obtenerLearningPath(Integer codigo) {
	        return learningPathsMap.get(codigo);
	    }
	    
	    public Map<Integer, LearningPath> obtenerLearningPaths() {
	        return learningPathsMap;
	    }
	}




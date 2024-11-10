	package Persistencias;
	
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
	
	import LearningPath.LearningPath;
	import co.edu.andes.usuarios.Estudiante;
	
	public class persistenciaEstudiante implements Serializable {
		
	private static final String ARCHIVO_ESTUDIANTES = "estudiantes.ser"; 
	private HashMap<String, HashMap<Integer, LearningPath>> mapaEstudiantes;
	private HashMap<Integer, List<LearningPath>> lpInscritos;
	
	public persistenciaEstudiante() {
	   
	    mapaEstudiantes = new HashMap<>();
	    cargarLpInscritos(); 
	}
	
	 public void cargarLpInscritos() {
	        File archivo = new File(ARCHIVO_ESTUDIANTES);
	        if (!archivo.exists()) {
	            mapaEstudiantes = new HashMap<>(); 
	            return;
	        }
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
	            @SuppressWarnings("unchecked")
	            HashMap<String, HashMap<Integer, LearningPath>> mapa = (HashMap<String, HashMap<Integer, LearningPath>>) ois.readObject();
	            mapaEstudiantes = mapa;
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            mapaEstudiantes = new HashMap<>(); 
	        }
	    }


    public void guardarLpInscritos(Estudiante estudiante) {
       
        String nombreUsuario = estudiante.getNombreUsuario();
        HashMap<Integer, LearningPath> learningPathsInscritos = estudiante.getLpInscritos();

       
        mapaEstudiantes.put(nombreUsuario, learningPathsInscritos);
        
        File archivo = new File(ARCHIVO_ESTUDIANTES);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();  
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ESTUDIANTES))) {
            oos.writeObject(mapaEstudiantes);
            System.out.println("Datos guardados correctamente en " + ARCHIVO_ESTUDIANTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void mostrarLpInscritos(Estudiante estudiante) {
        String nombreUsuario = estudiante.getNombreUsuario();
        
        cargarLpInscritos();

            if (mapaEstudiantes.containsKey(nombreUsuario)) {
                HashMap<Integer, LearningPath> learningPathsInscritos = mapaEstudiantes.get(nombreUsuario);
              

                System.out.println("Learning Paths inscritos para " + nombreUsuario + ":");
                for (LearningPath lp : learningPathsInscritos.values()) {
                    System.out.println(" - " + lp.getTitulo()); 
                }
            } else {
                System.out.println("No se encontraron Learning Paths inscritos para el estudiante " + nombreUsuario);
            }

        
        }
    }
	


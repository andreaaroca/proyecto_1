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

	
	public persistenciaEstudiante() {
	   
	    mapaEstudiantes = cargarLpInscritos(); 
	}
	
	@SuppressWarnings("unchecked")
    private HashMap<String, HashMap<Integer, LearningPath>> cargarLpInscritos() {
        File archivo = new File(ARCHIVO_ESTUDIANTES);

        if (!archivo.exists()) {
            return new HashMap<>(); 
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (HashMap<String, HashMap<Integer, LearningPath>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>(); 
        }
    }
	
    private void guardarLpInscritosEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ESTUDIANTES))) {
            oos.writeObject(mapaEstudiantes);
            System.out.println("Datos guardados correctamente en " + ARCHIVO_ESTUDIANTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void guardarLpInscritos(Estudiante estudiante) {
    	
    	mapaEstudiantes = cargarLpInscritos();
       
        String nombreUsuario = estudiante.getNombreUsuario();
        HashMap<Integer, LearningPath> learningPathsInscritos = estudiante.getLpInscritos();

       
        mapaEstudiantes.put(nombreUsuario, learningPathsInscritos);
        guardarLpInscritosEnArchivo();
        
    }
    
    public void mostrarLpInscritos(Estudiante estudiante) {
        String nombreUsuario = estudiante.getNombreUsuario();
        

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

	

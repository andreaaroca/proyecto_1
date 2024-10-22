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
	
	private static final long serialVersionUID = 1L;
	private static final String ARCHIVO_ESTUDIANTES = "estudiantes_inscritos.ser";
	
	private Map<Integer, LearningPath> lpInscritos;
	public persistenciaEstudiante() {
        this.lpInscritos = cargarInscripciones();
	}
	
        @SuppressWarnings("unchecked")
   	 public Map<Integer, LearningPath> cargarInscripciones() {
   		
   		 File archivo = new File(ARCHIVO_ESTUDIANTES);
   	     if (archivo.exists()) { 
   	         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
   	             return (Map<Integer, LearningPath>) ois.readObject(); 
   	         } catch (IOException | ClassNotFoundException e) {
   	             e.printStackTrace();
   	         }
   	     }
   	     return new HashMap<>(); 
   	 }

        public void guardarLpInscritos(Estudiante estudiante) {
            HashMap<Integer, LearningPath> lpInscritos = estudiante.getLpInscritos();
   		    Map<Integer, LearningPath> inscripcionesExistentes = cargarInscripciones();

   		    inscripcionesExistentes.putAll(lpInscritos); 
   		    File archivo = new File(ARCHIVO_ESTUDIANTES);

   		    try {
   		        if (!archivo.exists()) {
   		            archivo.createNewFile(); 
   		        }
   		
   		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
   		            oos.writeObject(inscripcionesExistentes); 
   		        }
   		    } catch (IOException e) {
   		        e.printStackTrace();
   		    }
   		}
        
        public void mostrarLpInscritosDesdeArchivo(List<Estudiante> estudiantes) {
            Map<Integer, LearningPath> inscripciones = cargarInscripciones();
            
            for (Estudiante estudiante : estudiantes) {
                System.out.println("Inscripciones para " + estudiante.getNombre() + ":");
                for (Map.Entry<Integer, LearningPath> entry : inscripciones.entrySet()) {
                    LearningPath lp = entry.getValue();
                    if (lp != null) {
                        System.out.println("- " + lp.getTitulo() + " (ID: " + lp.getIdLP() + ")");
                    }
                }
                System.out.println("---");
            }
        }
	
}

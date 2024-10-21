package Persistencias;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import LearningPath.LearningPath;
import co.edu.andes.usuarios.Estudiante;

public class persistenciaEstudiante {
	
	private static final String ARCHIVO_ESTUDIANTES = "estudiantes_inscritos.txt";
	persistenciaLP lpControl = new persistenciaLP();
	Scanner scanner = new Scanner(System.in);
	
    public void guardarInscripciones(Estudiante estudiante) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_ESTUDIANTES, true))) {
            writer.write(estudiante.getNombreUsuario() + "\n"); 
            for (LearningPath lp : estudiante.getLpInscritos().values()) {
                writer.write(lp.getIdLP() + "\n"); 
            }
            writer.write("---\n"); 
        } catch (IOException e) {
            System.err.println("Error al guardar inscripciones: " + e.getMessage());
        }
    }

    public void cargarInscripciones(List<Estudiante> estudiantes) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_ESTUDIANTES))) {
            String linea;
            Estudiante estudianteActual = null;

            while ((linea = reader.readLine()) != null) {
                if (linea.equals("---")) {
                    
                    estudianteActual = null;
                } else if (estudianteActual == null) {
                    estudianteActual = buscarEstudiantePorNombre(linea, estudiantes);
                } else {
                    int codigoLP = Integer.parseInt(linea);
                    if (estudianteActual != null) {
                    	Estudiante.inscribirLearningPath(lpControl, estudianteActual, scanner); 
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar inscripciones: " + e.getMessage());
        }
    }

    private Estudiante buscarEstudiantePorNombre(String nombreUsuario, List<Estudiante> estudiantes) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNombreUsuario().equals(nombreUsuario)) {
                return estudiante;
            }
        }
        return null; 
    }
	
}

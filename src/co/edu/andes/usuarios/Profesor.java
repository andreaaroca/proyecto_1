package co.edu.andes.usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import LearningPath.LearningPath;

public class Profesor extends Usuario {
	
	 private List<LearningPath> learningPathsCreados;
	
    public Profesor(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        super(nombre, nombreUsuario, password, "Profesor");
        this.learningPathsCreados = new ArrayList<>();
    }
    public LearningPath crearLearningPath(String titulo, String descripcion, String objetivos, String dificultad) {
        LearningPath nuevoLearningPath = new LearningPath(this, titulo, descripcion, objetivos, dificultad);
        learningPathsCreados.add(nuevoLearningPath);
        return nuevoLearningPath;
        }
        
    public List<LearningPath> obtenerLearningPathsCreados() {
         return learningPathsCreados;
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


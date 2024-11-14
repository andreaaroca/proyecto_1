package Controlador;

import co.edu.andes.usuarios.*;


import co.edu.andes.sistema.GestorUsuarios;

import java.util.Map;

import Actividades.*;
import LearningPath.*;

import Persistencias.*;
import java.util.Scanner;



public class Controlador {
	
	

	public Controlador() {
		// TODO Auto-generated constructor stub
	}


	public static void crearEstudiante(String nombre, String nombreUsuario, String password, GestorUsuarios gestorUsuarios) {
		Usuario usuario;
		usuario = new Estudiante(nombre, nombreUsuario, password, "Estudiante");
		boolean usuarioYaRegistrado = gestorUsuarios.registrarUsuario(usuario, "Estudiante");
        if (usuarioYaRegistrado) {
        	 System.out.println("Error: El nombre de usuario '" + nombreUsuario + "' ya está registrado.");
        } else {
        	System.out.println("Estudiante registrado exitosamente.");
           
        }
	}
	
	public static void crearProfesor(String nombre, String nombreUsuario, String password, GestorUsuarios gestorUsuarios) {
		Usuario usuario;
		usuario = new Profesor(nombre, nombreUsuario, password, "Profesor");
		boolean usuarioYaRegistrado = gestorUsuarios.registrarUsuario(usuario, "Profesor");
        if (usuarioYaRegistrado) {
        	 System.out.println("Error: El nombre de usuario '" + nombreUsuario + "' ya está registrado.");
        } else {
        	System.out.println("Profesor registrado exitosamente.");
           
        }
	}
	
	public static void profesorCrearLearningPath(int codigo, String titulo, String descripcion, String objetivos, String dificultad, String duracion, Map<String, Actividad> actividades, Profesor profesorCreador) {
		profesorCreador.crearLearningPath(codigo, titulo, descripcion, objetivos, dificultad, duracion, actividades, profesorCreador);
	}
	
	
	public static void crearActividad(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo, 
			Double notaAprovacion,  String recursoLink, String ejercicio, int idLp, Profesor profesorCreador){
		
				Map<Integer, LearningPath> mapaProfesorLp=profesorCreador.getLearningPathsMap();
				if(mapaProfesorLp.containsKey(idLp)) {
					LearningPath lp=mapaProfesorLp.get(idLp);
					if (!(lp.getActividades().containsKey(idActividad))) {
						if (tipo=="Tarea") {
							profesorCreador.crearTarea(idActividad, descripcion, objetivo, dificultad, duracion,
									 ejercicio, idLp); }
						else if (tipo=="Encuesta") {
							profesorCreador.crearEncuesta(idActividad, descripcion, objetivo, dificultad, duracion, idLp); }
							
						else if (tipo=="Revisar Recurso") {
							profesorCreador.crearRevisarRecurso(idActividad, descripcion, objetivo, dificultad, duracion
									, recursoLink, idLp);}
						
					
						else if (tipo=="Quiz") {
							profesorCreador.crearQuiz(idActividad, descripcion, objetivo,  dificultad, duracion,
									 notaAprovacion, idLp);}
						
						else if (tipo=="Examen") {
							profesorCreador.crearExamen(idActividad, descripcion, objetivo,  dificultad, duracion,
									 notaAprovacion, idLp);}
						
						else {
							System.out.println("No existe ese tipo de actividad o esta mal escrito, no se puede añadir actividad");
						}
				} 
					
					else {
						System.out.println("Ya existe esta actividade en el Learning Path");}
					
					
				}
				
				else {
					System.out.println("Learning Path inexistente o creado por otro profesor, no se puede añadir actividad");
				}
	}
	
	public static void eliminarLp(int idLp, Profesor profesorCreador) {
		Map<Integer, LearningPath> mapaProfesorLp=profesorCreador.getLearningPathsMap();
		if(mapaProfesorLp.containsKey(idLp)) {
			profesorCreador.eliminarLearningPath(idLp);
			}
		else {
			System.out.println("Learning Path inexistente o creado por otro profesor, no se puede eliminar");
		}
		
	}
	
	public static void profesorCalificarActividad(String nombreUsuario, int idActividad, float nota, GestorUsuarios gestorUsuarios, Profesor profesorEvaluador) {
			Usuario usuario=gestorUsuarios.obtenerUsuario(nombreUsuario);
			
		    Estudiante estudiante = (Estudiante) usuario;
			profesorEvaluador.calificarActividad(estudiante, idActividad, nota);
			
		}
		
	public static void calcularTiempoActividad(String nombreUsuario, int idActividad, float nota, GestorUsuarios gestorUsuarios, Profesor profesorEvaluador) {
		Usuario usuario=gestorUsuarios.obtenerUsuario(nombreUsuario);
		
	    Estudiante estudiante = (Estudiante) usuario;
		profesorEvaluador.calificarActividad(estudiante, idActividad, nota);
		
	}
		
		
	
	
	public static void imprimirLearningPathsInscritos(persistenciaEstudiante persistencia, Estudiante estudiante) {
    	persistencia.guardarLpInscritos(estudiante);
    	persistencia.mostrarLpInscritos(estudiante);
       
    }
	
	public static void mostrarLearningPathsDesdeArchivo(persistenciaLP lpControl) {
		lpControl.mostrarLearningPathsDesdeArchivo();
		
	}
	
	public static void estudianteInscribirLearningPath(persistenciaLP lpControl, Estudiante estudiante, Scanner scanner) {
		Estudiante.inscribirLearningPath(lpControl, estudiante, scanner);
	}
		
	public static void estudianteCrearResenaLearningPath(int idLp, String opinionActividad, int rating, int idActividad, Estudiante estudiante) {
		estudiante.crearReseñaLearningPath(idLp, opinionActividad, rating, idActividad);
	}
		
	
}	
	
	
	

	
	
	
	
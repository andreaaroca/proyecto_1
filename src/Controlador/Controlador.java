package Controlador;

import co.edu.andes.usuarios.*;

import java.util.Map;

import LearningPath.*;

import Persistencias.*;

public class Controlador {

	public Controlador() {
		// TODO Auto-generated constructor stub
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

	
}	
	
	
	
	

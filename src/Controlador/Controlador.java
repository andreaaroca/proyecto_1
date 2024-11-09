package Controlador;

import co.edu.andes.usuarios.*;

public class Controlador {

	public Controlador() {
		// TODO Auto-generated constructor stub
	}



	
	public void crearActividad(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo, 
			Double notaAprovacion,  String recursoLink, String ejercicio, int idLp, Profesor profesorCreador){
		
			if (tipo=="Tarea") {
				profesorCreador.crearTarea(idActividad, descripcion, objetivo, dificultad, duracion,
						 ejercicio, idLp); }
			
			else if (tipo=="Encuesta") {
			profesorCreador.crearEncuesta(idActividad, descripcion, objetivo, dificultad, duracion, idLp); }
			
			else if (tipo=="Revisar Recurso") {
				profesorCreador.crearRevisarRecurso(idActividad, descripcion, objetivo, dificultad, duracion, idLp);}
			
		
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

	
}	
	
	
	
	

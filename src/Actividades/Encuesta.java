package Actividades;

import java.util.*;




public class Encuesta extends Actividad {
	
	private List<String> preguntas;

	public Encuesta(int idActividad, String descripcion, String objetivo, String dificultad, String duracion) {
		super(idActividad, descripcion, objetivo, dificultad, duracion);
		preguntas=new ArrayList<String>();
		
	}
	
	
	public List<String> getPreguntas() {
		return preguntas;
	}


	public void agregarPregunta(String pregunta) {
		preguntas.add(pregunta);
	
		
		//despues esto se enviara a registro actividad, y se asociara la respuesta del estudiante con la pregunta
		
	}

	
}
	
	
	
	
	




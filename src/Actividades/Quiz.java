package Actividades;
import java.util.*;

public class Quiz extends Evaluacion 
{
	private Map<String,List<String>> preguntas;
	private PreguntaQuiz pregunta;
	
	public Quiz(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo,
			Double notaAprovacion) 
	{
		super(idActividad, descripcion, objetivo, dificultad, duracion, tipo, notaAprovacion);
		this.preguntas = new HashMap<String,List<String>>();
	}

	public Map<String, List<String>> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Map<String, List<String>> preguntas) {
		this.preguntas = preguntas;
	}

	public PreguntaQuiz getPregunta() {
		return pregunta;
	}

	public void setPregunta(PreguntaQuiz pregunta) {
		this.pregunta = pregunta;
	}
	
	
}
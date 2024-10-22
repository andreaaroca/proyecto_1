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
	
	
}

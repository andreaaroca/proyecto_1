package Actividades;
import java.util.*;

public class Quiz extends Evaluacion 
{
	private static final long serialVersionUID = 1L;
	private Map<String,PreguntaQuiz> preguntas;
	private PreguntaQuiz pregunta;
	
	public Quiz(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo,
			Double notaAprovacion) 
	{
		super(idActividad, descripcion, objetivo, dificultad, duracion, tipo, notaAprovacion);
		this.preguntas = new HashMap<String,PreguntaQuiz>();
	}

	public Map<String, PreguntaQuiz> getPreguntas() 
	{
		return preguntas;
	}

	public void agregarPreguntas(Map<String, PreguntaQuiz> preguntas, PreguntaQuiz pregunta) 
	{
		this.preguntas.put(pregunta.getEnunciado(), pregunta);
	}

	public PreguntaQuiz getPregunta() 
	{
		return pregunta;
	}
	
	public void crearPregunta(String enunciado, List<String> opciones, int indiceCorrecto, String explicacion)
	{
		this.pregunta = new PreguntaQuiz(enunciado, opciones, indiceCorrecto, explicacion);
	}
	
	
}
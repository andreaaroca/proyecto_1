package Actividades;


import java.util.*;


public class Encuesta extends Actividad 
{
	private static final long serialVersionUID = 1L;
	private List<String> preguntas;
	private Map<String, String> respuestasEstudiante;

	public Encuesta(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo) 
	{
		super(idActividad, descripcion, objetivo, dificultad, duracion, tipo);
		this.preguntas=new ArrayList<String>();
		this.respuestasEstudiante = new HashMap <String,String>();
	}
	
	
	public List<String> getPreguntas() 
	{
		return preguntas;
	}


	public void agregarPregunta(String pregunta) 
	{
		preguntas.add(pregunta);
		//despues esto se enviara a registro actividad, y se asociara la respuesta del estudiante con la pregunta
	}
	
	public void agregarRespuesta(String idEstudiante, String respuesta)
	{
		respuestasEstudiante.put(idEstudiante, respuesta);
	}

	public Map<String, String> getRespuestasEstudiantes()
	{
		return respuestasEstudiante;
	}
}
	
	
	
	

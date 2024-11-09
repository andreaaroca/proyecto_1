package Actividades;
import java.util.*;

public class Examen extends Evaluacion 
{
	private List<String> preguntasAbiertas;
	private Map<String, String> respuestasEstudiante;
	private boolean calificado;
	
	public Examen(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo,
			Double notaAprovacion) 
	{
		super(idActividad, descripcion, objetivo, dificultad, duracion, tipo, notaAprovacion);
		this.preguntasAbiertas = new ArrayList<String>();
		this.respuestasEstudiante = new HashMap <String,String>();
		this.calificado = false;
		
	}

}
package Actividades;

import java.util.*;
import LearningPath.Resena;
public abstract class Actividad {

	
	private String descripcion;
	private String objetivo;
	private String dificultad;
	private String duracion;
	private List <Resena> resenas;
	private boolean enviado;
	
	public Actividad(String descripcion, String objetivo, String dificultad, String duracion, List<Resena> resenas) {
		
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.dificultad = dificultad;
		this.duracion = duracion;
		this.resenas = resenas;
	}
	
	
	

}

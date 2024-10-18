package Actividades;

import java.util.*;
import LearningPath.*;
public abstract class Actividad {

	protected int idActividad;
	protected String descripcion;
	protected String objetivo;
	protected String dificultad;
	protected String duracion;
	protected List <Resena> resenas;
	protected boolean enviado;
	
	
	public Actividad(int idActividad, String descripcion, String objetivo, String dificultad, String duracion) {
		
		this.idActividad= idActividad;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.dificultad = dificultad;
		this.duracion = duracion;
		this.resenas = new ArrayList<Resena>();
		this.enviado=false;
		
	}

	
	
	public int getIdActividad() {
		return idActividad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public String getDificultad() {
		return dificultad;
	}

	public String getDuracion() {
		return duracion;
	}

	public List<Resena> getResenas() {
		return resenas;
	}

	public boolean isEnviado() {
		return enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

	public void agregarResena(Resena r) {
		resenas.add(r); 
	}
	
}
	

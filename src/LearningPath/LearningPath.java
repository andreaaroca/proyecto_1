package LearningPath;

import java.io.Serializable;
import java.util.*;

import java.util.List;

import Actividades.Actividad;


import co.edu.andes.usuarios.Profesor;

public class LearningPath implements Serializable {
	
	private static final long serialVersionUID = 1L; // Para la serialización
	
    private String titulo;
    private String descripcion; 
    private String objetivos;
    private String dificultad;
    private String duracion;
    private Map<Integer, Actividad> actividades;
    private String idActividad;
    private int idLP;
	
    public LearningPath(int idLP, String titulo, String descripcion, String objetivos, 
            String dificultad, String duracion, Map<Integer, Actividad> actividades) {
    	this.idLP = idLP;
    	this.titulo = titulo;
    	this.descripcion = descripcion;
    	this.objetivos = objetivos;
    	this.dificultad = dificultad;
    	this.duracion = duracion;
    	this.actividades = new HashMap<>();
    	
    }

	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	

	public Map<Integer, Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Map<Integer, Actividad> actividades) {
		this.actividades = actividades;
	}
	
	public void agregarActividades(List<Actividad> listaActividades) {
	    for (Actividad actividad : listaActividades) {
	        actividades.put(actividad.getIdActividad(), actividad);
	    }
	}

    public boolean validarLearningPath() {
        return 
               titulo != null && !titulo.isEmpty() &&
               descripcion != null && !descripcion.isEmpty() &&
               objetivos != null && !objetivos.isEmpty() &&
               dificultad != null && !dificultad.isEmpty() &&
               duracion != null && !duracion.isEmpty() &&
               actividades != null && !actividades.isEmpty();
    }
    
    public Map<Integer, Actividad> getListaActividades() {
        return actividades;
    }

	public String getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}

	public int getIdLP() {
		return idLP;
	}

	public void setIdLP(int idLP) {
		this.idLP = idLP;
	}	
}

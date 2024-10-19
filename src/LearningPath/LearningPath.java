package LearningPath;

import java.util.*;

import java.util.List;

import Actividades.Actividad;


import co.edu.andes.usuarios.Profesor;

public class LearningPath {
	
    private String titulo;
    private String descripcion; 
    private String objetivos;
    private String dificultad;
    private String duracion;
    private List<Actividad> obligatorias;
	
    public LearningPath(String titulo, String descripcion, String objetivos, 
            String dificultad, String duracion, List<Actividad> obligatorias) {
    
    	this.titulo = titulo;
    	this.descripcion = descripcion;
    	this.objetivos = objetivos;
    	this.dificultad = dificultad;
    	this.duracion = duracion;
    	
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


	public List<Actividad> getObligatorias() {
		return obligatorias;
	}


	public void setObligatorias(List<Actividad> obligatorias) {
		this.obligatorias = obligatorias;
	}
	
	public void agregarActividad(Actividad actividad) {
        this.obligatorias.add(actividad);
    }

    public void eliminarActividad(Actividad actividad) {
        this.obligatorias.remove(actividad);
    }

    public boolean validarLearningPath() {
        return 
               titulo != null && !titulo.isEmpty() &&
               descripcion != null && !descripcion.isEmpty() &&
               objetivos != null && !objetivos.isEmpty() &&
               dificultad != null && !dificultad.isEmpty() &&
               duracion != null && !duracion.isEmpty() &&
               obligatorias != null && !obligatorias.isEmpty();
    }
    
    public List<Actividad> getListaActividades() {
        return obligatorias;
    }
holaaaaaaaaaaaaaaaaa
odio esto
	
}

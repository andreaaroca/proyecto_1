package LearningPath;

import java.io.Serializable;
import java.util.*;

import Actividades.Actividad;


import co.edu.andes.usuarios.Profesor;
import co.edu.andes.usuarios.Usuario;

public class LearningPath implements Serializable {
	
	private static final long serialVersionUID = 1L;// Para la serialización
	private Usuario profesorCreador;
    private String titulo;
    private String descripcion; 
    private String objetivos;
    private String dificultad;
    private String duracion;
    private Map<Integer, Actividad> actividades;
    private String idActividad;
    private int idLP;
    private Map<Integer, String> reseñas;
    List<Integer> calificaciones; 
    private double promedioCalificaciones; 
	
    public LearningPath(Integer idLP, String titulo, String objetivos, String descripcion, String dificultad, 
            String duracion, Map<String, Actividad> actividades, Usuario profesorCreador) {
    	this.idLP = idLP;
    	this.titulo = titulo;
    	this.descripcion = descripcion;
    	this.objetivos = objetivos;
    	this.dificultad = dificultad;
    	this.duracion = duracion;
    	this.actividades = new HashMap<>();
    	this.profesorCreador = profesorCreador;
    
    	
    }
    
    public Usuario getProfesorCreador() {
        return profesorCreador;
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
	
	public void agregarActividades(Actividad actividad) {
	    int id=actividad.getIdActividad();
	    actividades.put(id, actividad);
	    
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
	
	public int getIdLP() {
		return idLP;
	}

	public void setIdLP(int idLP) {
		this.idLP = idLP;
	}
	
	 public double getPromedioCalificaciones() { 
	        return promedioCalificaciones;
	        
	    }

	   
	 public void setPromedioCalificaciones(double promedioCalificaciones) {
		this.promedioCalificaciones = promedioCalificaciones;
	}

	public void agregarReseña(String reseña, int calificacion, int idActividad) {
		    if (this.reseñas == null) {
		        this.reseñas = new HashMap<>();
		    }
		    if (this.calificaciones == null) {
		        this.calificaciones = new ArrayList<>();
		    }

		    reseñas.put(idActividad, reseña);
		    calificaciones.add(calificacion);

		    actualizarPromedioCalificaciones();
		}

   
     private void actualizarPromedioCalificaciones() {
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        promedioCalificaciones = suma / (double) calificaciones.size();
    }

	    public void mostrarRatings() {
	        System.out.println("Reseñas del Learning Path " + titulo + ":");
	        if (reseñas.isEmpty()) {
	            System.out.println("No hay reseñas para este Learning Path.");
	        } else {
	            for (Integer reseña : reseñas.keySet()) {
	                System.out.println("- " + reseña);
	            }
	            System.out.println("Promedio de Calificaciones: " + promedioCalificaciones);
	        }
	    }
	


	@Override
	public String toString() {
	    return "LearningPath{" +
	            "codigo=" + idLP +
	            ", titulo='" + titulo + '\'' +
	            ", descripcion='" + descripcion + '\'' +
	            ", objetivos='" + objetivos + '\'' +
	            ", dificultad='" + dificultad + '\'' +
	            ", duracion='" + duracion + '\'' +
	            ", rating='" + promedioCalificaciones + '\'' +
	            ", creador=" + profesorCreador + 
	            '}';
	}
	
	
	

	
}

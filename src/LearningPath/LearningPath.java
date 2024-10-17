package LearningPath;

import java.util.*;

import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;

public class LearningPath {
	
	private Profesor creador;
	private String titulo;
	private String descripcion; 
	private String objetivos;
	private String dificultad;
	
	
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

	public LearningPath(Profesor creador, String titulo, String descripcion, String objetivos, String dificultad) {
		this.creador = creador;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivos = objetivos;
		this.dificultad = dificultad;
	}

}

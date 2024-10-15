package LearningPath;


import co.edu.andes.usuarios.Profesor;

public class LearningPath {
	
	public Profesor creador;
	public String titulo;
	public String descripcion; 
	public String objetivos;
	public String dificultad;
	
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

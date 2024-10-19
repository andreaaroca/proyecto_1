package Actividades;

public class RevisarRecurso extends Actividad {
	
	private String recursoLink;
	//private File recursoArchivo;

	public RevisarRecurso(int idActividad, String descripcion, String objetivo, String dificultad, String duracion
			, String recursoLink) {
		super(idActividad, descripcion, objetivo, dificultad, duracion);
		this.recursoLink=recursoLink;
		
	}

	public String getRecursoLink() {
		return recursoLink;
	}
	
	
	
	

	

}

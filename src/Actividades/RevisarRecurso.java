package Actividades;

public class RevisarRecurso extends Actividad 
{
	
	private static final long serialVersionUID = 1L;
	private String recursoLink;
	//private File recursoArchivo;

	public RevisarRecurso(int idActividad, String descripcion, String objetivo, String dificultad, String duracion
			, String recursoLink, String tipo) {
		super(idActividad, descripcion, objetivo, dificultad, duracion, tipo);
		this.recursoLink=recursoLink;	
	}

	public String getRecursoLink() 
	{
		return recursoLink;
	}
	
}
package Actividades;

public abstract class Evaluacion extends Actividad 
{
	protected Double notaAprovacion;
	
	public Evaluacion(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
			String tipo, Double notaAprovacion) 
	{
		super(idActividad, descripcion, objetivo, dificultad, duracion, tipo);
		this.notaAprovacion = notaAprovacion;
	}

	public Double getNotaAprovacion() 
	{
		return notaAprovacion;
	}

	public void setNotaAprovacion(Double notaAprovacion) 
	{
		this.notaAprovacion = notaAprovacion;
	}

}

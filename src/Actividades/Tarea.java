package Actividades;

public class Tarea extends Actividad 
{
	private static final long serialVersionUID = 1L;
	private String ejercicio;
	private boolean exitosa;
	private String entregadoPor;
	

	public Tarea(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
			 String ejercicio, String tipo) 
	{
		super(idActividad, descripcion, objetivo, dificultad, duracion, tipo);
		this.ejercicio=ejercicio;
		exitosa=false;
		entregadoPor= "No ha sido entregado";
		
	}

	public String getEjercisio() 
	{
		return ejercicio;
	}

	//el usuario va a tener un metodo que diga que se creo la tarea completar trea, donde tenga adentro set exitosa y set entrgado_por,
	//ese metodo de usuario tiene un parametro String que le llega de la consoa donde en la interfaz el usuario explica donde lo envio
	
	public String getEntregadoPor() 
	{
		return entregadoPor;
	}

	public void setEntregadoPor(String entregadoPor) 
	{
		this.entregadoPor = entregadoPor;
	}

	public boolean isExitosa() 
	{
		return exitosa;
	}

	public void setExitosa(boolean exitosa) 
	{
		this.exitosa = true;
	}
	
	
	

}
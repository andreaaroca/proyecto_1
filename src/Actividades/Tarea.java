package Actividades;

public class Tarea extends Actividad {
	
	private String ejercisio;
	private boolean exitosa;
	

	public Tarea(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
			 String ejercisio) {
		super(idActividad, descripcion, objetivo, dificultad, duracion);
		this.ejercisio=ejercisio;
		exitosa=false;
	}

	public String getEjercisio() {
		return ejercisio;
	}

	public String entregadoPor() {
		if (enviado==true) {
			consola.getEnvioTarea();
			//de la interfaz se confirma que se envia, y se dice adonde se envio, de ahi el 
			//controlador le manda esta informacion a el metodo entregadoPor()
		}
	}

	
	public boolean isExitosa() {
		return exitosa;
	}

	public void setExitosa(boolean exitosa) {
		this.exitosa = exitosa;
	}
	
	
	

}

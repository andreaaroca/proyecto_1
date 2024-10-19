package Actividades;

public class Tarea extends Actividad {
	
	private String ejercisio;
	private boolean exitosa;
	private String entregadoPor;
	

	public Tarea(int idActividad, String descripcion, String objetivo, String dificultad, String duracion,
			 String ejercisio) {
		super(idActividad, descripcion, objetivo, dificultad, duracion);
		this.ejercisio=ejercisio;
		exitosa=false;
		entregadoPor= "No ha sido entregado";
		
	}

	public String getEjercisio() {
		return ejercisio;
	}

	//el usuario va a tener un metodo que diga que se creo la tarea completar trea, donde tenga adentro set exitosa y set entrgado_por,
	//ese metodo de usuario tiene un parametro String que le llega de la consoa donde en la interfaz el usuario explica donde lo envio
	
	public String getEntregadoPor() {
		return entregadoPor;
	}

	public void setEntregadoPor(String entregadoPor) {
		this.entregadoPor = entregadoPor;
	}

	public boolean isExitosa() {
		return exitosa;
	}

	public void setExitosa(boolean exitosa) {
		this.exitosa = true;
	}
	
	
	

}

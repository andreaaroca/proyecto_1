package LearningPath;

import co.edu.andes.usuarios.Estudiante;

import co.edu.andes.usuarios.Profesor;


import java.time.*;

public class MonitoreoActividad {

	private int idActividad;
	private Estudiante estudiante;
	private boolean completado;

	
	public MonitoreoActividad(int idActividad, Estudiante estudiante) {
		this.idActividad=idActividad;
		this.estudiante = estudiante;
		this.completado=false;
	}
	
	
	
	public int getIdActividad() {
		return idActividad;
	}



	public Estudiante getEstudiante() {
		return estudiante;
	}



	public String calcularTiempoDedicado(Estudiante estudiante) {
		
		LocalDateTime tiempoI= estudiante.iniciarActividad();
		LocalDateTime tiempoF= estudiante.enviarActividad();
		
        Duration tiempoDedicado = Duration.between(tiempoI, tiempoF);
        String tiempoDedicadoHoras= (tiempoDedicado.toHours()+ " horas");
        
        
        return tiempoDedicadoHoras;
        
		
	}
		

	public void calificacion(Estudiante estudiante, int idActividad) {
		
		Profesor.calificarActividad(estudiante,idActividad, intnota);
		
	}
	//revisar esto con el mapa de estudiantes y la cosas calificadas q se va a crear
	//esto de pronto no necisita un monitoero os illamar es el mada actividade calificadas



	public boolean isCompletado() {
		return completado;
	}



	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

// preguntar por tasas de fallo y exito

}

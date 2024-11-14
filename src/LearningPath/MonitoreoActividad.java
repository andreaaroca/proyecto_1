package LearningPath;

import co.edu.andes.usuarios.Estudiante;
import java.time.*;

import co.edu.andes.usuarios.Profesor;




public class MonitoreoActividad {

	private int idActividad;
	private Estudiante estudiante;
	private boolean completado;
	private Profesor profesor;
	private int idLp;

	
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



	public String calcularTiempoDedicado(int idActividad) {
		
		
		
		LocalDateTime tiempoI= estudiante.getActividadesIniciadasTiempo().get(idActividad);
		LocalDateTime tiempoF= estudiante.getActividadesEnviadasTiempo().get(idActividad);
        Duration tiempoDedicado = Duration.between(tiempoI, tiempoF);
        String tiempoDedicadoHoras= (tiempoDedicado.toHours() + " horas");
       
        
        
        return tiempoDedicadoHoras;
        
		
	}
		

	public boolean completadoyoCalificado(int idActividad) {
		
		
			if(estudiante.getActividadesCompletadas().containsKey(idActividad)) {
				setCompletado(true);
				return true;  }
				else { return false;}
		
		
	}
	//revisar esto con el mapa de estudiantes y la cosas calificadas q se va a crear
	//esto de pronto no necisita un monitoero os illamar es el mada actividade calificadas



	public Profesor getProfesor() {
		return profesor;
	}



	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}



	public boolean isCompletado() {
		return completado;
	}



	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

// preguntar por tasas de fallo y exito

}
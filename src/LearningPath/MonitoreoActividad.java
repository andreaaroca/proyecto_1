package LearningPath;

import co.edu.andes.usuarios.Estudiante;
import java.util.*;

import co.edu.andes.usuarios.Profesor;


import java.time.*;

public class MonitoreoActividad {

	private int idActividad;
	private Estudiante estudiante;
	private boolean completado;
	private HashMap<String,LocalDateTime> tiemposActividad;
	private float calificacion;
	
	
	
	

	
	public MonitoreoActividad(int idActividad, Estudiante estudiante) {
		this.idActividad=idActividad;
		this.estudiante = estudiante;
		this.completado=false;
		this.tiemposActividad= new HashMap<String,LocalDateTime>() ;
		this.calificacion=0;
	}
	
	
	
	public int getIdActividad() {
		return idActividad;
	}



	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void inicioActividad(Estudiante estudiante) {
		//monitoreoactividad algo para poner los en una lista
		LocalDateTime tiempoI= this.estudiante.iniciarActividad();
		tiemposActividad.put("Inicio", tiempoI);
		
		
		
	}

	public String calcularTiempoDedicado(Estudiante estudiante) {
		LocalDateTime tiempoF= estudiante.enviarActividad();
		tiemposActividad.put("Fin", tiempoF);
		
        Duration tiempoDedicado = Duration.between(tiemposActividad.get("Inicio"), tiemposActividad.get("Inicio"));
        String tiempoDedicadoHoras= (tiempoDedicado.toHours()+ " horas");
        
        
        return tiempoDedicadoHoras;
        
		
	}
		

	public void Calificacion(Estudiante estudiante, int idActividad, float nota) { 
		
		if((estudiante==getEstudiante())&&(idActividad==getIdActividad()));
			this.calificacion=nota;
			
		
		
		
		
	}
	//revisar esto con el mapa de estudiantes y la cosas calificadas q se va a crear
	//esto de pronto no necisita un monitoero os illamar es el mada actividade calificadas



	public float getCalificacion() {
		return calificacion;
	}



	public HashMap<String, LocalDateTime> getTiemposActividad() {
		return tiemposActividad;
	}



	public boolean isCompletado() {
		return completado;
	}



	public void setCompletado(boolean completado) {
		
		this.completado = true;
	}

// preguntar por tasas de fallo y exito

}

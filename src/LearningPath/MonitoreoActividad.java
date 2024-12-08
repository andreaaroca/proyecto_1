package LearningPath;

import co.edu.andes.usuarios.Estudiante;
import java.time.*;

import co.edu.andes.usuarios.Profesor;

import Persistencias.*;
import java.util.*;


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

	
	public HashMap<String, Integer> graficaActividades(HashMap<String,HashMap<Integer, LocalDateTime>> estudEnviadas) {
		HashMap<String, Integer> mesCantidad=new HashMap<String, Integer>();
		int contadorEnero= 0;
		int contadorFeb= 0;	
		int contadorMar= 0;
		int contadorAbr= 0;
		int contadorMayo= 0;
		int contadorJun= 0;
		int contadorJul= 0;
		int contadorAgo= 0;
		int contadorSep= 0;
		int contadorOct= 0;
		int contadorNov= 0;
		int contadorDic= 0;
		for (HashMap<Integer, LocalDateTime> actTiempo:estudEnviadas.values()) {
			for(LocalDateTime tiempo:actTiempo.values()) {
				if (tiempo.getMonth().toString()=="JANUARY") {
					contadorEnero++;
				}
				else if (tiempo.getMonth().toString()=="FEBRUARY") {
					contadorFeb++;
				}
				else if (tiempo.getMonth().toString()=="MARCH") {
					contadorMar++;
				}
				else if (tiempo.getMonth().toString()=="APRIL") {
					contadorAbr++;
				}
				else if (tiempo.getMonth().toString()=="MAY") {
					contadorMayo++;
				}
				else if (tiempo.getMonth().toString()=="JUNE") {
					contadorJun++;
				}
				else if (tiempo.getMonth().toString()=="JULY") {
					contadorJul++;
				}
				else if (tiempo.getMonth().toString()=="AUGUST") {
					contadorAgo++;
				}
				else if (tiempo.getMonth().toString()=="SEPTEMBER") {
					contadorSep++;
				}
				else if (tiempo.getMonth().toString()=="OCTOBER") {
					contadorOct++;
				}
				else if (tiempo.getMonth().toString()=="NOVEMBER") {
					contadorNov++;
				}
				else if (tiempo.getMonth().toString()=="DECEMBER") {
					contadorAgo++;
				}
				
			}
			
		}
		mesCantidad.put("Enero", contadorEnero);
		mesCantidad.put("Febrero", contadorFeb);
		mesCantidad.put("Marzo", contadorMar);
		mesCantidad.put("Abril", contadorAbr);
		mesCantidad.put("Mayo", contadorMayo);
		mesCantidad.put("Junio", contadorJun);
		mesCantidad.put("Julio", contadorJul);
		mesCantidad.put("Agosto", contadorAgo);
		mesCantidad.put("Septiembre", contadorSep);
		mesCantidad.put("Octubre", contadorOct);
		mesCantidad.put("Noviembre", contadorNov);
		mesCantidad.put("Diciembre", contadorDic);
		return mesCantidad;
		
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
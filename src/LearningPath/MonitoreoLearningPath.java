package LearningPath;
import co.edu.andes.usuarios.Estudiante;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;


public class MonitoreoLearningPath {

	private LearningPath lp;
	private Estudiante estudiante;
	private List <MonitoreoActividad> actividadesMonitoreadasEstudiante;
	private List <MonitoreoActividad> actividadesMonitoreadasGeneral;
	
	public MonitoreoLearningPath(LearningPath lp, Estudiante estudiante) {
		
		this.lp = lp;
		this.estudiante = estudiante;
		this.actividadesMonitoreadasEstudiante = new ArrayList<MonitoreoActividad>();
		this.actividadesMonitoreadasGeneral = new ArrayList<MonitoreoActividad>();
	}

	public LearningPath getLp() {
		return lp;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	public void agregarActividadMonitoreada(MonitoreoActividad actividadMonitoreada, LearningPath lp, Estudiante estudiante) {
		Estudiante estudianteMonAct=actividadMonitoreada.getEstudiante();
		int idActMon=actividadMonitoreada.getIdActividad();

		if ((lp.getMapaActividades().containsKey(idActMon))&&(estudiante==estudianteMonAct) ) {
			
			actividadesMonitoreadasEstudiante.add(actividadMonitoreada);
			
			}
		else {
			System.out.println("Actividad no esta dentro del learning path a monitorear");
		}
			//posiblemente aqui tiene que ir una excpeción
		}
	
	public void agregarActividadMonitoreadaGeneral(MonitoreoActividad actividadMonitoreada, LearningPath lp) {
		
		int idActMon=actividadMonitoreada.getIdActividad();

		if ((lp.getMapaActividades().containsKey(idActMon))) {
			
			actividadesMonitoreadasGeneral.add(actividadMonitoreada);
			
			}
		else {
			System.out.println("Actividad no esta dentro del learning path a monitorear");
		}
			//posiblemente aqui tiene que ir una excpeción
		}
		
	public float progresoLp(List <MonitoreoActividad> actividadesMonitoreadasEstudiante, LearningPath lp) {
		int contador=0;
		for (MonitoreoActividad actividadMon:actividadesMonitoreadasEstudiante) {
			if (actividadMon.isCompletado()==true && lp.getObligatorias().contains(actividadMon) ) {
				contador++;
				
			}
		float porcentajeCompletadas=(contador/actividadesMonitoreadasEstudiante.size())*100;
		
		return porcentajeCompletadas;
		
		}
	}
	
	public String calcularTiempoDedicadoLp(Estudiante estudiante, List <MonitoreoActividad> actividadesMonitoreadasEstudiante) {
			
			LocalDateTime tiempoI= estudiante.iniciarLp();
			if (progresoLp(actividadesMonitoreadasEstudiante, lp)==1) {
				LocalDateTime tiempoF= estudiante.finalizarLp();
				}
			
	        Duration tiempoDedicado = Duration.between(tiempoI, tiempoF);
	        String tiempoDedicadoHoras= (tiempoDedicado.toHours()+ " horas");
	        
	        
	        return tiempoDedicadoHoras;
	
	}
	

	
//preguntar por tasa de fallos y exitos 
	
	public float tasaDeExitoActividad(List <MonitoreoActividad> actividadesMonitoreadasGeneral, int id) {
		int contadorExito=0;
		int contadorFallo=0;
		for(MonitoreoActividad actividadMon:actividadesMonitoreadasGeneral) {
			if (id==actividadMon.getIdActividad() && actividadMon.isCompletado()==true) {
				contadorExito++;
			}
			else if (id==actividadMon.getIdActividad() && actividadMon.isCompletado()==false) {
			contadorFallo++;
			}
		}
			
		float tasaExitoPorcentaje=((contadorExito)/(contadorExito+contadorFallo))*100;
		
		return tasaExitoPorcentaje;
				
	
	

}
	
	
}





















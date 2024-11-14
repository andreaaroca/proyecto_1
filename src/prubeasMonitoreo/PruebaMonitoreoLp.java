package prubeasMonitoreo;


import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.time.*;


import org.junit.jupiter.api.*;


import LearningPath.*;
import co.edu.andes.usuarios.Usuario;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import Actividades.*;



public class PruebaMonitoreoLp {

	private LearningPath lp1;
	private Profesor profesorCreador1;
	private Estudiante estudiante1;
	private List <MonitoreoActividad> actividadesMonitoreadasEstudiante1;
	private List <MonitoreoActividad> actividadesMonitoreadasGeneral1;
	private HashMap<Integer,Actividad> actividades1;
	private HashMap<String,Actividad> actividades1constructor;
	private HashMap<Integer,LocalDateTime> lpInscritosTiempoI1;
	private HashMap<Integer,LocalDateTime> lpInscritosTiempoF1;
	private MonitoreoActividad actividadMonitoreada1;
	private Encuesta actividad1;
	private MonitoreoLearningPath monitoreoLp1;
	private int idActividad1;
	private int idLp1;
	private LocalDateTime tiempoIniciada1;
	private LocalDateTime tiempoFinalizada1;
	
	

	@BeforeEach
    public void setUp( ) {
		
		idActividad1=7;
		actividad1=new Encuesta(idActividad1, "hacer un for", "entender el uso de un for loop", "baja", "20 minutos", "Encusta");
		actividades1constructor= new HashMap<String,Actividad>();
		actividades1= new HashMap<Integer,Actividad>();
		lpInscritosTiempoI1= new HashMap<Integer,LocalDateTime>();
		lpInscritosTiempoF1= new HashMap<Integer,LocalDateTime>();
		actividades1.put(idActividad1,actividad1);
		profesorCreador1 = new Profesor("Juan", "juancalderon", "juan123", "Profesor");
		idLp1=15;
		lp1=new LearningPath(idLp1, "python", "introduccion a pyhton", "aprender el uso de for y while", "media", "3 horas", actividades1constructor, profesorCreador1);
		estudiante1= new Estudiante("Andrea", "aarcoca", "andrea123", "Estudiante");
		actividadMonitoreada1=new MonitoreoActividad(idActividad1, estudiante1);
		monitoreoLp1=new MonitoreoLearningPath(lp1, estudiante1);
		actividadesMonitoreadasEstudiante1= new ArrayList <MonitoreoActividad>();
		actividadesMonitoreadasEstudiante1.add(actividadMonitoreada1);
		actividadesMonitoreadasGeneral1= new ArrayList <MonitoreoActividad>();
		actividadesMonitoreadasGeneral1.add(actividadMonitoreada1);
		lp1.agregarActividades(actividad1);
		LocalDateTime tiempoIniciada1 = LocalDateTime.of(2024, 10, 11, 11, 10);
        LocalDateTime tiempoFinalizada1 = LocalDateTime.of(2024, 10, 11, 14, 10);
        lpInscritosTiempoI1.put(idLp1, tiempoIniciada1);
        lpInscritosTiempoF1.put(idLp1, tiempoFinalizada1);
        estudiante1.setLpInscritosTiempoI(lpInscritosTiempoI1);
		estudiante1.setLpInscritosTiempoF(lpInscritosTiempoF1);
		
		
	}
	

	@Test
	void testAgregarActividadMonitoreada( )
	{
		monitoreoLp1.agregarActividadMonitoreada(actividadMonitoreada1, lp1, estudiante1);
	    assertIterableEquals( actividadesMonitoreadasEstudiante1, monitoreoLp1.getActividadesMonitoreadasEstudiante(), "la lista de actividades monitoreadas del estudiante no es la esperada" );
	}
	
	@Test
	
	void testagregarActividadMonitoreadaGeneral( )
	{
		monitoreoLp1.agregarActividadMonitoreadaGeneral(actividadMonitoreada1, lp1);
	    assertIterableEquals( actividadesMonitoreadasGeneral1, monitoreoLp1.getActividadesMonitoreadasGeneral(), "la lista de actividades generales no es la esperada");
	    
	}
	
	@Test
	
	void testProgresoLp( )
	{
		actividadMonitoreada1.setCompletado(true);
		monitoreoLp1.agregarActividadMonitoreada(actividadMonitoreada1, lp1, estudiante1);
	    assertEquals( 100.0, monitoreoLp1.progresoLp(actividadesMonitoreadasEstudiante1, lp1), "no es el progreso esperado");
	    
	}
	
	@Test
	
	void testCalcularTiempoDedicadoLp( )
	{
		assertEquals( "3 horas", monitoreoLp1.calcularTiempoDedicadoLp(estudiante1, idLp1), "El tiempo calculado no es el esperado" );
	    
	}
	
	@Test
	
	void testTasaDeExitoActividad( )
	{
		actividadMonitoreada1.setCompletado(true);
		monitoreoLp1.agregarActividadMonitoreadaGeneral(actividadMonitoreada1, lp1);
	    assertEquals( 100.0, monitoreoLp1.progresoLp(actividadesMonitoreadasEstudiante1, lp1), "no es la tasa de exito esperada");
	    
	}
	



}
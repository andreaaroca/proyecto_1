package Pruebas;


	import static org.junit.jupiter.api.Assertions.*;

	import java.util.*;


	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

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
		private Map<String,Actividad> actividades1;
		private MonitoreoActividad actividadMonitoreada1;
		private Encuesta actividad1;
		private MonitoreoLearningPath monitoreoLp1;
		
		
		

		@BeforeEach
	    public void setUp( ) {
			
			actividad1=new Encuesta(7, "hacer un for", "entender el uso de un for loop", "baja", "20 minutos", "Encusta");
			actividades1= new HashMap<String,Actividad>();
			actividades1.put("7",actividad1);
			profesorCreador1 = new Profesor("Juan", "juancalderon", "juan123", "Profesor");
			lp1=new LearningPath(15, "python", "introduccion a pyhton", "aprender el uso de for y while", "media", "3 horas", actividades1, profesorCreador1);
			estudiante1= new Estudiante("Andrea", "aarcoca", "andrea123", "Estudiante");
			actividadMonitoreada1=new MonitoreoActividad(7, estudiante1);
			monitoreoLp1=new MonitoreoLearningPath(lp1, estudiante1);
			actividadesMonitoreadasEstudiante1= new ArrayList <MonitoreoActividad>();
			actividadesMonitoreadasGeneral1= new ArrayList <MonitoreoActividad>();
			
			
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
			
		    assertEquals( 100.0, monitoreoLp1.progresoLp(actividadesMonitoreadasEstudiante1, lp1), "no es el progreso esperado");
		    
		}
		@Test
		void testTasaDeExitoActividad( )
		{
			actividadMonitoreada1.setCompletado(true);
			monitoreoLp1.agregarActividadMonitoreadaGeneral(actividadMonitoreada1, lp1);
		    assertEquals( 100.0, monitoreoLp1.progresoLp(actividadesMonitoreadasEstudiante1, lp1), "no es la tasa de exito esperada");
		    
		}


	}

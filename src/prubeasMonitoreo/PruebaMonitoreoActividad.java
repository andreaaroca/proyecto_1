package prubeasMonitoreo;


import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;


import org.junit.jupiter.api.*;


import LearningPath.*;
import co.edu.andes.usuarios.Usuario;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import Actividades.*;


public class PruebaMonitoreoActividad {

	private int idActividad2;
	private Estudiante estudiante2;
	private boolean completado2;
	private Profesor profesorEvaluador2;
	private float nota2;
	private HashMap<Integer, LearningPath> lpInscritos2;
	private HashMap<Integer, Actividad> actividadesIniciadas2;
	private HashMap<Integer, LocalDateTime> actividadesIniciadasTiempo2;
	private HashMap<Integer, Actividad> actividadesEnviadas2;
	private HashMap<Integer, LocalDateTime> actividadesEnviadasTiempo2;
	private HashMap<Integer, Actividad> actividadesCompletadas2;
	private HashMap<Integer, Float> actividadesCalificadas2;
	private MonitoreoActividad monitoreoActividad2;
	private LocalDateTime tiempoIniciada;
	private LocalDateTime tiempoEnviada;
	private Quiz quiz2;
	
	
	@BeforeEach
    public void setUp( ) {
		
		
		profesorEvaluador2 = new Profesor("Juan", "juancalderon", "juan123", "Profesor");
		estudiante2= new Estudiante("Andrea", "aarcoca", "andrea123", "Estudiante");
		actividadesIniciadasTiempo2= new HashMap<Integer, LocalDateTime>();
		actividadesEnviadasTiempo2= new HashMap<Integer, LocalDateTime>();
		idActividad2=7;
		quiz2= new Quiz(idActividad2, "Quiz de Java", "examinar conociemintos", "media", "30 minutos", "Quiz", 3.0);
		monitoreoActividad2= new MonitoreoActividad(idActividad2,estudiante2);
		LocalDateTime tiempoIniciada2 = LocalDateTime.of(2024, 10, 11, 11, 10);
        LocalDateTime tiempoEnviada2 = LocalDateTime.of(2024, 10, 11, 14, 10);
        actividadesIniciadasTiempo2.put(idActividad2, tiempoIniciada2);
        actividadesEnviadasTiempo2.put(idActividad2, tiempoEnviada2);
        estudiante2.setActividadesIniciadasTiempo(actividadesIniciadasTiempo2);
		estudiante2.setActividadesEnviadasTiempo(actividadesEnviadasTiempo2);
		nota2=(float) 3.5;
		actividadesEnviadas2= new HashMap<Integer, Actividad>();
		actividadesCompletadas2= new HashMap<Integer, Actividad>();
		actividadesCalificadas2= new HashMap<Integer, Float>();
		completado2=true;
		actividadesCompletadas2.put(idActividad2, quiz2);
        actividadesCalificadas2.put(idActividad2, nota2);
        estudiante2.setActividadesCompletadas(actividadesCompletadas2);
        estudiante2.setActividadesCalificadas(actividadesCalificadas2);		
		
	}
	

	@Test
	void testCalcularTiempoDedicado( )
	{
		
        
	    assertEquals( "3 horas", monitoreoActividad2.calcularTiempoDedicado(idActividad2), "El tiempo calculado no es el esperado" );
	}
	
	@Test
	void testCompletadoyoCalificado( )
	
	{
		
        
	    assertTrue(monitoreoActividad2.completadoyoCalificado(idActividad2), "Se esperaba que la actividad ya hubiera sido completada y/o calificada" );
	}
	
	
}


	

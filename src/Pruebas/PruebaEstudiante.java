package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Actividades.Actividad;
import Actividades.Encuesta;
import LearningPath.LearningPath;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import co.edu.andes.usuarios.Usuario;

public class PruebaEstudiante {
	

    private Estudiante estudiante;
    private LearningPath lp;
    private HashMap<Integer, Actividad> actividadesIniciadas2;
	private HashMap<Integer, LocalDateTime> actividadesIniciadasTiempo2;
	private HashMap<Integer, Actividad> actividadesEnviadas2;
	private HashMap<Integer, LocalDateTime> actividadesEnviadasTiempo2;

    @BeforeEach
    public void setUp() {
        estudiante = new Estudiante("Andrea", "aandrea", "password123", "Estudiante");
        actividadesIniciadasTiempo2= new HashMap<Integer, LocalDateTime>();
		actividadesEnviadasTiempo2= new HashMap<Integer, LocalDateTime>();
        Actividad actividad1 = new Encuesta(7, "hacer un for", "entender el uso de un for loop", "baja", "20 minutos", "Encusta");
		Map<String, Actividad> actividades1 = new HashMap<String,Actividad>();
		actividades1.put("7",actividad1);
		Usuario profesorCreador1 = new Profesor("Juan", "juancalderon", "juan123", "Profesor");
        lp = new LearningPath(15, "python", "introduccion a pyhton", "aprender el uso de for y while", "media", "3 horas", actividades1, profesorCreador1) ;
        LocalDateTime tiempoIniciada2 = LocalDateTime.of(2024, 10, 11, 11, 10);
        LocalDateTime tiempoEnviada2 = LocalDateTime.of(2024, 10, 11, 14, 10);
        actividadesIniciadasTiempo2.put(7, tiempoIniciada2);
        actividadesEnviadasTiempo2.put(7, tiempoEnviada2);
        estudiante.setActividadesIniciadasTiempo(actividadesIniciadasTiempo2);
		estudiante.setActividadesEnviadasTiempo(actividadesEnviadasTiempo2);
        }

    @Test
    public void testInscribirLearningPath() {
       
        assertTrue(estudiante.getLpInscritos().containsKey(15));
        assertEquals("Java Basics", estudiante.getLpInscritos().get(15).getTitulo());
    }

    @Test
    public void testCrearReseñaLearningPath() {
        estudiante.getLpInscritos().put(15, lp); 

        estudiante.crearReseñaLearningPath(15, "Muy bueno", 5, 7);
            
        assertEquals(15, lp.getPromedioCalificaciones()); 
    }

    @Test
    public void testIniciarLp() {
        LocalDateTime inicio = estudiante.iniciarLp(1);
        assertNotNull(inicio);  
    }

    @Test
    public void testFinalizarLp() {
        LocalDateTime fin = estudiante.finalizarLp(1);
        assertNotNull(fin); 
    }

    @Test
    public void testIniciarActividad() {
        estudiante.iniciarActividad(15,7);
        
        
       assertEquals( LocalDateTime.of(2024, 10, 11, 11, 10), estudiante.getActividadesIniciadasTiempo().get(7), "La actividad iniciada no es la esperada" );  
    }

    @Test
    public void testEnviarActividad() {
    	estudiante.enviarActividad(15,7);
        
        
        assertEquals( LocalDateTime.of(2024, 10, 11, 14, 10), estudiante.getActividadesEnviadasTiempo().get(7), "La actividad enviada no es la esperada" );  
     }

    
   

    @Test
    public void testCrearReseñaLearningPathNoInscrito() {
        estudiante.crearReseñaLearningPath(15, "Muy bueno", 4, 7); 
        
        assertNull(lp.getPromedioCalificaciones());
    }

    @Test
    public void testFinalizarLpSinIniciar() {
     
        LocalDateTime fin = estudiante.finalizarLp(15);
        
        assertNull(fin); 
    }

   
	

}

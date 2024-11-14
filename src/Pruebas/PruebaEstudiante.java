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

    @BeforeEach
    public void setUp() {
        estudiante = new Estudiante("Andrea", "aandrea", "password123", "Estudiante");
        Actividad actividad1 = new Encuesta(7, "hacer un for", "entender el uso de un for loop", "baja", "20 minutos", "Encusta");
		Map<String, Actividad> actividades1 = new HashMap<String,Actividad>();
		actividades1.put("7",actividad1);
		Usuario profesorCreador1 = new Profesor("Juan", "juancalderon", "juan123", "Profesor");
        lp = new LearningPath(15, "python", "introduccion a pyhton", "aprender el uso de for y while", "media", "3 horas", actividades1, profesorCreador1) ;
        }

    @Test
    public void testInscribirLearningPath() {
       
        assertTrue(estudiante.getLpInscritos().containsKey(1));
        assertEquals("Java Basics", estudiante.getLpInscritos().get(1).getTitulo());
    }

    @Test
    public void testCrearReseñaLearningPath() {
        estudiante.getLpInscritos().put(1, lp); 

        estudiante.crearReseñaLearningPath(15, "Muy bueno", 5, 7);
            
        assertEquals(5, lp.getPromedioCalificaciones()); 
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
        LocalDateTime inicioActividad = estudiante.iniciarActividad();
        assertNotNull(inicioActividad);  
    }

    @Test
    public void testEnviarActividad() {
        LocalDateTime envioActividad = estudiante.enviarActividad();
        assertNotNull(envioActividad);  
    }
   

    @Test
    public void testCrearReseñaLearningPathNoInscrito() {
        estudiante.crearReseñaLearningPath(999, "Muy bueno", 4, 7); 
        
        assertNull(lp.getPromedioCalificaciones());
    }

    @Test
    public void testFinalizarLpSinIniciar() {
     
        LocalDateTime fin = estudiante.finalizarLp(15);
        
        assertNull(fin); 
    }

   
	

}

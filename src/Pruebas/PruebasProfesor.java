package Pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import Actividades.*;
import co.edu.andes.usuarios.*;
import java.util.*;
import LearningPath.*;


public class PruebasProfesor 
{
	private Profesor profesor;
	private Map<String, Actividad> actividades;
	
	@BeforeEach
	private void SetUp()
	{
		profesor = new Profesor("Jose", "Joselito", "josh123", "Profesor");
		actividades = new HashMap<>();
		Integer codigo = 1;
        String titulo = "Aprender Java";
        String descripcion = "Un camino de aprendizaje para Java";
        String objetivos = "Aprender conceptos básicos de Java";
        String dificultad = "Media";
        String duracion = "4 semanas";

        profesor.crearLearningPath(codigo, titulo, descripcion, objetivos, dificultad, duracion, actividades, profesor);
	}
	
	@Test
    void testCrearLearningPath() 
	{
		Integer codigo = 1;
		LearningPath lp = profesor.getLearningPathsMap().get(codigo);
		String titulo = lp.getTitulo();
        assertNotNull(profesor.getLearningPathsMap().get(codigo));
        assertEquals(titulo, lp.getTitulo());
    }

    @Test
    void testCrearTarea() 
    {
    	Integer codigo = 1;
        int idActividad = 1;
        String tareaDescripcion = "Tarea de Java";
        String tareaObjetivo = "Completar la tarea de Java";
        String tareaDificultad = "Baja";
        String tareaDuracion = "1 semana";
        String ejercicio = "Realizar ejercicios de Java";

        profesor.crearTarea(idActividad, tareaDescripcion, tareaObjetivo, tareaDificultad, tareaDuracion, ejercicio, codigo);

        
        LearningPath lp = profesor.getLearningPathsMap().get(codigo);
        assertTrue(lp.getActividades().containsKey(idActividad));
        assertEquals(tareaDescripcion, lp.getActividades().get(idActividad).getDescripcion());
    }
    
    void testCrearRevisarRecurso() {
        Integer codigo = 1;
        

        int idActividad = 3;
        String recursoDescripcion = "Recurso sobre Java";
        String recursoObjetivo = "Revisar el recurso proporcionado";
        String recursoDificultad = "Baja";
        String recursoDuracion = "1 semana";
        String recursoLink = "http://ejemplo.com/recurso-java";

        profesor.crearRevisarRecurso(idActividad, recursoDescripcion, recursoObjetivo, recursoDificultad, recursoDuracion, recursoLink, codigo);

        LearningPath lp = profesor.getLearningPathsMap().get(codigo);
        assertTrue(lp.getActividades().containsKey(idActividad));
        assertEquals(recursoDescripcion, lp.getActividades().get(idActividad).getDescripcion());
    }

    @Test
    void testCrearQuiz() {
        Integer codigo = 1;

        int idActividad = 4;
        String quizDescripcion = "Quiz sobre Java";
        String quizObjetivo = "Evaluar conocimientos sobre Java";
        String quizDificultad = "Media";
        String quizDuracion = "1 semana";
        Double notaAprobacion = 7.0;

        profesor.crearQuiz(idActividad, quizDescripcion, quizObjetivo, quizDificultad, quizDuracion, notaAprobacion, codigo);

        LearningPath lp = profesor.getLearningPathsMap().get(codigo);
        assertTrue(lp.getActividades().containsKey(idActividad));
        assertEquals(quizDescripcion, lp.getActividades().get(idActividad).getDescripcion());
    }

    @Test
    void testCrearExamen() {
        Integer codigo = 1;        

        int idActividad = 5;
        String examenDescripcion = "Examen sobre Java";
        String examenObjetivo = "Evaluar conocimientos finales sobre Java";
        String examenDificultad = "Alta";
        String examenDuracion = "2 horas";
        Double notaAprobacion = 8.0;

        profesor.crearExamen(idActividad, examenDescripcion, examenObjetivo, examenDificultad, examenDuracion, notaAprobacion, codigo);

        LearningPath lp = profesor.getLearningPathsMap().get(codigo);
        assertTrue(lp.getActividades().containsKey(idActividad));
        assertEquals(examenDescripcion, lp.getActividades().get(idActividad).getDescripcion());
    }

    @Test
    void testEliminarActividad() {
        Integer codigo = 1;

        int idActividad = 1;
        String tareaDescripcion = "Tarea de Java";
        String tareaObjetivo = "Completar la tarea de Java";
        String tareaDificultad = "Baja";
        String tareaDuracion = "1 semana";
        String ejercicio = "Realizar ejercicios de Java";

        profesor.crearTarea(idActividad, tareaDescripcion, tareaObjetivo, tareaDificultad, tareaDuracion, ejercicio, codigo);
        assertTrue(profesor.getLearningPathsMap().get(codigo).getActividades().containsKey(idActividad));

        profesor.eliminarActividad(codigo, idActividad);
        assertFalse(profesor.getLearningPathsMap().get(codigo).getActividades().containsKey(idActividad)); // Debe ser false después de eliminar
    }

    @Test
    void testEliminarLearningPath() 
    {
        Integer codigo = 1;

        assertNotNull(profesor.getLearningPathsMap().get(codigo));

        profesor.eliminarLearningPath(codigo);
        assertNull(profesor.getLearningPathsMap().get(codigo)); 
    }
}
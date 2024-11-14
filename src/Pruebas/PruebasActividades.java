package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import co.edu.andes.sistema.GestorUsuarios;
import Actividades.*;
import java.util.*;

public class PruebasActividades 
{
	
		
		private Actividad actividad;
		private Actividad encuesta;

	    @BeforeEach
	    public void setUp() 
	    {
	        
	        actividad = new Tarea(1, "Descripción de prueba", "Objetivo de prueba", "Fácil", "1 hora", "ejercicio","Tarea");
	        encuesta = new Encuesta(5, "Descripción", "Objetivo", "Intermedio", "40 minutos", "Encuesta");
	    }

	    @Test
	    public void testAgregarComentarioResena() 
	    {
	        String comentario1 = "Muy interesante";
	        String comentario2 = "La actividad fue útil y fácil de entender.";
	        String comentario3 = "Me gustaría ver más ejemplos";

	        actividad.agregarComentarioResena(comentario1);
	        actividad.agregarComentarioResena(comentario2);
	        actividad.agregarComentarioResena(comentario3);

	     
	        List<String> resenas = actividad.getResenas();

	   
	        assertEquals(3, resenas.size(), "La cantidad de comentarios no es la esperada.");

	        assertEquals(comentario1, resenas.get(0), "El primer comentario no coincide.");
	        assertEquals(comentario2, resenas.get(1), "El segundo comentario no coincide.");
	        assertEquals(comentario3, resenas.get(2), "El tercer comentario no coincide.");
	    }
	    
	    @Test
	    public void testAgregarPreguntaEncuesta() 
	    {
	        encuesta.agregarPregunta("¿Cuál es tu opinión?");
	        assertEquals(1, encuesta.getPreguntas().size());
	        assertEquals("¿Cuál es tu opinión?", encuesta.getPreguntas().get(0));
	    }

	    @Test
	    public void testRecursoLink() 
	    {
	        RevisarRecurso recurso = new RevisarRecurso(4, "Descripción", "Objetivo", "Medio", "20 minutos", "https://recurso.com", "Recurso");
	        assertEquals("https://recurso.com", recurso.getRecursoLink());
	    }

	    @Test
	    public void testAgregarRespuestaEncuesta() 
	    {
	        
	        encuesta.agregarRespuesta("12345", "Esta es mi respuesta");
	        assertEquals("Esta es mi respuesta", encuesta.getRespuestasEstudiante().get("12345"));
	    }


}

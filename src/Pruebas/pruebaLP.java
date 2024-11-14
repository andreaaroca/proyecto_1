package Pruebas;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Actividades.Actividad;
import LearningPath.LearningPath;
import co.edu.andes.usuarios.Usuario;
import co.edu.andes.usuarios.Profesor;

public class pruebaLP {
	

    private LearningPath lp;
    private Usuario profesor;
    private Actividad actividad1;
    private Actividad actividad2;
	
	 @BeforeEach
	    public void setUp() {
	        profesor = new Profesor("Kelly", "kelly123", "1234", "Profesor");
	        lp = new LearningPath(1, "Curso de Java", "Aprender conceptos básicos de Java",
	                              "Curso introductorio", "Intermedio", "10 horas",
	                              new HashMap<>(), profesor);

	        actividad1 = new Actividad(101, "Introducción a Java", "Entender los conceptos básicos", "Fácil", "2 horas", "Teoría") {};
	        actividad2 = new Actividad(102, "Programación Orientada a Objetos", "Aprender DPOO en Java", "Intermedio", "3 horas", "Práctica") {};
	    }
	
	@Test
    public void testCreacionLearningPath() {
    
       
        assertEquals(1, lp.getIdLP(), "El ID del Learning Path debería ser 1");
        assertEquals("Curso de Java", lp.getTitulo(), "El título del Learning Path debería ser 'Curso de Java'");
        assertEquals("Aprender conceptos básicos de Java", lp.getObjetivos(), "La descripción del Learning Path debería ser 'Aprender conceptos básicos de Java'");
        assertEquals("Curso introductorio", lp.getDescripcion(), "La categoría debería ser 'Curso introductorio'");
        assertEquals("Intermedio", lp.getDificultad(), "El nivel debería ser 'Intermedio'");
        assertEquals("10 horas", lp.getDuracion(), "La duración debería ser '10 horas'");
        assertEquals(profesor, lp.getProfesorCreador(), "El profesor asignado debería ser el mismo que el creador");
        assertEquals(lp.getPromedioCalificaciones(), 0.0);
    }
	
	@Test
    public void testAgregarActividad() {
        lp.agregarActividad(actividad1);
        lp.agregarActividad(actividad2);

        assertEquals(2, lp.getActividades().size(), "Debería haber 2 actividades en el Learning Path");
        assertTrue(lp.getActividades().containsKey(101), "El mapa debe contener la actividad con ID 'A1'");
        assertTrue(lp.getActividades().containsKey(102), "El mapa debe contener la actividad con ID 'A2'");
    }


    @Test
    public void testPromedioInicialCero() {
        assertEquals(0.0, lp.getPromedioCalificaciones(), "El promedio inicial debería ser 0.0");
    }

    @Test
    public void testAgregarCalificacion() {
        lp.agregarReseña("Buen curso", 8, 101);
        assertEquals(8.0, lp.getPromedioCalificaciones(), "El promedio después de la primera calificación debería ser 8.0");

        lp.agregarReseña("Excelente contenido", 9, 102);
        assertEquals(8.5, lp.getPromedioCalificaciones(), "El promedio después de dos calificaciones debería ser 8.5");

        lp.agregarReseña("Pudo ser mejor", 7, 103);
        assertEquals(8.0, lp.getPromedioCalificaciones(), "El promedio después de tres calificaciones debería ser 8.0");
    }

    
    @Test
    public void testPromedioCalificacionesConValoresLimite() {
        lp.agregarReseña("Calificación mínima", 0, 101);
        assertEquals(0.0, lp.getPromedioCalificaciones(), "El promedio con una calificación de 0 debería ser 0.0");

        lp.agregarReseña("Calificación máxima", 10, 102);
        assertEquals(5.0, lp.getPromedioCalificaciones(), "El promedio con calificaciones de 0 y 10 debería ser 5.0");
    }

}

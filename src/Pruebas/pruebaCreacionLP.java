package Pruebas;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import LearningPath.LearningPath;
import co.edu.andes.usuarios.Usuario;
import co.edu.andes.usuarios.Profesor;

public class pruebaCreacionLP {
	@Test
    public void testCreacionLearningPath() {
        Usuario profesor = new Profesor("Profesor Ejemplo", "profe123", "password", "Profesor");
        
  
        LearningPath lp = new LearningPath(1, "Curso de Java", "Aprender conceptos básicos de Java", 
                                           "Curso introductorio", "Intermedio", "10 horas", 
                                           new HashMap<>(), profesor);
        
       
        assertEquals(1, lp.getIdLP(), "El ID del Learning Path debería ser 1");
        assertEquals("Curso de Java", lp.getTitulo(), "El título del Learning Path debería ser 'Curso de Java'");
        assertEquals("Aprender conceptos básicos de Java", lp.getObjetivos(), "La descripción del Learning Path debería ser 'Aprender conceptos básicos de Java'");
        assertEquals("Curso introductorio", lp.getDescripcion(), "La categoría debería ser 'Curso introductorio'");
        assertEquals("Intermedio", lp.getDificultad(), "El nivel debería ser 'Intermedio'");
        assertEquals("10 horas", lp.getDuracion(), "La duración debería ser '10 horas'");
        assertEquals(profesor, lp.getProfesorCreador(), "El profesor asignado debería ser el mismo que el creador");
        assertEquals(lp.getPromedioCalificaciones(), 0.0);
    }

}

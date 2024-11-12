package Pruebas;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import LearningPath.LearningPath;
import co.edu.andes.usuarios.Usuario;
import co.edu.andes.usuarios.Profesor;


public class pruebaCalificacionLP {
    
    private LearningPath lp;
    private Usuario profesor;

    @BeforeEach
    public void setUp() {
        profesor = new Profesor("Profesor Ejemplo", "profe123", "password", "Profesor");
        lp = new LearningPath(1, "Curso de Java", "Aprender conceptos básicos de Java", 
                              "Curso introductorio", "Intermedio", "10 horas", 
                              new HashMap<>(), profesor);
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

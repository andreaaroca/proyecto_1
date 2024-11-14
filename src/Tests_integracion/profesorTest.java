package Tests_integracion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.andes.usuarios.Profesor;
import LearningPath.LearningPath;
import Actividades.*;

public class ProfesorTest {

    private Profesor profesor;
    private LearningPath learningPath;
    private Actividad actividad;

    @BeforeEach
    public void setUp() {
        profesor = new Profesor("Juan", "12345", "Profesor de matemáticas");
        learningPath = new LearningPath(101, "Álgebra Avanzada", "Curso completo de álgebra", "Intermedio", 40, profesor);
        actividad = new Actividad(201, "Ecuaciones Cuadráticas", "Actividad sobre resolución de ecuaciones cuadráticas", "Básico", 10);
    }

    @Test
    public void testCrearLearningPath() {
        profesor.crearLearningPath(learningPath);
        assertTrue(profesor.getLearningPathsCreados().containsKey(learningPath.getIdLP()),
                   "El profesor debería tener el LearningPath en su lista de creados.");
    }

    @Test
    public void testEliminarLearningPath() {
        profesor.crearLearningPath(learningPath);
        boolean eliminado = profesor.eliminarLearningPath(learningPath.getIdLP());
        assertTrue(eliminado, "El LearningPath debería ser eliminado correctamente.");
        assertFalse(profesor.getLearningPathsCreados().containsKey(learningPath.getIdLP()), 
                    "El LearningPath ya no debería estar en la lista de creados.");
    }

    @Test
    public void testEliminarLearningPathNoExistente() {
        boolean eliminado = profesor.eliminarLearningPath(999); // ID que no existe
        assertFalse(eliminado, "El sistema debería indicar que no se puede eliminar un LearningPath inexistente.");
    }

    @Test
    public void testAgregarActividadALearningPath() {
        profesor.crearLearningPath(learningPath);
        boolean actividadAgregada = profesor.agregarActividadALearningPath(learningPath.getIdLP(), actividad);
        assertTrue(actividadAgregada, "La actividad debería ser agregada exitosamente al LearningPath.");
        assertTrue(learningPath.getActividades().contains(actividad), "La actividad debería estar en la lista de actividades del LearningPath.");
    }

    @Test
    public void testAgregarActividadADosVeces() {
        profesor.crearLearningPath(learningPath);
        profesor.agregarActividadALearningPath(learningPath.getIdLP(), actividad);
        boolean actividadDuplicada = profesor.agregarActividadALearningPath(learningPath.getIdLP(), actividad);
        assertFalse(actividadDuplicada, "El sistema debería rechazar actividades duplicadas en el mismo LearningPath.");
    }

    @Test
    public void testEliminarActividadDeLearningPath() {
        profesor.crearLearningPath(learningPath);
        profesor.agregarActividadALearningPath(learningPath.getIdLP(), actividad);
        boolean actividadEliminada = profesor.eliminarActividadDeLearningPath(learningPath.getIdLP(), actividad.getIdActividad());
        assertTrue(actividadEliminada, "La actividad debería ser eliminada correctamente del LearningPath.");
        assertFalse(learningPath.getActividades().contains(actividad), "La actividad ya no debería estar en el LearningPath.");
    }

    @Test
    public void testEliminarActividadNoExistenteDeLearningPath() {
        profesor.crearLearningPath(learningPath);
        boolean actividadEliminada = profesor.eliminarActividadDeLearningPath(learningPath.getIdLP(), 999); // ID de actividad inexistente
        assertFalse(actividadEliminada, "El sistema debería indicar que no se puede eliminar una actividad inexistente.");
    }

    @Test
    public void testCrearResenaParaLearningPath() {
        profesor.crearLearningPath(learningPath);
        boolean resenaCreada = profesor.crearResenaLearningPath(learningPath.getIdLP(), "Buen curso de álgebra avanzada");
        assertTrue(resenaCreada, "El profesor debería poder crear una reseña para su propio LearningPath.");
    }

    @Test
    public void testCrearResenaDuplicadaParaLearningPath() {
        profesor.crearLearningPath(learningPath);
        profesor.crearResenaLearningPath(learningPath.getIdLP(), "Muy buen curso");
        boolean resenaDuplicada = profesor.crearResenaLearningPath(learningPath.getIdLP(), "Excelente contenido");
        assertFalse(resenaDuplicada, "El sistema debería rechazar reseñas duplicadas para el mismo LearningPath.");
    }
}
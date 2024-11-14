package Tests_integracion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.andes.usuarios.Estudiante;
import LearningPath.*;
import Actividad.*;

public class EstudianteTest {

    private Estudiante estudiante;
    private LearningPath learningPath;
    private Actividad actividad;

    @BeforeEach
    public void setUp() {
        estudiante = new Estudiante("Ana", "78910", "Estudiante de ingeniería");
        learningPath = new LearningPath(202, "Física Mecánica", "Curso sobre mecánica clásica", "Avanzado", 50, null);
        actividad = new Actividad(101, "Movimiento Rectilíneo", "Estudiar el movimiento en línea recta", "Intermedio", 10);
        learningPath.agregarActividad(actividad);  // Agregar actividad al learning path
    }

    @Test
    public void testInscribirseEnLearningPath() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        assertTrue(estudiante.getLpInscritos().containsKey(learningPath.getIdLP()),
                   "El estudiante debería estar inscrito en el LearningPath.");
    }

    @Test
    public void testVerLearningPathsInscritos() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        Map<Integer, LearningPath> inscritos = estudiante.getLpInscritos();
        assertEquals(1, inscritos.size(), "Debería haber un LearningPath inscrito.");
    }

    @Test
    public void testInscripcionDuplicadaEnLearningPath() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        boolean resultado = estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        assertFalse(resultado, "El sistema debería rechazar inscripciones duplicadas en el mismo LearningPath.");
    }

    @Test
    public void testIniciarActividad() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        boolean inicioExitoso = estudiante.iniciarActividad(learningPath.getIdLP(), actividad.getIdActividad());
        assertTrue(inicioExitoso, "El estudiante debería poder iniciar la actividad si está inscrito en el LearningPath.");
    }

    @Test
    public void testIniciarActividadSinInscripcion() {
        boolean inicioExitoso = estudiante.iniciarActividad(learningPath.getIdLP(), actividad.getIdActividad());
        assertFalse(inicioExitoso, "El sistema debería rechazar el inicio de actividad si el estudiante no está inscrito.");
    }

    @Test
    public void testCrearResenaParaLearningPath() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        boolean resenaExitosa = estudiante.crearResenaLearningPath(learningPath.getIdLP(), "Excelente curso sobre física");
        assertTrue(resenaExitosa, "El estudiante debería poder crear una reseña para el LearningPath inscrito.");
    }

    @Test
    public void testCrearResenaDuplicadaParaLearningPath() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        estudiante.crearResenaLearningPath(learningPath.getIdLP(), "Excelente curso sobre física");
        boolean resenaDuplicada = estudiante.crearResenaLearningPath(learningPath.getIdLP(), "Muy buena explicación");
        assertFalse(resenaDuplicada, "El sistema debería rechazar reseñas duplicadas para el mismo LearningPath.");
    }

    @Test
    public void testCrearResenaParaActividad() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        boolean resenaActividadExitosa = estudiante.crearResenaActividad(learningPath.getIdLP(), actividad.getIdActividad(), "Actividad muy clara y útil");
        assertTrue(resenaActividadExitosa, "El estudiante debería poder crear una reseña para una actividad específica.");
    }

    @Test
    public void testCrearResenaDuplicadaParaActividad() {
        estudiante.inscribirLearningPath(learningPath.getIdLP(), learningPath);
        estudiante.crearResenaActividad(learningPath.getIdLP(), actividad.getIdActividad(), "Muy buen ejercicio");
        boolean resenaDuplicada = estudiante.crearResenaActividad(learningPath.getIdLP(), actividad.getIdActividad(), "Buena explicación");
        assertFalse(resenaDuplicada, "El sistema debería rechazar reseñas duplicadas para la misma actividad.");
    }
}
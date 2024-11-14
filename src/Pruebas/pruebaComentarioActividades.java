package Pruebas;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Actividades.Actividad;


public class pruebaComentarioActividades {
	
	 private Actividad actividad;
	
    private class ActividadPrueba extends Actividad {
        public ActividadPrueba(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo) {
            super(idActividad, descripcion, objetivo, dificultad, duracion, tipo);
        }
    }

    @BeforeEach
    public void setUp() {
        
        actividad = new ActividadPrueba(1, "Descripción de prueba", "Objetivo de prueba", "Fácil", "1 hora", "Tarea");
    }

    @Test
    public void testAgregarComentarioResena() {
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

}

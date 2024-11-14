		package Pruebas;
		
		import static org.junit.jupiter.api.Assertions.*;
		import java.util.*;
		import org.junit.jupiter.api.BeforeEach;
		import org.junit.jupiter.api.Test;
		import Actividades.Actividad;
		import LearningPath.LearningPath;
		import Persistencias.persistenciaLP;
		import co.edu.andes.usuarios.Profesor;
		
		public class PruebaPersistenciaLp {
	
			        persistenciaLP persistencia = new persistenciaLP();
			        
			        actividades1constructor = new HashMap<String, Actividad>();
	   
			        Profesor profesor = new Profesor("Kelly", "kelly123", "1234", "Profesor");
	
			        Map<Integer, Actividad> actividades = new HashMap<>();
			        
			        Actividad actividad = new Actividad(1, "Actividad de prueba", "Descripción de actividad");
			        
			        
			        actividades1constructor.put(1, actividad);
	
			        LearningPath lp = new LearningPath(1, "Curso de Java", "Objetivo del curso", "Aprende Java desde cero", 
			                                            "Intermedio", "10 horas", actividades1constructor, profesor);
	
			        Map<Integer, LearningPath> learningPaths = new HashMap<>();
			        learningPaths.put(lp.getIdLP(), lp);
	
			        persistencia.guardarLearningPaths(learningPaths);
	
			        persistencia.mostrarLearningPathsDesdeArchivo();
	
			        persistencia.actualizarRating(1, 4.5);
	
			        persistencia.mostrarLearningPathsDesdeArchivo();
			    }
		

}

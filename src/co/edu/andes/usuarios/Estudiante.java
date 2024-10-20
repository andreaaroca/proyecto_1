package co.edu.andes.usuarios;

import java.util.*;
import LearningPath.LearningPath;
import Actividades.*;

public class Estudiante extends Usuario{
	
	private HashMap<Integer, LearningPath> lpInscritos;

	public Estudiante(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        super(nombre, nombreUsuario, password, "Estudiante");
    }
	  
	    
	
}

package Consola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Actividades.Actividad;
import LearningPath.*;
import co.edu.andes.sistema.GestorUsuarios;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import co.edu.andes.usuarios.Usuario;
import Persistencias.persistenciaEstudiante;
import Persistencias.persistenciaLP;
import Controlador.*;

public class MainProfesorEvaluador {
	
	private static Usuario usuario;
	private static Map<Integer, LearningPath> learningPaths = new HashMap<>();
	static persistenciaLP lpControl = new persistenciaLP();
	private static persistenciaEstudiante persistencia = new persistenciaEstudiante();

    private static void mostrarMenu() {
        System.out.println("1. Registrar Profesor");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Salir");
        System.out.println("4. Mostrar Usuarios desde Archivo");
        System.out.print("Seleccione una opción: ");   
    }


    private static void mostrarMenuProfesorEvaluador(Scanner scanner, Profesor profesorEvaluador, persistenciaLP lpControl, GestorUsuarios gestorUsuarios) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Calificar y marcar como completa una Actividad");
            System.out.println("2. Revisar Progreso Learning Path");
            System.out.println("3. Ver tiempo que duro el estudiante en completar una actividad");
            System.out.println("4. Ver tiempo que duro el estudiante en completar un LearningPath");
            System.out.println("5. Calcular Tasa de exito de una actividad");
            System.out.println("6. Revisar si una actividad ha sido completada");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            if (opcion==1) {
            	System.out.print("Ingrese el nombre de usuario del estudiante a calificar: ");
                String nombreUsuario = scanner.nextLine();
            	System.out.print("Ingrese código de la actividad: ");
                int idActividad = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Ingrese nota (si es una actividad no calificable ingrese 0.0: ");
                float nota = scanner.nextFloat();
                scanner.nextLine();
                Controlador.profesorCalificarActividad(nombreUsuario, idActividad, nota, gestorUsuarios, profesorEvaluador);
                 }
            
        	   
                
            	
            }
            
}
            

        
    private static void registrarUsuario(GestorUsuarios gestorUsuarios, Scanner scanner) {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese nombre de usuario de profesor: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        
        Controlador.crearProfesor(nombre, nombreUsuario, password, gestorUsuarios);
    }

    private static void iniciarSesion(GestorUsuarios gestorUsuarios, Scanner scanner) {
        System.out.print("Ingrese nombre de usuario del profesor: ");
        String nombreUsuario = scanner.nextLine();
        
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        
        String tipoUsuario = gestorUsuarios.iniciarSesion(nombreUsuario, password);
        
        if (tipoUsuario != null) {
            System.out.println("Inicio de sesión exitoso como: " + tipoUsuario);
            
            Object usuario = gestorUsuarios.obtenerUsuario(nombreUsuario);
            
              if (tipoUsuario.equals("Profesor") && usuario instanceof Profesor) {
                System.out.println("Opciones para profesor:");
                Profesor profesorEvaluador = (Profesor) usuario; 
                mostrarMenuProfesorEvaluador(scanner, profesorEvaluador, lpControl, gestorUsuarios);
            } else {
                System.out.println("Error: el tipo de usuario no coincide con " + tipoUsuario + ".");
            }
        } else {
            System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
        }
    
        
}
    public static void mainProfesorEvaluador() {
    	GestorUsuarios sistema = new GestorUsuarios();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true; 
        
        sistema.cargarUsuariosDesdeArchivo();

        while (continuar) {
            mostrarMenu(); 
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            if (opcion == 1) {
                registrarUsuario(sistema, scanner);
            } else if (opcion == 2) {
            	iniciarSesion(sistema, scanner);
            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema...");
            } else if (opcion ==4){ 
                    List<String> usuarios = sistema.mostrarUsuariosDesdeArchivo();
                    System.out.println("Usuarios registrados en el archivo:");
                    for (String usuario : usuarios) {
                        System.out.println(usuario);}

            }
            else{
                System.out.println("Opción no válida."); 
        }
    }
  
        scanner.close();           
}
    
}
        
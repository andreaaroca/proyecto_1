package Consola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Actividades.Actividad;
import LearningPath.LearningPath;
import co.edu.andes.sistema.GestorUsuarios;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import co.edu.andes.usuarios.Usuario;
import Persistencias.persistenciaEstudiante;
import Persistencias.persistenciaLP;
import Controlador.*;

public class Main {
	
	private static Usuario usuario;
	private static Map<Integer, LearningPath> learningPaths = new HashMap<>();
	static persistenciaLP lpControl = new persistenciaLP();
	private static persistenciaEstudiante persistencia = new persistenciaEstudiante();

    private static void mostrarMenu() {
        System.out.println("1. Registrar Estudiante");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Salir");
        System.out.println("4. Mostrar Usuarios desde Archivo");
        System.out.print("Seleccione una opción: ");   
    }
    
    
    
    private static void mostrarMenuEstudiante(Scanner scanner, Estudiante estudiante) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Ver learningPaths");
            System.out.println("2. InscribirLearningPath");
            System.out.println("3. Ver learningpaths inscritos");
            System.out.println("4. Crear reseña");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            

            if (opcion == 1) {
                System.out.println("Mostrando LearningPaths...");
                
                Controlador.mostrarLearningPathsDesdeArchivo(lpControl);
                
            } else if (opcion == 2) {
            	Controlador.estudianteInscribirLearningPath(lpControl, estudiante, scanner);
            	
            } else if (opcion == 3) {	
            	System.out.println("Tus LearningPaths inscritos son: ");
            	Controlador.imprimirLearningPathsInscritos(persistencia, estudiante);
            	
            } else if (opcion == 4) {
                continuar = false; 
                System.out.println("Para crear la reseña..."); 
                
                System.out.print("Ingrese id del Learning Path: ");
                int idLp = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Ingrese id de la actividad: ");
                int idActividad = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ingrese rating del learning path: ");
                int rating = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ingrese su opinion de la actividad: ");
                String opinionActividad= scanner.nextLine();
         
                Controlador.estudianteCrearResenaLearningPath(idLp, opinionActividad, rating, idActividad, estudiante);

         
            } else if (opcion == 5) {
                continuar = false; 
                System.out.println("Saliendo del menú de estudiante...");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    
 

    
    private static void registrarUsuario(GestorUsuarios gestorUsuarios, Scanner scanner) {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();

        Controlador.crearEstudiante(nombre, nombreUsuario, password, gestorUsuarios);
       
        
    }

    private static void iniciarSesion(GestorUsuarios gestorUsuarios, Scanner scanner) {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        
        String tipoUsuario = gestorUsuarios.iniciarSesion(nombreUsuario, password);
        
        if (tipoUsuario != null) {
            System.out.println("Inicio de sesión exitoso como: " + tipoUsuario);
            
            Object usuario = gestorUsuarios.obtenerUsuario(nombreUsuario);
            
            if (tipoUsuario.equals("Estudiante") && usuario instanceof Estudiante) {
                System.out.println("Opciones para estudiante:");
                Estudiante estudiante = (Estudiante) usuario; 
                mostrarMenuEstudiante(scanner, estudiante);
            } else {
                System.out.println("Error: el tipo de usuario no coincide con " + tipoUsuario + ".");
            }
        } else {
            System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
        }
    }
   
    
    
    
    public static void mainEstudiante() {
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








    	
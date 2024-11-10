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

public class Main {
	
	private static Usuario usuario;
	private static Map<Integer, LearningPath> learningPaths = new HashMap<>();
	static persistenciaLP lpControl = new persistenciaLP();

    private static void mostrarMenu() {
        System.out.println("1. Registrar Usuario");
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
                lpControl.mostrarLearningPathsDesdeArchivo();
                
            } else if (opcion == 2) {
            	Estudiante.inscribirLearningPath(lpControl, estudiante, scanner);
            } else if (opcion == 3) {	
            	System.out.println("Tus LearningPaths inscritos son: ");
            	imprimirLearningPathsInscritos(persistencia, estudiante);
            	
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
         
                estudiante.crearReseñaLearningPath(idLp, opinionActividad, rating, idActividad);

         
            } else if (opcion == 5) {
                continuar = false; 
                System.out.println("Saliendo del menú de estudiante...");
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    
 

    private static void mostrarMenuProfesor(Scanner scanner, Profesor profesorCreador, persistenciaLP lpControl) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Crear Learning Path");
            System.out.println("2. Crear Actividad");
            System.out.println("3. Salir");
            System.out.println("4. Mostrar archivo Learning paths creados");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.println("Para crear el Learning Path...");
                
                System.out.print("Ingrese código del Learning Path: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); 

                System.out.print("Ingrese título del Learning Path: ");
                String titulo = scanner.nextLine();

                System.out.print("Ingrese descripción: ");
                String descripcion = scanner.nextLine();

                System.out.print("Ingrese objetivos: ");
                String objetivos = scanner.nextLine();

                System.out.print("Ingrese dificultad: ");
                String dificultad = scanner.nextLine();

                System.out.print("Ingrese duración: ");
                String duracion = scanner.nextLine();
                
             //  agregar la lógica para pedir al usuario que ingrese actividades

                Map<String, Actividad> actividades = new HashMap<>(); //eso no va ahi pero es mientras acabamos lo de actividades
                profesorCreador.crearLearningPath(codigo, titulo, descripcion, objetivos, dificultad, duracion, actividades, profesorCreador);
        
                
            } else if (opcion == 2) {
                System.out.println("Creando actividad...");
            } else if (opcion == 3) {
                continuar = false; 
                System.out.println("Saliendo del menú de profesor...");  
            } else if (opcion == 4) {
                System.out.println("mostrando learning paths creados...");
                profesorCreador.mostrarLearningPathsDesdeArchivo();
               
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

        System.out.print("Ingrese tipo de usuario (Estudiante/Profesor): ");
        String tipoUsuario = scanner.nextLine();

        Usuario usuario;
        if (tipoUsuario.equalsIgnoreCase("Estudiante")) {
            usuario = new Estudiante(nombre, nombreUsuario, password, tipoUsuario);
        } else if (tipoUsuario.equalsIgnoreCase("Profesor")) {
            usuario = new Profesor(nombre, nombreUsuario, password, tipoUsuario);
        } else {
            System.out.println("Tipo de usuario no válido.");
            return; 
        }

        boolean usuarioYaRegistrado = gestorUsuarios.registrarUsuario(usuario, tipoUsuario);
        if (usuarioYaRegistrado) {
        	 System.out.println("Error: El nombre de usuario '" + nombreUsuario + "' ya está registrado.");
        } else {
        	System.out.println("Usuario registrado exitosamente.");
           
        }
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
            } else if (tipoUsuario.equals("Profesor") && usuario instanceof Profesor) {
                System.out.println("Opciones para profesor:");
                Profesor profesorCreador = (Profesor) usuario; 
                mostrarMenuProfesor(scanner, profesorCreador, lpControl);
            } else {
                System.out.println("Error: el tipo de usuario no coincide con " + tipoUsuario + ".");
            }
        } else {
            System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
        }
    }
   
    
    private static void imprimirLearningPaths(Map<Integer, LearningPath> learningPaths) {
    	lpControl.obtenerLearningPaths();
        if (learningPaths.isEmpty()) {
            System.out.println("No hay Learning Paths registrados.");
        } else {
            System.out.println("Learning Paths registrados:");
            for (LearningPath lp : learningPaths.values()) {
            	System.out.println("Profesor Creador: " +  lp.getProfesorCreador().getNombre());
                System.out.println("Código: " + lp.getIdLP());
                System.out.println("Título: " + lp.getTitulo());
                System.out.println("Descripción: " + lp.getDescripcion());
                System.out.println("Objetivos: " + lp.getObjetivos());
                System.out.println("Dificultad: " + lp.getDificultad());
                System.out.println("Duración: " + lp.getDuracion());
                System.out.println("------------------------------------");
            }
        }
    }
    
    private static void imprimirLearningPathsInscritos(Estudiante estudiante) {
        Map<Integer, LearningPath> lpInscritos = estudiante.getLpInscritos(); 
        imprimirLearningPaths(lpInscritos);
    }
    public static void main(String[] args) {
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








    	
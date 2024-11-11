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

public class Main_profesor {
	
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
                Controlador.profesorCrearLearningPath(codigo, titulo, descripcion, objetivos, dificultad, duracion, actividades, profesorCreador);
        
                
            } else if (opcion == 2) {
                System.out.println("Creando actividad...");
                
                System.out.print("Ingrese código de la actividad: ");
                int idActividad = scanner.nextInt();
                scanner.nextLine(); 
                
                System.out.print("Ingrese código del learning path en que la actividad sera inscrita: ");
                int idLp = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Ingrese descripción: ");
                String descripcion = scanner.nextLine();

                System.out.print("Ingrese objetivos: ");
                String objetivos = scanner.nextLine();

                System.out.print("Ingrese dificultad: ");
                String dificultad = scanner.nextLine();

                System.out.print("Ingrese duración: ");
                String duracion = scanner.nextLine();
                
                System.out.println("Tipos: ");
                System.out.println("1. Tarea");
                System.out.println("2. Encuesta");
                System.out.println("3. Revisar Recurso");
                System.out.println("4. Quiz");
                System.out.println("5. Examen");
                System.out.print("Seleccione una opcion: ");
                int opcionAct = scanner.nextInt();
                scanner.nextLine();
                String ejercisio = null;
                String recursoLink=null;
                double notaAprobacion=0.0;
                
                if (opcionAct==1) {
                	System.out.print("Ingrese el ejercisio: ");
                    ejercisio = scanner.nextLine();
                    Controlador.crearActividad(idActividad, descripcion, objetivos, dificultad, duracion, "Tarea", 
                			notaAprobacion,  recursoLink, ejercisio, idLp, profesorCreador);}
                else if (opcionAct==2) {
                    Controlador.crearActividad(idActividad, descripcion, objetivos, dificultad, duracion, "Encuesta", 
                			notaAprobacion,  recursoLink, ejercisio, idLp, profesorCreador);}
                else if (opcionAct==3) {
                	System.out.print("Ingrese el recurso a revisar (link): ");
                    recursoLink = scanner.nextLine();
                    Controlador.crearActividad(idActividad, descripcion, objetivos, dificultad, duracion, "Revisar Recurso", 
                			notaAprobacion,  recursoLink, ejercisio, idLp, profesorCreador);}
                else if (opcionAct==4) {
                	System.out.print("Ingrese la nota minima aprobatoria: ");
                    notaAprobacion = scanner.nextDouble();
                    scanner.nextLine();
                    Controlador.crearActividad(idActividad, descripcion, objetivos, dificultad, duracion, "Quiz", 
                			notaAprobacion,  recursoLink, ejercisio, idLp, profesorCreador);}
                else if (opcionAct==5) {
                	System.out.print("Ingrese la nota minima aprobatoria: ");
                    notaAprobacion = scanner.nextDouble();
                    scanner.nextLine();
                    Controlador.crearActividad(idActividad, descripcion, objetivos, dificultad, duracion, "Examen", 
                			notaAprobacion,  recursoLink, ejercisio, idLp, profesorCreador);}
                
	                     
                
                
                else {
                	System.out.print("Vuelva escoger un tipo de actividad");
                }
                
                
                
                
            } else if (opcion == 3) {
                continuar = false; 
                System.out.println("Saliendo del menú de profesor...");  
            } else if (opcion == 4) {
                System.out.println("mostrando learning paths creados...");
                profesorCreador.mostrarLearningPathsDesdeArchivo();
            } else if (opcion == 5) {
            	System.out.print("Ingrese código del learningpath a eliminar: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();
                Controlador.eliminarLp(codigo, profesorCreador);
                
               
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
        
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
                Profesor profesorCreador = (Profesor) usuario; 
                mostrarMenuProfesor(scanner, profesorCreador, lpControl);
            } else {
                System.out.println("Error: el tipo de usuario no coincide con " + tipoUsuario + ".");
            }
        } else {
            System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
        }
    }
   
    
    
    public static void mainProfesor() {
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








   
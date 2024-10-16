package Consola;

import java.util.List;
import java.util.Scanner;

import LearningPath.LearningPath;
import co.edu.andes.persistencia.GestorUsuarios;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import co.edu.andes.usuarios.Usuario;

public class Main {
	

    private static void mostrarMenu() {
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Salir");
        System.out.println("4. Mostrar Usuarios desde Archivo");
        System.out.print("Seleccione una opción: ");
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

        gestorUsuarios.registrarUsuario(usuario, tipoUsuario);
        
        boolean registroExitoso = gestorUsuarios.registrarUsuario(usuario, tipoUsuario);
        if (registroExitoso) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error: El nombre de usuario '" + nombreUsuario + "' ya está registrado.");
        }
    }

    private static void iniciarSesion(GestorUsuarios gestorUsuarios, Scanner leer) {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = leer.nextLine();

        System.out.print("Ingrese contraseña: ");
        String password = leer.nextLine();
        
        String tipoUsuario = gestorUsuarios.iniciarSesion(nombreUsuario, password);
        
        if (tipoUsuario != null) {
            System.out.println("Inicio de sesión exitoso como: " + tipoUsuario);
          
           
            if (tipoUsuario.equals("Estudiante")) {
            	System.out.println("Opciones para estudiante:");
            } else if (tipoUsuario.equals("Profesor")) {
            	System.out.println("Opciones para profesor:");
            
            }
         
        } else {
            System.out.println("Credenciales incorrectas. Inténtalo de nuevo.");
          
        }
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

    
    	
    	
package Consola;

import java.util.Scanner;

import co.edu.andes.sistema.GestorUsuarios;

public class MainInicio {

	public MainInicio() {
		// TODO Auto-generated constructor stub
	}


public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("1. Estudiante");
    System.out.println("2. Profesor");
    System.out.println("3. Salir");
    System.out.print("Seleccione una opción: ");
    int opcion = scanner.nextInt();
    scanner.nextLine();
    if (opcion==1) {
    	Main.mainEstudiante();}
	else if (opcion==2) {
    	Main_profesor.mainProfesor();}
	else if (opcion == 3) {
    System.out.println("Saliendo del sistema...");
    
    }
    
   
    
}
}
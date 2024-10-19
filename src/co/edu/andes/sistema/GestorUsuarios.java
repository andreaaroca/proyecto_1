package co.edu.andes.sistema;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import LearningPath.LearningPath;
import co.edu.andes.usuarios.Estudiante;
import co.edu.andes.usuarios.Profesor;
import co.edu.andes.usuarios.Usuario;

public class GestorUsuarios {
	
	private ArrayList<Profesor> profesoresRegistrados = new ArrayList<>();
    private ArrayList<Estudiante> estudiantesRegistrados = new ArrayList<>();
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    
    public GestorUsuarios() {
        profesoresRegistrados = new ArrayList<>();
        estudiantesRegistrados = new ArrayList<>();
    }
    
    public boolean registrarUsuario(Usuario usuario, String tipo) {
    if (usuarioYaRegistrado(usuario.getNombreUsuario())) {
        return true; 
    }

    if (usuario instanceof Estudiante) {
        estudiantesRegistrados.add((Estudiante) usuario);
    } else if (usuario instanceof Profesor) {
        profesoresRegistrados.add((Profesor) usuario);
    }
    guardarUsuarioEnArchivo(usuario);
    return false;

    }
    
    public boolean usuarioYaRegistrado(String nombreUsuario) {
        for (Estudiante estudiante : estudiantesRegistrados) {
            if (estudiante.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        for (Profesor profesor : profesoresRegistrados) {
            if (profesor.getNombreUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false; 
    }
    
	public void guardarUsuarioEnArchivo(Usuario usuario) {
	   	 try (FileWriter fw = new FileWriter(ARCHIVO_USUARIOS, true);
	   	         PrintWriter pw = new PrintWriter(fw)) {
	   	        pw.println(usuario.getNombre() + "," + usuario.getNombreUsuario()  + "," + usuario.getPassword() + ","  +  usuario.getTipoUsuario());;
	   	    } catch (IOException e) {
	   	        e.printStackTrace();
	   	    }
	}
		
    public void cargarUsuariosDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                String nombreUsuario = datos[1];
                String contraseña = datos[2];
                String tipo = datos[3];

                if (tipo.equals("Estudiante")) {
                    estudiantesRegistrados.add(new Estudiante(nombre, nombreUsuario, contraseña, tipo));
                } else if (tipo.equals("Profesor")) {
                    profesoresRegistrados.add(new Profesor(nombre, nombreUsuario, contraseña, tipo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String iniciarSesion(String nombreUsuario, String password) {
        for (Estudiante estudiante : estudiantesRegistrados) {
            if (estudiante.getNombreUsuario().equals(nombreUsuario) && estudiante.getPassword().equals(password)) {
                return "Estudiante"; 
            }
        }
        for (Profesor profesor : profesoresRegistrados) {
            if (profesor.getNombreUsuario().equals(nombreUsuario) && profesor.getPassword().equals(password)) {
                return "Profesor"; 
            }
        }
        return null; 
        
    }
    
    public List<String> mostrarUsuariosDesdeArchivo() {
        List<String> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                usuarios.add(linea); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios; 
    }
    
    }



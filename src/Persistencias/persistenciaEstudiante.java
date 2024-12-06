package Persistencias;
	
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;
	
	import LearningPath.LearningPath;
	import co.edu.andes.usuarios.Estudiante;
	import Actividades.*;
	import java.time.*;
	
	public class persistenciaEstudiante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String ARCHIVO_ESTUDIANTES = "estudiantes.ser"; 
	private HashMap<String, HashMap<Integer, LearningPath>> mapaEstudiantes;
	private HashMap<String,HashMap<Integer, LocalDateTime>> mapaEstudiantesIniciadas;
	private HashMap<String,HashMap<Integer, LocalDateTime>> mapaEstudiantesFin;
	
	private HashMap<Integer, List<LearningPath>> lpInscritos;
	private static final String ARCHIVO_INICIADASACTIVIDADES = "iniciadasActividades.ser";
	private static final String ARCHIVO_FINACTIVIDADES = "finActividades.ser";
	
	public persistenciaEstudiante() {
	   
	    mapaEstudiantes = new HashMap<>();
	    
	    this.mapaEstudiantesIniciadas=cargarActIniciadas();
	    this.mapaEstudiantesFin=cargarActFin();
	    cargarLpInscritos(); 
	    
	}
	@SuppressWarnings("unchecked")
	 public void cargarLpInscritos() {
	        File archivo = new File(ARCHIVO_ESTUDIANTES);
	        if (!archivo.exists()) {
	            mapaEstudiantes = new HashMap<>(); 
	            return;
	        }
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
	            
	            HashMap<String, HashMap<Integer, LearningPath>> mapa = (HashMap<String, HashMap<Integer, LearningPath>>) ois.readObject();
	            mapaEstudiantes = mapa;
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            mapaEstudiantes = new HashMap<>(); 
	        }
	    }
	 
	@SuppressWarnings("unchecked")
	 public HashMap<String,HashMap<Integer, LocalDateTime>> cargarActIniciadas() {
			
		 File archivo = new File(ARCHIVO_INICIADASACTIVIDADES);
	     if (archivo.exists()) { 
	         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
	             return (HashMap<String,HashMap<Integer, LocalDateTime>>) ois.readObject(); 
	         } catch (IOException | ClassNotFoundException e) {
	             e.printStackTrace();
	         }
	     }
	     return new HashMap<>(); 
	 }
	
	@SuppressWarnings("unchecked")
	public HashMap<String,HashMap<Integer, LocalDateTime>> cargarActFin() {
		
		 File archivo = new File(ARCHIVO_FINACTIVIDADES);
	     if (archivo.exists()) { 
	         try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
	             return (HashMap<String,HashMap<Integer, LocalDateTime>>) ois.readObject(); 
	         } catch (IOException | ClassNotFoundException e) {
	             e.printStackTrace();
	         }
	     }
	     return new HashMap<>(); 
	 }



    public void guardarLpInscritos(Estudiante estudiante) {
    	cargarLpInscritos();
       
        String nombreUsuario = estudiante.getNombreUsuario();
        HashMap<Integer, LearningPath> learningPathsInscritos = estudiante.getLpInscritos();

       
        mapaEstudiantes.put(nombreUsuario, learningPathsInscritos);
        
        File archivo = new File(ARCHIVO_ESTUDIANTES);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();  
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ESTUDIANTES))) {
            oos.writeObject(mapaEstudiantes);
            System.out.println("Datos guardados correctamente en " + ARCHIVO_ESTUDIANTES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void guardarIniciadosAct(HashMap<String,HashMap<Integer, LocalDateTime>> iniciadasAct) {
	    
    	HashMap<String,HashMap<Integer, LocalDateTime>>estudianteIniciadas = cargarActIniciadas();

    	estudianteIniciadas.putAll(iniciadasAct); 
	    File archivo = new File(ARCHIVO_INICIADASACTIVIDADES);

	    try {
	        if (!archivo.exists()) {
	            archivo.createNewFile(); 
	        }
	
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
	            oos.writeObject(estudianteIniciadas); 
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
    
	public void guardarFinAct(HashMap<String,HashMap<Integer, LocalDateTime>> finAct) {
		    
	    	HashMap<String,HashMap<Integer, LocalDateTime>>estudianteIniciadas = cargarActFin();
	
	    	estudianteIniciadas.putAll(finAct); 
		    File archivo = new File(ARCHIVO_FINACTIVIDADES);
	
		    try {
		        if (!archivo.exists()) {
		            archivo.createNewFile(); 
		        }
		
		        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
		            oos.writeObject(estudianteIniciadas); 
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	    
    public void mostrarLpInscritos(Estudiante estudiante) {
        String nombreUsuario = estudiante.getNombreUsuario();
        
        cargarLpInscritos();

            if (mapaEstudiantes.containsKey(nombreUsuario)) {
                HashMap<Integer, LearningPath> learningPathsInscritos = mapaEstudiantes.get(nombreUsuario);
              

                System.out.println("Learning Paths inscritos para " + nombreUsuario + ":");
                for (LearningPath lp : learningPathsInscritos.values()) {
                    System.out.println(" - " + lp.getTitulo()); 
                }
            } else {
                System.out.println("No se encontraron Learning Paths inscritos para el estudiante " + nombreUsuario);
            }

        
        }
    
    public void iniciarActividad(Estudiante estudiante, int idLp, int idActividad, LocalDateTime hora) {
		cargarLpInscritos();
		
	    if (mapaEstudiantes.containsKey(estudiante.getNombreUsuario())) {
	    	HashMap<Integer, LearningPath> learningPathsInscritos=mapaEstudiantes.get(estudiante.getNombreUsuario());
	    	if (learningPathsInscritos.containsKey(idLp)){
	    		if((learningPathsInscritos.get(idLp).getActividades().containsKey(idActividad))&&(estudiante.getActividadesIniciadasTiempo().containsKey(idActividad))) {
	    			estudiante.getActividadesIniciadasTiempo().put(idActividad,hora );
	    			guardarLpInscritos(estudiante);
	    			
	    			
	    				
	    			}
	    			
	    			
	    			
	    		}
	    		
	    		
	    	}
	    	
	    else
	    {
	        System.out.println("LearningPath con ID " + idLp + " no encontrado en el archivo.");
	    }
	
	}
	
	
	
	public void finActividad(Estudiante estudiante, int idLp, int idActividad, LocalDateTime hora) {
		cargarLpInscritos();
		
	    if (mapaEstudiantes.containsKey(estudiante.getNombreUsuario())) {
	    	HashMap<Integer, LearningPath> learningPathsInscritos=mapaEstudiantes.get(estudiante.getNombreUsuario());
	    	if (learningPathsInscritos.containsKey(idLp)){
	    		if((learningPathsInscritos.get(idLp).getActividades().containsKey(idActividad))&&(estudiante.getActividadesIniciadasTiempo().containsKey(idActividad))) {
	    			estudiante.getActividadesIniciadasTiempo().put(idActividad,hora );
	    			guardarLpInscritos(estudiante);
	    			
	    			
	    				
	    			}
	    			
	    			
	    			
	    		}
	    		
	    		
	    	}
	    	
	    else
	    {
	        System.out.println("LearningPath con ID " + idLp + " no encontrado en el archivo.");
	    }
	
	}
	
	 public String obtenerLearningPathsInscritosTexto(Estudiante estudiante) {
	        StringBuilder builder = new StringBuilder();
	        String nombreUsuario = estudiante.getNombreUsuario();

	        if (mapaEstudiantes.containsKey(nombreUsuario)) {
	            HashMap<Integer, LearningPath> learningPathsInscritos = mapaEstudiantes.get(nombreUsuario);

	            builder.append("Learning Paths inscritos para ").append(nombreUsuario).append(":\n");
	            for (LearningPath lp : learningPathsInscritos.values()) {
	                builder.append(" - ").append(lp.getTitulo()).append("\n");
	            }
	        } else {
	            builder.append("No se encontraron Learning Paths inscritos para ").append(nombreUsuario).append("\n");
	        }
	        return builder.toString();
	    }
	
	}

	

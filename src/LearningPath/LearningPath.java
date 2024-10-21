package LearningPath;

import java.util.*;

import Actividades.Actividad;
import co.edu.andes.usuarios.*;

import co.edu.andes.usuarios.Profesor;

public class LearningPath 
{
	private String titulo;
    private String descripcion; 
    private String objetivos;
    private String dificultad;
    private String duracion;
    private List<Actividad> obligatorias;
    private String ratingPromedio;
	private List<Actividad> prerequisitos;
	private String version;
	private List<Actividad> sugeridas;
	private Date fechaModificacion;
	private Date fechaLimite;
	private Date fechaCreacion;

	
    public LearningPath(String titulo, String descripcion, String objetivos, String dificultad, String duracion,
			String version, Date fechaModificacion, Date fechaLimite, Date fechaCreacion) 
    {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivos = objetivos;
		this.dificultad = dificultad;
		this.duracion = duracion;
		this.obligatorias = new ArrayList<Actividad>();
		this.ratingPromedio = "0";
		this.prerequisitos = new ArrayList<Actividad>();
		this.version = version;
		this.sugeridas = new ArrayList<Actividad>();
		this.fechaModificacion = fechaModificacion;
		this.fechaLimite = fechaLimite;
		this.fechaCreacion = fechaCreacion;
    }

	
	public String getDuracion() 
	{
		return duracion;
	}


	public void setDuracion(String duracion) 
	{
		this.duracion = duracion;
	}


	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion) 
	{
		this.descripcion = descripcion;
	}

	public String getObjetivos() 
	{
		return objetivos;
	}

	public void setObjetivos(String objetivos) 
	{
		this.objetivos = objetivos;
	}

	public String getDificultad() 
	{
		return dificultad;
	}

	public void setDificultad(String dificultad) 
	{
		this.dificultad = dificultad;
	}


	public List<Actividad> getObligatorias() 
	{
		return obligatorias;
	}
	
	public void agregarActividad(Actividad actividad) 
	{
        this.obligatorias.add(actividad);
    }

    public void eliminarActividad(Actividad actividad) 
    {
        this.obligatorias.remove(actividad);
    }

    public boolean validarLearningPath() 
    {
        return 
               titulo != null && !titulo.isEmpty() &&
               descripcion != null && !descripcion.isEmpty() &&
               objetivos != null && !objetivos.isEmpty() &&
               dificultad != null && !dificultad.isEmpty() &&
               duracion != null && !duracion.isEmpty() &&
               obligatorias != null && !obligatorias.isEmpty();
    }


	public String getRatingPromedio() 
	{
		return ratingPromedio;
	}


	public void setRatingPromedio(String ratingPromedio) 
	{
		this.ratingPromedio = ratingPromedio;
	}


	public List<Actividad> getPrerequisitos() 
	{
		return prerequisitos;
	}


	public void setPrerequisitos(List<Actividad> prerequisitos) 
	{
		this.prerequisitos = prerequisitos;
	}


	public String getVersion() 
	{
		return version;
	}


	public void setVersion(String version) 
	{
		this.version = version;
	}


	public List<Actividad> getSugeridas() 
	{
		return sugeridas;
	}


	public void setSugeridas(List<Actividad> sugeridas) 
	{
		this.sugeridas = sugeridas;
	}


	public Date getFechaModificacion() 
	{
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) 
	{
		this.fechaModificacion = fechaModificacion;
	}


	public Date getFechaLimite() 
	{
		return fechaLimite;
	}


	public void setFechaLimite(Date fechaLimite) 
	{
		this.fechaLimite = fechaLimite;
	}


	public Date getFechaCreacion() 
	{
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) 
	{
		this.fechaCreacion = fechaCreacion;
	}
	
}

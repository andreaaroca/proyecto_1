package Actividades;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;
import LearningPath.*;
public abstract class Actividad implements Serializable 
{
	private static final long serialVersionUID = 1L;
	protected int idActividad;
	protected String descripcion;
	protected String objetivo;
	protected String dificultad;
	protected String duracion;
	protected List<String> resenas;
	protected boolean enviado;
	protected String tipo;
	
	
	public Actividad(int idActividad, String descripcion, String objetivo, String dificultad, String duracion, String tipo) 
	{
		
		this.idActividad= idActividad;
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.dificultad = dificultad;
		this.duracion = duracion;
		this.resenas = new ArrayList<String>();
		this.enviado=false;
		this.tipo=tipo;
		
	}

	
	
	public int getIdActividad() 
	{
		return idActividad;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public String getObjetivo() 
	{
		return objetivo;
	}

	public String getDificultad() 
	{
		return dificultad;
		
		
	}

	public String getDuracion() 
	{
		return duracion;
	}


	public boolean isEnviado() 
	{
		return enviado;
	}

	public void setEnviado(boolean enviado) 
	{
		this.enviado = enviado;
	}

	public void agregarResena(String r) 
	{
		resenas.add(r); 
	}

	public String getTipo() 
	{
		return tipo;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	public void agregarComentarioResena(String comentario) {
        resenas.add(comentario); 
    }
	
	public List<String> getResenas() 
	{
		return resenas;
	}
	
	
	
	
}

package Actividades;
import java.util.*;

public class PreguntaQuiz 
{
	private String enunciado;
	private List<String> opciones;
	private int indiceCorrecto;
	private String explicacion;
	
	public PreguntaQuiz(String enunciado, List<String> opciones, int indiceCorrecto, String explicacion) 
	{
		this.enunciado = enunciado;
		this.opciones = opciones;
		this.indiceCorrecto = indiceCorrecto;
		this.explicacion = explicacion;
	}

	public String getEnunciado() 
	{
		return enunciado;
	}

	public void setEnunciado(String enunciado) 
	{
		this.enunciado = enunciado;
	}

	public List<String> getOpciones() 
	{
		return opciones;
	}

	public void setOpciones(List<String> opciones) 
	{
		this.opciones = opciones;
	}

	public int getIndiceCorrecto() 
	{
		return indiceCorrecto;
	}

	public void setIndiceCorrecto(int indiceCorrecto) 
	{
		this.indiceCorrecto = indiceCorrecto;
	}

	public String getExplicacion() 
	{
		return explicacion;
	}

	public void setExplicacion(String explicacion) 
	{
		this.explicacion = explicacion;
	}
	
	
}
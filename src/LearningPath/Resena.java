package LearningPath;

import co.edu.andes.usuarios.Usuario;

public class Resena {

	public int idLP;
	public int idActividad;
	private String valoracion;
	private int  rating;
	private Usuario  user;
	
	

	public Resena(String valoracion, int rating) {
		super();
		this.valoracion = valoracion;
		this.rating = rating;
	}
	public String getValoracion() {
		return valoracion;
	}
	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getIdLP() {
		return idLP;
	}
	public void setIdLP(int idLP) {
		this.idLP = idLP;
	}
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	 @Override
	    public String toString() {
	        return "ID Actividad: " + idActividad + ", Rating: " + rating + ", Opinión: " + valoracion;
	    }
}

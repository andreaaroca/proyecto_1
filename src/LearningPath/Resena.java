package LearningPath;

import co.edu.andes.usuarios.Usuario;

public class Resena {

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
	
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
}

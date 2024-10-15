package co.edu.andes.usuarios;


;

public abstract class Usuario {
	private String nombre;	
	protected String nombreUsuario;
	private String correo;
	private String password;
	private String tipoUsuario;

	
	public Usuario(String nombre, String nombreUsuario, String password, String tipoUsuario) {
        this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String usuario) {
		this.nombreUsuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {

		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
   public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	

	public boolean iniciarSesion(String nombreUsuario, String password) {
	    return this.nombreUsuario.equals(nombreUsuario) && this.password.equals(password);
	}
	
	
	}

	



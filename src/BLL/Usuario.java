package BLL;

public class Usuario {
	protected int id;
	protected String nombre;
	protected String apellido;
	protected String mail;
	protected String contraseña;
	protected int id_tipo;
	

	public Usuario(int id,String nombre, String apellido, String mail, String contraseña, int tipo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contraseña = contraseña;
		this.id_tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getTipo() {
		return id_tipo;
	}
	public void setTipo(int tipo) {
		this.id_tipo = tipo;
	}
	@Override
	public String toString() {
		return "User [nombre=" + nombre + ", mail=" + mail + "]";
	}
}

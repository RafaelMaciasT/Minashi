
public class Mineral {
	
	private String nombre;
	private String estado;
	private double precio;
	public Mineral(String nombre, String estado, double precio) {
		super();
		this.nombre = nombre;
		this.estado = estado;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Mineral [nombre=" + nombre + ", estado=" + estado + ", precio=" + precio + "]";
	}

	
	
}

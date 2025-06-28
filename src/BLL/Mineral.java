package BLL;

public class Mineral {
    private int id;
    private String nombre;
    private double precio;
    private double cantidad; 
    private int peso;

    
    public Mineral(int id, String nombre, double precio, double cantidad, int peso) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.peso = peso;
    }

    
    public Mineral(String nombre, double precio, double cantidad, int peso) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.peso = peso;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    
    public String getUnidadPeso() {
        return (peso == 1) ? "KG" : "TNS";
    }

    @Override
    public String toString() {
        return "Mineral [id=" + id + ", nombre=" + nombre + ", precio=" + precio +
                ", cantidad=" + cantidad + ", unidad=" + getUnidadPeso() + "]";
    }
}


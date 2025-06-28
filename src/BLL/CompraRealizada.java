package BLL;

public class CompraRealizada {
    private String nombreMineral;
    private double cantidad;
    private String unidad;
    private double precioUnitario;

    public CompraRealizada(String nombreMineral, double cantidad, String unidad, double precioUnitario) {
        this.nombreMineral = nombreMineral;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precioUnitario = precioUnitario;
    }

    public String getNombreMineral() { return nombreMineral; }
    public double getCantidad() { return cantidad; }
    public String getUnidad() { return unidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    @Override
    public String toString() {
        return nombreMineral + " x " + cantidad + " " + unidad + " ($" + precioUnitario + ")";
    }
}



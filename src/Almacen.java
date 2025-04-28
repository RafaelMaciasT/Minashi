
public class Almacen {

	private int nro_almacen;
	private Mineral minerales;
	public Almacen(int nro_almacen, Mineral minerales) {
		super();
		this.nro_almacen = nro_almacen;
		this.minerales = minerales;
	}
	public int getNro_almacen() {
		return nro_almacen;
	}
	public void setNro_almacen(int nro_almacen) {
		this.nro_almacen = nro_almacen;
	}
	public Mineral getMinerales() {
		return minerales;
	}
	public void setMinerales(Mineral minerales) {
		this.minerales = minerales;
	}
	@Override
	public String toString() {
		return "Almacen [nro_almacen=" + nro_almacen + ", minerales=" + minerales + "]";
	}
	
}

import javax.swing.JOptionPane;

public class Cliente extends Usuario {

	private String contra;
	private int nro_cliente;
	
	public Cliente(String nombre, String mail, String contra, int nro_cliente) {
		super(nombre, mail);
		this.contra = contra;
		this.nro_cliente = nro_cliente;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public int getNro_cliente() {
		return nro_cliente;
	}
	public void setNro_cliente(int nro_cliente) {
		this.nro_cliente = nro_cliente;
	}
	@Override
	public String toString() {
		return "Cliente [contra=" + contra + ", nro_cliente=" + nro_cliente + "]";
	}
	
	public static boolean cliente_ingreso ( String a , String b , String c ) {
		// Nombre = Rafael   mail= rafa@minashi.com  contra= davinci
		
		if (a.isEmpty() && a!= "Rafael" || b.isEmpty() && b != "rafa@minashi.com"|| c.isEmpty() && c != "davinci") {
			JOptionPane.showMessageDialog(null, "No Pudo ingresa, datos incorrectos");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso correcto");
			return false;
		}
		
	}
	
}

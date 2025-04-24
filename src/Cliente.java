import javax.swing.JOptionPane;

public class Cliente extends Usuario {

	private int nro_cliente;
	private String contraseña;
	public Cliente(String nombre, String apellido, String mail, int nro_cliente, String contraseña) {
		super(nombre, apellido, mail);
		this.nro_cliente = nro_cliente;
		this.contraseña = contraseña;
	}
	public int getNro_cliente() {
		return nro_cliente;
	}
	public void setNro_cliente(int nro_cliente) {
		this.nro_cliente = nro_cliente;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return "Cliente [nro_cliente=" + nro_cliente + ", contraseña=" + contraseña + "]";
	}
   public static void reg_cliente(Cliente addcli) {
		
		String cliname=JOptionPane.showInputDialog("Ingrese nombre del cliente");
		String cliapell=JOptionPane.showInputDialog("Ingrese apellido del cliente");
		String climail=JOptionPane.showInputDialog("Ingrese mail del cliente");
		int clinro=0001;
		int cliin=Integer.parseInt(JOptionPane.showInputDialog("Ingrese contraseña"));
		
		
		
		Empleado agg_cliente= new Empleado(cliname, cliapell, climail, clinro, cliin);
		JOptionPane.showMessageDialog(null, agg_cliente);
	
		
	}
	
}

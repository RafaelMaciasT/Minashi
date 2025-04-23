import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Empleado extends Persona{

	private int nro_empleado;
	private int pin;
	public Empleado(String nombre, String apellido, String mail, int nro_empleado, int pin) {
		super(nombre, apellido, mail);
		this.nro_empleado = nro_empleado;
		this.pin = pin;
	}
	public int getNro_empleado() {
		return nro_empleado;
	}
	public void setNro_empleado(int nro_empleado) {
		this.nro_empleado = nro_empleado;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Empleado [nro_empleado=" + nro_empleado + ", pin=" + pin + "]";
	}
	
	public static void agregar_mineral (LinkedList<Mineral>mines) {
		String minename= JOptionPane.showInputDialog("Ingrese nombre de mineral");
		 Mineral a = new Mineral(minename,"a",1);
		 JOptionPane.showMessageDialog(null, a);
	}
	
	public static void reg_empleado(Empleado addem) {
		
		String empname=JOptionPane.showInputDialog("Ingrese nombre del empleado");
		String empapell=JOptionPane.showInputDialog("Ingrese nombre del empleado");
		String empmail=JOptionPane.showInputDialog("Ingrese nombre del empleado");
		int empnro=0001;
		int empin=Integer.parseInt(JOptionPane.showInputDialog("Ingrese pin"));
		
		Empleado agg_empleado= new Empleado(empname, empapell, empmail, empnro, empin);
		JOptionPane.showMessageDialog(null, agg_empleado);
	}
}

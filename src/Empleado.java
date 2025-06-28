import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Empleado extends Usuario{

	private int pin;
	private int nro_empleado;
	public Empleado(String nombre, String mail, int pin, int nro_empleado) {
		super(nombre, mail);
		this.pin = pin;
		this.nro_empleado = nro_empleado;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getNro_empleado() {
		return nro_empleado;
	}
	public void setNro_empleado(int nro_empleado) {
		this.nro_empleado = nro_empleado;
	}
	@Override
	public String toString() {
		return "Empleado [pin=" + pin + ", nro_empleado=" + nro_empleado + "]";
	}
	
	public static boolean empleado_ingreso ( String a , String b , int c ) {
		// Nombre = Artem   mail= artem@minashi.com  pin=1234
		
		if (a.isEmpty() && a!= "Artem" || b.isEmpty() && b != "artem@minashi.com"  || c!=1234 ) {
			JOptionPane.showMessageDialog(null, "Ingreso incorrecto");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso correctamente");
			return false;
		}
		
	}
}

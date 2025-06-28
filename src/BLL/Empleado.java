package BLL;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Empleado extends Usuario{

	//No tienen una funcion actualmente
	
	
	
	public Empleado(int id, String nombre, String apellido, String mail, String contraseña, int tipo) {
		super(id, nombre, apellido, mail, contraseña, tipo);
	}

	public static boolean empleado_ingreso ( String a , String b , int c ) {
		
		
		if (a.isEmpty() && a!= "Artem" || b.isEmpty() && b != "artem@minashi.com"  || c!=1234 ) {
			JOptionPane.showMessageDialog(null, "Ingreso incorrecto");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso correctamente");
			return false;
		}

	}
	
	public void prueba () {
		JOptionPane.showMessageDialog(null, "Empleado seleccionado");
	}
}

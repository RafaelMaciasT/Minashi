package BLL;
import javax.swing.JOptionPane;

public class Cliente extends Usuario {

	
	
	
	public Cliente(int id, String nombre, String apellido, String mail, String contraseña, int tipo) {
		super(id, nombre, apellido, mail, contraseña, tipo);
	}



	
	public static boolean cliente_ingreso ( String a , String b , String c ) {
		
		
		if (a.isEmpty() && a!= "Rafael" || b.isEmpty() && b != "rafa@minashi.com"|| c.isEmpty() && c != "davinci") {
			JOptionPane.showMessageDialog(null, "No Pudo ingresa, datos incorrectos");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ingreso correcto");
			return false;
		}
		
	}
	
}

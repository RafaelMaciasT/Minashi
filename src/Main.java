import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JOptionPane.showMessageDialog(null, "Mensaje de Main");
		 
		String [] Menu= {"Ingresar", "Registrar","Salir"};
		int opciones;
		do {
			opciones=JOptionPane.showOptionDialog(null, "Menu", "Opciones de menu", 0, 0, null, Menu, Menu[0]);
			
			
		switch (opciones) {
		case 0:
			
			break;

		case 1:
			
			break;
		case 2:
			
		default:
			break;
		}
		} while (opciones!=2);
		
	}

}

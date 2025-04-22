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
			
			JOptionPane.showMessageDialog(null, "Seleccion de inicio de cuenta");
			
			String []Accmenu= {"Empleado" , "Cliente","Salir"};
			int accop;
			do {
				accop=JOptionPane.showOptionDialog(null, "Selecciones el Tipo de Usuario", "Seleccion de Inicio", 0, 0, null, Accmenu, Accmenu[0]);
				
				switch (accop) {
				case 0:
					JOptionPane.showMessageDialog(null, "Seleccion de inicio de cuenta");
					
					String []empmenu= {"Empleado" , "Cliente","Salir"};
					int empop;
					do {
						empop=JOptionPane.showOptionDialog(null, "Selecciones el Tipo de Usuario", "Seleccion de Inicio", 0, 0, null, empmenu, empmenu[0]);
						
						switch (empop) {
						case 0:
							
							break;

						case 1:
							break;
						case 2: 
						default:
							break;
						}
					} while (empop!=2);
					break;
				

				case 1:
					break;
				case 2: 
				default:
					break;
				}
			} while (accop!=2);
			break;

		case 1:
            JOptionPane.showMessageDialog(null, "Registro de Cuenta");
			
			String []regmenu= {"Empleado" , "Cliente","Salir"};
			int regop;
			do {
				regop=JOptionPane.showOptionDialog(null, "Tipo de Usuario para Registrar", "Seleccion de Registro", 0, 0, null, regmenu, regmenu[0]);
				
				switch (regop) {
				case 0:
					
					break;

				case 1:
					break;
				case 2: 
				default:
					break;
				}
			} while (regop!=2);
			break;
			
			
		case 2:
			
		default:
			break;
		}
		} while (opciones!=2);
		
	}

}

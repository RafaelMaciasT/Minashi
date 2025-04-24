import java.util.ResourceBundle.Control;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		String [] Menu= {"Ingresar", "Registrar","Salir"};
		int opciones;
		do {
			opciones=JOptionPane.showOptionDialog(null, "Menu", "Opciones de menu", 0, 0, null, Menu, Menu[0]);
			
			
		switch (opciones) {
		
		// SECCION DE ELECCION EMPLEADO - CLIENTE (INICIO DE SESION/INGRESO)
		case 0:
			JOptionPane.showMessageDialog(null, "Seleccion de inicio de cuenta");
			
			String []Accmenu= {"Empleado" , "Cliente","Salir"};
			int accop;
			do {
				accop=JOptionPane.showOptionDialog(null, "Selecciones el Tipo de Usuario", "Seleccion de Inicio", 0, 0, null, Accmenu, Accmenu[0]);
				
				switch (accop) {
				//SECCION DE MENU EMPLEADO
				case 0:
					String []empmenu= {"Control de Stock y venta" , "Control de Mineral","Recibir Minerales","Salir"};
					int empop;
					do {
						empop=JOptionPane.showOptionDialog(null, "Seleccion Acciones", "Menu Empleado", 0, 0, null, empmenu, empmenu[0]);
						// CONTROL DE STOCK
						switch (empop) {
						
						case 0:
							JOptionPane.showMessageDialog(null, "Ver / Controlar Stock ");
							String []estkmenu= {"Agregar productos" , "Cambiar precio","Cambiar cantidad en venta","Salir"};
							int estkop;
							do {
								estkop=JOptionPane.showOptionDialog(null, "Seleccion Acciones", "Menu Empleado", 0, 0, null, estkmenu, estkmenu[0]);
								
								switch (estkop) {
								case 0:
									JOptionPane.showMessageDialog(null, "Agregar");
									Empleado.agregar_mineral(null);
									break;
								case 1:
									JOptionPane.showMessageDialog(null, "Cambio de precio");
									break;
								case 2:
									JOptionPane.showMessageDialog(null, "Cambio de cantidad en en venta");
									break;
								case 3:
								default:
									break;
								}
							} while (estkop!=3);
							
							break;

						case 1:
							JOptionPane.showMessageDialog(null, "Elija mineral para controlar su estado");
							break;
						case 2:
							JOptionPane.showMessageDialog(null, "Lista de minerales a recibir");
							break;
						case 3:
						default:
							break;
						}
					} while (empop!=3);
					break;
				// SECCION DE MENU CLIENTE
				case 1:
					JOptionPane.showMessageDialog(null, "Menu Cliente");
					
					// SECCION DE COMPRA
					String []climenu= {"Seccion de Compra" ,"Salir"};
					int cliop;
					do {
						cliop=JOptionPane.showOptionDialog(null, "Seleccion Acciones", "Menu Empleado", 0, 0, null, climenu, climenu[0]);
						
						switch (cliop) {
						case 0:
							JOptionPane.showMessageDialog(null, "Lista de productos en venta");
							break;

						case 1:
						
						default:
							break;
						}
					} while (cliop!=1);
					
					break;
				case 2: 
				default:
					break;
				}
			} while (accop!=2);
			break;

			//SECCION DE REGISTRO
		case 1:
            JOptionPane.showMessageDialog(null, "Registro de Cuenta");
			
			String []regmenu= {"Empleado" , "Cliente","Salir"};
			int regop;
			do {
				regop=JOptionPane.showOptionDialog(null, "Tipo de Usuario para Registrar", "Seleccion de Registro", 0, 0, null, regmenu, regmenu[0]);
				
				switch (regop) {
				//REGISTRO DE EMPLEADO
				case 0:
					Empleado.reg_empleado(null);
					
					Cliente nuevo = new Cliente("Rafael", "Macias","MAIL", 1212, "CONTRA");
					
				
					break;

				// REGISTRO DE CLIENTE
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

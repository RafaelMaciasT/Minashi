import java.util.ResourceBundle.Control;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
						
	
		
		String [] opcion= {"Inciar", "Registro","Salir"};
		int selop;
		do {
			selop=JOptionPane.showOptionDialog(null, "Seleccion", null, 0, 0, null, opcion, opcion[0]);
			switch (selop ) {
			case 0:
				
				// SELECCION TIPO DE USUARIO
				String [] opini= {"Cliente", "Empleado","Salir"};
				int selini;
				do {
					selini=JOptionPane.showOptionDialog(null, "Seleccion", null, 0, 0, null, opini, opini[0]);
					switch (selini) {
					// OPCION DE CLIENTE
					case 0:
						// Nombre = Rafael   mail= rafa@minashi.com  contra= davinci
						Cliente nvlcient= new Cliente("", "", "", 0);
						JOptionPane.showMessageDialog(null, "Lista de productos en venta");
					String nomb=JOptionPane.showInputDialog("Ingrese nombre");
					String mail=JOptionPane.showInputDialog("Ingrese Mail");
					String contra=JOptionPane.showInputDialog("Ingrese Contraseña");
						boolean respuesta= nvlcient.cliente_ingreso(nomb, mail, contra);
						//JOptionPane.showMessageDialog(null,respuesta);
						if (respuesta == true) {
							JOptionPane.showMessageDialog(null, "No se pudo ingresar");
						} else {
							JOptionPane.showMessageDialog(null, "Se pudo ingresar");
							
							String []datvalor= {"Comprar Mineral" , "Salir"};
							int valor;
							do {
								valor=JOptionPane.showOptionDialog(null, "Seleccion Acciones", "Menu Empleado", 0, 0, null, datvalor, datvalor[0]);
								switch (valor) {
								// SECCION COMPRA
								case 0:
									JOptionPane.showMessageDialog(null, "Se mostrara una lista con los Minerales para poder comprarlo");
									break;
								case 1:
								// SALIR
								default:
									break;
								}
							} while (valor!=1);
						}
						break;
						
					case 1:
						// OPCION DE EMPLEADO
						// Nombre = Artem   mail= artem@minashi.com  pin=1234
						Empleado nvlemp= new Empleado("", "", 0, 0);
						JOptionPane.showMessageDialog(null, "Lista de productos en venta");
					String nombemp=JOptionPane.showInputDialog("Ingrese nombre");
					String mailemp=JOptionPane.showInputDialog("Ingrese Mail");
					int emp= Integer.parseInt(JOptionPane.showInputDialog("Ingrese pin"));
						boolean respuestaemp= nvlemp.empleado_ingreso(nombemp, mailemp, emp);
					
						if (respuestaemp == true) {
							JOptionPane.showMessageDialog(null, "No se pudo ingresar");
						} else {
							JOptionPane.showMessageDialog(null, "Se pudo ingresar");
							
							String []datvalor= {"Recibir" , "Catalogar Mineral","Colocar Precio","Consulta de Stock","Salir"};
							int valor;
							do {
								valor=JOptionPane.showOptionDialog(null, "Seleccion Acciones", "Menu Empleado", 0, 0, null, datvalor, datvalor[0]);
								switch (valor) {
								// RECIBIR PRODUCTO
								case 0:
									JOptionPane.showMessageDialog(null, "Opcion para recibir productos");
									break;
									// CATALOGAR
								case 1:
									JOptionPane.showMessageDialog(null, "Opcion para Catalogar Minerales segun pureza");
									break;
									// COLOCAR PRECIO
								case 2:
									JOptionPane.showMessageDialog(null, "Seccion para Colocar precio / Editar");
									break;
									// CONSULTA STOCK
								case 3:
									JOptionPane.showMessageDialog(null, "Opcion para Consulta de Stock");
									break;
								case 4:
									// SALIR
								default:
									break;
								}
							} while (valor!=4);
						}
					default:
						break;
					}
							} while (selini!=2);
				
				break;
			case 1:
			// AREA DE REGISTRO - AUN NO DISPONIBLE
			JOptionPane.showMessageDialog(null, "Zona registro" + "\n" + "Aun No disponible ");
				break;
			case 2:
			// SALIR
			default:
				break;
			}
		} while (selop!=2 );
		
			
	}	

}

	
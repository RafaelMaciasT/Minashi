package GUI;

import javax.swing.*;
import BLL.Cliente;
import BLL.Sesion;

public class MenuCliente extends JFrame {

    private Cliente cliente;
    private JButton btnComprar, btnHistorial, btnCerrarSesion, btnVolver;
    private JLabel lblBienvenida;
 

    public MenuCliente() {
      
        if (!(Sesion.getUsuarioActual() instanceof Cliente)) {
            JOptionPane.showMessageDialog(this, "No hay un cliente logueado.");
            dispose();
            return;
        }

        Cliente cliente = (Cliente) Sesion.getUsuarioActual();

        cliente = (Cliente) Sesion.getUsuarioActual();

        setTitle("Menú Cliente");
        setSize(520, 370);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 

        lblBienvenida = new JLabel("Bienvenido, " + cliente.getNombre());
        lblBienvenida.setBounds(30, 20, 350, 25);
        add(lblBienvenida);

        btnComprar = new JButton("🛒 Realizar Compra");
        btnComprar.setBounds(140, 70, 220, 40);
        btnComprar.addActionListener(e -> {
        	new Compra().setVisible(true);
           
            System.out.println("Ir a sección de compra");
        });
        add(btnComprar);

        btnHistorial = new JButton("📄 Historial de Compras");
        btnHistorial.setBounds(140, 130, 220, 40);
        btnHistorial.addActionListener(e -> {
        	 new Historial().setVisible(true);
            
            System.out.println("Ver historial de compras");
        });
        add(btnHistorial);

        btnCerrarSesion = new JButton("🔒 Cerrar Sesión");
        btnCerrarSesion.setBounds(140, 190, 220, 40);
        btnCerrarSesion.addActionListener(e -> {
            Sesion.cerrarSesion();
            
            dispose();
        });
        add(btnCerrarSesion);

       
    }
}


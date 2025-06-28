package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import BLL.Usuario;
import BLL.Sesion;

public class MenuEmpleado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnGestionarMinerales, btnVerClientes, btnEditarCuenta, btnCerrarSesion;

    public MenuEmpleado() {
        setTitle("Menú de Empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        Usuario usuario = Sesion.getUsuarioActual();

        JLabel lblBienvenida = new JLabel("Hola, " + usuario.getNombre());
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        lblBienvenida.setBounds(20, 20, 300, 30);
        contentPane.add(lblBienvenida);

        btnGestionarMinerales = new JButton("Gestionar Minerales");
        btnGestionarMinerales.setBounds(100, 70, 200, 30);
        btnGestionarMinerales.addActionListener(e -> {
            new VerMineral().setVisible(true);
            dispose();
        });
        contentPane.add(btnGestionarMinerales);
   
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBounds(100, 200, 200, 30);
        btnCerrarSesion.addActionListener(e -> {
            Sesion.cerrarSesion();
            new MenuInicio().setVisible(true);
            dispose();
        });
        contentPane.add(btnCerrarSesion);
    }
}


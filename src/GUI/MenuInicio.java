package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BLL.Cliente;
import BLL.Empleado;
import BLL.Usuario;
import DLL.ControllerUsuario;
import BLL.Sesion;

public class MenuInicio extends JFrame {

    private JPanel contentPane;
    private JTextField inputMail;
    private JPasswordField inputPass;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuInicio frame = new MenuInicio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MenuInicio() {
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblTitulo = new JLabel("Inicio de Sesión");
        lblTitulo.setBounds(30, 20, 200, 20);
        contentPane.add(lblTitulo);

        JLabel lblMail = new JLabel("Mail:");
        lblMail.setBounds(30, 60, 80, 14);
        contentPane.add(lblMail);

        inputMail = new JTextField();
        inputMail.setBounds(30, 80, 250, 25);
        contentPane.add(inputMail);

        JLabel contrasenia = new JLabel("Contraseña:");
        contrasenia.setBounds(30, 120, 100, 14);
        contentPane.add(contrasenia);

        inputPass = new JPasswordField();
        inputPass.setBounds(30, 140, 250, 25);
        contentPane.add(inputPass);

        JButton Ingresar = new JButton("Ingresar");
        Ingresar.setBounds(30, 190, 120, 30);
        contentPane.add(Ingresar);
        
        JButton btnRegistro = new JButton("Registrarse");
        btnRegistro.setBounds(170, 190, 120, 30);
        contentPane.add(btnRegistro);
        btnRegistro.addActionListener(e -> {
            new Registro().setVisible(true);
            dispose();
        });

        Ingresar.addActionListener(e -> {
            String mail = inputMail.getText().trim();
            String contra = new String(inputPass.getPassword());

            ControllerUsuario<Usuario> controller = new ControllerUsuario<>();
            Usuario usuario = controller.login("", "", mail, contra, 0);

            if (usuario != null) {
                Sesion.iniciarSesion(usuario);
                
                if (usuario instanceof Cliente) {
                    new MenuCliente().setVisible(true);
                } else if (usuario instanceof Empleado) {
                    new MenuEmpleado().setVisible(true);
                }

                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Mail o contraseña incorrectos.");
            }
        });
    }
}


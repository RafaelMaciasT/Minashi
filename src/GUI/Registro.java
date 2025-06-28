package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BLL.Cliente;
import BLL.Empleado;
import BLL.Usuario;
import DLL.ControllerUsuario;

public class Registro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField inputNombre = new JTextField();
    private JTextField inputApellido = new JTextField();
    private JTextField inputMail = new JTextField();
    private JPasswordField inputPass = new JPasswordField();
    private JPasswordField inputConfirmPass = new JPasswordField();
    private JComboBox<String> comboTipo = new JComboBox<>(new String[] { "Cliente", "Empleado" });
    private JButton btnRegistrar = new JButton("Registrar");

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Registro frame = new Registro();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Registro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 478, 360);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnRegistrar.setBounds(166, 257, 120, 25);
        contentPane.add(btnRegistrar);

        inputNombre.setBounds(21, 46, 168, 20);
        contentPane.add(inputNombre);

        inputApellido.setBounds(212, 46, 168, 20);
        contentPane.add(inputApellido);

        inputMail.setBounds(21, 102, 168, 20);
        contentPane.add(inputMail);

        inputPass.setBounds(21, 158, 168, 20);
        contentPane.add(inputPass);

        inputConfirmPass.setBounds(212, 158, 168, 20);
        contentPane.add(inputConfirmPass);

        comboTipo.setBounds(212, 102, 168, 20);
        contentPane.add(comboTipo);
        
        JButton btnVolver = new JButton("Volver al inicio");
        btnVolver.setBounds(166, 290, 140, 25);
        btnVolver.addActionListener(e -> {
            dispose();
            new MenuInicio().setVisible(true);
        });
        contentPane.add(btnVolver);


        JLabel lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setBounds(80, 226, 300, 20);
        contentPane.add(lblError);

        contentPane.add(new JLabel("Nombre")).setBounds(21, 21, 46, 14);
        contentPane.add(new JLabel("Apellido")).setBounds(212, 21, 46, 14);
        contentPane.add(new JLabel("Mail")).setBounds(21, 77, 46, 14);
        contentPane.add(new JLabel("Tipo")).setBounds(212, 77, 100, 14);
        contentPane.add(new JLabel("Contraseña")).setBounds(21, 133, 77, 14);
        contentPane.add(new JLabel("Confirmar contraseña:")).setBounds(212, 133, 200, 14);

        btnRegistrar.addActionListener(e -> {
            lblError.setText(""); 

            String nombre = inputNombre.getText().trim();
            String apellido = inputApellido.getText().trim();
            String mail = inputMail.getText().trim();
            String pass = new String(inputPass.getPassword());
            String passConfirm = new String(inputConfirmPass.getPassword());
            String tipoSeleccionado = comboTipo.getSelectedItem().toString();
            int tipo = tipoSeleccionado.equals("Empleado") ? 2 : 1;

            if (nombre.isEmpty() || apellido.isEmpty() || mail.isEmpty() || pass.isEmpty() || passConfirm.isEmpty()) {
                lblError.setText("Todos los campos son obligatorios.");
                return;
            }

            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                lblError.setText("El nombre solo puede contener letras.");
                return;
            }

            if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                lblError.setText("El apellido solo puede contener letras.");
                return;
            }

            if (!mail.contains("@") || mail.length() < 5) {
                lblError.setText("El correo debe contener '@' y ser válido.");
                return;
            }

            if (!pass.matches("[a-zA-Z0-9]{4,}")) {
                lblError.setText("Contraseña: mínimo 4 caracteres, solo letras o números.");
                return;
            }

            if (!pass.equals(passConfirm)) {
                lblError.setText("Las contraseñas no coinciden.");
                return;
            }

            ControllerUsuario<Usuario> controller = new ControllerUsuario<>();
            if (controller.existeUsuario(mail)) {
                lblError.setText("Ya existe un usuario con ese correo.");
                return;
            }

            Usuario nuevo = (tipo == 2)
                ? new Empleado(0, nombre, apellido, mail, pass, tipo)
                : new Cliente(0, nombre, apellido, mail, pass, tipo);

            controller.agregarUsuario(nuevo);

            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
            dispose();
            new MenuInicio().setVisible(true);
        });
    }
}



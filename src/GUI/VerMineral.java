package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;
import BLL.Mineral;
import DLL.ControllerEmpleado;

public class VerMineral extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton btnAgregar, btnEditar, btnCerrar, btnEliminar, btnVolver;
    private JScrollPane scrollPane;

    public VerMineral() {
        setTitle("Gestión de Minerales");
        setSize(720, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        modelo = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Cantidad", "Unidad"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        tabla.setShowGrid(true);
        tabla.setGridColor(Color.LIGHT_GRAY);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(20, 20, 660, 240);
        add(scrollPane);

        btnAgregar = new JButton("Agregar Mineral");
        btnAgregar.setBounds(40, 290, 180, 30);
        btnAgregar.addActionListener(e -> agregarMineral());
        add(btnAgregar);

        btnEditar = new JButton("Editar Seleccionado");
        btnEditar.setBounds(250, 290, 180, 30);
        btnEditar.addActionListener(e -> editarSeleccionado());
        add(btnEditar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(40, 330, 120, 30);
        btnEliminar.addActionListener(e -> eliminarSeleccionado());
        add(btnEliminar);
        
        
        btnVolver = new JButton("Volver al menú");
        btnVolver.setBounds(560, 330, 130, 30);
        btnVolver.addActionListener(e -> {
            new MenuEmpleado().setVisible(true); 
            dispose();
        });
        add(btnVolver);


        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(470, 290, 160, 30);
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar);

        cargarDatos();
        tabla.removeColumn(tabla.getColumnModel().getColumn(0)); 
    }

    private void cargarDatos() {
        modelo.setRowCount(0);
        LinkedList<Mineral> lista = ControllerEmpleado.mostrarMineral();
        for (Mineral m : lista) {
            String unidad = (m.getPeso() == 1) ? "KG" : "TNS";
            modelo.addRow(new Object[]{
                m.getId(),
                m.getNombre(),
                m.getPrecio(),
                m.getCantidad(),
                unidad
            });
        }

        if (lista.isEmpty()) {
            modelo.addRow(new Object[]{"", "Sin registros", "", "", ""});
        }
    }

    private void agregarMineral() {
        JTextField txtNombre = new JTextField();
        JTextField txtPrecio = new JTextField();
        JTextField txtCantidad = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Precio:"));
        panel.add(txtPrecio);
        panel.add(new JLabel("Cantidad:"));
        panel.add(txtCantidad);

        int confirmar = JOptionPane.showConfirmDialog(this, panel, "Nuevo mineral", JOptionPane.OK_CANCEL_OPTION);
        if (confirmar != JOptionPane.OK_OPTION) return;

        String[] opciones = {"KG", "TNS"};
        int seleccion = JOptionPane.showOptionDialog(
                this, "Seleccioná unidad:", "Unidad de Peso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]
        );

        if (seleccion == -1) return;
        int idPeso = (seleccion == 0) ? 1 : 2;
        String unidad = opciones[seleccion];

        try {
            String nombre = txtNombre.getText().trim();
            String strPrecio = txtPrecio.getText().trim();
            String strCantidad = txtCantidad.getText().trim();

            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras.");
                return;
            }

            if (!strPrecio.matches("[0-9]+(\\.[0-9]+)?") || !strCantidad.matches("[0-9]+(\\.[0-9]+)?")) {
                JOptionPane.showMessageDialog(this, "Precio y cantidad deben ser números válidos.");
                return;
            }

            double precio = Double.parseDouble(strPrecio);
            double cantidad = Double.parseDouble(strCantidad);

            
            LinkedList<Mineral> lista = ControllerEmpleado.mostrarMineral();
            for (Mineral m : lista) {
                String unidadExistente = (m.getPeso() == 1) ? "KG" : "TNS";
                if (m.getNombre().equalsIgnoreCase(nombre) && unidadExistente.equals(unidad)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un mineral con ese nombre y unidad.");
                    return;
                }
            }

            Mineral nuevo = new Mineral(nombre, precio, cantidad, idPeso);
            ControllerEmpleado.añadirProducto(nuevo);
            cargarDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados.");
        }
    }

    private void editarSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccioná un mineral.");
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);
        String nombre = (String) modelo.getValueAt(fila, 1);
        double precio = (double) modelo.getValueAt(fila, 2);
        double cantidad = (double) modelo.getValueAt(fila, 3);
        String unidadActual = (String) modelo.getValueAt(fila, 4);

        JTextField txtNombre = new JTextField(nombre);
        JTextField txtPrecio = new JTextField(String.valueOf(precio));
        JTextField txtCantidad = new JTextField(String.valueOf(cantidad));

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Precio:"));
        panel.add(txtPrecio);
        panel.add(new JLabel("Cantidad:"));
        panel.add(txtCantidad);

        int confirmar = JOptionPane.showConfirmDialog(this, panel, "Editar mineral", JOptionPane.OK_CANCEL_OPTION);
        if (confirmar != JOptionPane.OK_OPTION) return;

        String[] opciones = {"KG", "TNS"};
        int seleccion = JOptionPane.showOptionDialog(
                this, "Unidad actual: " + unidadActual + "\nSeleccioná nueva unidad:",
                "Unidad", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, unidadActual);

        if (seleccion == -1) return;
        int idPeso = (seleccion == 0) ? 1 : 2;
        String nuevaUnidad = opciones[seleccion];

        try {
            String nuevoNombre = txtNombre.getText().trim();
            String strPrecio = txtPrecio.getText().trim();
            String strCantidad = txtCantidad.getText().trim();

            if (!nuevoNombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras.");
                return;
            }

            if (!strPrecio.matches("[0-9]+(\\.[0-9]+)?") || !strCantidad.matches("[0-9]+(\\.[0-9]+)?")) {
                JOptionPane.showMessageDialog(this, "Precio y cantidad deben ser números válidos.");
                return;
            }

            double nuevoPrecio = Double.parseDouble(strPrecio);
            double nuevaCantidad = Double.parseDouble(strCantidad);

           
            LinkedList<Mineral> lista = ControllerEmpleado.mostrarMineral();
            for (Mineral m : lista) {
                String unidadExistente = (m.getPeso() == 1) ? "KG" : "TNS";
                if (m.getId() != id && m.getNombre().equalsIgnoreCase(nuevoNombre) && unidadExistente.equals(nuevaUnidad)) {
                    JOptionPane.showMessageDialog(this, "Ya existe un mineral con ese nombre y unidad.");
                    return;
                }
            }

            Mineral actualizado = new Mineral(id, nuevoNombre, nuevoPrecio, nuevaCantidad, idPeso);
            ControllerEmpleado.editarProducto(actualizado);
            cargarDatos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el mineral.");
        }
    }

    private void eliminarSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccioná un mineral para eliminar.");
            return;
        }

        int id = (int) modelo.getValueAt(fila, 0);
        String nombre = (String) modelo.getValueAt(fila, 1);

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que querés eliminar \"" + nombre + "\"?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Mineral m = new Mineral(id, "", 0, 0, 0);
            ControllerEmpleado.eliminarProducto(m);
            cargarDatos();
        }
        
    }

}


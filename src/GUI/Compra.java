package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

import BLL.Mineral;
import BLL.CompraRealizada;
import DLL.ControllerEmpleado;

public class Compra extends JFrame {

    private JComboBox<Mineral> comboMinerales;
    private JTextField txtCantidad;
    private JButton btnComprar, btnVolver;
    private JTextArea areaResumen;
    private double totalGeneral = 0.0;

    
    public static LinkedList<CompraRealizada> historialCompras = new LinkedList<>();

    public Compra() {
        setTitle("Realizar Compra");
        setSize(540, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblMineral = new JLabel("🧱 Mineral:");
        lblMineral.setBounds(30, 30, 100, 25);
        add(lblMineral);

        comboMinerales = new JComboBox<>();
        comboMinerales.setBounds(140, 30, 340, 25);
        add(comboMinerales);

        JLabel lblCantidad = new JLabel("📦 Cantidad:");
        lblCantidad.setBounds(30, 70, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(140, 70, 100, 25);
        add(txtCantidad);

        btnComprar = new JButton("✅ Comprar");
        btnComprar.setBounds(270, 70, 120, 30);
        btnComprar.addActionListener(e -> realizarCompra());
        add(btnComprar);

        areaResumen = new JTextArea();
        areaResumen.setEditable(false);
        JScrollPane scrollResumen = new JScrollPane(areaResumen);
        scrollResumen.setBounds(30, 130, 450, 200);
        add(scrollResumen);

        btnVolver = new JButton("⬅️ Volver");
        btnVolver.setBounds(30, 340, 100, 30);
        btnVolver.addActionListener(e -> dispose());
        add(btnVolver);

        cargarMinerales();
    }

    private void cargarMinerales() {
        comboMinerales.removeAllItems();
        LinkedList<Mineral> minerales = ControllerEmpleado.mostrarMineral();
        for (Mineral m : minerales) {
            comboMinerales.addItem(m);
        }
    }

    private void realizarCompra() {
        try {
            Mineral mineral = (Mineral) comboMinerales.getSelectedItem();
            double cantidad = Double.parseDouble(txtCantidad.getText().trim());

            if (mineral == null || cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "Seleccioná un mineral válido y una cantidad mayor a 0.");
                return;
            }

            double subtotal = cantidad * mineral.getPrecio();
            totalGeneral += subtotal;

            String unidad = mineral.getUnidadPeso(); // "KG" o "TNS"
            CompraRealizada compra = new CompraRealizada(mineral.getNombre(), cantidad, unidad, subtotal);
            historialCompras.add(compra);

            String resumen = "🛒 " + compra + " | $" + String.format("%.2f", subtotal);
            areaResumen.append(resumen + "\n");
            areaResumen.append("💰 Total acumulado: $" + String.format("%.2f", totalGeneral) + "\n\n");

            txtCantidad.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresá una cantidad válida.");
        }
    }

}

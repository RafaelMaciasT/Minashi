package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;
import BLL.CompraRealizada;
import GUI.Compra;

public class Historial extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTotal;
    private JButton btnCerrar;

    public Historial() {
        setTitle("Historial de Compras");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Mineral");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Unidad");
        modelo.addColumn("Subtotal ($)");

        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(30, 30, 520, 220);
        add(scroll);

        lblTotal = new JLabel("Total Facturado: $0.00");
        lblTotal.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTotal.setBounds(30, 270, 300, 25);
        add(lblTotal);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(460, 310, 90, 30);
        btnCerrar.addActionListener(e -> dispose());
        add(btnCerrar);

        cargarHistorial();
    }

    private void cargarHistorial() {
        LinkedList<CompraRealizada> historial = Compra.historialCompras;
        double total = 0.0;

        modelo.setRowCount(0);

        for (CompraRealizada c : historial) {
            double subtotal = c.getCantidad() * c.getPrecioUnitario();
            total += subtotal;

            Object[] fila = {
                c.getNombreMineral(),
                c.getCantidad(),
                c.getUnidad(),
                String.format("%.2f", subtotal)
            };
            modelo.addRow(fila);
        }

        lblTotal.setText("Total Facturado: $" + String.format("%.2f", total));
    }
}


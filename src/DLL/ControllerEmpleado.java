package DLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import BLL.Mineral;
import BLL.Usuario;

public class ControllerEmpleado<T extends Usuario> {
    private static Connection con = Conexion.getInstance().getConnection();

    public static LinkedList<Mineral> mostrarMineral() {
        LinkedList<Mineral> listaMin = new LinkedList<>();
        try {
            PreparedStatement state = (PreparedStatement) con.prepareStatement(
                "SELECT * FROM mineral"
            );

            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_mineral");
                String nombre = rs.getString("nombre");
                int peso = rs.getInt("id_peso");
                double precio = rs.getDouble("precio");
                double cantidad = rs.getDouble("cantidad");

                listaMin.add(new Mineral(id, nombre, precio, cantidad, peso));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMin;
    }

    public static void añadirProducto(Mineral mineral) {
        try {
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(
                "INSERT INTO mineral (nombre, id_peso, precio, cantidad) VALUES (?, ?, ?, ?)"
            );
            statement.setString(1, mineral.getNombre());
            statement.setInt(2, mineral.getPeso());
            statement.setDouble(3, mineral.getPrecio());
            statement.setDouble(4, mineral.getCantidad());

            int filas = statement.executeUpdate();
            if (filas > 0) {
                System.out.println("Producto añadido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarProducto(Mineral mineral) {
        try {
            PreparedStatement state = (PreparedStatement) con.prepareStatement(
                "UPDATE mineral SET nombre = ?, id_peso = ?, precio = ?, cantidad = ? WHERE id_mineral = ?"
            );
            state.setString(1, mineral.getNombre());
            state.setInt(2, mineral.getPeso());
            state.setDouble(3, mineral.getPrecio());
            state.setDouble(4, mineral.getCantidad());
            state.setInt(5, mineral.getId());

            int edits = state.executeUpdate();
            if (edits > 0) {
                JOptionPane.showMessageDialog(null, "Mineral modificado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarProducto(Mineral mineral) {
        try {
            PreparedStatement state = (PreparedStatement) con.prepareStatement(
                "DELETE FROM mineral WHERE id_mineral = ?"
            );
            state.setInt(1, mineral.getId());

            int fila = state.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Mineral eliminado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean existeMineral(String nombre, int peso) {
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(
                "SELECT COUNT(*) FROM mineral WHERE nombre = ? AND id_peso = ?"
            );
            ps.setString(1, nombre);
            ps.setInt(2, peso);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


package DLL;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BLL.Cliente;
import BLL.Empleado;
import BLL.Usuario;
import BLL.Encriptador;
import repository.UsuarioRepository;

public class ControllerUsuario<T extends Usuario> implements UsuarioRepository {

    private static Connection con = Conexion.getInstance().getConnection();

    @Override
    public T login(String nombre, String apellido, String mail, String contra, int tipo) {
        T usuario = null;

        try {
            String hash = Encriptador.encriptarSHA256(contra);

            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(
                "SELECT * FROM usuario WHERE mail = ? AND contra = ?"
            );
            stmt.setString(1, mail);
            stmt.setString(2, hash);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombreDB = rs.getString("nombre");
                String apellidoDB = rs.getString("apellido");
                int tipoUsuario = rs.getInt("id_tipo");

                switch (tipoUsuario) {
                    case 2:
                        usuario = (T) new Empleado(id, nombreDB, apellidoDB, mail, contra, tipoUsuario);
                        break;
                    case 1:
                        usuario = (T) new Cliente(id, nombreDB, apellidoDB, mail, contra, tipoUsuario);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(
                "INSERT INTO usuario (nombre, apellido, mail, contra, id_tipo) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getMail());
            ps.setString(4, Encriptador.encriptarSHA256(usuario.getContraseña()));
            ps.setInt(5, usuario.getTipo());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> mostrarUsuario() {
        List<Usuario> Listauser = new LinkedList<>();
        try {
            PreparedStatement state = (PreparedStatement) con.prepareStatement(
                "SELECT * FROM usuario WHERE id_usuario=?"
            );
            state.setInt(1, 1); // 
            ResultSet rs = state.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String contra = rs.getString(5);
                int tipo = rs.getInt(6);

                Listauser.add(new Usuario(id, nombre, apellido, mail, contra, tipo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Listauser;
    }

    public boolean existeUsuario(String mail) {
        try {
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(
                "SELECT id_usuario FROM usuario WHERE mail = ?"
            );
            stmt.setString(1, mail);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}


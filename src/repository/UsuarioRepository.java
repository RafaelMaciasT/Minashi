package repository;

import java.util.List;

import BLL.Usuario;

public interface UsuarioRepository {

	void agregarUsuario(Usuario usuario);
	
	List<Usuario>mostrarUsuario();
		<T> T login(String nombre, String apellido, String mail, String contra, int tipo);
	
}

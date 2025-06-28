package BLL;

import BLL.Usuario;

public class Sesion {
    private static Usuario usuarioActual;

    public static void iniciarSesion(Usuario u) {
        usuarioActual = u;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }
}


package co.patronesgof.fis.repositories;

import java.util.ArrayList;
import java.util.List;

import co.patronesgof.fis.models.Usuario;

public class UsuarioRepository {

    // Lista para simular una base de datos de usuarios
    private List<Usuario> usuarios;

    // Constructor
    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
    }

    // Método para agregar un usuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado: " + usuario);
    }

    // Método para obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    // Método para buscar un usuario por su índice (esto es solo un ejemplo simple)
    public Usuario obtenerUsuarioPorIndice(int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            return usuarios.get(indice);
        } else {
            System.out.println("Índice de usuario no válido.");
            return null;
        }
    }

    // Método para eliminar un usuario por su índice
    public void eliminarUsuarioPorIndice(int indice) {
        if (indice >= 0 && indice < usuarios.size()) {
            Usuario usuarioEliminado = usuarios.remove(indice);
            System.out.println("Usuario eliminado: " + usuarioEliminado);
        } else {
            System.out.println("Índice no válido.");
        }
    }
}

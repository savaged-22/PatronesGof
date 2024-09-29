package co.patronesgof.fis.models;

import java.util.ArrayList;
import java.util.List;

public class Estacion {
    private String nombre;
    private String estado;
    private List<Usuario> usuarios;

    public Estacion(String nombre) {
        this.nombre = nombre;
        this.usuarios = new ArrayList<>();
    }

    public void suscribir(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario " + usuario + " suscrito a " + nombre);
    }

    public void desuscribir(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("Usuario " + usuario + " desuscrito de " + nombre);
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarUsuarios();
    }

    private void notificarUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.actualizar("La estación " + nombre + " ha cambiado a estado: " + estado);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }
}

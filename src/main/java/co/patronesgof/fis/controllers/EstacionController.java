package co.patronesgof.fis.controllers;

import co.patronesgof.fis.models.Estacion;
import co.patronesgof.fis.models.Usuario;

public class EstacionController {
    private Estacion estacion;

    public EstacionController(String nombre) {
        this.estacion = new Estacion(nombre);
    }

    public void suscribirUsuario(Usuario usuario) {
        estacion.suscribir(usuario);
    }

    public void desuscribirUsuario(Usuario usuario) {
        estacion.desuscribir(usuario);
    }

    public void cambiarEstado(String estado) {
        estacion.setEstado(estado);
    }

    public Estacion getEstacion() {
        return estacion;
    }
}

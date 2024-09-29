package co.patronesgof.fis.controllers;

import co.patronesgof.fis.models.Usuario;
import co.patronesgof.fis.models.UsuarioInterface;
import co.patronesgof.fis.services.interfaces.ValidadorVisitorInterfaceService;

public class UsuarioController {
    private Usuario usuario;

    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    public void recibirNotificacion(String mensaje) {
        usuario.actualizar(mensaje);
    }

    public void validarUsuario(ValidadorVisitorInterfaceService validador) {
        if (usuario instanceof UsuarioInterface) {
            ((UsuarioInterface) usuario).aceptar(validador);
        } else {
            System.out.println("El usuario no puede ser validado.");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

package co.patronesgof.fis.models;

import co.patronesgof.fis.services.interfaces.ValidadorVisitorInterfaceService;

public class UsuarioRegular implements Usuario, UsuarioInterface {
    private String nombre;

    public UsuarioRegular(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Usuario Regular " + nombre + " recibe actualización: " + mensaje);
    }

    @Override
    public void aceptar(ValidadorVisitorInterfaceService visitor) {
        visitor.visitar(this);  // Este método invoca la lógica para validar a una persona mayor
    }


    @Override
    public String toString() {
        return "UsuarioRegular{" + "nombre='" + nombre + '\'' + '}';
    }
}

package co.patronesgof.fis.models;

import co.patronesgof.fis.services.interfaces.ValidadorVisitorInterfaceService;

public class PersonaMayor implements Usuario, UsuarioInterface {
    private String nombre;

    public PersonaMayor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Persona Mayor " + nombre + " recibe actualización: " + mensaje);
    }

    // Implementación del método aceptar del patrón Visitor
    @Override
    public void aceptar(ValidadorVisitorInterfaceService visitor) {
        visitor.visitar(this);  // Este método invoca la lógica para validar a una persona mayor
    }

    @Override
    public String toString() {
        return "PersonaMayor{" + "nombre='" + nombre + '\'' + '}';
    }
}

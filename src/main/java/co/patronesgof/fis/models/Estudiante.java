package co.patronesgof.fis.models;

import co.patronesgof.fis.services.interfaces.ValidadorVisitorInterfaceService;

public class Estudiante implements Usuario, UsuarioInterface {
    private String nombre;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println("Estudiante " + nombre + " recibe actualización: " + mensaje);
    }

    // Implementación del método aceptar del patrón Visitor
    @Override
    public void aceptar(ValidadorVisitorInterfaceService visitor) {
        visitor.visitar(this);  // Este método invoca la lógica para validar a un estudiante
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre='" + nombre + '\'' + '}';
    }
}

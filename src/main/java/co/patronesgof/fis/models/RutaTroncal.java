package co.patronesgof.fis.models;

public class RutaTroncal extends Ruta {

    public RutaTroncal(String codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Ruta Troncal - Código: " + codigo + ", Nombre: " + nombre);
    }
}

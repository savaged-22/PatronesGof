package co.patronesgof.fis.models;

public class RutaLocal extends Ruta {

    public RutaLocal(String codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Ruta Local - Código: " + codigo + ", Nombre: " + nombre);
    }
}

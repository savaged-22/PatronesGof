package co.patronesgof.fis.models;

public class BusBiarticulado extends Bus {

    public BusBiarticulado(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Bus Biarticulado - ID: " + id + ", Capacidad: " + capacidad);
    }
}

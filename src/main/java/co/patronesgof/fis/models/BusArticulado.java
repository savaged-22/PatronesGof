package co.patronesgof.fis.models;

public class BusArticulado extends Bus {

    public BusArticulado(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Bus Articulado - ID: " + id + ", Capacidad: " + capacidad);
    }
}

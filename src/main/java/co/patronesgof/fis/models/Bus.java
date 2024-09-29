package co.patronesgof.fis.models;

public abstract class Bus {
    protected String id;
    protected int capacidad;

    public Bus(String id, int capacidad) {
        this.id = id;
        this.capacidad = capacidad;
    }

    public abstract void mostrarInfo();

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}

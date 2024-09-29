package co.patronesgof.fis.repositories;

import java.util.ArrayList;
import java.util.List;

import co.patronesgof.fis.models.Bus;

public class BusRepository {

    // Lista para simular una base de datos de buses
    private List<Bus> buses;

    // Constructor
    public BusRepository() {
        this.buses = new ArrayList<>();
    }

    // Método para agregar un bus
    public void agregarBus(Bus bus) {
        buses.add(bus);
        System.out.println("Bus agregado: " + bus.getId());
    }

    // Método para obtener todos los buses
    public List<Bus> obtenerBuses() {
        return buses;
    }

    // Método para buscar un bus por su ID
    public Bus obtenerBusPorId(String id) {
        for (Bus bus : buses) {
            if (bus.getId().equals(id)) {
                return bus;
            }
        }
        System.out.println("Bus con ID " + id + " no encontrado.");
        return null;
    }

    // Método para eliminar un bus por su ID
    public void eliminarBusPorId(String id) {
        Bus busAEliminar = null;
        for (Bus bus : buses) {
            if (bus.getId().equals(id)) {
                busAEliminar = bus;
                break;
            }
        }

        if (busAEliminar != null) {
            buses.remove(busAEliminar);
            System.out.println("Bus eliminado: " + id);
        } else {
            System.out.println("Bus con ID " + id + " no encontrado.");
        }
    }
}

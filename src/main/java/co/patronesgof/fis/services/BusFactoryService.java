package co.patronesgof.fis.services;

import co.patronesgof.fis.models.Bus;
import co.patronesgof.fis.models.BusArticulado;
import co.patronesgof.fis.models.BusBiarticulado;

public class BusFactoryService {

    public Bus crearBus(String tipo, String id, int capacidad) {
        switch (tipo.toLowerCase()) {
            case "articulado":
                return new BusArticulado(id, capacidad);
            case "biarticulado":
                return new BusBiarticulado(id, capacidad);
            default:
                throw new IllegalArgumentException("Tipo de bus desconocido: " + tipo);
        }
    }
}

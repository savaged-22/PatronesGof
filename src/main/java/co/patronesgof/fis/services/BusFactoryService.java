package co.patronesgof.fis.services;

import org.springframework.stereotype.Service;

import co.patronesgof.fis.models.Bus;
import co.patronesgof.fis.models.BusArticulado;
import co.patronesgof.fis.models.BusBiarticulado;

@Service
public class BusFactoryService {

    public Bus createBus(String tipoBus) {
        if (tipoBus.equalsIgnoreCase("Articulado")) {
            return new BusArticulado();
        } else if (tipoBus.equalsIgnoreCase("Biarticulado")) {
            return new BusBiarticulado();
        } else {
            throw new IllegalArgumentException("Tipo de bus no válido");
        }
    }
}

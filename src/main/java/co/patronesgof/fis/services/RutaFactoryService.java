package co.patronesgof.fis.services;

import org.springframework.stereotype.Service;

import co.patronesgof.fis.models.Ruta;
import co.patronesgof.fis.models.RutaLocal;
import co.patronesgof.fis.models.RutaTroncal;

@Service
public class RutaFactoryService {

    public Ruta createRuta(String tipoRuta) {
        if (tipoRuta.equalsIgnoreCase("Local")) {
            return new RutaLocal();
        } else if (tipoRuta.equalsIgnoreCase("Troncal")) {
            return new RutaTroncal();
        } else {
            throw new IllegalArgumentException("Tipo de ruta no válido");
        }
    }
}

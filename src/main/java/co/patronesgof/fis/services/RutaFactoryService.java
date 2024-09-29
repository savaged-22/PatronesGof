package co.patronesgof.fis.services;

import co.patronesgof.fis.models.Ruta;
import co.patronesgof.fis.models.RutaLocal;
import co.patronesgof.fis.models.RutaTroncal;

public class RutaFactoryService {

    public Ruta crearRuta(String tipo, String codigo, String nombre) {
        switch (tipo.toLowerCase()) {
            case "local":
                return new RutaLocal(codigo, nombre);
            case "troncal":
                return new RutaTroncal(codigo, nombre);
            default:
                throw new IllegalArgumentException("Tipo de ruta desconocido: " + tipo);
        }
    }
}

package co.patronesgof.fis.models;

import jakarta.persistence.Entity;

@Entity
public class RutaLocal extends Ruta {

    public RutaLocal() {
        super.setTipoRuta("Local");
    }
}

package co.patronesgof.fis.models;

import jakarta.persistence.Entity;

@Entity
public class RutaTroncal extends Ruta {

    public RutaTroncal() {
        super.setTipoRuta("Troncal");
    }
}

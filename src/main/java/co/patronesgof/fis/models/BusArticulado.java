package co.patronesgof.fis.models;

import jakarta.persistence.Entity;

@Entity
public class BusArticulado extends Bus {
    
    public BusArticulado() {
        super.setTipoBus("Articulado");
    }
}

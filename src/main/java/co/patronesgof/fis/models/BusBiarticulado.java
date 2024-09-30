package co.patronesgof.fis.models;

import jakarta.persistence.Entity;

@Entity
public class BusBiarticulado extends Bus {
    
    public BusBiarticulado() {
        super.setTipoBus("Biarticulado");
    }
}

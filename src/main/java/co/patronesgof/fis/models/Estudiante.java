package co.patronesgof.fis.models;

import jakarta.persistence.Entity;

@Entity
public class Estudiante extends Usuario {
    
    public Estudiante() {
        super.setTipoUsuario("Estudiante");
    }
}

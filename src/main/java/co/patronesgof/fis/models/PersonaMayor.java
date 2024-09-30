package co.patronesgof.fis.models;

import jakarta.persistence.Entity;

@Entity
public class PersonaMayor extends Usuario {
    
    public PersonaMayor() {
        super.setTipoUsuario("PersonaMayor");
    }
}

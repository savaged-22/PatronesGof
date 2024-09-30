package co.patronesgof.fis.models;

import jakarta.persistence.Entity;

@Entity
public class UsuarioRegular extends Usuario {
    
    public UsuarioRegular() {
        super.setTipoUsuario("Regular");
    }
}

package co.patronesgof.fis.services.interfaces;

import co.patronesgof.fis.models.Estudiante;
import co.patronesgof.fis.models.PersonaMayor;
import co.patronesgof.fis.models.UsuarioRegular;

public interface ValidadorVisitorInterfaceService {
    void visitar(UsuarioRegular usuario);
    void visitar(Estudiante usuario);
    void visitar(PersonaMayor usuario);
}

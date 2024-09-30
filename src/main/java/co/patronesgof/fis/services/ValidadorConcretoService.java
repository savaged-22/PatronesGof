package co.patronesgof.fis.services;

import org.springframework.stereotype.Service;

import co.patronesgof.fis.models.Estudiante;
import co.patronesgof.fis.models.PersonaMayor;
import co.patronesgof.fis.models.UsuarioRegular;
import co.patronesgof.fis.services.interfaces.ValidadorVisitorInterfaceService;

@Service
public class ValidadorConcretoService implements ValidadorVisitorInterfaceService {

    @Override
    public void visitar(Estudiante estudiante) {
        System.out.println("Validando estudiante con tarifa especial");
    }

    @Override
    public void visitar(PersonaMayor personaMayor) {
        System.out.println("Validando persona mayor con tarifa reducida");
    }

    @Override
    public void visitar(UsuarioRegular usuarioRegular) {
        System.out.println("Validando usuario regular con tarifa estándar");
    }
}

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
        // Lógica de validación para estudiante
        System.out.println("Validando estudiante con tarifa especial");
    }

    @Override
    public void visitar(PersonaMayor personaMayor) {
        // Lógica de validación para persona mayor
        System.out.println("Validando persona mayor con tarifa reducida");
    }

    @Override
    public void visitar(UsuarioRegular usuarioRegular) {
        // Lógica de validación para usuario regular
        System.out.println("Validando usuario regular con tarifa estándar");
    }
}

package co.patronesgof.fis.services;

import co.patronesgof.fis.models.Estudiante;
import co.patronesgof.fis.models.PersonaMayor;
import co.patronesgof.fis.models.UsuarioRegular;
import co.patronesgof.fis.services.interfaces.ValidadorVisitorInterfaceService;

public class ValidadorConcretoService implements ValidadorVisitorInterfaceService {

    @Override
    public void visitar(UsuarioRegular usuario) {
        System.out.println("Validando Usuario Regular: Tarifa estándar aplicada.");
    }

    @Override
    public void visitar(Estudiante usuario) {
        System.out.println("Validando Estudiante: Tarifa reducida para estudiantes aplicada.");
    }

    @Override
    public void visitar(PersonaMayor usuario) {
        System.out.println("Validando Persona Mayor: Tarifa reducida para personas mayores aplicada.");
    }
}

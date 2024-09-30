package co.patronesgof.fis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.patronesgof.fis.models.Estacion;
import co.patronesgof.fis.repositories.EstacionRepository;

@Service
public class EstacionService {

    @Autowired
    private EstacionRepository estacionRepository;

    public List<Estacion> findAll() {
        return estacionRepository.findAll();
    }

    public Optional<Estacion> findById(Long id) {
        return estacionRepository.findById(id);
    }

    public Estacion save(Estacion estacion) {
        return estacionRepository.save(estacion);
    }

    public void deleteById(Long id) {
        estacionRepository.deleteById(id);
    }
}

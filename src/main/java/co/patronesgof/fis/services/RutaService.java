package co.patronesgof.fis.services;

import co.patronesgof.fis.models.Ruta;
import co.patronesgof.fis.repositories.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> findAll() {
        return rutaRepository.findAll();
    }

    public Optional<Ruta> findById(Long id) {
        return rutaRepository.findById(id);
    }

    public Ruta save(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public void deleteById(Long id) {
        rutaRepository.deleteById(id);
    }
}

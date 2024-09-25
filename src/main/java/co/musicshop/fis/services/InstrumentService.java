package co.musicshop.fis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.musicshop.fis.models.Instrument;
import co.musicshop.fis.repositories.InstrumentRepository; // Asegúrate de que este repositorio existe.
import co.musicshop.fis.services.interfaces.InstrumentServiceInterface;

@Service
public class InstrumentService implements InstrumentServiceInterface {

    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public List<Instrument> findAll() {
        return instrumentRepository.findAll();
    }

    @Override
    public Optional<Instrument> findById(Long id) {
        return instrumentRepository.findById(id);
    }

    @Override
    public Instrument save(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @Override
    public void deleteById(Long id) {
        instrumentRepository.deleteById(id);
    }
}

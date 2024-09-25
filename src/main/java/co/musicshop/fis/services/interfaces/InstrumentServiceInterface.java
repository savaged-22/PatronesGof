package co.musicshop.fis.services.interfaces;

import java.util.List;
import java.util.Optional;
import co.musicshop.fis.models.Instrument;

public interface InstrumentServiceInterface {
    List<Instrument> findAll();
    Optional<Instrument> findById(Long id);
    Instrument save(Instrument instrument);
    void deleteById(Long id);
}

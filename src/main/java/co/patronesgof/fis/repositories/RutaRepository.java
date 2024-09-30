package co.patronesgof.fis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.patronesgof.fis.models.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
}

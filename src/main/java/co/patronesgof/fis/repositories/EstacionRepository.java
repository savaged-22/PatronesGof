package co.patronesgof.fis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.patronesgof.fis.models.Estacion;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion, Long> {
}

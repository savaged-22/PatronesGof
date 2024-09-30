package co.patronesgof.fis.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.patronesgof.fis.dtos.CreateEstacionDto;
import co.patronesgof.fis.models.Estacion;
import co.patronesgof.fis.services.EstacionService;

@RestController
@RequestMapping("/api/estaciones")
public class EstacionController {

    @Autowired
    private EstacionService estacionService;

    @GetMapping
    public List<Estacion> getAllEstaciones() {
        return estacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estacion> getEstacionById(@PathVariable Long id) {
        Optional<Estacion> estacion = estacionService.findById(id);
        return estacion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estacion createEstacion(@RequestBody CreateEstacionDto createEstacionDto) {
        Estacion estacion = new Estacion();
        estacion.setNombre(createEstacionDto.getNombre());
        estacion.setEstado(createEstacionDto.getEstado());
        return estacionService.save(estacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estacion> updateEstacion(@PathVariable Long id, @RequestBody CreateEstacionDto estacionDetails) {
        Optional<Estacion> estacionOptional = estacionService.findById(id);
        if (estacionOptional.isPresent()) {
            Estacion estacion = estacionOptional.get();
            estacion.setNombre(estacionDetails.getNombre());
            estacion.setEstado(estacionDetails.getEstado());
            Estacion updatedEstacion = estacionService.save(estacion);
            return ResponseEntity.ok(updatedEstacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstacion(@PathVariable Long id) {
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

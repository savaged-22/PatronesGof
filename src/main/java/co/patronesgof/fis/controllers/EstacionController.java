package co.patronesgof.fis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.patronesgof.fis.dtos.CreateEstacionDto;
import co.patronesgof.fis.models.Estacion;
import co.patronesgof.fis.services.EstacionService;

@Controller
@RequestMapping("/estaciones")
public class EstacionController {

    @Autowired
    private EstacionService estacionService;

    // Mostrar la lista de estaciones
    @GetMapping
    public String listEstaciones(Model model) {
        model.addAttribute("estaciones", estacionService.findAll());
        return "estaciones-list";  // Apunta a estaciones-list.html
    }

    // Mostrar el formulario de creación de estaciones
    @GetMapping("/nuevo")
    public String showEstacionForm(Model model) {
        model.addAttribute("createEstacionDto", new CreateEstacionDto());
        return "estaciones";  // Apunta a estaciones.html
    }

    // Crear una nueva estación
    @PostMapping
    public String createEstacion(@ModelAttribute CreateEstacionDto createEstacionDto) {
        Estacion estacion = new Estacion();
        estacion.setNombre(createEstacionDto.getNombre());
        estacion.setEstado(createEstacionDto.getEstado());
        estacionService.save(estacion);
        return "redirect:/estaciones";
    }

    // Eliminar una estación
    @PostMapping("/{id}/eliminar")
    public String deleteEstacion(@PathVariable Long id) {
        estacionService.deleteById(id);
        return "redirect:/estaciones";
    }
}

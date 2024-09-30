package co.patronesgof.fis.controllers;

import co.patronesgof.fis.dtos.CreateRutaDto;
import co.patronesgof.fis.models.Ruta;
import co.patronesgof.fis.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RutaController {

    @Autowired
    private RutaService rutaService;

    // Muestra el formulario de creación de rutas
    @GetMapping("/routes")
    public String showRouteForm(Model model) {
        model.addAttribute("createRouteDto", new CreateRutaDto());
        model.addAttribute("routes", rutaService.findAll()); // Agregamos la lista de rutas existentes
        return "ruta-form";
    }

    // Crea una nueva ruta a partir de los datos enviados por el formulario
    @PostMapping("/routes")
    public String createRoute(@ModelAttribute CreateRutaDto createRouteDto) {
        Ruta ruta = new Ruta();
        ruta.setCodigo(createRouteDto.getCodigo());
        ruta.setNombre(createRouteDto.getNombre());
        ruta.setTipoRuta(createRouteDto.getTipoRuta());
        rutaService.save(ruta); // Guarda la nueva ruta
        return "redirect:/routes"; // Redirige a la página con la lista de rutas
    }
}

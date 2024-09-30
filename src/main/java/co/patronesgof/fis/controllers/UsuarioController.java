package co.patronesgof.fis.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.patronesgof.fis.dtos.CreateUsuarioDto;
import co.patronesgof.fis.models.Usuario;
import co.patronesgof.fis.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Mostrar la lista de usuarios
    @GetMapping
    public String listUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuarios-list";  // Apunta a usuarios-list.html
    }

    // Mostrar el formulario para crear un nuevo usuario
    @GetMapping("/nuevo")
    public String showUsuarioForm(Model model) {
        model.addAttribute("createUsuarioDto", new CreateUsuarioDto());
        return "usuarios";  // Apunta a usuarios.html
    }

    // Crear un nuevo usuario
    @PostMapping
    public String createUsuario(@ModelAttribute CreateUsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setTipoUsuario(usuarioDto.getTipoUsuario());
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    // Editar un usuario existente
    @GetMapping("/{id}/editar")
    public String editUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("createUsuarioDto", usuario.get());
            return "usuarios";  // Usamos la misma vista para editar
        } else {
            return "404";  // O una página personalizada de error
        }
    }

    // Eliminar un usuario
    @PostMapping("/{id}/eliminar")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }
}

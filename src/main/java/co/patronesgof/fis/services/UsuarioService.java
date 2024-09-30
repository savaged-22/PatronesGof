package co.patronesgof.fis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.patronesgof.fis.dtos.CreateUsuarioDto;
import co.patronesgof.fis.models.Usuario;
import co.patronesgof.fis.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Sobrecargar el método save para aceptar un Usuario completo
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

     // Cambiar la lógica de guardar un Usuario usando CreateUsuarioDto
     public Usuario save(CreateUsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setTipoUsuario(usuarioDto.getTipoUsuario());
        return usuarioRepository.save(usuario);
    }
}

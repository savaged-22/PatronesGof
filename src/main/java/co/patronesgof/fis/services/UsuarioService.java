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

    public Usuario save(CreateUsuarioDto createUsuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(createUsuarioDto.getNombre());
        usuario.setTipoUsuario(createUsuarioDto.getTipoUsuario());
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}

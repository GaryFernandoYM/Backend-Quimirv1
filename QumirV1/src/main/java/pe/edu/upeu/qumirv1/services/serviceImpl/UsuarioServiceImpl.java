package pe.edu.upeu.qumirv1.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upeu.qumirv1.dtos.UsuarioDto;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.repositories.UsuarioRepository;
import pe.edu.upeu.qumirv1.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario register(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setFullName(usuarioDto.getFullName());
        usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario login(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioDto.getEmail()).orElse(null);
        if (usuario != null && passwordEncoder.matches(usuarioDto.getPassword(), usuario.getPassword())) {
            return usuario;
        }
        return null;
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return null;
    }
}

package pe.edu.upeu.qumirv1.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.repositories.UsuarioRepository;
import pe.edu.upeu.qumirv1.services.UsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            // Codificar la contraseña antes de guardarla
            String hashedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(hashedPassword);
            return usuarioRepo.save(usuario);
        } catch (Exception e) {
            throw new AppException("Error al guardar el usuario: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Usuario> findAll() {
        try {
            return usuarioRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error al obtener todos los usuarios: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Usuario usuario = usuarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));

        usuarioRepo.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> optionalUsuario = usuarioRepo.findById(id);
        return optionalUsuario.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
    }

    @Override
    public Usuario update(Usuario usuario, Long id) {
        Usuario usuarioExistente = usuarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        usuarioExistente.setCorreo(usuario.getCorreo());
        // No actualizar la contraseña aquí para evitar su re-hashing

        return usuarioRepo.save(usuarioExistente);
    }
}

package pe.edu.upeu.qumirv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.services.serviceImpl.UsuarioServiceImpl;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    default Usuario findByCorreoAndPassword(UsuarioServiceImpl usuarioServiceImpl, String correo, String password) {
        Optional<Usuario> optionalUsuario = findByCorreo(correo);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuarioServiceImpl.passwordEncoder.matches(password, usuario.getPassword())) {
                return usuario;
            }
        }
        return null;
    }
}


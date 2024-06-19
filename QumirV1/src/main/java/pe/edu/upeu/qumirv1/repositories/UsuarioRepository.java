package pe.edu.upeu.qumirv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.qumirv1.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}

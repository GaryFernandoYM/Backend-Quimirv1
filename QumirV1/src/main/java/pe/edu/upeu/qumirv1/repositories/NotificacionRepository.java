package pe.edu.upeu.qumirv1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.qumirv1.models.Notificacion;
import pe.edu.upeu.qumirv1.models.Usuario;

public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    List<Usuario> findByUsuarioId(Integer idUsuario);

}

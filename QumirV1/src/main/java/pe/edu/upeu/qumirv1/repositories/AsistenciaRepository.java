package pe.edu.upeu.qumirv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import pe.edu.upeu.qumirv1.models.Asistencia;
import pe.edu.upeu.qumirv1.models.Usuario;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    List<Usuario> findByUsuarioId(Integer idUsuario);

}

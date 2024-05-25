package pe.edu.upeu.qumirv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.models.Reclamacion;

import java.util.Optional;

/**
 * Repository interface for NoticiaAmbiental entity.
 * Provides CRUD operations and custom query methods.
 *
 * Author: Fernando
 */
@Repository
public interface ReclamacionRepository extends JpaRepository<Reclamacion, Long> {

    Optional<Reclamacion> findAllBy();
}

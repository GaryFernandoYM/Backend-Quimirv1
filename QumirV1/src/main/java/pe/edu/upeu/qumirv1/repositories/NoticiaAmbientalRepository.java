package pe.edu.upeu.qumirv1.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for NoticiaAmbiental entity.
 * Provides CRUD operations and custom query methods.
 *
 * Author: Fernando
 */
@Repository
public interface NoticiaAmbientalRepository extends JpaRepository<NoticiaAmbiental, Long> {

    Optional<NoticiaAmbiental> findByTitulo(String titulo);
}

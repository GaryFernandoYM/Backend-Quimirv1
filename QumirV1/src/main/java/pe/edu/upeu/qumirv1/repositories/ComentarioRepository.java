package pe.edu.upeu.qumirv1.repositories;

import org.springframework.stereotype.Repository;
import pe.edu.upeu.qumirv1.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Comentario entity.
 * Provides CRUD operations and custom query methods.
 *
 * Author: Fernando
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {


    Optional<Comentario> findByComentario(String comentario);
}



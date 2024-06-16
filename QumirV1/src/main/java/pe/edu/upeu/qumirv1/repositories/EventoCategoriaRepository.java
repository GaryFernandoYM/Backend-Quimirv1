package pe.edu.upeu.qumirv1.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.qumirv1.models.EventoCategoria;
import pe.edu.upeu.qumirv1.models.EventoCategoria.EventoCategoriaId;

public interface EventoCategoriaRepository extends JpaRepository<EventoCategoria, EventoCategoriaId> {
    Optional<EventoCategoria> findAllBy();
}

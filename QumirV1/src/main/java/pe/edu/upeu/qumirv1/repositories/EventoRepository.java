package pe.edu.upeu.qumirv1.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.qumirv1.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    Optional<Evento> findAllBy();
}

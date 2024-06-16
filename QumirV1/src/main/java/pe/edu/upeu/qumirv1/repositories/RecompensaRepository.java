package pe.edu.upeu.qumirv1.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.qumirv1.models.Recompensa;

public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {
    Optional<Recompensa> findAllBy();
}

package pe.edu.upeu.qumirv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.qumirv1.models.EventoCategoria;
import pe.edu.upeu.qumirv1.models.EventoCategoria.EventoCategoriaId;

@Repository
public interface EventoCategoriaRepository extends JpaRepository<EventoCategoria, EventoCategoriaId> {

}

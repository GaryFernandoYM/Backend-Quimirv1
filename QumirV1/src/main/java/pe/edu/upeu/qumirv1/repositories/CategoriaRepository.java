package pe.edu.upeu.qumirv1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.qumirv1.models.Categoria;
import pe.edu.upeu.qumirv1.models.Reclamacion;
// fray
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Reclamacion> findAllBy();
}

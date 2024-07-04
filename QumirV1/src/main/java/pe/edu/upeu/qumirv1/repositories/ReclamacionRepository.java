package pe.edu.upeu.qumirv1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.qumirv1.models.Reclamacion;

public interface ReclamacionRepository extends JpaRepository<Reclamacion, Integer> {

    List<Reclamacion> findByUsuarioId(Integer idUsuario);

}

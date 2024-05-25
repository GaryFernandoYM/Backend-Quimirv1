package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Reclamacion;

import java.util.List;
import java.util.Map;

public interface ReclamacionService {
    Reclamacion save(Reclamacion reclamacion);
    List<Reclamacion> findAll();
    Map<String, Boolean> delete(Long id);
    Reclamacion getReclamacionById(Long id);
    Reclamacion update(Reclamacion reclamacion, Long id);
}

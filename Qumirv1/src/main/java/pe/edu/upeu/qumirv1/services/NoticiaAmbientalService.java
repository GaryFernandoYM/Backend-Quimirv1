package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;

import java.util.List;
import java.util.Map;

public interface NoticiaAmbientalService {
    NoticiaAmbiental save(NoticiaAmbiental noticiaAmbiental);
    List<NoticiaAmbiental> findAll();
    Map<String, Boolean> delete(Long id);
    NoticiaAmbiental getEventoAmbientalById(Long id);
    NoticiaAmbiental update(NoticiaAmbiental noticiaAmbiental, Long id);
}

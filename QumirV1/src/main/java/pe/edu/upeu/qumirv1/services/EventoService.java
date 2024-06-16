package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Categoria;
import pe.edu.upeu.qumirv1.models.Evento;

import java.util.List;
import java.util.Map;

public interface EventoService {
    Evento save(Evento evento);

    List<Evento> findAll();
    Map<String, Boolean> delete(Long id);
    Evento getEventoById(Long id);
    Evento update(Evento evento, Long id);
}

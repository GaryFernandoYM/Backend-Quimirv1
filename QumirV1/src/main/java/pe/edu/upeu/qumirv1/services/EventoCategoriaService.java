package pe.edu.upeu.qumirv1.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.qumirv1.models.EventoCategoria;
import pe.edu.upeu.qumirv1.models.EventoCategoria.EventoCategoriaId;

public interface EventoCategoriaService {
    EventoCategoria save(EventoCategoria eventoCategoria);

    List<EventoCategoria> findAll();
    Map<String, Boolean> delete(EventoCategoriaId id);
    EventoCategoria getEventoCategoriaById(EventoCategoriaId id);
    EventoCategoria update(EventoCategoria eventoCategoria, EventoCategoriaId id);
}

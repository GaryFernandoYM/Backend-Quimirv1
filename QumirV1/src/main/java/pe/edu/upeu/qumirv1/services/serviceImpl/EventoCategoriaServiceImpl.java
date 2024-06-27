package pe.edu.upeu.qumirv1.services.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.qumirv1.models.EventoCategoria;
import pe.edu.upeu.qumirv1.models.EventoCategoria.EventoCategoriaId;
import pe.edu.upeu.qumirv1.repositories.EventoCategoriaRepository;
import pe.edu.upeu.qumirv1.services.EventoCategoriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EventoCategoriaServiceImpl implements EventoCategoriaService {

    @Autowired
    private EventoCategoriaRepository eventoCategoriaRepository;

    @Override
    public EventoCategoria save(EventoCategoria eventoCategoria) {
        return eventoCategoriaRepository.save(eventoCategoria);
    }

    @Override
    public List<EventoCategoria> findAll() {
        return eventoCategoriaRepository.findAll();
    }

    @Override
    public Map<String, Boolean> delete(EventoCategoriaId id) {
        Optional<EventoCategoria> eventoCategoria = eventoCategoriaRepository.findById(id);
        Map<String, Boolean> response = new HashMap<>();
        if (eventoCategoria.isPresent()) {
            eventoCategoriaRepository.delete(eventoCategoria.get());
            response.put("deleted", Boolean.TRUE);
        } else {
            response.put("deleted", Boolean.FALSE);
        }
        return response;
    }

    @Override
    public EventoCategoria getEventoCategoriaById(EventoCategoriaId id) {
        return eventoCategoriaRepository.findById(id).orElse(null);
    }

    @Override
    public EventoCategoria update(EventoCategoria eventoCategoria, EventoCategoriaId id) {
        Optional<EventoCategoria> existingEventoCategoria = eventoCategoriaRepository.findById(id);
        if (existingEventoCategoria.isPresent()) {
            EventoCategoria updatedEventoCategoria = existingEventoCategoria.get();
            updatedEventoCategoria.setEvento(eventoCategoria.getEvento());
            updatedEventoCategoria.setCategoria(eventoCategoria.getCategoria());
            return eventoCategoriaRepository.save(updatedEventoCategoria);
        } else {
            return null;
        }
    }
}

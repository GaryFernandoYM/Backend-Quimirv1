package pe.edu.upeu.qumirv1.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.qumirv1.models.Evento;
import pe.edu.upeu.qumirv1.repositories.EventoRepository;
import pe.edu.upeu.qumirv1.services.EventoService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        if (evento.isPresent()) {
            eventoRepository.delete(evento.get());
            return Map.of("deleted", true);
        }
        return Map.of("deleted", false);
    }

    @Override
    public Evento getEventoById(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public Evento update(Evento evento, Long id) {
        Evento existingEvento = eventoRepository.findById(id).orElse(null);
        if (existingEvento != null) {
            existingEvento.setNombreEvento(evento.getNombreEvento());
            existingEvento.setDescripcion(evento.getDescripcion());
            existingEvento.setFechaEvento(evento.getFechaEvento());
            existingEvento.setUbicacion(evento.getUbicacion());
            existingEvento.setOrganizador(evento.getOrganizador());
            existingEvento.setCapacidadMaxima(evento.getCapacidadMaxima());
            existingEvento.setPuntos(evento.getPuntos());
            existingEvento.setFechaCreacion(evento.getFechaCreacion());
            existingEvento.setCategoria(evento.getCategoria());
            return eventoRepository.save(existingEvento);
        }
        return null;
    }
}

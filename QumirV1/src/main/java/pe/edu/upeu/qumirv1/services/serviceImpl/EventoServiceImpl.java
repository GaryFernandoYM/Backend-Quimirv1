package pe.edu.upeu.qumirv1.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.Evento;
import pe.edu.upeu.qumirv1.repositories.EventoRepository;
import pe.edu.upeu.qumirv1.services.EventoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepo;

    @Override
    public Evento save(Evento evento) {
        try {
            return eventoRepo.save(evento);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Evento> findAll() {
        try {
            return eventoRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Evento evento = eventoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no existe con id: " + id));

        try {
            eventoRepo.delete(evento);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Evento getEventoById(Long id) {
        return eventoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no existe con id: " + id));
    }

    @Override
    public Evento update(Evento eventoDetails, Long id) {
        Evento evento = eventoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no existe con id: " + id));

        // Actualizar los campos necesarios
        evento.setNombreEvento(eventoDetails.getNombreEvento());
        evento.setDescripcion(eventoDetails.getDescripcion());
        evento.setFechaEvento(eventoDetails.getFechaEvento());
        evento.setUbicacion(eventoDetails.getUbicacion());
        evento.setOrganizador(eventoDetails.getOrganizador());
        evento.setCapacidadMaxima(eventoDetails.getCapacidadMaxima());
        evento.setPuntos(eventoDetails.getPuntos());
        evento.setCategoria(eventoDetails.getCategoria());

        try {
            return eventoRepo.save(evento);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

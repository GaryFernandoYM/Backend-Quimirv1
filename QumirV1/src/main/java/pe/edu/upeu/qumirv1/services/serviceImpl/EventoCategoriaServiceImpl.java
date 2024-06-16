package pe.edu.upeu.qumirv1.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.EventoCategoria;
import pe.edu.upeu.qumirv1.models.EventoCategoria.EventoCategoriaId;
import pe.edu.upeu.qumirv1.repositories.EventoCategoriaRepository;
import pe.edu.upeu.qumirv1.services.EventoCategoriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class EventoCategoriaServiceImpl implements EventoCategoriaService {

    @Autowired
    private final EventoCategoriaRepository eventoCategoriaRepo;

    @Override
    public EventoCategoria save(EventoCategoria eventoCategoria) {
        try {
            return eventoCategoriaRepo.save(eventoCategoria);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<EventoCategoria> findAll() {
        try {
            return eventoCategoriaRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(EventoCategoriaId id) {
        EventoCategoria eventoCategoria = eventoCategoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EventoCategoria no existe con id: " + id));

        eventoCategoriaRepo.delete(eventoCategoria);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public EventoCategoria getEventoCategoriaById(EventoCategoriaId id) {
        return eventoCategoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EventoCategoria no existe con id: " + id));
    }

    @Override
    public EventoCategoria update(EventoCategoria eventoCategoriaDetails, EventoCategoriaId id) {
        EventoCategoria eventoCategoria = eventoCategoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EventoCategoria no existe con id: " + id));

        // Actualizar los campos necesarios
        eventoCategoria.setEvento(eventoCategoriaDetails.getEvento());
        eventoCategoria.setCategoria(eventoCategoriaDetails.getCategoria());

        try {
            return eventoCategoriaRepo.save(eventoCategoria);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
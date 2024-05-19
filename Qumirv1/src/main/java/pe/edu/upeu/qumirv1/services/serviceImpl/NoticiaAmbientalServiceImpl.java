package pe.edu.upeu.qumirv1.services.serviceImpl;

import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.repositories.NoticiaAmbientalRepository;
import pe.edu.upeu.qumirv1.services.NoticiaAmbientalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
@RequiredArgsConstructor
@Service
@Transactional
public class NoticiaAmbientalServiceImpl implements NoticiaAmbientalService {

    @Autowired
    private NoticiaAmbientalRepository noticiaRepo;

    @Override
    public NoticiaAmbiental save(NoticiaAmbiental noticia) {
        try {
            return noticiaRepo.save(noticia);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<NoticiaAmbiental> findAll() {
        try {
            return noticiaRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        NoticiaAmbiental noticia = noticiaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento ambiental no existe con id: " + id));

        noticiaRepo.delete(noticia);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public NoticiaAmbiental getEventoAmbientalById(Long id) {
        NoticiaAmbiental findNoticia = noticiaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento ambiental no existe con id: " + id));
        return findNoticia;
    }

    @Override
    public NoticiaAmbiental update(NoticiaAmbiental evento, Long id) {
        NoticiaAmbiental eventoExistente = noticiaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento ambiental no existe con id: " + id));
        eventoExistente.setTitulo(evento.getTitulo());
        eventoExistente.setContenido(evento.getContenido());
        eventoExistente.setFechaPublicacion(evento.getFechaPublicacion());
        return noticiaRepo.save(eventoExistente);
    }
}

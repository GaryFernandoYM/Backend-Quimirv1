package pe.edu.upeu.qumirv1.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.Comentario;
import pe.edu.upeu.qumirv1.repositories.ComentarioRepository;
import pe.edu.upeu.qumirv1.services.ComentarioService;

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
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepo;

    @Override
    public Comentario save(Comentario comentario) {
        try {
            return comentarioRepo.save(comentario);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Comentario> findAll() {
        try {
            return comentarioRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Comentario comentario = comentarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento ambiental no existe con id: " + id));

        comentarioRepo.delete(comentario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Comentario getComentarioById(Long id) {
        Comentario findComentario = comentarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento ambiental no existe con id: " + id));
        return findComentario;
    }

    @Override
    public Comentario update(Comentario evento, Long id) {
        Comentario eventoExistente = comentarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento ambiental no existe con id: " + id));
        eventoExistente.setIdUsuario(evento.getIdUsuario());
        eventoExistente.setIdEvento(evento.getIdEvento());
        eventoExistente.setIdNoticia(evento.getIdNoticia());
        eventoExistente.setComentario(evento.getComentario());
        eventoExistente.setCalificacion(evento.getCalificacion());
        eventoExistente.setFechaComentario(evento.getFechaComentario());



        return comentarioRepo.save(eventoExistente);
    }
}
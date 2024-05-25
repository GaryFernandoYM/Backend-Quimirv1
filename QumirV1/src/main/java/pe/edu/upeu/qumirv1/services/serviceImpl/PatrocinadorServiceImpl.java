package pe.edu.upeu.qumirv1.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.models.Patrocinador;
import pe.edu.upeu.qumirv1.repositories.NoticiaAmbientalRepository;
import pe.edu.upeu.qumirv1.repositories.PatrocinadorRepository;
import pe.edu.upeu.qumirv1.services.NoticiaAmbientalService;
import pe.edu.upeu.qumirv1.services.PatrocinadorService;

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
public class PatrocinadorServiceImpl implements PatrocinadorService {

    @Autowired
    private PatrocinadorRepository patrocinadorRepo;

    @Override
    public Patrocinador save(Patrocinador patrocinador) {
        try {
            return patrocinadorRepo.save(patrocinador);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Patrocinador> findAll() {
        try {
            return patrocinadorRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Patrocinador patrocinador = patrocinadorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patrocinador no existe con id: " + id));

        patrocinadorRepo.delete(patrocinador);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Patrocinador getPatrocinadorById(Long id) {
        Patrocinador findPatrocinador = patrocinadorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patrocinador no existe con id: " + id));
        return findPatrocinador;
    }

    @Override
    public Patrocinador update(Patrocinador evento, Long id) {
        Patrocinador eventoExistente = patrocinadorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patrocinador no existe con id: " + id));
        eventoExistente.setNombre(evento.getNombre());
        eventoExistente.setDescripcion(evento.getDescripcion());
        return patrocinadorRepo.save(eventoExistente);
    }
}

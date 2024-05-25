package pe.edu.upeu.qumirv1.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.models.Reclamacion;
import pe.edu.upeu.qumirv1.repositories.NoticiaAmbientalRepository;
import pe.edu.upeu.qumirv1.repositories.ReclamacionRepository;
import pe.edu.upeu.qumirv1.services.NoticiaAmbientalService;
import pe.edu.upeu.qumirv1.services.ReclamacionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
@RequiredArgsConstructor
@Service
@Transactional
public class ReclamacionServiceImpl implements ReclamacionService {

    @Autowired
    private ReclamacionRepository reclamacionRepo;

    @Override
    public Reclamacion save(Reclamacion reclamacion) {
        try {
            return reclamacionRepo.save(reclamacion);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Reclamacion> findAll() {
        try {
            return reclamacionRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Reclamacion reclamacion = reclamacionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("reclamaciones no existe con id: " + id));

        reclamacionRepo.delete(reclamacion);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Reclamacion getReclamacionById(Long id) {
        Reclamacion findReclamacion = reclamacionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("reclamaciones no existe con id: " + id));
        return findReclamacion;
    }

    @Override
    public Reclamacion update(Reclamacion evento, Long id) {
        Reclamacion eventoExistente = reclamacionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("reclamaciones no existe con id: " + id));
        eventoExistente.setId_usuario(evento.getId_usuario());
        eventoExistente.setId_recompensa(evento.getId_recompensa());
        eventoExistente.setFechaReclamacion(evento.getFechaReclamacion());
        eventoExistente.setEstado(evento.getEstado());
        return reclamacionRepo.save(eventoExistente);
    }
}

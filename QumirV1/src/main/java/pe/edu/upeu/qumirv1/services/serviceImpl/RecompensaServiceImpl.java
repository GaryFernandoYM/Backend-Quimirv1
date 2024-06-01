package pe.edu.upeu.qumirv1.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.Recompensa;
import pe.edu.upeu.qumirv1.repositories.RecompensaRepository;
import pe.edu.upeu.qumirv1.services.RecompensaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class RecompensaServiceImpl implements RecompensaService {

    @Autowired
    private final RecompensaRepository recompensaRepo;

    @Override
    public Recompensa save(Recompensa recompensa) {
        try {
            return recompensaRepo.save(recompensa);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Recompensa> findAll() {
        try {
            return recompensaRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Recompensa recompensa = recompensaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa no existe con id: " + id));

        recompensaRepo.delete(recompensa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Recompensa getRecompensaById(Long id) {
        return recompensaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa no existe con id: " + id));
    }

    @Override
    public Recompensa update(Recompensa recompensaDetails, Long id) {
        Recompensa recompensa = recompensaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa no existe con id: " + id));

        // Actualizar los campos necesarios
        recompensa.setNombreRecompensa(recompensaDetails.getNombreRecompensa());
        recompensa.setDescripcion(recompensaDetails.getDescripcion());
        recompensa.setPuntosNecesarios(recompensaDetails.getPuntosNecesarios());
        recompensa.setFechaExpiracion(recompensaDetails.getFechaExpiracion());

        try {
            return recompensaRepo.save(recompensa);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
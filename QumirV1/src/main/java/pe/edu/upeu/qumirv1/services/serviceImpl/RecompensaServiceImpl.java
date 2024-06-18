package pe.edu.upeu.qumirv1.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.qumirv1.models.Recompensa;
import pe.edu.upeu.qumirv1.repositories.RecompensaRepository;
import pe.edu.upeu.qumirv1.services.RecompensaService;

@Service
public class RecompensaServiceImpl implements RecompensaService {

    @Autowired
    private RecompensaRepository recompensaRepository;

    @Override
    public List<Recompensa> listar() {
        return recompensaRepository.findAll();
    }

    @Override
    public Recompensa guardar(Recompensa recompensa) {
        return recompensaRepository.save(recompensa);
    }

    @Override
    public Recompensa actualizar(Recompensa recompensa) {
        return recompensaRepository.save(recompensa);
    }

    @Override
    public Optional<Recompensa> listarPorId(Integer id) {
        return recompensaRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        recompensaRepository.deleteById(id);
    }
}
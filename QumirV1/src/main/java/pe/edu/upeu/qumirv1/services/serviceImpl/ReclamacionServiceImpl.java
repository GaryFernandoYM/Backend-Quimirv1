package pe.edu.upeu.qumirv1.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.qumirv1.models.Asistencia;
import pe.edu.upeu.qumirv1.models.Reclamacion;
import pe.edu.upeu.qumirv1.repositories.ReclamacionRepository;
import pe.edu.upeu.qumirv1.services.ReclamacionService;

@Service
public class ReclamacionServiceImpl implements ReclamacionService {

    @Autowired
    private ReclamacionRepository reclamacionRepository;

    @Override
    public List<Reclamacion> listar() {
        return reclamacionRepository.findAll();
    }

    @Override
    public Reclamacion guardar(Reclamacion reclamacion) {
        return reclamacionRepository.save(reclamacion);
    }

    @Override
    public Reclamacion actualizar(Reclamacion reclamacion) {
        return reclamacionRepository.save(reclamacion);
    }

    @Override
    public Optional<Reclamacion> listarPorId(Integer id) {
        return reclamacionRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        reclamacionRepository.deleteById(id);
    }

    @Override
    public List<Reclamacion> listarPorUsuario(Integer idUsuario) {
        // Obtener la lista de Asistencias por categoría directamente desde el
        // repositorio
        return reclamacionRepository.findByUsuarioId(idUsuario);
    }
}

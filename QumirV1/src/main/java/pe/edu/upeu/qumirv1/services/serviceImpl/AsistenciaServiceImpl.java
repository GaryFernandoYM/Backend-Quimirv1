package pe.edu.upeu.qumirv1.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.Asistencia;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.repositories.AsistenciaRepository;
import pe.edu.upeu.qumirv1.services.AsistenciaService;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Override
    public List<Asistencia> listar() {
        return asistenciaRepository.findAll();
    }

    @Override
    public Asistencia guardar(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Asistencia actualizar(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public Optional<Asistencia> listarPorId(Integer id) {
        // Obtener la Asistencia de la base de datos
        Asistencia asistencia = asistenciaRepository.findById(id).orElse(null);

        if (asistencia != null) {
            try {

                Usuario usuario = usuarioService.getUsuarioById(asistencia.getUsuario().getId());
                System.out.println("Después de la petición");
                System.out.println(usuario.toString());
                System.out.println(usuario.getEmail());
                System.out.println(usuario.getId());
                asistencia.setUsuario(usuario);
            } catch (ResourceNotFoundException e) {
                System.out.println("Usuario no encontrado con id: " + asistencia.getUsuario().getId());
            }
        }

        return Optional.ofNullable(asistencia);
    }

    @Override
    public void eliminarPorId(Integer id) {
        asistenciaRepository.deleteById(id);
    }
}

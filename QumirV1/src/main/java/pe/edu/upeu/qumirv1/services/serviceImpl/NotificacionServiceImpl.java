package pe.edu.upeu.qumirv1.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.Notificacion;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.repositories.NotificacionRepository;
import pe.edu.upeu.qumirv1.services.NotificacionService;

@Service
public class NotificacionServiceImpl implements NotificacionService {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Override
    public List<Notificacion> listar() {
        return notificacionRepository.findAll();
    }

    @Override
    public Notificacion guardar(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public Notificacion actualizar(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public Optional<Notificacion> listarPorId(Integer id) {
        // Obtener la Notificacion de la base de datos
        Notificacion notificacion = notificacionRepository.findById(id).orElse(null);

        if (notificacion != null) {
            try {

                Usuario usuario = usuarioService.getUsuarioById(notificacion.getUsuario().getId());
                System.out.println("Después de la petición");
                System.out.println(usuario.toString());
                System.out.println(usuario.getCorreo());
                System.out.println(usuario.getId());
                notificacion.setUsuario(usuario);
            } catch (ResourceNotFoundException e) {
                System.out.println("Usuario no encontrado con id: " + notificacion.getUsuario().getId());
            }
        }

        return Optional.ofNullable(notificacion);
    }

    @Override
    public void eliminarPorId(Integer id) {
        notificacionRepository.deleteById(id);
    }
}

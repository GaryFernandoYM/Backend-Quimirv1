package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Notificacion;
import java.util.List;
import java.util.Optional;

public interface NotificacionService {
    public List<Notificacion> listar();

    public Notificacion guardar(Notificacion notificacion);

    public Notificacion actualizar(Notificacion notificacion);

    public Optional<Notificacion> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}

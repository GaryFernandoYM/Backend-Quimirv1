package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Asistencia;
import pe.edu.upeu.qumirv1.models.Reclamacion;

import java.util.List;

import java.util.Optional;

public interface ReclamacionService {

    public List<Reclamacion> listar();

    public Reclamacion guardar(Reclamacion reclamacion);

    public Reclamacion actualizar(Reclamacion reclamacion);

    public Optional<Reclamacion> listarPorId(Integer id);

    public void eliminarPorId(Integer id);

    // Otros métodos existentes
    List<Reclamacion> listarPorUsuario(Integer idUsuario);

}

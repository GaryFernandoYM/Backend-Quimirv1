package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Asistencia;
import java.util.List;
import java.util.Optional;

public interface AsistenciaService {
    public List<Asistencia> listar();

    public Asistencia guardar(Asistencia asistencia);

    public Asistencia actualizar(Asistencia asistencia);

    public Optional<Asistencia> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}

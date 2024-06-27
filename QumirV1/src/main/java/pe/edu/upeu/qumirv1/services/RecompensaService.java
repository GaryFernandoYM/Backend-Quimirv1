package pe.edu.upeu.qumirv1.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.qumirv1.models.Recompensa;

public interface RecompensaService {

    public List<Recompensa> listar();

    public Recompensa guardar(Recompensa recompensa);

    public Recompensa actualizar(Recompensa recompensa);

    public Optional<Recompensa> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}

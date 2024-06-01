package pe.edu.upeu.qumirv1.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.qumirv1.models.Recompensa;

public interface RecompensaService {
    Recompensa save(Recompensa recompensa);

    List<Recompensa> findAll();
    Map<String, Boolean> delete(Long id);
    Recompensa getRecompensaById(Long id);
    Recompensa update(Recompensa recompensa, Long id);
}

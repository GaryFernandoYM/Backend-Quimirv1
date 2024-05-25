package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Patrocinador;


import java.util.List;
import java.util.Map;

public interface PatrocinadorService {
    Patrocinador save(Patrocinador patrocinador);
    List<Patrocinador> findAll();
    Map<String, Boolean> delete(Long id);
    Patrocinador getPatrocinadorById(Long id);
    Patrocinador update(Patrocinador patrocinador, Long id);
}

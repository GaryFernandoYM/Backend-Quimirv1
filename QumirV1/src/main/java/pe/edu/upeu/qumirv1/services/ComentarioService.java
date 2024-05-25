package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Comentario;

import java.util.List;
import java.util.Map;

public interface ComentarioService {
    Comentario save(Comentario comentario);
    List<Comentario> findAll();
    Map<String, Boolean> delete(Long id);
    Comentario getComentarioById(Long id);
    Comentario update(Comentario comentario, Long id);

}

package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Categoria;

import java.util.List;
import java.util.Map;

public interface CategoriaService {
    Categoria save(Categoria categoria);

    List<Categoria> findAll();
    Map<String, Boolean> delete(Long id);
    Categoria getCategoriaById(Long id);
    Categoria update(Categoria categoria, Long id);
}

package pe.edu.upeu.qumirv1.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.qumirv1.models.Categoria;

public interface CategoriaService {
    Categoria save(Categoria categoria);

    List<Categoria> findAll();
    Map<String, Boolean> delete(Long id);
    Categoria getCategoriaById(Long id);
    Categoria update(Categoria categoria, Long id);
}

package pe.edu.upeu.qumirv1.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.qumirv1.models.Categoria;
import pe.edu.upeu.qumirv1.repositories.CategoriaRepository;
import pe.edu.upeu.qumirv1.services.CategoriaService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria not found"));

        categoriaRepository.delete(categoria);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria not found"));
    }

    @Override
    public Categoria update(Categoria categoriaDetails, Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria not found"));

        categoria.setNombreCategoria(categoriaDetails.getNombreCategoria());
        return categoriaRepository.save(categoria);
    }
}

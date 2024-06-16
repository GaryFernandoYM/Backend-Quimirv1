package pe.edu.upeu.qumirv1.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.qumirv1.exceptions.AppException;
import pe.edu.upeu.qumirv1.exceptions.ResourceNotFoundException;
import pe.edu.upeu.qumirv1.models.Categoria;
import pe.edu.upeu.qumirv1.repositories.CategoriaRepository;
import pe.edu.upeu.qumirv1.services.CategoriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepo;

    @Override
    public Categoria save(Categoria categoria) {
        try {
            return categoriaRepo.save(categoria);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Categoria> findAll() {
        try {
            return categoriaRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Categoria categoria = categoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no existe con id: " + id));

        categoriaRepo.delete(categoria);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no existe con id: " + id));
    }

    @Override
    public Categoria update(Categoria categoriaDetails, Long id) {
        Categoria categoria = categoriaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria no existe con id: " + id));

        // Actualizar los campos necesarios

        categoria.setNombrecategoria(categoria.getNombrecategoria());

        try {
            return categoriaRepo.save(categoria);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.Categoria;

import pe.edu.upeu.qumirv1.services.CategoriaService;


import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
@RestController
@RequestMapping("/qumir/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/list")
    public ResponseEntity<List<Categoria>> listEventos() {
        List<Categoria> comentarios = categoriaService.findAll();
        return ResponseEntity.ok(comentarios);
    }

    @PostMapping("/crear")
    public ResponseEntity<Categoria> createEvento(@RequestBody Categoria categoria) {
        Categoria data = categoriaService.save(categoria);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Categoria> getEventoById(@PathVariable Long id) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Map<String, Boolean> response = categoriaService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Categoria> updateEvento(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
        Categoria updatedEvento = categoriaService.update(categoriaDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }
}

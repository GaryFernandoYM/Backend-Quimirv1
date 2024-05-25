package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.Comentario;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.services.ComentarioService;
import pe.edu.upeu.qumirv1.services.NoticiaAmbientalService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
@RestController
@RequestMapping("/qumir/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Comentario>> listEventos() {
        List<Comentario> comentarios = comentarioService.findAll();
        return ResponseEntity.ok(comentarios);
    }

    @PostMapping("/crear")
    public ResponseEntity<Comentario> createEvento(@RequestBody Comentario comentario) {
        Comentario data = comentarioService.save(comentario);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Comentario> getEventoById(@PathVariable Long id) {
        Comentario comentario = comentarioService.getComentarioById(id);
        return ResponseEntity.ok(comentario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Map<String, Boolean> response = comentarioService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Comentario> updateEvento(@PathVariable Long id, @RequestBody Comentario comentarioDetails) {
        Comentario updatedEvento = comentarioService.update(comentarioDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }
}

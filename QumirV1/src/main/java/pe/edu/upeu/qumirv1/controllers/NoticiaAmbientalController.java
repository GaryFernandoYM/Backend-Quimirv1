package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.services.NoticiaAmbientalService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
@RestController
@RequestMapping("/qumir/noticiaambiental")
public class NoticiaAmbientalController {
    @Autowired
    private NoticiaAmbientalService noticiaService;

    @GetMapping("/list")
    public ResponseEntity<List<NoticiaAmbiental>> listEventos() {
        List<NoticiaAmbiental> noticias = noticiaService.findAll();
        return ResponseEntity.ok(noticias);
    }

    @PostMapping("/crear")
    public ResponseEntity<NoticiaAmbiental> createEvento(@RequestBody NoticiaAmbiental noticia) {
        NoticiaAmbiental data = noticiaService.save(noticia);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<NoticiaAmbiental> getEventoById(@PathVariable Long id) {
        NoticiaAmbiental noticia = noticiaService.getEventoAmbientalById(id);
        return ResponseEntity.ok(noticia);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Map<String, Boolean> response = noticiaService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<NoticiaAmbiental> updateEvento(@PathVariable Long id, @RequestBody NoticiaAmbiental noticiaDetails) {
        NoticiaAmbiental updatedEvento = noticiaService.update(noticiaDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }
}

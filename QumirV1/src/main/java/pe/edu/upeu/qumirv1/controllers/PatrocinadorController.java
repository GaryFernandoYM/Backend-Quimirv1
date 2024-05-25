package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.models.Patrocinador;
import pe.edu.upeu.qumirv1.services.NoticiaAmbientalService;
import pe.edu.upeu.qumirv1.services.PatrocinadorService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
@RestController
@RequestMapping("/qumir/patrocinador")
public class PatrocinadorController {
    @Autowired
    private PatrocinadorService patrocinadorService;

    @GetMapping("/list")
    public ResponseEntity<List<Patrocinador>> listEventos() {
        List<Patrocinador> patrocinadors = patrocinadorService.findAll();
        return ResponseEntity.ok(patrocinadors);
    }

    @PostMapping("/crear")
    public ResponseEntity<Patrocinador> createEvento(@RequestBody Patrocinador patrocinador) {
        Patrocinador data = patrocinadorService.save(patrocinador);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Patrocinador> getEventoById(@PathVariable Long id) {
        Patrocinador patrocinador = patrocinadorService.getPatrocinadorById(id);
        return ResponseEntity.ok(patrocinador);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Map<String, Boolean> response = patrocinadorService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Patrocinador> updateEvento(@PathVariable Long id, @RequestBody Patrocinador patrocinadorDetails) {
        Patrocinador updatedEvento = patrocinadorService.update(patrocinadorDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }
}

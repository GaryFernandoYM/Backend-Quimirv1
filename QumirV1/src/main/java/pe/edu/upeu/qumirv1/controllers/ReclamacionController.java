package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.NoticiaAmbiental;
import pe.edu.upeu.qumirv1.models.Reclamacion;
import pe.edu.upeu.qumirv1.services.NoticiaAmbientalService;
import pe.edu.upeu.qumirv1.services.ReclamacionService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Fernando
 */
@RestController
@RequestMapping("/qumir/reclamacion")
public class ReclamacionController {
    @Autowired
    private ReclamacionService reclamacionService;

    @GetMapping("/list")
    public ResponseEntity<List<Reclamacion>> listEventos() {
        List<Reclamacion> reclamacions = reclamacionService.findAll();
        return ResponseEntity.ok(reclamacions);
    }

    @PostMapping("/crear")
    public ResponseEntity<Reclamacion> createEvento(@RequestBody Reclamacion reclamacion) {
        Reclamacion data = reclamacionService.save(reclamacion);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Reclamacion> getEventoById(@PathVariable Long id) {
        Reclamacion reclamacion = reclamacionService.getReclamacionById(id);
        return ResponseEntity.ok(reclamacion);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Map<String, Boolean> response = reclamacionService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Reclamacion> updateEvento(@PathVariable Long id, @RequestBody Reclamacion reclamacionDetails) {
        Reclamacion updatedEvento = reclamacionService.update(reclamacionDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }
}

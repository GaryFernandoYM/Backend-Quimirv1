package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.Recompensa;
import pe.edu.upeu.qumirv1.services.RecompensaService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qumir/recompensa")
public class RecompensaController {
    @Autowired
    private RecompensaService recompensaService;

    @GetMapping("/list")
    public ResponseEntity<List<Recompensa>> listRecompensas() {
        List<Recompensa> recompensas = recompensaService.findAll();
        return ResponseEntity.ok(recompensas);
    }

    @PostMapping("/crear")
    public ResponseEntity<Recompensa> createRecompensa(@RequestBody Recompensa recompensa) {
        Recompensa data = recompensaService.save(recompensa);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Recompensa> getRecompensaById(@PathVariable Long id) {
        Recompensa recompensa = recompensaService.getRecompensaById(id);
        return ResponseEntity.ok(recompensa);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecompensa(@PathVariable Long id) {
        Map<String, Boolean> response = recompensaService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Recompensa> updateRecompensa(@PathVariable Long id, @RequestBody Recompensa recompensaDetails) {
        Recompensa updatedRecompensa = recompensaService.update(recompensaDetails, id);
        return ResponseEntity.ok(updatedRecompensa);
    }
}
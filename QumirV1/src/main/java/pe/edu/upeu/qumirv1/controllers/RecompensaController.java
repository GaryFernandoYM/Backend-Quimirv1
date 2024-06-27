package pe.edu.upeu.qumirv1.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upeu.qumirv1.models.Recompensa;
import pe.edu.upeu.qumirv1.services.RecompensaService;

@RestController
@RequestMapping("/recompensa")
public class RecompensaController {
    @Autowired
    private RecompensaService recompensaService;

    @GetMapping()
    public ResponseEntity<List<Recompensa>> list() {
        return ResponseEntity.ok().body(recompensaService.listar());
    }

    @PostMapping()
    public ResponseEntity<Recompensa> save(@RequestBody Recompensa recompensa) {
        return ResponseEntity.ok(recompensaService.guardar(recompensa));
    }

    @PutMapping()
    public ResponseEntity<Recompensa> update(@RequestBody Recompensa recompensa) {
        return ResponseEntity.ok(recompensaService.actualizar(recompensa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recompensa> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(recompensaService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        recompensaService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
}
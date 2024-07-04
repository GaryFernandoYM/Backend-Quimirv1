package pe.edu.upeu.qumirv1.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upeu.qumirv1.models.Asistencia;
import pe.edu.upeu.qumirv1.models.Reclamacion;
import pe.edu.upeu.qumirv1.services.ReclamacionService;

@RestController
@RequestMapping("/reclamacion")
public class ReclamacionController {

    @Autowired
    private ReclamacionService reclamacionService;

    @GetMapping("/asistenciaPorUsuario/{idUsuario}")
    public ResponseEntity<List<Reclamacion>> listarAsistenciasPorUsuario(@PathVariable Integer idUsuario) {
        List<Reclamacion> reclamacion = reclamacionService.listarPorUsuario(idUsuario);
        return ResponseEntity.ok(reclamacion);
    }

    @GetMapping()
    public ResponseEntity<List<Reclamacion>> list() {
        return ResponseEntity.ok().body(reclamacionService.listar());
    }

    @PostMapping()
    public ResponseEntity<Reclamacion> save(@RequestBody Reclamacion Reclamacion) {
        return ResponseEntity.ok(reclamacionService.guardar(Reclamacion));
    }

    @PutMapping()
    public ResponseEntity<Reclamacion> update(@RequestBody Reclamacion Reclamacion) {
        return ResponseEntity.ok(reclamacionService.actualizar(Reclamacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamacion> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(reclamacionService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        reclamacionService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
}

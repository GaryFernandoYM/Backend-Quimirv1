package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upeu.qumirv1.models.Notificacion;
import pe.edu.upeu.qumirv1.services.NotificacionService;

import java.util.List;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping()
    public ResponseEntity<List<Notificacion>> list() {
        return ResponseEntity.ok().body(notificacionService.listar());
    }

    @PostMapping()
    public ResponseEntity<Notificacion> save(@RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(notificacionService.guardar(notificacion));
    }

    @PutMapping()
    public ResponseEntity<Notificacion> update(
            @RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(notificacionService.actualizar(notificacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(notificacionService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        notificacionService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
}

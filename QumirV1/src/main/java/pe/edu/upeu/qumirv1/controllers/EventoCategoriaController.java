package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.EventoCategoria;
import pe.edu.upeu.qumirv1.models.EventoCategoria.EventoCategoriaId;
import pe.edu.upeu.qumirv1.services.EventoCategoriaService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qumir/eventocategoria")
public class EventoCategoriaController {
    @Autowired
    private EventoCategoriaService eventoCategoriaService;

    @GetMapping("/list")
    public ResponseEntity<List<EventoCategoria>> listEventoCategorias() {
        List<EventoCategoria> eventoCategorias = eventoCategoriaService.findAll();
        return ResponseEntity.ok(eventoCategorias);
    }

    @PostMapping("/crear")
    public ResponseEntity<EventoCategoria> createEventoCategoria(@RequestBody EventoCategoria eventoCategoria) {
        EventoCategoria data = eventoCategoriaService.save(eventoCategoria);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{idEvento}/{idCategoria}")
    public ResponseEntity<EventoCategoria> getEventoCategoriaById(@PathVariable Long idEvento, @PathVariable Long idCategoria) {
        EventoCategoriaId id = new EventoCategoriaId(idEvento, idCategoria);
        EventoCategoria eventoCategoria = eventoCategoriaService.getEventoCategoriaById(id);
        return ResponseEntity.ok(eventoCategoria);
    }

    @DeleteMapping("/eliminar/{idEvento}/{idCategoria}")
    public ResponseEntity<Map<String, Boolean>> deleteEventoCategoria(@PathVariable Long idEvento, @PathVariable Long idCategoria) {
        EventoCategoriaId id = new EventoCategoriaId(idEvento, idCategoria);
        Map<String, Boolean> response = eventoCategoriaService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{idEvento}/{idCategoria}")
    public ResponseEntity<EventoCategoria> updateEventoCategoria(@PathVariable Long idEvento, @PathVariable Long idCategoria, @RequestBody EventoCategoria eventoCategoriaDetails) {
        EventoCategoriaId id = new EventoCategoriaId(idEvento, idCategoria);
        EventoCategoria updatedEventoCategoria = eventoCategoriaService.update(eventoCategoriaDetails, id);
        return ResponseEntity.ok(updatedEventoCategoria);
    }
}
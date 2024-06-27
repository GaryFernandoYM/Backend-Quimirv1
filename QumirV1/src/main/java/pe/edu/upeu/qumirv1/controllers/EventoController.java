package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.Evento;
import pe.edu.upeu.qumirv1.services.EventoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qumir/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping("/list")
    public ResponseEntity<List<Evento>> listEventos() {
        List<Evento> eventos = eventoService.findAll();
        return ResponseEntity.ok(eventos);
    }

    @PostMapping("/crear")
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        try {
            Evento data = eventoService.save(evento);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error creando el evento: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Map<String, Boolean> response = eventoService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento eventoDetails) {
        Evento updatedEvento = eventoService.update(eventoDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }
}

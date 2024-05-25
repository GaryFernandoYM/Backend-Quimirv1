package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.services.UsuarioService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qumir/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> listEventos() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> createEvento(@RequestBody Usuario usuario) {
        Usuario data = usuarioService.save(usuario);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> getEventoById(@PathVariable Long id) {
        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvento(@PathVariable Long id) {
        Map<String, Boolean> response = usuarioService.delete(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> updateEvento(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario updatedEvento = usuarioService.update(usuarioDetails, id);
        return ResponseEntity.ok(updatedEvento);
    }
}

package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.services.UsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/qumir/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Usuario usuario) {
        // Verificar las credenciales del usuario en la base de datos
        final Usuario usuarioValido = usuarioService.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
        if (usuarioValido != null) {
            // Generar un token de autenticación (aquí puedes usar JWT u otra técnica)
            String authToken = generateAuthToken(usuarioValido);

            // Devolver el token de autenticación en la respuesta
            Map<String, String> response = new HashMap<>();
            response.put("token", authToken);
            return ResponseEntity.ok(response);
        } else {
            // Si las credenciales son incorrectas, devolver un mensaje de error
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Credenciales incorrectas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    // Método para generar un token de autenticación (implementa tu lógica aquí)
    private String generateAuthToken(Usuario usuario) {
        // Implementa tu lógica para generar un token aquí
        return "TOKEN_GENERADO";
    }
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

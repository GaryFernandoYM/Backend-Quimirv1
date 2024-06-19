package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.dtos.UsuarioDto;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioService.register(usuarioDto);
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Usuario ya existe");
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioService.login(usuarioDto);
        if (usuario == null) {
            return ResponseEntity.badRequest().body("Email o contraseña inválidos");
        }
        return ResponseEntity.ok(usuario);
    }
}

package pe.edu.upeu.qumirv1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.qumirv1.models.Usuario;
import pe.edu.upeu.qumirv1.services.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> registerUser(@RequestBody Usuario usuario) {
        Usuario registeredUser = usuarioService.registerUser(usuario);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUser(@RequestBody Usuario usuario) {
        Usuario loggedInUser = usuarioService.loginUser(usuario.getEmail(), usuario.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}


package pe.edu.upeu.qumirv1.controllers;

import pe.edu.upeu.qumirv1.models.User; // Importa tu clase User
import pe.edu.upeu.qumirv1.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user); // Debe guardar la instancia de User correctamente
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable String userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        return user.orElse(null);
    }
}

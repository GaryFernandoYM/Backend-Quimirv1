package pe.edu.upeu.qumirv1.controllers;

import pe.edu.upeu.qumirv1.models.UserLocation;
import pe.edu.upeu.qumirv1.repositories.UserLocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/qumir")
public class UserLocationController {

    @Autowired
    private UserLocationRepository userLocationRepository;

    @PostMapping("/postmsn")
    public UserLocation createUserLocation(@RequestBody UserLocation userLocation) {
        return userLocationRepository.save(userLocation);
    }

    @GetMapping("/locations")
    public List<UserLocation> getAllLocations() {
        return userLocationRepository.findAll();
    }

    @GetMapping("/location/{userId}")
    public UserLocation getUserLocation(@PathVariable String userId) {
        Optional<UserLocation> userLocation = userLocationRepository.findByUserId(userId);
        return userLocation.orElse(null); // Manejar caso de usuario no encontrado
    }
}

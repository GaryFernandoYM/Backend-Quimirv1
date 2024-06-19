package pe.edu.upeu.qumirv1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.qumirv1.models.UserLocation;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    Optional<UserLocation> findByUserId(String userId); // Definir método de búsqueda personalizado


}

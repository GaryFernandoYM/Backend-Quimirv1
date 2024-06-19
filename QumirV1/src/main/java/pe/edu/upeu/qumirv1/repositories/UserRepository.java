package pe.edu.upeu.qumirv1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.qumirv1.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}

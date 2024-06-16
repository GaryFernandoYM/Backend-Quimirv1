package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Usuario;

import java.util.List;
import java.util.Map;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Map<String, Boolean> delete(Long id);
    Usuario getUsuarioById(Long id);
    Usuario update(Usuario usuario, Long id);
    Usuario findByEmailAndPassword(Object object, String password); // Corregido el nombre del método
}

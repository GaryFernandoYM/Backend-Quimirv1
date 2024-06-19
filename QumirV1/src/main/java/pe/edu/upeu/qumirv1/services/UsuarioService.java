package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.models.Usuario;

public interface UsuarioService {
    Usuario registerUser(Usuario usuario);
    Usuario loginUser(String email, String password);
    Usuario getUsuarioById(Long id); // Nuevo método
}



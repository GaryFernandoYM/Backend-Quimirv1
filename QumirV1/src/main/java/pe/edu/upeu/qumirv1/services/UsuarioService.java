package pe.edu.upeu.qumirv1.services;

import pe.edu.upeu.qumirv1.dtos.UsuarioDto;
import pe.edu.upeu.qumirv1.models.Usuario;

public interface UsuarioService {
    Usuario register(UsuarioDto usuarioDto);
    Usuario login(UsuarioDto usuarioDto);
    Usuario getUsuarioById(Long id);
}

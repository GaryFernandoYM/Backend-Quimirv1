package pe.edu.upeu.qumirv1.dtos;

import lombok.Data;

@Data
public class UsuarioDto {
    private String email;
    private String password;
    private String fullName;
}

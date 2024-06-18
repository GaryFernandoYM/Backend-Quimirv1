package pe.edu.upeu.qumirv1.models;

//no es necesario poner el nombre de la tabla ya que por defecto se pone 
//si quieres que el modelo se cree con diferente nombre en ese caso si deverias poner el nombre de la tabla

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Entity
@Data
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre_recompensa;
    private String descripcion;
    private String puntos_necesarios;
    private String foto;
    private Date fecha_creacion;
    private Date fecha_expiracion;

    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at = LocalDateTime.now();

    @PreUpdate
    private void preUpdate() {
        updated_at = LocalDateTime.now();
    }
}
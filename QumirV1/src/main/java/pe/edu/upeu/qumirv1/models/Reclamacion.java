package pe.edu.upeu.qumirv1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *
 * @author Fernando
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Reclamacion")
public class Reclamacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario", nullable = false, length = 255)
    private String id_usuario;

    @Column(name = "id_recompensa", nullable = false, length = 255)
    private String id_recompensa;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_reclamacion", nullable = false)
    private LocalDateTime fechaReclamacion;

    @Column(name = "estado", nullable = false, length = 255)
    private String estado;


}

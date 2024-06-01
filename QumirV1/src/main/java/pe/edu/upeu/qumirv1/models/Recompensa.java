package pe.edu.upeu.qumirv1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Recompensas")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_recompensa", nullable = false, length = 100)
    private String nombreRecompensa;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "puntos_necesarios", nullable = false)
    private int puntosNecesarios;

   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private String fechaCreacion;
    //LocalDateTime

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate fechaExpiracion;
}

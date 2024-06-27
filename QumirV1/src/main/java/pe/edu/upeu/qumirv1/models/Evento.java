package pe.edu.upeu.qumirv1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data


@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nombre_evento", nullable = false, length = 100)
    private String nombreEvento;

    @NotNull
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "fecha_evento")
    private LocalDateTime fechaEvento;

    @NotNull
    @Column(name = "ubicacion", nullable = false, length = 150)
    private String ubicacion;

    @NotNull
    @Column(name = "organizador", nullable = false, length = 100)
    private String organizador;

    @NotNull
    @Column(name = "capacidad_maxima", nullable = false)
    private int capacidadMaxima;

    @NotNull
    @Column(name = "puntos", nullable = false)
    private int puntos;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @NotNull
    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;
}

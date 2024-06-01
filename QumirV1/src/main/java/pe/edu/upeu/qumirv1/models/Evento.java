package pe.edu.upeu.qumirv1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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

    @Column(name = "nombre_evento", nullable = false, length = 100)
    private String nombreEvento;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_evento", nullable = false)
    private String fechaEvento;
    //LocalDateTime

    @Column(name = "ubicacion", nullable = false, length = 255)
    private String ubicacion;

    @Column(name = "organizador", nullable = false, length = 100)
    private String organizador;

    @Column(name = "capacidad_maxima", nullable = false)
    private int capacidadMaxima;

    @Column(name = "puntos", nullable = false)
    private int puntos;

   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private String fechaCreacion;
    //LocalDateTime

    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;
}

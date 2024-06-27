package pe.edu.upeu.qumirv1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entidad que representa un comentario realizado por un usuario.
 * Los comentarios pueden estar asociados a eventos o noticias.
 *
 * Funcionalidad: Almacena comentarios de los usuarios sobre eventos, noticias y otros elementos.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Integer     idUsuario;

    @Column(name = "id_evento")
    private Integer idEvento;

    @Column(name = "id_noticia")
    private Integer idNoticia;

    @Column(name = "comentario", nullable = false, columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_comentario", nullable = false)
    private LocalDateTime fechaComentario;
}

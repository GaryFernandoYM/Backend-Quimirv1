package pe.edu.upeu.qumirv1.models;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "Reclamacion")
public class Reclamacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String estado;
    private Date fecha_reclamo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recompensa_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Recompensa recompensa;

}

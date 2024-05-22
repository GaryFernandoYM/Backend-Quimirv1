package pe.edu.upeu.qumirv1.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reclamaciones")
public class Reclamacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reclamacion")
    private Long idReclamacion;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_recompensa")
    private Long idRecompensa;

    @Column(name = "fecha_reclamacion")
    private LocalDateTime fechaReclamacion;

    @Column(name = "estado", length = 50)
    private String estado;

    // Constructor, getters y setters

    public Reclamacion() {
    }

    public Reclamacion(Long idUsuario, Long idRecompensa, LocalDateTime fechaReclamacion, String estado) {
        this.idUsuario = idUsuario;
        this.idRecompensa = idRecompensa;
        this.fechaReclamacion = fechaReclamacion;
        this.estado = estado;
    }

    public Long getIdReclamacion() {
        return idReclamacion;
    }

    public void setIdReclamacion(Long idReclamacion) {
        this.idReclamacion = idReclamacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(Long idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public LocalDateTime getFechaReclamacion() {
        return fechaReclamacion;
    }

    public void setFechaReclamacion(LocalDateTime fechaReclamacion) {
        this.fechaReclamacion = fechaReclamacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

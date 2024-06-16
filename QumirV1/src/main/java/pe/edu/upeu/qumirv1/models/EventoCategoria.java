package pe.edu.upeu.qumirv1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Eventos_Categorias")
public class EventoCategoria {

    @EmbeddedId
    private EventoCategoriaId id;

    @ManyToOne
    @MapsId("idEvento")
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @ManyToOne
    @MapsId("idCategoria")
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class EventoCategoriaId implements Serializable {

        private static final long serialVersionUId = 1L;

        @Column(name = "id_evento")
        private Long idEvento;

        @Column(name = "id_categoria")
        private Long idCategoria;

        @Override
        public int hashCode() {
            return java.util.Objects.hash(idEvento, idCategoria);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            EventoCategoriaId that = (EventoCategoriaId) obj;
            return idEvento.equals(that.idEvento) && idCategoria.equals(that.idCategoria);
        }
    }
}

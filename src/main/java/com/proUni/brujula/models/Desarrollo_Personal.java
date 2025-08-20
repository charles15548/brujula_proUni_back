package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "desarrollo_personal")
public class Desarrollo_Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String contenido;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo_Desarrollo_Personal tipo_Desarrollo_Personal;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion = LocalDateTime.now();

    @Column(name = "url")
    private String url;

    public Desarrollo_Personal(String titulo, String contenido, Long id_tipo, String url) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.url = url;
    }
}

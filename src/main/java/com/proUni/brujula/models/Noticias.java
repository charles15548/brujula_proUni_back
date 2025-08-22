package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "noticias")
public class Noticias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String contenido;
    
    private String fuente;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion = LocalDateTime.now();

    @Column(name = "imagen_url")
    private String imagenUrl;

    public Noticias() {}

    public Noticias(String titulo, String contenido,String fuente, String imagenUrl) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fuente = fuente;
        this.imagenUrl = imagenUrl;
    }
}

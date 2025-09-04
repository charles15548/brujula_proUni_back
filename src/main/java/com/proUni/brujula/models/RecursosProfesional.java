package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "recursos_profesionales")
public class RecursosProfesional{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private String link;
    
    private String nombre;
    
    private String img;
    
    @Column(name = "d_profesional_id", nullable = false)
    private Long dpId;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public RecursosProfesional() {};
    public RecursosProfesional(String titulo, String descripcion, String link, String nombre, String img, Long dpId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link = link;
        this.nombre = nombre;
        this.img = img;
        this.dpId = dpId;
    }
	

     

}

package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "testimonios")
public class Testimonios{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private String img;
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "d_profesional_id")
    private DesarrolloProfesional desarrolloProfesional;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public 	Testimonios() {};
	

     

}

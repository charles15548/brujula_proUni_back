package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "uni_top")
public class UniTop{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;
    
    private String img;
    
    @ManyToOne
    @JoinColumn(name = "d_profesional_id")
    private DesarrolloProfesional desarrolloProfesional;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public 	UniTop() {};
	

     

}

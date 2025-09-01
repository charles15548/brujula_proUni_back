package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "bolsa_trabajo")
public class BolsaTrabajo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String empresa;

    private String link;
    
    private String img;
    
    @ManyToOne
    @JoinColumn(name = "d_profesional_id")
    private DesarrolloProfesional desarrolloProfesional;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public 	BolsaTrabajo() {};
	

     

}

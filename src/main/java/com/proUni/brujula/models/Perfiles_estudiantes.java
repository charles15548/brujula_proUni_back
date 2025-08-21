package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "perfiles_estudiante")
public class Perfiles_estudiantes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;

    private String apellidos;

    private String carrera;
    
    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Auth_estudiantes estudiante;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public Perfiles_estudiantes() {};
	public Perfiles_estudiantes(String nombres, String apellidos, String carrera, Auth_estudiantes estudiante,
			LocalDateTime fechaRegistro) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.carrera = carrera;
		this.estudiante = estudiante;
		this.fechaRegistro = fechaRegistro;
	}

     

}

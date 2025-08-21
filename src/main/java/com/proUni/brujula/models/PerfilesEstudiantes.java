package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "perfiles_estudiante")
public class PerfilesEstudiantes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;

    private String apellidos;

    private String carrera;
    
    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private AuthEstudiantes estudiante;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public PerfilesEstudiantes() {};
	public PerfilesEstudiantes(String nombres, String apellidos, String carrera, AuthEstudiantes estudiante,
			LocalDateTime fechaRegistro) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.carrera = carrera;
		this.estudiante = estudiante;
		this.fechaRegistro = fechaRegistro;
	}

     

}

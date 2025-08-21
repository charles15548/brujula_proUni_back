package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "auth_admins")
public class Auth_administradores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String password;

    @Column(name = "fecha_registro", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime fechaRegistro = LocalDateTime.now();
    
    public Auth_administradores() {};

	public Auth_administradores(String nombre, String correo, String password, LocalDateTime fechaRegistro) {
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
	}
	

}

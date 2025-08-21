package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tipo_desarrollo_personal")
public class Tipo_Desarrollo_Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    
    public Tipo_Desarrollo_Personal() {}

	public Tipo_Desarrollo_Personal(String descripcion) {
		this.descripcion = descripcion;
	}
    
}

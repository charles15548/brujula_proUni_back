package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "tipo_desarrollo_personal")
public class TipoDesarrolloPersonal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    
    public TipoDesarrolloPersonal() {}

	public TipoDesarrolloPersonal(String descripcion) {
		this.descripcion = descripcion;
	}
    
}

package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "recursos_personales")
public class RecursosPersonal {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String titulo;

	    private String descripcion;

	    private String link;
	    
	    private String img;
	    
	    @ManyToOne
	    @JoinColumn(name = "desarrollo_id")
	    private DesarrolloPersonal desarrolloPersonal;

	    @Column(name = "fecha_publicacion")
	    private LocalDateTime fechaRegistro = LocalDateTime.now();

	    public 	RecursosPersonal() {};
		


}

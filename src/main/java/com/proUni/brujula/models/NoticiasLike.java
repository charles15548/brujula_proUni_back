package com.proUni.brujula.models;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "noticias_likes")
public class NoticiasLike {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "noticia_id", nullable = false)
	    private Long noticiaId;

	    @Column(name = "estudiante_id", nullable = false)
	    private Long estudianteId;

	    @Column(name = "fecha_like")
	    private LocalDateTime fechaLike = LocalDateTime.now();

	    public NoticiasLike() {}

	    public NoticiasLike(Long noticiaId, Long estudianteId) {
	        this.noticiaId = noticiaId;
	        this.estudianteId = estudianteId;
	    }
   
}

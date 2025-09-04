package com.proUni.brujula.serviceImplement;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.RecursosProfesional;
import com.proUni.brujula.models.Noticias;
import com.proUni.brujula.models.NoticiasLike;
import com.proUni.brujula.repository.RecursoProfesionalRepository;
import com.proUni.brujula.repository.NoticiaLikeRepository;
import com.proUni.brujula.repository.NoticiasRepository;
import com.proUni.brujula.service.RecursoProfesionalService;
import com.proUni.brujula.service.NoticiasService;

import DTO.NoticiasProjection;

@Service
public class RecursoProfesionalSI implements RecursoProfesionalService{

	@Autowired
	private RecursoProfesionalRepository dao;
	
	private final String SUPABASE_URL = "https://ykayyxqcplawwwyjqbrq.supabase.co";
    private final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlrYXl5eHFjcGxhd3d3eWpxYnJxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTU2MjE2MDYsImV4cCI6MjA3MTE5NzYwNn0.hrKC7HNWdM-AcFBAx1_PAOVE6gzhwrkHXwhLfLqyJ9k";
    private final String BUCKET = "img/noticias"; 

	
	
	 
	 
	 
	@Override
	public ResponseEntity<Map<String, Object>> listarHerramientasProfesional() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<Map<String, Object>> crearHerramientasProfesional(String titulo, String gancho,
			String contenido, String fuente, MultipartFile imagen) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<Map<String, Object>> actualizarHerramientasProfesional(Long id, String gancho, String titulo,
			String contenido, String fuente, MultipartFile imagen) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<Map<String, Object>> eliminarHerramientasProfesional(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<Map<String, Object>> listarHerramientasProfesionalPorTipo(Long userId) {
		 Map<String, Object> respuesta = new HashMap<>();
	        List<RecursosProfesional> herramienta = dao.findByDesarrolloProfesionalId(userId);

	        if (herramienta.isEmpty()) {
	            respuesta.put("mensaje", "No existen registros");
	            respuesta.put("status", HttpStatus.NOT_FOUND);
	            respuesta.put("fecha", new Date());
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	        }

	        respuesta.put("mensaje", "Listado");
	        respuesta.put("herramienta", herramienta);
	        respuesta.put("status", HttpStatus.OK);
	        respuesta.put("fecha", new Date());
	        return ResponseEntity.ok(respuesta);
	}


	

	
}

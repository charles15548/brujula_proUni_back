package com.proUni.brujula.serviceImplement;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.BolsaTrabajo;
import com.proUni.brujula.models.DesarrolloPersonal;
import com.proUni.brujula.repository.BolsaTrabajoRepository;
import com.proUni.brujula.service.BolsaTrabajoService;

@Service
public class BolsaTrabajoSI implements BolsaTrabajoService{

	@Autowired
	private BolsaTrabajoRepository repo;
	
	private final String SUPABASE_URL = "https://ykayyxqcplawwwyjqbrq.supabase.co";
    private final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlrYXl5eHFjcGxhd3d3eWpxYnJxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTU2MjE2MDYsImV4cCI6MjA3MTE5NzYwNn0.hrKC7HNWdM-AcFBAx1_PAOVE6gzhwrkHXwhLfLqyJ9k";
    private final String BUCKET = "desarrolloProfesional/bolsa"; 

	@Override
	public ResponseEntity<Map<String, Object>> listarBolsaTrabajo() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<BolsaTrabajo> bolsaTrabajos = repo.findAll();
		
		if(!bolsaTrabajos.isEmpty()) {
			respuesta.put("mensaje", "Lista bolsa trabajo");
			respuesta.put("bolsaTrabajo", bolsaTrabajos);
			respuesta.put("status", HttpStatus.OK);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		}else {
			respuesta.put("mensaje", "No existen registros");
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> crearBolsaTrabajo(String titulo, String empresa, String link,
			MultipartFile img, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Map<String, Object>> actualizarBolsaTrabajo(Long id, DesarrolloPersonal desarrollo_Personal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Map<String, Object>> eliminarBolsaTrabajo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}

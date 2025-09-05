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
import com.proUni.brujula.models.servicios;
import com.proUni.brujula.models.DesarrolloProfesional;
import com.proUni.brujula.models.Noticias;
import com.proUni.brujula.models.NoticiasLike;
import com.proUni.brujula.repository.RecursoProfesionalRepository;
import com.proUni.brujula.repository.ServiciosRepository;
import com.proUni.brujula.repository.NoticiaLikeRepository;
import com.proUni.brujula.repository.NoticiasRepository;
import com.proUni.brujula.service.RecursoProfesionalService;
import com.proUni.brujula.service.ServicioService;
import com.proUni.brujula.service.NoticiasService;

import DTO.NoticiasProjection;
import com.proUni.brujula.serviceImplement.Utilitarios;
@Service
public class ServiciosSI implements ServicioService{

	@Autowired
	private ServiciosRepository dao;
	
	
	

	@Override
	public ResponseEntity<Map<String, Object>> listarServiciosPorTipo(String tipo) {
		Map<String, Object> respuesta = new HashMap<>();
		List<servicios> s = dao.findByTipo(tipo);
		
		if(s.isEmpty()) {
			respuesta.put("mensaje", "No existen registros");
            respuesta.put("status", HttpStatus.NOT_FOUND);
            respuesta.put("fecha", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
		respuesta.put("mensaje", "Listado");
        respuesta.put("servicio", s);
        respuesta.put("status", HttpStatus.OK);
        respuesta.put("fecha", new Date());
        return ResponseEntity.ok(respuesta);
	}

	@Override
	public ResponseEntity<Map<String, Object>> listarServiciosPorFacultad(String facultad) {
		Map<String, Object> respuesta = new HashMap<>();
		List<servicios> s = dao.findByFacultad(facultad);
		
		if(s.isEmpty()) {
			respuesta.put("mensaje", "No existen registros");
            respuesta.put("status", HttpStatus.NOT_FOUND);
            respuesta.put("fecha", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
		respuesta.put("mensaje", "Listado");
        respuesta.put("servicio", s);
        respuesta.put("status", HttpStatus.OK);
        respuesta.put("fecha", new Date());
        return ResponseEntity.ok(respuesta);
	}

	@Override
	public ResponseEntity<Map<String, Object>> listarServiciosPorTipoYFacultad(String tipo, String facultad) {
		Map<String, Object> respuesta = new HashMap<>();
		List<servicios> s = dao.findByTipoAndFacultad(tipo,facultad);
		
		if(s.isEmpty()) {
			respuesta.put("mensaje", "No existen registros");
            respuesta.put("status", HttpStatus.NOT_FOUND);
            respuesta.put("fecha", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
		respuesta.put("mensaje", "Listado");
        respuesta.put("servicio", s);
        respuesta.put("status", HttpStatus.OK);
        respuesta.put("fecha", new Date());
        return ResponseEntity.ok(respuesta);
	}

	
}

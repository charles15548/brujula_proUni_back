package com.proUni.brujula.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.Desarrollo_Personal;
import com.proUni.brujula.models.Noticias;

public interface DesarrolloPersonalService {
	public ResponseEntity<Map<String, Object>> listarDesarrolloPersonal();
	public ResponseEntity<Map<String, Object>> crearDesarrolloPersonal(String titulo, String contenido, Long id_tipo,MultipartFile imagen);
    public ResponseEntity<Map<String, Object>> actualizarDesarrolloPersonal(Long id, Desarrollo_Personal desarrollo_Personal);
    public ResponseEntity<Map<String, Object>> eliminarDesarrolloPersonal(Long id);
}



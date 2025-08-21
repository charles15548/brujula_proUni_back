package com.proUni.brujula.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.DesarrolloPersonal;

public interface DesarrolloPersonalService {
	public ResponseEntity<Map<String, Object>> listarDesarrolloPersonal();
	public ResponseEntity<Map<String, Object>> crearDesarrolloPersonal(String titulo, String contenido, Long idTipo,MultipartFile imagen);
    public ResponseEntity<Map<String, Object>> actualizarDesarrolloPersonal(Long id, DesarrolloPersonal desarrollo_Personal);
    public ResponseEntity<Map<String, Object>> eliminarDesarrolloPersonal(Long id);
}



package com.proUni.brujula.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.DesarrolloPersonal;

public interface BolsaTrabajoService {

	public ResponseEntity<Map<String, Object>> listarBolsaTrabajo();
	public ResponseEntity<Map<String, Object>> crearBolsaTrabajo(String titulo, String empresa,String link,MultipartFile img, Long id);
    public ResponseEntity<Map<String, Object>> actualizarBolsaTrabajo(Long id, DesarrolloPersonal desarrollo_Personal);
    public ResponseEntity<Map<String, Object>> eliminarBolsaTrabajo(Long id);


}



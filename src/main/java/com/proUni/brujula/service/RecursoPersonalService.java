package com.proUni.brujula.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.Noticias;

public interface RecursoPersonalService {
	public ResponseEntity<Map<String, Object>> listarRecursosPersonales();
	ResponseEntity<Map<String, Object>> listarRecursosPersonalesPorTipo(Long tipoId);

}



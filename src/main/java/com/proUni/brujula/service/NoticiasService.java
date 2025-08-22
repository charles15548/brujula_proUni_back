package com.proUni.brujula.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.Noticias;

public interface NoticiasService {
	public ResponseEntity<Map<String, Object>> listarNoticias();
	public ResponseEntity<Map<String, Object>> crearNoticia(String titulo, String contenido,String fuente, MultipartFile imagen);
    public ResponseEntity<Map<String, Object>> actualizarNoticia(Long id, String titulo, String contenido,String fuente,MultipartFile imagen);
    public ResponseEntity<Map<String, Object>> eliminarNoticia(Long id);
}



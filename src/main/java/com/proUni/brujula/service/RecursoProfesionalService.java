package com.proUni.brujula.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.DesarrolloProfesional;
import com.proUni.brujula.models.Noticias;

public interface RecursoProfesionalService {
	public ResponseEntity<Map<String, Object>> listarHerramientasProfesional();
	
	public ResponseEntity<Map<String, Object>> crearHerramientasProfesional(String titulo,String descripcion, String link,String nombre, MultipartFile imagen, Long dpId);
    public ResponseEntity<Map<String, Object>> actualizarHerramientasProfesional(Long id, String titulo, String descripcion, String link,String nombre, MultipartFile imagen,Long dpId);
    public ResponseEntity<Map<String, Object>> eliminarHerramientasProfesional(Long id);
    
    /* NOTICIA */
    ResponseEntity<Map<String, Object>> listarHerramientasProfesionalPorTipo(Long userId);
}



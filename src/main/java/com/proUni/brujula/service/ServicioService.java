package com.proUni.brujula.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface ServicioService {
    public ResponseEntity<Map<String, Object>> listarServiciosPorTipo(String tipo);

    public ResponseEntity<Map<String, Object>> listarServiciosPorFacultad(String facultad);
    
    public ResponseEntity<Map<String, Object>> listarServiciosPorTipoYFacultad(String tipo,String facultad);
    
}



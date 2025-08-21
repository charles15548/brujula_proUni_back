package com.proUni.brujula.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.DesarrolloPersonal;
import com.proUni.brujula.service.DesarrolloPersonalService;

@RestController
@RequestMapping("/api/desarrollo_personal")
@CrossOrigin(origins = {"http://localhost:3000", "https://soporte2.intelectiasac.com"})
public class DesarrolloPersonalController {

    @Autowired
    private DesarrolloPersonalService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarDesarrolloPersonal() {
        return service.listarDesarrolloPersonal();
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, Object>> crearDesarrolloPersonal(
    		@RequestParam("titulo") String titulo,
    		@RequestParam("contenido") String contenido,
    		@RequestParam("idTipo") Long idTipo,
    		@RequestParam("imagen") MultipartFile imagen) {
        return service.crearDesarrolloPersonal(titulo,contenido,idTipo,imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizarDesarrolloPersonal(@PathVariable Long id, @RequestBody DesarrolloPersonal desaPersonal) {
        return service.actualizarDesarrolloPersonal(id, desaPersonal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarDesarrolloPersonal(@PathVariable Long id) {
        return service.eliminarDesarrolloPersonal(id);
    }
}


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

import com.proUni.brujula.models.Noticias;
import com.proUni.brujula.service.NoticiasService;

@RestController
@RequestMapping("/api/noticias")
@CrossOrigin(origins = {"http://localhost:3000", "https://soporte2.intelectiasac.com"})
public class NoticiasController {

    @Autowired
    private NoticiasService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarNoticias() {
        return service.listarNoticias();
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Map<String, Object>> crearNoticia(
    		@RequestParam("titulo") String titulo,
    		@RequestParam("contenido") String contenido,
    		@RequestParam("imagen") MultipartFile imagen) {
        return service.crearNoticia(titulo,contenido,imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizarNoticia(@PathVariable Long id, @RequestBody Noticias noticia) {
        return service.actualizarNoticia(id, noticia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarNoticia(@PathVariable Long id) {
        return service.eliminarNoticia(id);
    }
}


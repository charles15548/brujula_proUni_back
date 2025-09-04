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
import com.proUni.brujula.service.RecursoProfesionalService;
import com.proUni.brujula.service.NoticiasService;
import com.proUni.brujula.service.RecursoPersonalService;

@RestController
@RequestMapping("/api/recursoPersonal")
@CrossOrigin(origins = {"http://localhost:3000", "https://soporte2.intelectiasac.com"})
public class RecursoPersonalController {

    @Autowired
    private RecursoPersonalService service;

    
    @GetMapping
    public ResponseEntity<Map<String, Object>> listarRecursoPersonalPorTipo(@RequestParam Long tipo) {
        return service.listarRecursosPersonalesPorTipo(tipo);
    }

   
    
}


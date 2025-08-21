package com.proUni.brujula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proUni.brujula.serviceImplement.AuthEstudianteSI;

@RestController
@RequestMapping("/api/authEstudiante")
@CrossOrigin(origins = {"http://localhost:3000", "https://soporte2.intelectiasac.com"})
public class AuthEstudiantesController {
	
	@Autowired
	AuthEstudianteSI authService;
	
	 @PostMapping("/login")
	    public String login(
	            @RequestParam String correo,
	            @RequestParam String password
	    ) {
	        return authService.login(correo, password);
	  }

}

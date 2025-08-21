package com.proUni.brujula.serviceImplement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proUni.brujula.models.AuthEstudiantes;
import com.proUni.brujula.repository.AuthEstudianteRespository;

@Service
public class AuthEstudianteSI {
	
	@Autowired
    private AuthEstudianteRespository repository;

	
	public String login(String correo, String password) {
	    	Optional<AuthEstudiantes> opt = repository.findByCorreo(correo);

	        if (opt.isEmpty()) {
	            return "❌ Correo no registrado";
	        }

	        AuthEstudiantes estudiante = opt.get();

	        if (password.equals(estudiante.getPassword())) {
	            return "✅ Login exitoso";
	        } else {
	            return "❌ Contraseña incorrecta";
	        }
	  }
}

package com.proUni.brujula.serviceImplement;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.BolsaTrabajo;
import com.proUni.brujula.models.DesarrolloPersonal;
import com.proUni.brujula.models.TipsGenerales;
import com.proUni.brujula.repository.BolsaTrabajoRepository;
import com.proUni.brujula.repository.TipsGeneralesRepository;
import com.proUni.brujula.service.BolsaTrabajoService;
import com.proUni.brujula.service.TipsService;

@Service
public class TipsSI implements TipsService{

	@Autowired
	private TipsGeneralesRepository repo;
	




	@Override
	public ResponseEntity<Map<String, Object>> listarTipsGenerales() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<TipsGenerales> tipsGenerales = repo.findAll();
		
		if(!tipsGenerales.isEmpty()) {
			respuesta.put("mensaje", "Lista tips");
			respuesta.put("Tips_Generales", tipsGenerales);
			respuesta.put("status", HttpStatus.OK);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		}else {
			respuesta.put("mensaje", "No existen registros");
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}
	
	
	
}

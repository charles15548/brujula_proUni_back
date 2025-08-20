package com.proUni.brujula.serviceImplement;

import java.lang.StackWalker.Option;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proUni.brujula.models.Desarrollo_Personal;
import com.proUni.brujula.models.Noticias;
import com.proUni.brujula.repository.DesarrolloPersonalRepository;
import com.proUni.brujula.repository.NoticiasRepository;
import com.proUni.brujula.service.DesarrolloPersonalService;
import com.proUni.brujula.service.NoticiasService;

@Service
public class DesarrolloPersonalSI implements DesarrolloPersonalService{

	@Autowired
	private DesarrolloPersonalRepository dao;
	
	private final String SUPABASE_URL = "https://ykayyxqcplawwwyjqbrq.supabase.co";
    private final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlrYXl5eHFjcGxhd3d3eWpxYnJxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTU2MjE2MDYsImV4cCI6MjA3MTE5NzYwNn0.hrKC7HNWdM-AcFBAx1_PAOVE6gzhwrkHXwhLfLqyJ9k";
    private final String BUCKET = "img/desarrolloPersonal"; 

	
	

	@Override
	public ResponseEntity<Map<String, Object>> listarDesarrolloPersonal() {
		Map<String,Object> respuesta = new HashMap<>();	
		List<Desarrollo_Personal> desarrollo_Personal = dao.findAll();
		
		if(!desarrollo_Personal.isEmpty()) {
			respuesta.put("mensaje", "Lista de DP");
			respuesta.put("desarrollo_Personal", desarrollo_Personal);
			respuesta.put("status", HttpStatus.OK);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.OK).body(respuesta);
		}else {
			respuesta.put("mensaje", "No existen registros DP");
			respuesta.put("status", HttpStatus.NOT_FOUND);
			respuesta.put("fecha", new Date());	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
		}
	}

	 
	 
	 private String subirImagen(MultipartFile imagen, String filename) throws Exception {
	        String uploadUrl = SUPABASE_URL + "/storage/v1/object/" + BUCKET + "/" + filename;
	        
	        System.out.println("URL de subida: " + uploadUrl);
	        System.out.println("Tamaño archivo: " + imagen.getSize() + " bytes");
	        System.out.println("Tipo de archivo: " + imagen.getContentType());
	        
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(uploadUrl))
	                .header("Authorization", "Bearer " + SUPABASE_KEY)
	                .header("Content-Type", imagen.getContentType())
	                .header("x-upsert", "true")
	                .POST(HttpRequest.BodyPublishers.ofByteArray(imagen.getBytes()))
	                .build();

	        HttpResponse<String> response = HttpClient.newHttpClient()
	                .send(request, HttpResponse.BodyHandlers.ofString());
	        
	        System.out.println("Status Code: " + response.statusCode());
	        System.out.println("Respuesta: " + response.body());
	        
	        if (response.statusCode() != 200 && response.statusCode() != 201) {
	            throw new RuntimeException("Error al subir imagen. Status: " + response.statusCode() + " - " + response.body());
	        }
	        
	        return SUPABASE_URL + "/storage/v1/object/public/" + BUCKET + "/" + filename;
	    }




	@Override
	public ResponseEntity<Map<String, Object>> crearDesarrolloPersonal(String titulo, String contenido, Long idTipo,
			MultipartFile imagen) {
		Map<String, Object> respuesta = new HashMap<>();
        
        try {
            // Subir imagen
            String filename = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
            String Url = subirImagen(imagen, filename);

            // Guardar noticia
            Desarrollo_Personal desarrollo_Personal = new Desarrollo_Personal(titulo, contenido,idTipo, Url);
            Desarrollo_Personal nueva = dao.save(desarrollo_Personal);
            
            respuesta.put("mensaje", "dp creada con éxito");
            respuesta.put("desarrollo_Personal", nueva);
            return ResponseEntity.ok(respuesta);
            
        } catch (Exception e) {
            respuesta.put("mensaje", "Error: " + e.getMessage());
            return ResponseEntity.badRequest().body(respuesta);
        }
	}


	@Override
	public ResponseEntity<Map<String, Object>> actualizarDesarrolloPersonal(Long id,
	        Desarrollo_Personal desarrollo_Personal) {

	    Map<String, Object> respuesta = new HashMap<>();
	    Optional<Desarrollo_Personal> existe = dao.findById(id);

	    if (existe.isPresent()) {
	        Desarrollo_Personal dp = existe.get();
	        dp.setTitulo(desarrollo_Personal.getTitulo());
	        dp.setContenido(desarrollo_Personal.getContenido());
	        dp.setTipo_Desarrollo_Personal(desarrollo_Personal.getTipo_Desarrollo_Personal());
	        dp.setUrl(desarrollo_Personal.getUrl());
	        // Opcional: actualizar la fecha si quieres reflejar la modificación
	        dp.setFechaPublicacion(LocalDateTime.now());

	        dao.save(dp);

	        respuesta.put("mensaje", "Desarrollo Personal actualizado con éxito");
	        respuesta.put("desarrolloPersonal", dp);
	        respuesta.put("status", HttpStatus.OK.value());
	        respuesta.put("fecha", new Date());
	        return ResponseEntity.ok(respuesta);

	    } else {
	        respuesta.put("mensaje", "No se encontró el Desarrollo Personal para actualizar");
	        respuesta.put("status", HttpStatus.NOT_FOUND.value());
	        respuesta.put("fecha", new Date());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	    }
	}




	@Override
	public ResponseEntity<Map<String, Object>> eliminarDesarrolloPersonal(Long id) {
		Map<String, Object> respuesta = new HashMap<>();
        Optional<Desarrollo_Personal> desarrollo_Personal = dao.findById(id);

        if (desarrollo_Personal.isPresent()) {
            dao.deleteById(id);
            respuesta.put("mensaje", "DP eliminada con éxito");
            respuesta.put("status", HttpStatus.OK.value());
            respuesta.put("fecha", new Date());
            return ResponseEntity.ok(respuesta);
        } else {
            respuesta.put("mensaje", "No se encontró la DP para eliminar");
            respuesta.put("status", HttpStatus.NOT_FOUND.value());
            respuesta.put("fecha", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }
	}

	
}

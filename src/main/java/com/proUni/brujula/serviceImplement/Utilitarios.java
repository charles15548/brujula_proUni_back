package com.proUni.brujula.serviceImplement;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.multipart.MultipartFile;

public class Utilitarios {
	private final String SUPABASE_URL = "https://ykayyxqcplawwwyjqbrq.supabase.co";
	private final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlrYXl5eHFjcGxhd3d3eWpxYnJxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTU2MjE2MDYsImV4cCI6MjA3MTE5NzYwNn0.hrKC7HNWdM-AcFBAx1_PAOVE6gzhwrkHXwhLfLqyJ9k"; 
	public String subirImagen(MultipartFile imagen, String filename, String BUCKET) throws Exception {
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
	
	 public void eliminarImagenSupabase(String filename, String BUCKET) throws Exception {
		    String deleteUrl = SUPABASE_URL + "/storage/v1/object/" + BUCKET + "/" + filename;

		    HttpRequest request = HttpRequest.newBuilder()
		            .uri(URI.create(deleteUrl))
		            .header("Authorization", "Bearer " + SUPABASE_KEY)
		            .DELETE()
		            .build();

		    HttpResponse<String> response = HttpClient.newHttpClient()
		            .send(request, HttpResponse.BodyHandlers.ofString());

		    if (response.statusCode() != 200 && response.statusCode() != 204) {
		        throw new RuntimeException("Error al eliminar imagen en Supabase. Status: " 
		                                   + response.statusCode() + " - " + response.body());
		    }
		}
	 
}

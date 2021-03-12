package com.RecetasParaTodos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecetasParaTodos.model.entity.Ingrediente;
import com.RecetasParaTodos.repo.IngredienteRepository;
import com.RecetasParaTodos.service.IngredienteService;

@CrossOrigin
@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

	// Repositorio
	@Autowired
	public IngredienteRepository repo;
	
	// Servicio
	public IngredienteService servicio;
	
	// Obtener todos los ingredientes ordenados alfabéticamente
	@GetMapping
	public ResponseEntity<?> getIngredientes()
	{
		ResponseEntity<?> response;
		try
		{
			List<Ingrediente> ingredientes = repo.findAllOrderedByDescripcion();
			List<String> lista = servicio.getListaString(ingredientes);
			response = ResponseEntity.ok(lista);
		}
		catch(Exception e)
		{
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}
	
	// Añadir un ingrediente
	@PostMapping
	public ResponseEntity<?> addIngrediente(@RequestBody Ingrediente ingrediente)
	{
		ResponseEntity<?> response;
		try
		{
			if(servicio.ingredienteExiste(ingrediente.getDescripcion()))
			{
				response = ResponseEntity.ok(repo.save(ingrediente));
			}
			else
			{
				response = ResponseEntity.status(HttpStatus.CONFLICT).body("El ingrediente ya existe");
			}
		}
		catch(Exception e)
		{
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}	
}
package com.RecetasParaTodos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecetasParaTodos.model.entity.Nacionalidad;
import com.RecetasParaTodos.repo.NacionalidadRepository;

@CrossOrigin
@RestController
@RequestMapping("/nacionalidad")
public class NacionalidadController
{
	@Autowired
	private NacionalidadRepository repo;

	// Obtener todas las nacionalidades ordenadas alfabeticamente
	@GetMapping
	public ResponseEntity<?> getNacionalidad()
	{
		ResponseEntity<?> response;
		try
		{
			List<Nacionalidad> nacionalidades = repo.findAllOrderedByDescripcion();
			response = ResponseEntity.ok(nacionalidades);
		}
		catch (Exception e)
		{
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}

	@PostMapping
	public ResponseEntity<?> addNacionalidad(@RequestBody Nacionalidad nacionalidad)
	{
		ResponseEntity<?> response;
		try
		{
			response = ResponseEntity.ok(repo.save(nacionalidad));
		}
		catch (Exception e)
		{
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}
}

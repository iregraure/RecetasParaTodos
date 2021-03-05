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

import com.RecetasParaTodos.model.entity.Categoria;
import com.RecetasParaTodos.repo.CategoriaRepository;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repo;
	
	// Obtener todas las categorias
	@GetMapping
	public ResponseEntity<?> getCategorias()
	{
		ResponseEntity<?> response;
		try
		{
			List<Categoria> categorias = (List<Categoria>) repo.findAll();
			response = ResponseEntity.ok(categorias);
		}
		catch(Exception e)
		{
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}
	
	// Crear una categoría
	@PostMapping
	public ResponseEntity<?> addCategoria(@RequestBody Categoria categoria)
	{
		ResponseEntity<?> response;
		try
		{
			response = ResponseEntity.ok(repo.save(categoria));
		}
		catch(Exception e)
		{
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}
	
}

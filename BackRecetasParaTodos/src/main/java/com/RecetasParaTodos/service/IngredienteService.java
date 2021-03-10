package com.RecetasParaTodos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecetasParaTodos.model.entity.Ingrediente;
import com.RecetasParaTodos.repo.IngredienteRepository;

@Service
public class IngredienteService {

	// Repositorio
	@Autowired
	private IngredienteRepository repo;
	
	// Método para comprobar si un ingrediente ya existe
	public boolean ingredienteExiste(String descripcion)
	{
		boolean existe = false;
		Ingrediente ingrediente = repo.findIngredienteByDescripcion(descripcion);
		if(ingrediente != null)
		{
			existe = true;
		}
		return existe;
	}
	
}

package com.RecetasParaTodos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecetasParaTodos.model.entity.Categoria;
import com.RecetasParaTodos.repo.CategoriaRepository;

@Service
public class CategoriaService {

	// Repositorio
	@Autowired
	private CategoriaRepository repo;
	
	// Método para comprobar si una categoría ya existe
	public boolean categoriaExiste(String descripcion)
	{
		boolean existe = false;
		Categoria cat = repo.findCategoriaByDescripcion(descripcion);
		if(cat != null)
		{
			existe = true;
		}
		return existe;
	}
	
}

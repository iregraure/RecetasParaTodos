package com.RecetasParaTodos.service;

import java.util.ArrayList;
import java.util.List;

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
	
	// Método que convierte una lista de String en una lista de ingrediente
	public List<Ingrediente> getListaIngredientes(List<String> ingredientes)
	{
		List<Ingrediente> lista = new ArrayList<Ingrediente>();
		for (String ingrediente : ingredientes) 
		{
			Ingrediente ingr = repo.findIngredienteByDescripcion(ingrediente);
			lista.add(ingr);
		}
		return lista;
	}
	
	//	Método que convierte una lista de ingredientes en una lista de String
	public List<String> getListaString(List<Ingrediente> ingredientes)
	{
		List<String> lista = new ArrayList<String>();
		for (Ingrediente ingrediente: ingredientes)
		{
			lista.add(ingrediente.getDescripcion());
		}
		return lista;
	}
	
}

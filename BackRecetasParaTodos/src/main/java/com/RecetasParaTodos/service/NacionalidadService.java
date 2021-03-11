package com.RecetasParaTodos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecetasParaTodos.model.entity.Nacionalidad;
import com.RecetasParaTodos.repo.NacionalidadRepository;

@Service
public class NacionalidadService {

	// Respositorio
	@Autowired
	private NacionalidadRepository repo;
	
	// Método para comprobar si una nacionalidad ya existe
	public boolean nacionalidadExiste(String descripcion)
	{
		boolean existe = false;
		Nacionalidad nacionalidad = repo.findNacionalidadByDescripcion(descripcion);
		if(nacionalidad != null)
		{
			existe = true;
		}
		return existe;
	}
	
}

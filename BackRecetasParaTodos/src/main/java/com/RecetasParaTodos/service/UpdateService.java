package com.RecetasParaTodos.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecetasParaTodos.model.entity.Receta;
import com.RecetasParaTodos.repo.RecetaRepository;

@Service
public class UpdateService
{
	// Repositorio
	@Autowired
	private RecetaRepository repo;

	// Actualizar una receta
	public void updateReceta(Receta original, Receta sent) throws Exception
	{
		// Si el nombre no es igual se comprueba que no existe, si existe se lanza una
		// excepción
		if (!original.getNombre().equalsIgnoreCase(sent.getNombre()))
		{
			Receta existe = repo.findRecetaByNombre(sent.getNombre());
			if (existe != null)
			{
				throw new Exception("Ya existe una receta con ese nombre");
			}
			else
			{
				original.setNombre(sent.getNombre());
			}
		}
		// Para el resto de atributos solo comprueba si es distinto, y en caso
		// afirmativo lo modifica
		// Para comparar la lista de ingredientes primero lo ordenamos y despues las
		// comparamos
		Collections.sort(original.getIngredientes());
		Collections.sort(sent.getIngredientes());
		if (!original.getIngredientes().equals(sent.getIngredientes()))
		{
			original.setIngredientes(sent.getIngredientes());
		}
		if (!original.getPreparacion().equalsIgnoreCase(sent.getPreparacion()))
		{
			original.setPreparacion(sent.getPreparacion());
		}
		if (!original.getTiempoPreparacion().equalsIgnoreCase(sent.getTiempoPreparacion()))
		{
			original.setTiempoPreparacion(sent.getTiempoPreparacion());
		}
		if (original.getRaciones() != sent.getRaciones())
		{
			original.setRaciones(sent.getRaciones());
		}
		if (original.isMicroondas() != sent.isMicroondas())
		{
			original.setMicroondas(sent.isMicroondas());
		}
		if (original.getCategoria() != sent.getCategoria())
		{
			original.setCategoria(sent.getCategoria());
		}
	}
}

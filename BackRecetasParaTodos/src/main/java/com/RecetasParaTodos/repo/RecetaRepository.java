package com.RecetasParaTodos.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RecetasParaTodos.model.entity.Receta;

@Repository
public interface RecetaRepository extends CrudRepository<Receta, Integer>
{
	// Obtener una receta sabiendo su id
	public Receta findRecetaById(int id);
	
	// Obtener todas las recetas de una categoría
	public List<Receta> findRecetaByCategoria(String categoria);
	
	// Obtener todas las recetas que se hacen en el microondas
	public List<Receta> findRecetaByMicroondas(Boolean micro);
	
	// Obtener todas las recetas de un usuario
	public List<Receta> findRecetaByUsuario(int id);
	
	// Obtener una receta sabiendo su nombe
	public Receta findRecetaByNombre(String nombre);
}
package com.RecetasParaTodos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RecetasParaTodos.model.entity.Ingrediente;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer>{
	
	// Buscar todos los ingredientes ordenados por su decripción
	@Query(value = "select * from Ingrediente order by descripcion", nativeQuery = true)
	public List<Ingrediente> findAllOrderedByDescripcion();
	
	// Buscar un ingrediente por su descripción
	public Ingrediente findIngredienteByDescripcion(String descripcion);

}

package com.RecetasParaTodos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RecetasParaTodos.model.entity.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

	public Categoria findCategoriaByDescripcion(String descripcion);
}

package com.RecetasParaTodos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RecetasParaTodos.model.entity.Nacionalidad;

@Repository
public interface NacionalidadRepository extends CrudRepository<Nacionalidad, Integer>
{
	public Nacionalidad findNacionalidadById(int id);
	
	public Nacionalidad findNacionalidadByDescripcion(String descripcion);
	
	@Query(value = "select * from Nacionalidad order by descripcion", nativeQuery = true)
	public List<Nacionalidad> findAllOrderedByDescripcion();
}

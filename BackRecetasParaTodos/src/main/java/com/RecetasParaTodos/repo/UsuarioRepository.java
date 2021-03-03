package com.RecetasParaTodos.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.RecetasParaTodos.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>
{
	// Obtener un usuario a partir de su nombre de usuario
	public Usuario findUsuarioByNombreUsuario(String username);
}
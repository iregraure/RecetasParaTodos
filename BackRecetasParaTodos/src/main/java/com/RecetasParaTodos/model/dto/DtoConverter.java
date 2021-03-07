package com.RecetasParaTodos.model.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RecetasParaTodos.model.entity.Categoria;
import com.RecetasParaTodos.model.entity.Receta;
import com.RecetasParaTodos.model.entity.Usuario;
import com.RecetasParaTodos.repo.CategoriaRepository;
import com.RecetasParaTodos.repo.UsuarioRepository;

@Component
public class DtoConverter {
	
	// Repositorio
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	// Obtener receta a partir del DTO
	public Receta fromRecetaDtoToReceta (RecetaDto dto)
	{
		Usuario usuario = usuarioRepo.findUsuarioByNombreUsuario(dto.getNombreUsuario());
		Categoria categoria = categoriaRepo.findCategoriaByDescripcion(dto.getCategoria());
		Receta receta = new Receta (dto.getNombre(), dto.getIngredientes(), dto.getPreparacion(), dto.getTiempoPreparacion(),
				dto.getRaciones(), dto.isMicroondas(), categoria, usuario);
		return receta;
	}
	
	// Obtener DTO a partir de receta
	public RecetaDto fromRecetaToRecetaDto(Receta receta)
	{
		RecetaDto dto = new RecetaDto(receta.getId(), receta.getNombre(), receta.getIngredientes(), receta.getPreparacion(), 
				receta.getTiempoPreparacion(), receta.getRaciones(), receta.isMicroondas(), receta.getCategoria().getDescripcion(), 
				receta.getUsuario().getNombreUsuario());
		return dto;
	}
	
	// Obtener usuario a partir del DTO
	public Usuario fromUsuarioDtoToUsuario (UsuarioDto dto)
	{
		return usuarioRepo.findUsuarioByNombreUsuario(dto.getNombreUsuario());
	}
	
	public UsuarioDto fromUsuarioToUsuarioDto (Usuario usuario)
	{
		UsuarioDto dto = new UsuarioDto(usuario.getNombre(), usuario.getFechaNacimiento(), usuario.getGenero(),
				usuario.getNacionalidad().getDescripcion(), usuario.getNombreUsuario());
		return dto;
	}
	
}

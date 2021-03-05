package com.RecetasParaTodos.model.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RecetasParaTodos.model.entity.Receta;
import com.RecetasParaTodos.model.entity.Usuario;
import com.RecetasParaTodos.repo.UsuarioRepository;

@Component
public class DtoConverter {
	
	// Repositorio
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	// Obtener receta a partir del DTO
	public Receta fromRecetaDtoToReceta (RecetaDto dto)
	{
		Usuario usuario = usuarioRepo.findUsuarioByNombreUsuario(dto.getNombreUsuario());
		Receta receta = new Receta (dto.getNombre(), dto.getIngredientes(), dto.getPreparacion(), dto.getTiempoPreparacion(),
				dto.getRaciones(), dto.isMicroondas(), dto.getCategoria(), usuario);
		return receta;
	}
	
	// Obtener DTO a partir de receta
	public RecetaDto fromRecetaToRecetaDto(Receta receta)
	{
		RecetaDto dto = new RecetaDto(receta.getId(), receta.getNombre(), receta.getIngredientes(), receta.getPreparacion(), 
				receta.getTiempoPreparacion(), receta.getRaciones(), receta.isMicroondas(), receta.getCategoria(), 
				receta.getUsuario().getNombreUsuario());
		return dto;
	}	
	
}

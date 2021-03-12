package com.RecetasParaTodos.model.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RecetasParaTodos.model.entity.Categoria;
import com.RecetasParaTodos.model.entity.Ingrediente;
import com.RecetasParaTodos.model.entity.Receta;
import com.RecetasParaTodos.model.entity.Usuario;
import com.RecetasParaTodos.repo.CategoriaRepository;
import com.RecetasParaTodos.repo.UsuarioRepository;
import com.RecetasParaTodos.service.IngredienteService;

@Component
public class DtoConverter {
	
	// Repositorio
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private IngredienteService servicio;
	
	// Obtener receta a partir del DTO
	public Receta fromRecetaDtoToReceta (RecetaDto dto)
	{
		Usuario usuario = usuarioRepo.findUsuarioByNombreUsuario(dto.getNombreUsuario());
		Categoria categoria = categoriaRepo.findCategoriaByDescripcion(dto.getCategoria());
		String tiempoPreparacion = dto.getHoras() + " hora " + dto.getMinutos() + " minutos";
		List<Ingrediente> ingredientes = servicio.getListaIngredientes(dto.getIngredientes());
		Receta receta = new Receta (dto.getNombre(), ingredientes, dto.getPreparacion(), tiempoPreparacion,
				dto.getRaciones(), dto.isMicroondas(), categoria, usuario);
		return receta;
	}
	
	// Obtener DTO a partir de receta
	public RecetaDto fromRecetaToRecetaDto(Receta receta)
	{
		String[] tiempo = receta.getTiempoPreparacion().replace(" hora ", " ").replace(" minutos", " ").split(" ");
		List<String> ingredientes = servicio.getListaString(receta.getIngredientes());
		RecetaDto dto = new RecetaDto(receta.getId(), receta.getNombre(), ingredientes, receta.getPreparacion(), 
				Integer.parseInt(tiempo[0]), Integer.parseInt(tiempo[1]), receta.getRaciones(), receta.isMicroondas(), receta.getCategoria().getDescripcion(), 
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

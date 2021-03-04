package com.RecetasParaTodos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecetasParaTodos.model.dto.DtoConverter;
import com.RecetasParaTodos.model.dto.RecetaDto;
import com.RecetasParaTodos.model.entity.Receta;
import com.RecetasParaTodos.model.entity.Usuario;
import com.RecetasParaTodos.model.enums.Categoria;
import com.RecetasParaTodos.repo.RecetaRepository;
import com.RecetasParaTodos.repo.UsuarioRepository;

@Service
public class RecetaService
{
	// Repositorios
	@Autowired
	private RecetaRepository recetaRepo;

	@Autowired
	private UsuarioRepository usuarioRepo;

	// Servicio
	@Autowired
	private UpdateService service;
	
	// Dto Converter
	@Autowired
	private DtoConverter converter;

	// Método que nos devuelve una receta a partir de su id, lanza una excepción si
	// no la encuentra
	public RecetaDto getReceta(int id) throws Exception
	{
		Receta receta = recetaRepo.findRecetaById(id);
		if (receta == null)
		{
			throw new Exception("La receta no existe");
		}
		return converter.fromRecetaToRecetaDto(receta);
	}

	// Método que nos devuelve todas las recetas de una categoría, lanza una
	// excepción si no hay ninguna
	public List<RecetaDto> getRecetasCategoria(String categoria) throws Exception
	{
		Categoria cat = Categoria.valueOf(categoria.toUpperCase());
		List<Receta> recetas = recetaRepo.findRecetaByCategoria(cat);
		if (recetas.size() == 0)
		{
			throw new Exception("No hay recetas de la categoria");
		}
		List<RecetaDto> recetasDto = new ArrayList<RecetaDto>();
		for (Receta receta : recetas) {
			recetasDto.add(converter.fromRecetaToRecetaDto(receta));
		}
		return recetasDto;
	}

	// Método que nos devuelve todas las recetas para el microondas, lanza una
	// excepción si no hay ninguna
	public List<RecetaDto> getRecetasMicroondas() throws Exception
	{
		List<Receta> recetas = recetaRepo.findRecetaByMicroondas(true);
		if (recetas.size() == 0)
		{
			throw new Exception("No hay recetas para el microondas");
		}
		List<RecetaDto> recetasDto = new ArrayList<RecetaDto>();
		for (Receta receta : recetas) {
			recetasDto.add(converter.fromRecetaToRecetaDto(receta));
		}
		return recetasDto;
	}

	// Método que nos devuelve todas las recetas de un usuario, lanza una
	// excepción si no hay ninguna
	public List<RecetaDto> getRecetasUsuario(String username) throws Exception
	{
		Usuario usuario = usuarioRepo.findUsuarioByNombreUsuario(username);
		if (usuario == null)
		{
			throw new Exception("El usuario no existe");
		}
		List<Receta> recetas = recetaRepo.findRecetaByUsuario(usuario);
		if (recetas.size() == 0)
		{
			throw new Exception("El usuario no tiene recetas");
		}
		List<RecetaDto> recetasDto = new ArrayList<RecetaDto>();
		for (Receta receta : recetas) {
			recetasDto.add(converter.fromRecetaToRecetaDto(receta));
		}
		return recetasDto;
	}

	// Método para crear una receta. Comprueba si ya existe una receta con el mismo
	// nombre y lanza una excepción en caso afirmativo
	public RecetaDto addReceta(Receta sent) throws Exception
	{
		Usuario usuario = usuarioRepo.findUsuarioByNombreUsuario(sent.getUsuario().getNombreUsuario());
		if (usuario == null)
		{
			throw new Exception("No existe el usuario indicado");
		}
		// Si el usuario existe actualizamos el usuario guardado en la receta
		sent.setUsuario(usuario);
		String nombreReceta = sent.getNombre();
		Receta receta = recetaRepo.findRecetaByNombre(nombreReceta);
		if (receta != null)
		{
			throw new Exception("Ya existe una receta con ese nombre");
		}
		recetaRepo.save(sent);
		return converter.fromRecetaToRecetaDto(sent);
	}

	// Método que modifica una receta. El servicio que utiliza lanza una excepción
	// si intenta modicifar el nombre por uno que ya existe
	public RecetaDto updateReceta(int id, RecetaDto sent) throws Exception
	{
		Receta receta = recetaRepo.findRecetaById(id);
		if (receta == null)
		{
			throw new Exception("La receta no existe");
		}
		service.updateRecetaOriginal(receta, sent);
		recetaRepo.save(receta);
		return converter.fromRecetaToRecetaDto(receta);
	}

	// Método que elimina una receta. Lanza una excepción si no existe
	public RecetaDto deleteReceta(int id) throws Exception
	{
		Receta receta = recetaRepo.findRecetaById(id);
		RecetaDto dto = converter.fromRecetaToRecetaDto(receta);
		if (receta == null)
		{
			throw new Exception("La receta no existe");
		}
		recetaRepo.delete(receta);
		return dto;
	}
}

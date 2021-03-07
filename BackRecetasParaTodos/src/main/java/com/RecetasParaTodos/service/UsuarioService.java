package com.RecetasParaTodos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RecetasParaTodos.model.dto.DtoConverter;
import com.RecetasParaTodos.model.dto.UsuarioDto;
import com.RecetasParaTodos.model.entity.Usuario;
import com.RecetasParaTodos.repo.UsuarioRepository;

@Service
public class UsuarioService {

	// Repositorio
	@Autowired
	private UsuarioRepository usuarioRepo;

	// Servicio
	@Autowired
	private UpdateService service;

	// Dto Converter
	@Autowired
	private DtoConverter converter;
	
	//Método que devuelve un usuario a partir de su nombre de usuario
	public UsuarioDto getUsuario(String username) throws Exception
	{
		Usuario usuario = usuarioRepo.findUsuarioByNombreUsuario(username);
		if(usuario == null)
		{
			throw new Exception("El usuario no existe");
		}
		return converter.fromUsuarioToUsuarioDto(usuario);
	}
	
	// Método para actualizar un usuario
	public UsuarioDto updateUsuario(String username, UsuarioDto sent) throws Exception
	{
		Usuario usuario = usuarioRepo.findUsuarioByNombreUsuario(username);
		if(usuario == null)
		{
			throw new Exception("El usuario no existe");
		}
		Usuario usuarioSent = converter.fromUsuarioDtoToUsuario(sent);
		service.updateUsuario(usuario, usuarioSent);
		usuarioRepo.save(usuario);
		return converter.fromUsuarioToUsuarioDto(usuario);
	}

}

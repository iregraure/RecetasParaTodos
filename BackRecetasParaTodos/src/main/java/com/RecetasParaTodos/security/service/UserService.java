package com.RecetasParaTodos.security.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.RecetasParaTodos.model.entity.Usuario;
import com.RecetasParaTodos.repo.UsuarioRepository;
import com.RecetasParaTodos.security.model.User;
import com.RecetasParaTodos.security.model.dto.SecurityDtoConverter;
import com.RecetasParaTodos.security.model.dto.SignUpDto;
import com.RecetasParaTodos.security.model.dto.UserDto;
import com.RecetasParaTodos.security.repo.UserRepository;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private SecurityDtoConverter converter;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username doesn't exist"));
	}

	public UserDetails loadUserById(int id) throws AuthenticationException
	{
		return userRepo.findById(id).orElseThrow(() -> new AuthenticationException("User id doesn't exist"));
	}

	public UserDto newUser(SignUpDto dto)
	{
		// Obtengo el user y lo guardo en la BBDD
		User newUser = converter.fromSignUpDtoToUser(dto);
		userRepo.save(newUser);
		// Obtengo el user y lo guardo en la BBDD
		Usuario newUsuario = converter.fromSignUpDtoToUsuario(dto);
		usuarioRepo.save(newUsuario);
		return converter.fromUserToUserDto(newUser);
	}
}

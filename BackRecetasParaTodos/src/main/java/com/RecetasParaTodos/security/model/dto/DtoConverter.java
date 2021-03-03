package com.RecetasParaTodos.security.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.RecetasParaTodos.model.entity.Usuario;
import com.RecetasParaTodos.repo.NacionalidadRepository;
import com.RecetasParaTodos.security.model.Role;
import com.RecetasParaTodos.security.model.User;
import com.RecetasParaTodos.security.repo.UserRepository;

@Component
public class DtoConverter
{
	@Autowired
	private NacionalidadRepository nacionalidadRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	PasswordEncoder passEncoder;

	public User fromSignUpDtoToUser(SignUpDto dto)
	{
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(passEncoder.encode(dto.getPass()));
		user.setRoles(Set.of(Role.AUTENTICADO));
		user.setCreateTime(LocalDateTime.now());
		user.setUpdateTime(LocalDateTime.now());
		user.setLastPaswordChange(LocalDateTime.now());
		user.setLocked(false);
		user.setEnabled(true);
		user.setAuthAttempts(0);
		user.setPasswordExpireDate(LocalDateTime.now().plusMonths(3));
		return user;
	}

	public Usuario fromSignUpDtoToUsuario(SignUpDto dto)
	{
		Usuario usuario = new Usuario();
		usuario.setNombre(dto.getNombre());
		usuario.setFechaNacimiento(dto.getFechaNacimiento());
		usuario.setGenero(dto.getGenero());
		usuario.setNacionalidad(nacionalidadRepo.findNacionalidadByDescripcion(dto.getNacionalidad()));
		usuario.setNombreUsuario(dto.getUsername());
		String username = dto.getUsername();
		User user = userRepo.findUserByUsername(username);
		usuario.setUser(user);
		return usuario;
	}

	public UserDto fromUserToUserDto(User user)
	{
		UserDto dto = new UserDto();
		dto.setUsername(user.getUsername());
		dto.setPass(user.getPassword());
		dto.setRoles(user.getRoles());
		return dto;
	}

	public User fromUserDtoToUser(UserDto dto)
	{
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(passEncoder.encode(dto.getPass()));
		if (dto.getUsername().equalsIgnoreCase("Invitado"))
		{
			user.setRoles(Set.of(Role.INVITADO));
		}
		else
		{
			user.setRoles(Set.of(Role.AUTENTICADO));
		}
		return user;
	}
}

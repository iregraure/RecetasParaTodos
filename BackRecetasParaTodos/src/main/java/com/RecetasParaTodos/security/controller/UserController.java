package com.RecetasParaTodos.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.RecetasParaTodos.security.filter.jwt.JWTTokenProvider;
import com.RecetasParaTodos.security.model.User;
import com.RecetasParaTodos.security.model.dto.SecurityDtoConverter;
import com.RecetasParaTodos.security.model.dto.SignUpDto;
import com.RecetasParaTodos.security.model.dto.UserDto;
import com.RecetasParaTodos.security.repo.UserRepository;
import com.RecetasParaTodos.security.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private SecurityDtoConverter converter;	

	// Get user autenticado a partir del jwt
	@GetMapping("/autenticado/{jwt}")
	public UserDto getUserAutenticado(@PathVariable String jwt)
	{
		int id = JWTTokenProvider.getIdUsuarioDesdeJwt(jwt);
		User user = repo.findUserById(id);
		return converter.fromUserToUserDto(user);
	}
	
	@PostMapping("/sign-up")
	public ResponseEntity<UserDto> signup(@RequestBody SignUpDto dto)
	{
		try
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(service.newUser(dto));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody UserDto dto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
}

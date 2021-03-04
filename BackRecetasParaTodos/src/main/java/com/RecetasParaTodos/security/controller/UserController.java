package com.RecetasParaTodos.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.RecetasParaTodos.security.model.dto.SignUpDto;
import com.RecetasParaTodos.security.model.dto.UserDto;
import com.RecetasParaTodos.security.service.UserService;

@CrossOrigin(exposedHeaders = "Authorization")
@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService service;

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

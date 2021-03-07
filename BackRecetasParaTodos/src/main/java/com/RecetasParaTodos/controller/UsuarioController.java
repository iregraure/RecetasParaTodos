package com.RecetasParaTodos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecetasParaTodos.model.dto.UsuarioDto;
import com.RecetasParaTodos.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	// Servicio
	@Autowired
	private UsuarioService service;

	// Obtener un usuario
	@GetMapping(path = "/{username}")
	public ResponseEntity<?> getUsuario(@PathVariable String username) {
		ResponseEntity<?> response;
		try {
			UsuarioDto usuario = service.getUsuario(username);
			response = ResponseEntity.ok(usuario);
		} catch (Exception e) {
			String mensaje = e.getMessage();
			if (mensaje.equals("El usuario no existe")) {
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			} else {
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

	// Modificar una receta
	@PutMapping("/{username}")
	public ResponseEntity<?> updateUsuario(@PathVariable String username, @RequestBody UsuarioDto sent) {
		ResponseEntity<?> response;
		try {
			UsuarioDto usuario = service.updateUsuario(username, sent);
			response = ResponseEntity.ok(usuario);
		} catch (Exception e) {
			String mensaje = e.getMessage();
			if (mensaje.equals("El usuario no existe")) {
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			} else {
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

}

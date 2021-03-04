package com.RecetasParaTodos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RecetasParaTodos.model.dto.RecetaDto;
import com.RecetasParaTodos.model.entity.Receta;
import com.RecetasParaTodos.model.enums.Categoria;
import com.RecetasParaTodos.service.RecetaService;

@CrossOrigin
@RestController
@RequestMapping("/receta")
public class RecetaController
{

	// Servicio
	@Autowired
	private RecetaService service;

	// Obtener una receta
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getReceta(@PathVariable int id)
	{
		ResponseEntity<?> response;
		try
		{
			RecetaDto receta = service.getReceta(id);
			response = ResponseEntity.ok(receta);
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			if (mensaje.equals("La receta no existe"))
			{
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			}
			else
			{
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

	// Obtener todas las recetas de una categoria
	@GetMapping(path = "/categoria/{categoria}")
	public ResponseEntity<?> getRecetasCategoria(@PathVariable String categoria)
	{
		ResponseEntity<?> response;
		try
		{
			List<RecetaDto> recetas = service.getRecetasCategoria(categoria);
			response = ResponseEntity.ok(recetas);
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			if (mensaje.equals("No hay recetas de la categoria"))
			{
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			}
			else
			{
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

	// Obtener todas las recetas hechas al microondas
	@GetMapping(path = "/microondas")
	public ResponseEntity<?> getRecetasMicroondas()
	{
		ResponseEntity<?> response;
		try
		{
			List<RecetaDto> recetas = service.getRecetasMicroondas();
			response = ResponseEntity.ok(recetas);
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			if (mensaje.equals("No hay recetas para el microondas"))
			{
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			}
			else
			{
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

	// Obtener todas las recetas de un usuario
	@GetMapping(path = "/usuario/{username}")
	public ResponseEntity<?> getRecetasUsuario(@PathVariable String username)
	{
		ResponseEntity<?> response;
		try
		{
			List<RecetaDto> recetas = service.getRecetasUsuario(username);
			response = ResponseEntity.ok(recetas);
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			if (mensaje.equals("El usuario no existe") || mensaje.equals("El usuario no tiene recetas"))
			{
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			}
			else
			{
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

	// Crear una receta
	@PostMapping
	public ResponseEntity<?> addReceta(@RequestBody Receta sent)
	{
		ResponseEntity<?> response;
		try
		{
			RecetaDto receta = service.addReceta(sent);
			response = ResponseEntity.ok(receta);
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			if (mensaje.equals("Ya existe una receta con ese nombre"))
			{
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			}
			else
			{
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

	// Modificar una receta
	@PutMapping("/{id}")
	public ResponseEntity<?> updateReceta(@PathVariable int id, @RequestBody RecetaDto sent)
	{
		ResponseEntity<?> response;
		try
		{
			RecetaDto receta = service.updateReceta(id, sent);
			response = ResponseEntity.ok(receta);
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			if (mensaje.equals("La receta no existe"))
			{
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			}
			else
			{
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

	// Eliminar una receta
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteReceta(@PathVariable int id)
	{
		ResponseEntity<?> response;
		try
		{
			RecetaDto receta = service.deleteReceta(id);
			response = ResponseEntity.ok(receta);
		}
		catch (Exception e)
		{
			String mensaje = e.getMessage();
			if (mensaje.equals("La receta no existe"))
			{
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
			}
			else
			{
				response = ResponseEntity.badRequest().body(mensaje);
			}
		}
		return response;
	}

}

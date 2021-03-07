package com.RecetasParaTodos.model.dto;

public class UsuarioDto {

	// Atributos
	private String nombre;
	
	private String fechaNacimiento;
	
	private String genero;
	
	private String nacionalidad;
	
	private String nombreUsuario;

	// Constructor
	public UsuarioDto(String nombre, String fechaNacimiento, String genero, String nacionalidad, String nombreUsuario) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.nacionalidad = nacionalidad;
		this.nombreUsuario = nombreUsuario;
	}

	// Métodos get y set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
}

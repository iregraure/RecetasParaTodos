package com.RecetasParaTodos.security.model.dto;

public class SignUpDto
{
	private String username;

	private String pass;

	private String nombre;

	private String fechaNacimiento;

	private String genero;

	private String nacionalidad;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero()
	{
		return genero;
	}

	public void setGenero(String genero)
	{
		this.genero = genero;
	}

	public String getNacionalidad()
	{
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}
}

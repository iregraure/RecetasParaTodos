package com.RecetasParaTodos.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nacionalidad
{

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	// Constructor
	public Nacionalidad()
	{
		super();
	}

	public Nacionalidad(String descripcion)
	{
		this.descripcion = descripcion;
	}

	// Métodos get y set
	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public int getId()
	{
		return id;
	}

}

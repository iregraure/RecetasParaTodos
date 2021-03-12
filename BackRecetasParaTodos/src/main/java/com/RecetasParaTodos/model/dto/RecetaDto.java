package com.RecetasParaTodos.model.dto;

import java.util.ArrayList;
import java.util.List;

public class RecetaDto {

	// Atributos
	private int id;
	
	private String nombre;

	private List<String> ingredientes;

	private String preparacion;

	private int horas;
	
	private int minutos;

	private int raciones;

	private boolean microondas;

	private String categoria;

	private String nombreUsuario;
	
	public RecetaDto(int id, String nombre, List<String> ingredientes, String preparacion, int horas, int minutos,
			int raciones, boolean microondas, String categoria, String nombreUsuario) 
	{
		this.id = id;
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
		this.horas = horas;
		this.minutos = minutos;
		this.raciones = raciones;
		this.microondas = microondas;
		this.categoria = categoria;
		this.nombreUsuario = nombreUsuario;
	}

	// Métodos get y set
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getRaciones() {
		return raciones;
	}

	public void setRaciones(int raciones) {
		this.raciones = raciones;
	}

	public boolean isMicroondas() {
		return microondas;
	}

	public void setMicroondas(boolean microondas) {
		this.microondas = microondas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}

package com.RecetasParaTodos.model.dto;

import java.util.List;

import com.RecetasParaTodos.model.entity.Categoria;

public class NewRecetaDto {

	// Atributos
	private String nombre;

	private List<String> ingredientes;

	private String preparacion;

	private String tiempoPreparacion;

	private int raciones;

	private boolean microondas;

	private Categoria categoria;

	private String nombreUsuario;

	public NewRecetaDto(String nombre, List<String> ingredientes, String preparacion, String tiempoPreparacion,
				int raciones, boolean microondas, Categoria categoria, String nombreUsuario) 
		{
			this.nombre = nombre;
			this.ingredientes = ingredientes;
			this.preparacion = preparacion;
			this.tiempoPreparacion = tiempoPreparacion;
			this.raciones = raciones;
			this.microondas = microondas;
			this.categoria = categoria;
			this.nombreUsuario = nombreUsuario;
		}

	// Métodos get y set
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

	public String getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(String tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}

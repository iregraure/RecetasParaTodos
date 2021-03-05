package com.RecetasParaTodos.model.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Receta
{
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	@ElementCollection
	@CollectionTable(name = "Ingredientes_receta", joinColumns = @JoinColumn(referencedColumnName = "id"))
	private List<String> ingredientes;

	private String preparacion;

	private String tiempoPreparacion;

	private int raciones;

	private boolean microondas;

	@ManyToOne
	@JoinColumn(name = "categoria", foreignKey = @ForeignKey(name = "FK_CATEGORIA_RECETA"))
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "user", foreignKey = @ForeignKey(name = "FK_USUARIO_RECETA"))
	private Usuario usuario;

	// Constructores
	public Receta()
	{
		super();
	}

	public Receta(String nombre, List<String> ingredientes, String preparacion, String tiempoPreparacion, int raciones,
			boolean microondas, Categoria categoria, Usuario usaurio)
	{
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
		this.tiempoPreparacion = tiempoPreparacion;
		this.raciones = raciones;
		this.microondas = microondas;
		this.categoria = categoria;
		this.usuario = usuario;
	}

	// Métodos get y set
	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public List<String> getIngredientes()
	{
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes)
	{
		this.ingredientes = ingredientes;
	}

	public String getPreparacion()
	{
		return preparacion;
	}

	public void setPreparacion(String preparacion)
	{
		this.preparacion = preparacion;
	}

	public String getTiempoPreparacion()
	{
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(String tiempoPreparacion)
	{
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public int getRaciones()
	{
		return raciones;
	}

	public void setRaciones(int raciones)
	{
		this.raciones = raciones;
	}

	public boolean isMicroondas()
	{
		return microondas;
	}

	public void setMicroondas(boolean microondas)
	{
		this.microondas = microondas;
	}

	public Categoria getCategoria()
	{
		return categoria;
	}

	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

	public int getId()
	{
		return id;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
}

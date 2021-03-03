package com.RecetasParaTodos.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.RecetasParaTodos.security.model.User;

@Entity
public class Usuario
{

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private String fechaNacimiento;

	private String genero;

	@ManyToOne
	@JoinColumn(name = "nacionalidadId", foreignKey = @ForeignKey(name = "FK_NACIONALIDAD_USUARIO"))
	private Nacionalidad nacionalidad;

	@OneToOne
	@JoinColumn(name = "idUser", foreignKey = @ForeignKey(name = "FK_USER_USUARIO"))
	private User user;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Receta> recetas;

	private String nombreUsuario;

	// Constructores
	public Usuario()
	{
		super();
		this.recetas = new ArrayList<Receta>();
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

	public int getId()
	{
		return id;
	}

	public Nacionalidad getNacionalidad()
	{
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}

	public User getUser()
	{
		return user;
	}

	public List<Receta> getRecetas()
	{
		return recetas;
	}

	public void addReceta(Receta receta)
	{
		this.recetas.add(receta);
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getNombreUsuario()
	{
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario)
	{
		this.nombreUsuario = nombreUsuario;
	}

}

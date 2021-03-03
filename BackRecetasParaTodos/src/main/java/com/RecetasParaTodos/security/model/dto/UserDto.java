package com.RecetasParaTodos.security.model.dto;

import java.util.Set;

import com.RecetasParaTodos.security.model.Role;

public class UserDto
{
	private String username;

	private String pass;

	private Set<Role> roles;

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

	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}
}

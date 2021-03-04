package com.RecetasParaTodos.security.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails
{
	private static final int MAX_ATTEMPTS = 3;

	private static final long serialVersionUID = -8237629737994643685L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String username;

	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<Role> roles;

	@CreatedDate
	private LocalDateTime createTime;

	@UpdateTimestamp
	private LocalDateTime updateTime;

	private LocalDateTime deleteTime;

	private LocalDateTime lastPaswordChange;

	private LocalDateTime lastLoginAttempt;

	private boolean locked;

	private boolean enabled;

	private int authAttempts;

	private LocalDateTime passwordExpireDate;

	// Constructor
	public User()
	{
		super();
	}

	// Métodos get y set
	public Set<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(Set<Role> roles)
	{
		this.roles = roles;
	}

	public LocalDateTime getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime)
	{
		this.updateTime = updateTime;
	}

	public LocalDateTime getDeleteTime()
	{
		return deleteTime;
	}

	public void setDeleteTime(LocalDateTime deleteTime)
	{
		this.deleteTime = deleteTime;
	}

	public LocalDateTime getLastPaswordChange()
	{
		return lastPaswordChange;
	}

	public void setLastPaswordChange(LocalDateTime lastPaswordChange)
	{
		this.lastPaswordChange = lastPaswordChange;
	}

	public LocalDateTime getLastLoginAttempt()
	{
		return lastLoginAttempt;
	}

	public void setLastLoginAttempt(LocalDateTime lastLoginAttempt)
	{
		this.lastLoginAttempt = lastLoginAttempt;
	}

	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	public int getAuthAttempts()
	{
		return authAttempts;
	}

	public void setAuthAttempts(int authAttempts)
	{
		this.authAttempts = authAttempts;
	}

	public LocalDateTime getPasswordExpireDate()
	{
		return passwordExpireDate;
	}

	public void setPasswordExpireDate(LocalDateTime passwordExpireDate)
	{
		this.passwordExpireDate = passwordExpireDate;
	}

	public Integer getId()
	{
		return id;
	}

	public LocalDateTime getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime)
	{
		this.createTime = createTime;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	// Métodos de UserDetails
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.name())).collect(Collectors.toList());
	}

	@Override
	public String getPassword()
	{
		return this.password;
	}

	@Override
	public String getUsername()
	{
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return ((this.deleteTime == null) || (this.getDeleteTime().isAfter(LocalDateTime.now())));
	}

	@Override
	public boolean isAccountNonLocked()
	{
		this.enabled = true;
		if (this.authAttempts == MAX_ATTEMPTS && this.lastLoginAttempt.plusMinutes(30).isBefore(LocalDateTime.now()))
		{
			this.enabled = false;
		}
		return this.enabled;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return this.passwordExpireDate.isAfter(LocalDateTime.now());
	}

	@Override
	public boolean isEnabled()
	{
		return this.enabled;
	}
}

package com.RecetasParaTodos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.RecetasParaTodos.security.common.SecurityConstants;
import com.RecetasParaTodos.security.filter.JWTAuthenticationFilter;
import com.RecetasParaTodos.security.filter.JWTAuthorizationFilter;
import com.RecetasParaTodos.security.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter;

	@Autowired
	private PasswordEncoder passEncoder;

	@Autowired
	private UserService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(service).passwordEncoder(passEncoder);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
				.antMatchers(HttpMethod.POST, SecurityConstants.LOGIN_URL).permitAll()
				.antMatchers(HttpMethod.POST, "/nacionalidad").permitAll()
				.antMatchers(HttpMethod.GET, "/receta/*").permitAll()
				.antMatchers(HttpMethod.POST, "/receta").permitAll()
				.antMatchers(HttpMethod.PUT, "/receta/*").permitAll()
				.antMatchers(HttpMethod.DELETE, "/receta/*").permitAll()
				.and().addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
				.addFilterBefore(jwtAuthorizationFilter, BasicAuthenticationFilter.class).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}

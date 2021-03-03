package com.RecetasParaTodos.security.filter;

import static com.RecetasParaTodos.security.filter.jwt.JWTTokenProvider.generateToken;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.RecetasParaTodos.security.common.SecurityConstants;
import com.RecetasParaTodos.security.model.User;
import com.RecetasParaTodos.security.model.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebFilter
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
	private static AuthenticationManager authManager;

	public JWTAuthenticationFilter(AuthenticationManager authManager)
	{
		this.authManager = authManager;
		setFilterProcessesUrl(SecurityConstants.LOGIN_URL);
	}

	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException
	{
		UserDto dto = null;
		try
		{
			dto = new ObjectMapper().readValue(request.getInputStream(), UserDto.class);
		}
		catch (IOException ioe)
		{
			throw new RuntimeException(ioe);
		}
		return authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPass()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException
	{
		response.addHeader(SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX + generateToken((User) authResult.getPrincipal()));
	}
}

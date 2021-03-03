package com.RecetasParaTodos.security.filter;

import static com.RecetasParaTodos.security.filter.jwt.JWTTokenProvider.validateToken;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.RecetasParaTodos.security.common.SecurityConstants;
import com.RecetasParaTodos.security.model.User;
import com.RecetasParaTodos.security.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
@WebFilter
public class JWTAuthorizationFilter extends OncePerRequestFilter
{
	@Autowired
	private UserService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{
		String header = request.getHeader(SecurityConstants.HEADER_STRING);

		if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX))
		{
			filterChain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken auth = getAuthentication(request);
		auth.setDetails(new WebAuthenticationDetails(request));
		SecurityContextHolder.getContext().setAuthentication(auth);
		filterChain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request)
	{
		String token = request.getHeader(SecurityConstants.HEADER_STRING).replace(SecurityConstants.TOKEN_PREFIX, "");
		UsernamePasswordAuthenticationToken upat = null;
		
		if(token != null && !token.isEmpty() && validateToken(token))
		{
			try
			{
				Integer idUser = Integer.valueOf(Jwts.parser()
											.setSigningKey(Keys.hmacShaKeyFor(SecurityConstants.SECRET.getBytes()))
											.parseClaimsJws(token)
											.getBody()
											.getId());
				User user = (User) service.loadUserById(idUser);
				if(idUser != null)
				{
					upat = new UsernamePasswordAuthenticationToken(idUser, user.getRoles(), user.getAuthorities());
				}
			}
			catch (AuthenticationException ae)
			{
				throw new RuntimeException("No user identifier has been found in the request");
			}
		}
		return upat;
	}
}

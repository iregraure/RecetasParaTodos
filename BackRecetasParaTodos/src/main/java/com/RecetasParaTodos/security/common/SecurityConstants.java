package com.RecetasParaTodos.security.common;

public class SecurityConstants
{
	public static final String SECRET = "Jwt_Secret_4_Recetas_Para_Todos_By_Iregraure_Cooking_Recipes_4_Every1";
	public static final long EXPIRATION_TIME = 14_400_000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/user/sign-up";
	public static final String LOGIN_URL = "/user/login";
}

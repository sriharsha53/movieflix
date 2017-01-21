package io.harsha.movieflix_api.auth;

import org.springframework.security.core.userdetails.User;

import io.harsha.movieflix_api.service.UserAuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenHandler {
	private final String secret;
	private final UserAuthenticationService userService;

	public TokenHandler(String secret, UserAuthenticationService userService) {
		this.secret = secret;
		this.userService = userService;
	}

	public User parseUserFromToken(String token) {
		String username = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
		return userService.loadUserByUsername(username);
	}

	public String createTokenForUser(User user) {
		return Jwts.builder().setSubject(user.getUsername()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}

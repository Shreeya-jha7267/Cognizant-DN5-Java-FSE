package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("START");
		LOGGER.debug("authHeader: {}", authHeader);

		String user = getUser(authHeader);
		String token = generateJwt(user);

		Map<String, String> response = new HashMap<>();
		response.put("token", token);

		LOGGER.info("END");
		return response;
	}

	private String getUser(String authHeader) {
		LOGGER.info("START");
		LOGGER.debug("Decoding user from header");

		// Header format: Basic <base64Encoded>
		String base64Token = authHeader.substring(6);
		byte[] decodedBytes = Base64.getDecoder().decode(base64Token);
		String credentials = new String(decodedBytes);

		// credentials format: username:password
		String[] values = credentials.split(":", 2);
		String user = values[0];

		LOGGER.debug("User retrieved: {}", user);
		LOGGER.info("END");
		return user;
	}

	private String generateJwt(String user) {
		LOGGER.info("START");
		LOGGER.debug("Generating token for user: {}", user);

		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();

		LOGGER.debug("Token generated: {}", token);
		LOGGER.info("END");
		return token;
	}
}

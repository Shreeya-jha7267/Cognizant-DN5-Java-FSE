package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		LOGGER.info("Start");
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("pwd"))
				.roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("pwd"))
				.roles("USER")
				.build();
		LOGGER.info("End");
		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
		LOGGER.info("Start");
		httpSecurity
				.csrf(csrf -> csrf.disable())
				.httpBasic(basic -> {})
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
						.anyRequest().authenticated()
				)
				.addFilter(new JwtAuthorizationFilter(authenticationManager));
		LOGGER.info("End");
		return httpSecurity.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}

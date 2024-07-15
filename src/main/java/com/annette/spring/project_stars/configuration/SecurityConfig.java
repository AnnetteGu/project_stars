package com.annette.spring.project_stars.configuration; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {

		return new MyUserDetailsService();

	}

	@Bean
	public AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());

		return provider;

	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/api/stars").permitAll()
											.requestMatchers(HttpMethod.GET, "/api/stars/**").permitAll()
											.requestMatchers(HttpMethod.POST, "/api/stars/**").permitAll()
											.requestMatchers(HttpMethod.POST, "/api/stars").authenticated()
											.requestMatchers(HttpMethod.PUT, "/api/stars").authenticated()
											.requestMatchers(HttpMethod.DELETE, "/api/stars/**").authenticated()
											.requestMatchers(HttpMethod.GET, "/api/users").permitAll()
											.requestMatchers(HttpMethod.GET, "/api/users/**").permitAll()
											.requestMatchers(HttpMethod.PUT, "/api/users/purchase-star").permitAll()
											.requestMatchers(HttpMethod.POST, "/api/users").permitAll()
											.requestMatchers(HttpMethod.PUT, "/api/users").permitAll()
											.requestMatchers(HttpMethod.DELETE, "/api/users/**").permitAll()
											.requestMatchers(HttpMethod.PUT, "/api/users/**").authenticated()
											.requestMatchers(HttpMethod.GET, "/api/const").permitAll()
											.requestMatchers(HttpMethod.GET, "/api/const/**").permitAll()
											.requestMatchers(HttpMethod.POST, "/api/const/**").permitAll()
											.requestMatchers(HttpMethod.POST, "/api/const").authenticated()
											.requestMatchers(HttpMethod.PUT, "/api/const").authenticated()
											.requestMatchers(HttpMethod.DELETE, "/api/const/**").authenticated()
											.requestMatchers(HttpMethod.GET, "/api/star/comments/**").permitAll()
											.requestMatchers(HttpMethod.GET, "/api/comments/**").permitAll()
											.requestMatchers(HttpMethod.POST, "/api/comments").permitAll()
											.requestMatchers(HttpMethod.PUT, "/api/comments").permitAll()
											.requestMatchers(HttpMethod.DELETE, "/api/comments/**").permitAll()
											.requestMatchers(HttpMethod.GET, "/api/user/comments/**").authenticated())
			.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
			.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder(5);

	}

}

package com.arshad.blogapi.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.arshad.blogapi.users.UsersService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

			http.authorizeHttpRequests((requests) -> {
								try {
									requests
											.anyRequest().permitAll()
											.and().cors().disable()
											.csrf().disable();
								} catch (Exception e) {
									throw new RuntimeException(e);
								}
							}
					);

			return http.build();

		//The below lines working for h2 but not other apis
		/*
		 * http .authorizeHttpRequests(auth -> auth
		 * .requestMatchers("/h2-console/**").permitAll() ) .headers(headers ->
		 * headers.disable()) .csrf(csrf -> csrf
		 * .ignoringRequestMatchers("/h2-console/**"));
		 */
	}
}

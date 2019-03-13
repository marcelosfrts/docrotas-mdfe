package com.server.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final String QUERY_USERS = "SELECT usuario, senha, ativo FROM usuario WHERE usuario = ?" ;
	private final String QUERY_PERMISSION = "SELECT u.usuario, p.chave FROM permissao AS p, usuario AS u WHERE p.usuarioid = u.id AND u.usuario = ?";
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.GET, "/home").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/logout").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class) 
			
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
		/*
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("password")
			.roles("ADMIN");
		*/
		
		try {
			DataSourceFactory dataSource = new DataSourceFactory();
			auth.jdbcAuthentication()
				.dataSource(dataSource.getSQLDataSource())
				.usersByUsernameQuery(QUERY_USERS)
				.authoritiesByUsernameQuery(QUERY_PERMISSION);
		}catch (Exception e) {
		}
	}
}

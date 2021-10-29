package com.code2.onlineshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;

	// Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// Service -> UserDetailsService
				auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Authorization
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
//				.anyRequest().authenticated()  
				.antMatchers("/shoppingCart/**").hasRole("CUSTOMER")
				.antMatchers("/checkout/**").hasRole("CUSTOMER")
				.and()
				.formLogin().loginPage("/login")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/accessDenied");
			
			http.csrf().disable();
			
		}
}

package com.example.OlympicsDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!

		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("PLAYER")
			.antMatchers("/player/**").hasRole("PLAYER")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/players/list")
				.permitAll()
			.and()
			.logout().permitAll();
			//.and()
			//.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
		
}







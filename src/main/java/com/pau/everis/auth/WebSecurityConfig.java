package com.pau.everis.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeRequests()
	                .antMatchers("/static/**", "/producto/**","/usuario/**").hasRole("ADMIN")//llenar tipo de rol ROL_ADMIN o ROL_USER
	                .antMatchers("/login").permitAll()
	               .antMatchers("/").permitAll()
	                .antMatchers("/usuario/**", "/producto/**", "/registro/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                
	                .defaultSuccessUrl("/");              
//	                .permitAll()
//	                .and()
//	            .logout()
//	                .permitAll();
	          
	    }
	}
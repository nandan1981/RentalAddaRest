package com.rentaladda.rent.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public abstract class RentalSecurityEnforcer extends WebSecurityConfigurerAdapter  {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
          .withUser("user").password("Pass").roles("ROOT");
    }
    
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/").authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
			
}

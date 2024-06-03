package com.zettamine.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private MyUserDetailsService userDetailsService;
	

	@Bean
	SecurityFilterChain mySecurity(HttpSecurity http) throws Exception {
		//with default details service
	/* return	http.csrf(x->x.disable())
		    .authorizeHttpRequests(req->
		                                req.requestMatchers("/home").permitAll()
		                                    .requestMatchers("/home/admin").authenticated()
		                                    .requestMatchers("/home/user").authenticated()
		                                    .anyRequest().permitAll())
		                                     
		    
		                                    
		    .formLogin(Customizer.withDefaults()).build(); */
	
		
		//with custom userdetailsservcie
		
	return	http.csrf(x->x.disable())
			.authorizeHttpRequests(req->
			req.requestMatchers("/home").permitAll()
			.requestMatchers("/home/user").hasRole("USER")
			.requestMatchers("/home/admin").hasRole("ADMIN")
			.anyRequest().permitAll())
			
			
           
           
		
			
			.formLogin(Customizer.withDefaults())
			.build();
	}
	
//	@Bean
//	UserDetailsService detailsService() {
//		UserDetails user = User.builder()
//				                  .username("user")
//				                  .password(encoder().encode("1234"))
//				                  .roles("USER")
//				                  .build();
//		UserDetails admin = User.builder()
//				.username("admin")
//				.password(encoder().encode("1234"))
//				.roles("USER","ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user,admin);
		
				                  
				                   
//	}
	
	@Bean
	AuthenticationProvider myAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder());
		return provider;
	}
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}

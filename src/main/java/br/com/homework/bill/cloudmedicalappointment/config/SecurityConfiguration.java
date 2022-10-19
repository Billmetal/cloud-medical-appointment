package br.com.homework.bill.cloudmedicalappointment.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public UserDetailsService userDetailsService() {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("user")
	      .password("user123")
	      .roles("USER")
	      .passwordEncoder(new Function<String, String>() {
			
			@Override
			public String apply(String t) {
				return encoder().encode(t);
			}
		})
	      .build());
	    return manager;
	}
	
	private static final String[] SWAGGER_WHITELIST = {
			"/v2/api-docs/**",
			"/",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**",
			"/csrf",
			"/*.js",
			"/*.css",
			"/*.ico",
			"/*.png"
	};
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	      .antMatchers(SWAGGER_WHITELIST).permitAll()
	      .anyRequest().authenticated()
	      .and().httpBasic()
	      .and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 

	    return http.build();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}

package lv.venta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsManager createDemoUsers() {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		
		UserDetails adminDetails = User.builder()
				.username("admin")
				.password(encoder.encode("CZFhgOcHSb"))
				.authorities("ADMIN")
				.build();
		
		
		UserDetails modDetails = User.builder()
				.username("moderator")
				.password(encoder.encode("pZh4WH2dXB"))
				.authorities("MODERATOR")
				.build();
		
		
		return new InMemoryUserDetailsManager(adminDetails, modDetails);
		
		
	}
	
	@Bean
	public SecurityFilterChain configurePermissionToEndpoints(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->auth
				.requestMatchers("/api/contact").permitAll()
				.requestMatchers("/informacija/**").permitAll()
				.requestMatchers("/kontakti**").permitAll()
				.requestMatchers("/mainpage/biedribadarbojas/**").permitAll()
				.requestMatchers("/pasakumi/**").permitAll()
				.requestMatchers("/veikals/**").hasAuthority("ADMIN")
				.requestMatchers("/admin/**").hasAuthority("ADMIN")
				);
		
		http.formLogin(auth-> auth.permitAll());
		
		return http.build();
		
	}
	
}
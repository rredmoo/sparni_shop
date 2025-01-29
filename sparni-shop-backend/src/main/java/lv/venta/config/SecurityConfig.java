package lv.venta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public MyUserDetailsManager getDetailsService() {
        return new MyUserDetailsManager();
    }

    @Bean //authentication pārbaude
    public DaoAuthenticationProvider createProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        provider.setPasswordEncoder(encoder);
        provider.setUserDetailsService(getDetailsService());
        return provider;
    }

    @Bean
    public SecurityFilterChain configurePermissionToEndpoints(HttpSecurity http) throws Exception {
        http
                .cors() // Enable CORS
                .and()
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/contact/**").permitAll()
                        .requestMatchers("/informacija/**").permitAll()
                        .requestMatchers("/kontakti**").permitAll()
                        .requestMatchers("/mainpage/biedribadarbojas/**").permitAll()
                        .requestMatchers("/pasakumi/**").permitAll()
                        .requestMatchers("/veikals/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/kontakti/all").permitAll()
                        .requestMatchers("/payment/**").permitAll()
                        .requestMatchers("/basket/**").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ADMIN"))
                        
                        
                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .successHandler(successHandler())
                        .failureHandler(failureHandler())
                        .permitAll());

        return http.build();
    }

    // CORS Configuration
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:3000");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(source);
    }

    private AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString("Login Successful"));
        };
    }

    private AuthenticationFailureHandler failureHandler() {
        return (request, response, exception) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString("Invalid credentials"));
        };
    }
}

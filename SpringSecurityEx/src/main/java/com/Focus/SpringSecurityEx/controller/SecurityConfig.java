package com.Focus.SpringSecurityEx.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // It enables security in my way
public class SecurityConfig {
    @Autowired
    private JWTFilter jwtFilter;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable()).
                authorizeHttpRequests(request -> request
                        .requestMatchers("/login", "/register").permitAll()
                        .anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults()).
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // to implement jwtFilter before UsernamePasswordAuthenticationFilter.class
                .build();


    }
//        @Bean // When we use Bean,bean will be there in spring container and Spring Security picks it up from there
//        // Here UserDeatilsService is used to verify pass & username in our designed way
//        public UserDetailsService userDetailsService(){
//            UserDetails user1 = User //Here User is class
//                    .withDefaultPasswordEncoder()
//                    .username("Dhruvi")
//                    .password("@123")
//                    .roles("USER")
//                    .build(); // Here .build return object of UserDetails
//
//            UserDetails user2 = User
//                    .withDefaultPasswordEncoder()
//                    .username("Rohit")
//                    .password("123")
//                    .roles("USER")
//                    .build();
//
//        return new InMemoryUserDetailsManager(user1,user2); // InMemoryUserDetailsManager implements UserDetailsService
//        }

    // This bean is to change authentication provider
    @Bean // Create this object and manage it for me
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService){
        // AuthenticationProvider for database
        DaoAuthenticationProvider  provider = new DaoAuthenticationProvider(userDetailsService);
        //  provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }






}

package com.SpartanJam.CSC340.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import com.SpartanJam.CSC340.service.UserLoginService;

import jakarta.servlet.DispatcherType;

/**
*
* @author NehaChauhan
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserLoginService userLoginService;
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                .dispatcherTypeMatchers(DispatcherType.FORWARD,
                        DispatcherType.ERROR).permitAll()
                .requestMatchers("*.css/**").permitAll()
                .requestMatchers("*.png/**").permitAll()
                .requestMatchers("audio/*.mp3/**").permitAll()
                .requestMatchers("/new-user/**").permitAll()
                .requestMatchers("/create-new-user/**").permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/home").permitAll()
//                .requestMatchers("/**").permitAll() //disable security
                .requestMatchers("/listener/**").hasAnyAuthority("LISTENER","ADMIN")
                .requestMatchers("/artist/**").hasAnyAuthority("ARTIST","ADMIN")
                .requestMatchers("/song/**").hasAnyAuthority("ARTIST","ADMIN")
                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
                ).exceptionHandling((x) -> x.accessDeniedPage("/403"))
                .logout((logout) -> logout.permitAll())
                .requestCache((cache) -> cache
                .requestCache(requestCache)
                );

        return http.build();
    }
    
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userLoginService).passwordEncoder(
                passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

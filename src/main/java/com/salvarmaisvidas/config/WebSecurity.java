package com.salvarmaisvidas.config;

import com.salvarmaisvidas.user.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UserPrincipalDetailsService userPrincipalDetailsService;
    private final ErrorEntryPoint errorEntryPoint;

    public WebSecurity(UserPrincipalDetailsService userPrincipalDetailsService, ErrorEntryPoint errorEntryPoint) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.errorEntryPoint = errorEntryPoint;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //http.csrf().disable()//.authorizeRequests()
                //.antMatchers("/api/users/**")//.hasRole("ADMIN")
                //.antMatchers("/api/collaborators/**").hasAnyRole("ADMIN", "MANAGER")
                //.antMatchers("/api/collaboratorEvents/**").hasAnyRole("ADMIN", "MANAGER")
                //.antMatchers("/api/events/**").hasAnyRole("ADMIN", "MANAGER")
                //.antMatchers("/api/partners/**").hasAnyRole("ADMIN", "MANAGER")
                //.anyRequest()
                //.authenticated()
                //.and()
               // .httpBasic();
        http.csrf().disable().requestMatcher(
                i -> !i.getRequestURI().substring(i.getContextPath().length()).startsWith("/api"))
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(errorEntryPoint)
                .and()
                .httpBasic();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    @Autowired
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenFilter customAuthFilter = new CustomAuthenFilter(authenticationManagerBean());
        customAuthFilter.setFilterProcessesUrl("/login/**");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/login/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/login/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/token/refresh").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET, "/products/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/products/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET, "/carts/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthFilter);
        http.addFilterBefore(new CustomAuthorFilter(), UsernamePasswordAuthenticationFilter.class);
    }

//    @Bean
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception{
//        return super.authenticationManager();
//    }
}

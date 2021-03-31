package com.prince.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("prince")
                .password("prince123")
                .roles("ADMIN")
                .and()
                .withUser("rahul")
                .password("rahul123")
                .roles("USER");
    }

//    Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/users").hasRole("ADMIN")
                .antMatchers("/api/v1/blogs").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/comments").permitAll()
//                .antMatchers("/api/v1/comments/{email}/{id}").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}

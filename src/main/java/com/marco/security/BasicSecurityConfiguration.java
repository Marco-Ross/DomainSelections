package com.marco.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); //Creates object of DelegatingPasswordEncoder so you can specify type of encoding (eg. SHA-256)
        auth
            .inMemoryAuthentication()
                .withUser("Marco")
                .password(encoderPassword().encode("pass01"))
                .roles("USER")
            .and()
                .withUser("Kaylin")
                .password(encoderPassword().encode("pass02"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
                .authorizeRequests()
                .antMatchers("/railway/actor/**/create", "/railway/actor/**/delete", "/railway/actor/**/update").hasRole("ADMIN")
            .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder encoderPassword(){
        return new BCryptPasswordEncoder();
    }
}

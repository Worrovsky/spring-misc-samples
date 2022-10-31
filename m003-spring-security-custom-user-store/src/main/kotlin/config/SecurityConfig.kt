package com.example.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder?) {

        auth?.inMemoryAuthentication()
            ?.withUser("Alice")
            ?.password(passwordEncoder().encode("1"))
            ?.roles("Admin")
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
            ?.mvcMatchers("/hello")?.hasRole("Admin")
            ?.anyRequest()?.permitAll()
            ?.and()
            ?.httpBasic()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
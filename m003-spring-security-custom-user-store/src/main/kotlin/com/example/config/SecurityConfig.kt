package com.example.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var userDetailsService: UserDetailsService

    override fun configure(auth: AuthenticationManagerBuilder?) {

        auth
            ?.userDetailsService(userDetailsService)
            ?.passwordEncoder(passwordEncoder())

//        auth?.inMemoryAuthentication()
//            ?.withUser("Admin")
//            ?.password(passwordEncoder().encode("1"))
//            ?.roles("Admin")
    }

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
            ?.mvcMatchers("/hello")?.hasAnyRole("Admin", "USER")
            ?.anyRequest()?.permitAll()
            ?.and()
            ?.csrf()?.disable()
            ?.httpBasic()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
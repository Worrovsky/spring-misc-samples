package com.example.controllers

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class UserController {

    @GetMapping("/user")
    fun user(auth: Authentication): String {
        return "Name: ${auth.name}, authorities: ${auth.authorities}"

    }

    @GetMapping("/user2")
    fun user2(principal: Principal): String {
        return principal.toString()
    }
}
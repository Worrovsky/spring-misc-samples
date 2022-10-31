package com.example.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RegistrationController {

    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @PostMapping("/register")
    public fun register(@RequestBody user: User) {
        user.password = passwordEncoder.encode(user.password)
        userRepository.save(user)
    }
}
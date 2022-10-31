package com.example.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl: UserDetailsService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findUserByUsername(username)

        if (user != null) {
            return UserDetailsImpl(user)
        } else {
            throw UsernameNotFoundException("Not found $username")
        }
    }
}
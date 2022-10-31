package com.example.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(user: User): UserDetails {

    private val password: String = user.password
    private val username: String = user.username
    private val rolesAndAuthorities: MutableList<GrantedAuthority> = mutableListOf(SimpleGrantedAuthority(user.role))

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return rolesAndAuthorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
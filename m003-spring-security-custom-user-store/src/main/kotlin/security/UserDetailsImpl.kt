package com.example.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
    private val username: String,
    private val password: String,
    private val rolesAndAuthorities: MutableList<GrantedAuthority>): UserDetails {

    constructor(user: User) {

    }
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
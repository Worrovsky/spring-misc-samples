package com.example.security

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class UserRepository {
    private val users = ConcurrentHashMap<String, User>()

    public fun findUserByUsername(username: String): User? {
        return users[username]
    }

    public fun save(user: User) {
        users[user.username] = user
    }
}
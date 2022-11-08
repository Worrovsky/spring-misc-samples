package com.example.controllers

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "Say hello to undefined person")
    fun hello(): String {
        return "Hello"
    }

    @GetMapping("/hello/world")
    fun helloWorld(): String {
        return "Hello, world"
    }
}
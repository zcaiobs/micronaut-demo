package com.example.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/api")
class DemoController {

    @Get("/hello")
    fun helloWorld() : String {
        return "Hello World"
    }
}
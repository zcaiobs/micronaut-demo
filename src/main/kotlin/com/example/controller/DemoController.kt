package com.example.controller

import com.example.domain.DemoRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api")
class DemoController {

    @Get("/hello")
    fun getDemo() : String {
        return "Carlos"
    }

    @Post("/send")
    fun postDemo(@Body @Valid request: DemoRequest): Any {
        return request.toDemo()
    }
}
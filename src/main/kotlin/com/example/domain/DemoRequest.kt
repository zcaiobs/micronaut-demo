package com.example.domain

import com.example.validator.DemoValid
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class DemoRequest(
    @field:NotBlank @field:DemoValid val name: String,
    @field:NotBlank @field:Email val email: String,
    @field:Size(max = 10) val password: String
) {
    fun toDemo(): Demo = Demo(name, email, password)
}
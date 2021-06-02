package com.example.domain

import java.time.LocalDate

class DemoResponse(private val demo: Demo) {
    val id: Long? = demo.id
    val name: String = demo.name
    val email: String = demo.email
    val password: String = demo.password
    val date: LocalDate = demo.date
}
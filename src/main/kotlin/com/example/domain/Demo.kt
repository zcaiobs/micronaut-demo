package com.example.domain

import java.time.LocalDate

class Demo(
    val name: String,
    val email: String,
    val password: String,
    val date: LocalDate = LocalDate.now()
)
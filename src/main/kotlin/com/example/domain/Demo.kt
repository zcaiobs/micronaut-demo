package com.example.domain

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Demo() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    private set
    var name: String = ""
    private set
    var email: String = ""
    private set
    var password: String = ""
    private set
    val date: LocalDate = LocalDate.now()

    constructor(name: String, email: String, password: String) : this() {
        this.name = name
        this.email = email
        this.password = password
    }
}
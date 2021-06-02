package com.example.httpClient

import com.example.domain.Demo
import io.micronaut.data.model.Page
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import java.net.http.HttpResponse

@Client("http://localhost:8080/api/demo")
interface DemoClient {
    @Get(consumes = ["application/json"])
    fun getInfo(): HttpResponse<Page<Demo>>
}
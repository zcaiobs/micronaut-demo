package com.example

import com.example.util.DemoPraTestar
import com.example.domain.DemoRequest
import com.example.util.DemoService
import com.google.gson.*
import io.micronaut.data.model.Page
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
class DemoTest {

    @field:Inject
    lateinit var demoService: DemoService

    @field:Inject
    @field:Client("/api")
    lateinit var client: HttpClient

    @MockBean(DemoService::class)
    fun demoServiceMock(): DemoService {
        return Mockito.mock(DemoService::class.java)
    }

    @Test
    fun `Usando o mockito no teste`() {
        Mockito.`when`(demoService.returnServiceThing()).thenReturn("Olá eu sou um Mock")
        val result = client.toBlocking().exchange("/demo/service", String::class.java)
        assertEquals("Olá eu sou um Mock", result.body())
    }

    @Test
    fun `Deve retornar uma lista de DEMOs`() {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd").create()
        val resultGet = client.toBlocking().exchange("/demo?size=10", Page::class.java)
        val list = resultGet.body()
            .map { gson.toJson(it) }
            .map { gson.fromJson(it, DemoPraTestar::class.java) }
            .toCollection(mutableListOf())
        list.forEach { println(it) }
        assertEquals(HttpStatus.OK, resultGet.status())
        assertNotNull(resultGet.body())
        assertEquals(10, list.size)
    }

    @Test
    fun `Deve salvar um DEMO`() {
        val demo = DemoRequest("Demo", "demo@email", "12345")
        val resultPost = client.toBlocking()
            .exchange(HttpRequest.POST("/demo", demo), DemoRequest::class.java)
        assertEquals(HttpStatus.CREATED, resultPost.status)
    }
}

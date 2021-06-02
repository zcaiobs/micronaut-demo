package com.example
import com.example.httpClient.DemoClient
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class DemoTest(private val demoClient: DemoClient) {

    @Test
    fun testItWorks() {
        val page = demoClient.getInfo()
    }

}

package com.example.controller

import com.example.domain.Demo
import com.example.domain.DemoRequest
import com.example.domain.DemoResponse
import com.example.repository.DemoRepository
import com.example.util.DemoService
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.http.HttpHeaders
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.client.bind.ClientRequestUriContext
import io.micronaut.http.uri.UriBuilder
import io.micronaut.http.uri.UriMatcher
import io.micronaut.http.uri.UriTemplate
import io.micronaut.validation.Validated
import io.micronaut.web.router.UriRoute
import java.net.URI
import java.security.URIParameter
import java.util.*
import java.util.function.BiConsumer
import javax.validation.Valid

@Validated
@Controller("/api")
class DemoController(val demoRepository: DemoRepository, val demoService: DemoService) {

    @Get("/demo")
    fun getDemo(pageable: Pageable): HttpResponse<Page<Demo>>? {
        return HttpResponse.ok(demoRepository.findAll(pageable.order(Sort.Order.desc("id"))))
    }

    @Get("/demo/service")
    fun getDemoUnit(): HttpResponse<String> {
        val result = demoService.returnServiceThing()
        return HttpResponse.ok(result)
    }

    @Post("/demo")
    fun postDemo(@Body @Valid request: DemoRequest): HttpResponse<DemoResponse>? {
        val demo = demoRepository.save(request.toDemo())
        val uri = UriBuilder.of("demo/{id}").expand(mutableMapOf(Pair("id", demo.id)))
        return HttpResponse.created(DemoResponse(demo), uri)
    }
}
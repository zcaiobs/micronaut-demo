package com.example.controller

import com.example.domain.Demo
import com.example.domain.DemoRequest
import com.example.domain.DemoResponse
import com.example.repository.DemoRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.model.Sort
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api")
class DemoController(val demoRepository: DemoRepository) {

    @Get("/demo")
    fun getDemo(pageable: Pageable): HttpResponse<Page<Demo>>? {
        return HttpResponse.ok(demoRepository.findAll(pageable.order(Sort.Order.asc("id"))))
    }

    @Post("/demo")
    fun postDemo(@Body @Valid request: DemoRequest): MutableHttpResponse<DemoResponse>? {
        return HttpResponse.ok(DemoResponse(demoRepository.save(request.toDemo())))
    }
}
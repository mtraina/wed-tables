package com.mtraina.webtables

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface GuestHandler {
    fun guests(req: ServerRequest): Mono<ServerResponse>
}

@Component
class GuestHandlerImpl(private val reader: Reader): GuestHandler {
    override fun guests(req: ServerRequest) = ok().body(Flux.just(reader.read()))
}
package com.mtraina.webtables

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes(private val guestHandler: GuestHandler) {

    @Bean
    fun router() = router {
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/guests", guestHandler::guests)
            }
        }
        resources("/**", ClassPathResource("static/"))
    }
}

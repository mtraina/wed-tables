//package com.mtraina.webtables
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.reactive.config.CorsRegistry
//import org.springframework.web.reactive.config.EnableWebFlux
//import org.springframework.web.reactive.config.WebFluxConfigurer
//
//
//@Configuration
//@EnableWebFlux
//class WebConfig : WebFluxConfigurer {
//
//    override fun addCorsMappings(registry: CorsRegistry?) {
//
//        registry!!.addMapping("/api/**")
//                .allowedOrigins("http://localhost:8090")
//                .allowedMethods("GET")
////                .allowedHeaders("header1", "header2", "header3")
////                .exposedHeaders("header1", "header2")
////                .allowCredentials(true).maxAge(3600)
//
//    }
//}
package com.mtraina.webtables

import org.springframework.stereotype.Component

data class Guest(val name: String, val presence: String)

interface Converter<S, T> {
    fun convert(s: S): T
}

@Component
class GuestConverter: Converter<List<String>, List<Guest>> {

    override fun convert(s: List<String>): List<Guest> {
        return s.map { s -> s.split(",") }
                .map { t -> Guest(t.get(0), t.get(1)) }
    }
}
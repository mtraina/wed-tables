package com.mtraina.webtables

import org.springframework.stereotype.Component

data class Guest(val name: String, val isKid: Boolean, val presence: String)

interface Converter<S, T> {
    fun convert(s: S): T
}

@Component
class GuestConverter: Converter<List<String>, List<Guest>> {
    private val KID = "kid"

    private fun isKid(kind: String) = KID == kind

    override fun convert(s: List<String>): List<Guest> {
        return s.map { s -> s.split(",") }
                .map { t -> Guest(t[0], isKid(t[1]) , t[2]) }
                .filter { g -> "yes" == g.presence }
    }
}